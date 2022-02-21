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

/**
 * @author Pablo, Boix y Lazaro
 * @version 1.0
 * @since 2022-02-22
 */
public class RestClientCliente {
    Client client;

    public RestClientCliente(){
        this.client = ClientBuilder.newClient();
    }

    /**
     * Metodo POST de Cliente
     *
     * @param dni DNI del cliente
     * @param nombre Nombre del cliente
     * @param apellidos Apellidos del cliente
     * @param direccion Direccion del cliente
     * @param telefono Telefono del cliente
     */
    public void crear(String dni, String nombre, String apellidos, String direccion, int telefono){
        try{
            Cliente c = new Cliente(dni, nombre, apellidos, direccion, telefono);

            WebTarget wt = this.client.target("http://localhost:8080/clientes");
            Invocation.Builder invocationBuilder = wt.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.post(Entity.entity(c.toString(),MediaType.APPLICATION_JSON));

            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo GET de Cliente por su DNI
     *
     * @param dni DNI del cliente
     * @return Devuelve un String con el json sacado de la API con la peticion GET
     */
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

    /**
     * Metodo GET de Cliente por su DNI
     *
     * @param dni DNI del cliente
     * @return Devuelve un Cliente sacado de la API con la peticion GET
     */
    public Cliente obtenerClienteByDni(String dni){
        String resultado = this.client.target("http://localhost:8080/clientes/"+dni)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        resultado = resultado.replace("[", "");
        resultado = resultado.replace("]", "");

        Cliente cliente = new Gson().fromJson(resultado, Cliente.class);

        return cliente;
    }

    /**
     * Metodo GET de todos los clientes
     *
     * @return Devuelve una lista de clientes
     */
    public List<Cliente> consultarLista(){
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

    /**
     * Metodo para traducir el array que devuelve la API
     *
     * @param array Un String con el formato de llaves siguiente: [{"ejemplo": "esto es un ejemplo"},{"ejemplo": "este es otro ejemplo"}]
     * @return Devuelve un array con los objetos separados
     */
    public String[] jsonToArray(String array){

        array = array.replace("[", "");
        array = array.replace("]", "");
        System.out.println(array);
        String[] lista = array.split("}");

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

    /**
     * Metodo DELETE de Cliente por su DNI
     *
     * @param dni DNI del cliente
     */
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

    /**
     * Metodo PUT de Cliente
     *
     * @param dni DNI del cliente
     * @param nombre Nombre del cliente
     * @param apellidos Apellidos del cliente
     * @param direccion Direccion del cliente
     * @param telefono Telefono del cliente
     */
    public void modificar(String dni, String nombre, String apellidos, String direccion, int telefono){
        try{
            Cliente c = new Cliente(dni, nombre, apellidos, direccion, telefono);

            WebTarget wt = this.client.target("http://localhost:8080/clientes/" + dni);
            Invocation.Builder invocationBuilder = wt.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.put(Entity.entity(c.toString(),MediaType.APPLICATION_JSON));

            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
