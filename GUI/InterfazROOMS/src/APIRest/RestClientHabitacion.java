package APIRest;

import com.google.gson.Gson;

import javax.swing.*;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Pablo, Boix y Lazaro
 * @version 1.0
 * @since 2022-02-22
 */
public class RestClientHabitacion {
    Client client;

    public RestClientHabitacion(){
        this.client = ClientBuilder.newClient();
    }

    /**
     * Metodo POST de Habitacion
     *
     * @param numero ID de la habitacion
     * @param tipo Tipo de la habitacion. Opciones: "Individual", "Doble", "Familiar", "Suite" y "Gran Suite"
     * @param caracteristicas Caracteristicas de la habitacion, incluyendo el tipo de cama. Ejemplo: "Luminosa, Wifi, Matrimonio"
     * @param importe_noche Importe por noche de la habitacion
     */
    public void crear(long numero, String tipo, String caracteristicas, float importe_noche){
        try{
            Habitacion habitacion = new Habitacion(numero, tipo, caracteristicas, importe_noche);
            WebTarget wt = this.client.target("http://localhost:8080/habitaciones");
            Invocation.Builder invocationBuilder = wt.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.post(Entity.entity(habitacion.toString(),MediaType.APPLICATION_JSON));
            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
            System.out.println();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo GET de Habitacion por su ID
     *
     * @param numero ID de la habitacion
     * @return Devuelve un String con el json sacado de la API con la peticion GET
     */
    public String consultar(long numero){
        Gson gson = new Gson();
        Habitacion h = new Habitacion();

        String resultado = this.client.target("http://localhost:8080/habitaciones/"+numero)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        h = gson.fromJson(resultado, Habitacion.class);

        System.out.println("Resultado: \n" + resultado);
        return resultado;
    }

    /**
     * Metodo GET de Habitacion por su ID
     *
     * @param numero ID de la habitacion
     * @return Devuelve una Habitacion
     */
    public Habitacion GetHabitacion(long numero){
        Gson gson = new Gson();
        Habitacion h = new Habitacion();

        String resultado = this.client.target("http://localhost:8080/habitaciones/"+numero)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        h = gson.fromJson(resultado, Habitacion.class);

        return h;
    }

    /**
     * Metodo DELETE de Habitacion por su ID
     *
     * @param numero ID de la habitacion
     */
    public void eliminar(long numero){
        try{
            String resultado = this.client.target("http://localhost:8080/habitaciones/"+numero)
                    .request(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .delete(String.class);

            System.out.println("Resultado: \n" + resultado);
        }catch (InternalServerErrorException isee){
            isee.printStackTrace();

            JOptionPane.showMessageDialog(null, "Existe una reserva con esta habitación", "Error al borrar la habitación",JOptionPane.ERROR_MESSAGE);
            System.out.println("Existe una reserva con esta habitación");
        }
    }

    /**
     * Metodo PUT de Habitacion
     *
     * @param numero ID de la habitacion
     * @param tipo Tipo de la habitacion. Opciones: "Individual", "Doble", "Familiar", "Suite" y "Gran Suite"
     * @param caracteristicas Caracteristicas de la habitacion, incluyendo el tipo de cama. Ejemplo: "Luminosa, Wifi, Matrimonio"
     * @param importe_noche Importe por noche de la habitacion
     */
    public void modificar(long numero, String tipo, String caracteristicas, float importe_noche){
        try{
            Habitacion h = new Habitacion(numero, tipo, caracteristicas, importe_noche);

            WebTarget wt = this.client.target("http://localhost:8080/habitaciones/" + numero);
            Invocation.Builder invocationBuilder = wt.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.put(Entity.entity(h.toString(),MediaType.APPLICATION_JSON));

            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
