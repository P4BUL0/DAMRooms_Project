package APIRest;

import com.google.gson.*;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.*;

/**
 * @author Pablo, Boix y Lazaro
 * @version 1.0
 * @since 2022-02-22
 */
public class RestClientReserva {
    Client client;

    public RestClientReserva(){
        this.client = ClientBuilder.newClient();
    }

    /**
     * Metodo POST de Reserva
     *
     * @param fechaInicio Fecha de inicio de la reserva
     * @param fechaFin Fecha de finalizacion de la reserva
     * @param importeTotal Importe total de la reserva
     * @param c Cliente de la reserva
     * @param h Habitacion de la reserva
     */
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

    /**
     * Metodo GET de todas las habitaciones
     *
     * @return Devuelve una lista de habitaciones
     */
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

    /**
     * Metodo GET de todas las reservas existentes
     *
     * @return Devuelve un array con las reservas
     */
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

    /**
     * Metodo para traducir el array que devuelve la API
     *
     * @param array Un String con el formato de llaves siguiente: [{"ejemplo": "esto es un ejemplo"},{"ejemplo": "este es otro ejemplo"}]
     * @return Devuelve un array con los objetos separados
     */
    public String[] jsonToArray(String array){
        array = array.replace("[", "");
        array = array.replace("]", "");

        String[] lista = array.split("}");

        for (int i = 0; i < lista.length; i++) {
            if (i>=1){
                System.out.println(lista[i].indexOf(","));
                lista[i] = lista[i].substring( lista[i].indexOf(",")+1, lista[i].length() );
            }
            lista[i] += "}";
        }

        return lista;
    }

    /**
     * Metodo para separar el string donde estan todas las reservas
     *
     * @param resultado String donde estan todas las reservas
     * @return Devuelve un array con las reservas separadas
     */
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

    /**
     * Metodo DELETE de Reserva por su ID
     *
     * @param numero ID de la reserva
     */
    public void eliminar(long numero){
        String resultado = this.client.target("http://localhost:8080/reservas/"+numero)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .delete(String.class);

        System.out.println("Resultado: \n" + resultado);
    }

    /**
     * Metodo PUT de Reserva
     *
     * @param fechaInicio Fecha de inicio de la reserva
     * @param fechaFin Fecha de finalizacion de la reserva
     * @param importeTotal Importe total de la reserva
     * @param c Cliente de la reserva
     * @param h Habitacion de la reserva
     */
    public void modificar(long idReserva, LocalDate fechaInicio, LocalDate fechaFin, float importeTotal, Cliente c, Habitacion h){
        try{
            Reserva res = new Reserva(idReserva, fechaInicio, fechaFin, importeTotal, c ,h);

            System.out.println(res);

            WebTarget wt = this.client.target("http://localhost:8080/reservas/"+ idReserva);
            Invocation.Builder invocationBuilder = wt.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.put(Entity.entity(res.toString(),MediaType.APPLICATION_JSON));

            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
