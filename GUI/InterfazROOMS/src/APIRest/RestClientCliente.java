package APIRest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        String resultado = this.client.target("http://localhost:8080/clientes/"+dni)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        Type collectionType = new TypeToken<Collection<Cliente>>(){}.getType();
        Collection<Cliente> clientes = gson.fromJson(resultado, collectionType);

        System.out.println("Resultado: \n" + clientes);
        return resultado;
    }

    public Cliente obtenerClienteByDni(String dni){
        Gson gson = new Gson();
        String resultado = this.client.target("http://localhost:8080/clientes/"+dni)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        Cliente cliente = new Gson().fromJson(resultado, Cliente.class);

        return cliente;
    }


    public List<Cliente> consultarLista(){
        Gson gson = new Gson();
        List<Cliente> clienteList = new ArrayList<>();
        String resultado = this.client.target("http://localhost:8080/clientes")
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);
        String[] listaClientes = jsonToArray(resultado);

        for (int i = 0; i < listaClientes.length; i++) {
            Cliente cliente = new Gson().fromJson(listaClientes[i], Cliente.class);
            clienteList.add(cliente);
        }

        return clienteList;
    }

    public String[] jsonToArray(String s ){

        s = s.replace("[", "");
        s = s.replace("]", "");
        System.out.println(s);
        String[] lista = s.split("}");

        for (int i = 0; i < lista.length; i++) {
            System.out.println("------");

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


    public void eliminar(String dni){

        try{
            String resultado = this.client.target("http://localhost:8080/clientes/"+dni)
                    .request(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .delete(String.class);

            System.out.println("Resultado: \n" + resultado);
        }catch (InternalServerErrorException isee){
            isee.printStackTrace();
            JOptionPane.showMessageDialog(null, "Existe una reserva con este cliente", "Error al borrar el cliente",JOptionPane.ERROR_MESSAGE);
            System.out.println("Existe una reserva con este cliente");
        }

    }

    public void modificar(String dni, String nombre, String apellidos, String dirección, int telefono){
        try{
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
