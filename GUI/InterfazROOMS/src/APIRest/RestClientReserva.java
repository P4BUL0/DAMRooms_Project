package APIRest;

import com.google.gson.Gson;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

public class RestClientReserva {
    Client client;

    public RestClientReserva(){
        this.client = ClientBuilder.newClient();
    }

    public void crear(LocalDate fechaInicio, LocalDate fechaFin, float importeTotal, String estado, Cliente c, Habitacion h){
        //En el constructor hay que añadir cliente y habitación? Seteandole el primary key correspondiente?

        try{
            Reserva res = new Reserva(fechaInicio, fechaFin, importeTotal, estado, c ,h);
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

        r = gson.fromJson(resultado, Reserva.class);

        System.out.println("Resultado: \n" + resultado);
        return resultado;
    }

    public void eliminar(long numero){
        String resultado = this.client.target("http://localhost:8080/reservas/"+numero)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .delete(String.class);

        System.out.println("Resultado: \n" + resultado);
    }

    public void modificar(long numero){
        consultar(numero);

    }
}
