package ies.mz.ProyectoDAMROOMS.microservicios;


import ies.mz.ProyectoDAMROOMS.domain.Habitacion;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {

    Client client;

    public RestClient(){
        this.client = ClientBuilder.newClient();
    }

    public void crearHabitacion(){

        try{
            Habitacion habitacion = new Habitacion(3l, "Doble", "Aire acondicionado", 850.0f);
            WebTarget wt = this.client.target("http://localhost:8080/hotel/");
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

    public void verHabitacion(float numero){
        String resultado = this.client.target("http://localhost:8080/habitaciones/"+numero)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("Resultado: \n" + resultado);
    }
}
