package APIRest;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class RestClientReserva {
    Client client;

    public RestClientReserva(){
        this.client = ClientBuilder.newClient();
    }

    public void crear(LocalDate fechaInicio, LocalDate fechaFin, float importeTotal, Cliente c, Habitacion h){
        try{
            Reserva res = new Reserva(0,fechaInicio, fechaFin, importeTotal, c ,h);
            System.out.println(res);

            WebTarget wt = this.client.target("http://localhost:8080/reservas");
            Invocation.Builder invocationBuilder = wt.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.post(Entity.entity(res.toString(),MediaType.APPLICATION_JSON));

            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
        }catch(Exception e){
            e.printStackTrace();
        }
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

    public String[] consultarListaRes(){
        String resultado = this.client.target("http://localhost:8080/reservas/")
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        String[] listaReservas = separarReservas(resultado);

        for (int i = 0; i < listaReservas.length; i++) {
            String[] separarReserva = listaReservas[i].split(",");
            separarReserva[0] = separarReserva[0].replace("\\{","");
            separarReserva[0] = separarReserva[0].replace("}","");

            String id = separarReserva[0];
            id = id.substring(13);

            String fechaIn = separarReserva[1];
            fechaIn = fechaIn.substring(15,25);

            String fechaFin = separarReserva[2];
            fechaFin = fechaFin.replace("\"", "");

            String importeTotal = separarReserva[3];
            importeTotal = importeTotal.replace("\"", "");

            String estado = separarReserva[4];
            estado = estado.replace("\"", "");

            listaReservas[i] = "ID:" + id + " "
                    + fechaIn + " "
                    + fechaFin + " "
                    + importeTotal + " "
                    + estado;
        }

        return listaReservas;
    }

    public String[] jsonToArray(String s){
        s = s.replace("[", "");
        s = s.replace("]", "");

        String[] lista = s.split("}");

        for (int i = 0; i < lista.length; i++) {
            if (i>=1){
                System.out.println(lista[i].indexOf(","));
                lista[i] = lista[i].substring( lista[i].indexOf(",")+1, lista[i].length() );
            }
            lista[i] += "}";
        }

        return lista;
    }

    public String[] separarReservas(String resultado){
        resultado = resultado.replace("[", "");
        resultado = resultado.replace("]", "");

        String[] lista = resultado.split("}}");

        try{
            for (int i = 0; i < lista.length; i++) {
                if ( lista[i].substring(0,1).equals(",") ) {
                    lista[i] = lista[i].substring(1, lista[i].length());
                }
            }
        }catch (StringIndexOutOfBoundsException e){
        }

        for (String reserva: lista) {
            System.out.println("\n" +reserva);
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

    public void modificar(long idReserva, LocalDate fechaInicio, LocalDate fechaFin, float importeTotal, Cliente c, Habitacion h){
        try{
            Reserva res = new Reserva(idReserva, fechaInicio, fechaFin, importeTotal, c ,h);
            System.out.println(res);
            WebTarget wt = this.client.target("http://localhost:8080/reservas/"+ idReserva);
            Invocation.Builder invocationBuilder = wt.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.put(Entity.entity(res.toString(),MediaType.APPLICATION_JSON));
            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
            System.out.println();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
