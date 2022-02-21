package APIRest;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

public class RestClientReserva {
    Client client;

    public RestClientReserva(){
        this.client = ClientBuilder.newClient();
    }


    public void crear(LocalDate fechaInicio, LocalDate fechaFin, float importeTotal, Cliente c, Habitacion h){
        //En el constructor hay que añadir cliente y habitación? Seteandole el primary key correspondiente?

        try{

            Reserva res = new Reserva(fechaInicio, fechaFin, importeTotal, c ,h);
            System.out.println(res);
            WebTarget wt = this.client.target("http://localhost:8080/reservas");
            Invocation.Builder invocationBuilder = wt.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.post(Entity.entity(res.toString(),MediaType.APPLICATION_JSON));
            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
            System.out.println();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String consultar(long numero){
        Gson gson = new Gson();
        Reserva r = new Reserva();

        String resultado = this.client.target("http://localhost:8080/reservas/"+numero)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        //r = gson.fromJson(resultado, Reserva.class);
        Type collectionType = new TypeToken<Collection<Cliente>>(){}.getType();
        Collection<Cliente> clientes = gson.fromJson(resultado, collectionType);

        System.out.println("Resultado: \n" + clientes);
        return resultado;
    }
    public List<Habitacion> consultarListaHab(){
        List<Habitacion> habitacionList = new ArrayList<>();

        String resultado = this.client.target("http://localhost:8080/habitaciones/")
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);
        String[] listaHabitaciones = jsonToArray(resultado);


        for (int i = 0; i < listaHabitaciones.length; i++) {
            Habitacion habitacion = new Gson().fromJson(listaHabitaciones[i], Habitacion.class);
            habitacionList.add(habitacion);
        }
        return  habitacionList;
    }
    public List<Reserva> consultarListaRes(){
        List<Reserva> reservaList = new ArrayList<>();

        String resultado = this.client.target("http://localhost:8080/reservas/")
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);
        String[] listaReservas = jsonToArray(resultado);
        System.out.println("-----");
        for (String s: listaReservas) {

            System.out.println(s);
        }
        for (int i = 0; i < listaReservas.length; i++) {
            Reserva reserva = new Gson().fromJson(listaReservas[i], Reserva.class);
            reservaList.add(reserva);
        }
        return  reservaList;
    }

    public String[] jsonToArray(String s ){

        s = s.replace("[", "");
        s = s.replace("]", "");
        System.out.println(s);
        String[] lista = s.split("}");

        for (int i = 0; i < lista.length; i++) {
            if (i>=1){
                System.out.println(lista[i].indexOf(","));
                lista[i] = lista[i].substring( lista[i].indexOf(",")+1, lista[i].length() );
            }
            lista[i] += "}";
        }

        for (String habitacion: lista){
            System.out.println(habitacion);
        }
        return lista;
    }

    public void eliminar(long numero){
        String resultado = this.client.target("http://localhost:8080/reservas/"+numero)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .delete(String.class);

        System.out.println("Resultado: \n" + resultado);
    }

}
