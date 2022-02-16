package APIRest;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {

    Client client;

    public RestClient(){
        this.client = ClientBuilder.newClient();
    }

    //Métodos habitación
    public void crearHabitacion(String tipo, String caracteristicas, float importe_noche){

        try{
            Habitacion habitacion = new Habitacion(tipo, caracteristicas, importe_noche);
            WebTarget wt = this.client.target("http://localhost:8080/habitaciones");
            Invocation.Builder invocationBuilder =
                    wt.request(MediaType.APPLICATION_JSON);
            Response response =
                    invocationBuilder.post(Entity.entity(habitacion.toString(),MediaType.APPLICATION_JSON));
            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
            System.out.println();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String verHabitacion(long numero){
        System.out.println(numero);
        String resultado = this.client.target("http://localhost:8080/habitaciones/"+numero)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("Resultado: \n" + resultado);
        return resultado;
    }


    public void borrarHabitacion(long numero){
        String resultado = this.client.target("http://localhost:8080/habitaciones/"+numero)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .delete(String.class);

        System.out.println("Resultado: \n" + resultado);
    }


    //Métodos cliente

    public void crearCliente(String dni, String nombre, String apellidos, String direccion, int telefono){

        try{
            Cliente c = new Cliente(dni, nombre, apellidos, direccion, telefono);
            WebTarget wt = this.client.target("http://localhost:8080/clientes");
            Invocation.Builder invocationBuilder =
                    wt.request(MediaType.APPLICATION_JSON);
            Response response =
                    invocationBuilder.post(Entity.entity(c.toString(),MediaType.APPLICATION_JSON));
            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
            System.out.println();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String verCliente(String dni){
        String resultado = this.client.target("http://localhost:8080/clientesdni?dni="+dni)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("Resultado: \n" + resultado);
        return resultado;
    }


    //Métodos reserva
}
