package APIRest;

import com.google.gson.Gson;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClientHabitacion {
    Client client;

    public RestClientHabitacion(){
        this.client = ClientBuilder.newClient();
    }

    public void crear(String tipo, String caracteristicas, float importe_noche){
        try{
            Habitacion habitacion = new Habitacion(tipo, caracteristicas, importe_noche);
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

    public void eliminar(long numero){
        String resultado = this.client.target("http://localhost:8080/habitaciones/"+numero)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .delete(String.class);

        System.out.println("Resultado: \n" + resultado);
    }

    public void modificar(long numero){
        //Comentar la posibilidad de que colsultar devuelva el objeto directamente.
        consultar(numero);

    }


}
