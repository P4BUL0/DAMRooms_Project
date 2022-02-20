package APIRest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.Collection;

public class RestClientCliente {
    Client client;

    public RestClientCliente(){
        this.client = ClientBuilder.newClient();
    }

    public void crear(String dni, String nombre, String apellidos, String direccion, int telefono){
        try{
            Cliente c = new Cliente(dni, nombre, apellidos, direccion, telefono);
            WebTarget wt = this.client.target("http://localhost:8080/clientes");
            Invocation.Builder invocationBuilder = wt.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.post(Entity.entity(c.toString(),MediaType.APPLICATION_JSON));
            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
            System.out.println();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String consultar(String dni){
        Gson gson = new Gson();
        Cliente c = new Cliente();

        String resultado = this.client.target("http://localhost:8080/clientes/"+dni)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        Type collectionType = new TypeToken<Collection<Cliente>>(){}.getType();
        Collection<Cliente> clientes = gson.fromJson(resultado, collectionType);

        System.out.println("Resultado: \n" + clientes);
        return resultado;
    }

    public void eliminar(String dni){
        String resultado = this.client.target("http://localhost:8080/clientes/"+dni)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .delete(String.class);

        System.out.println("Resultado: \n" + resultado);
    }

    public void modificar(String dni, String nombre, String apellidos, String dirección, int telefono){
        try{
            Gson gson = new Gson();
            Cliente c = new Cliente(dni, nombre, apellidos, dirección, telefono);
            WebTarget wt = this.client.target("http://localhost:8080/clientes/" + dni);
            Invocation.Builder invocationBuilder = wt.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.put(Entity.entity(c.toString(),MediaType.APPLICATION_JSON));
            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
            System.out.println();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
