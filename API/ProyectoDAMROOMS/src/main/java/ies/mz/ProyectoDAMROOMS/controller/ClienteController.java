package ies.mz.ProyectoDAMROOMS.controller;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.exception.HabitacionNotFoundException;
import ies.mz.ProyectoDAMROOMS.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Tag(name = "CLiente", description = "Catálogo de clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Obtiene el listado de clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Listado de clientes",
                    content = @Content(
                            array = @ArraySchema(
                                    schema = @Schema(
                                            implementation = Cliente.class)))),
    })
    @GetMapping("/clientes")
    public ResponseEntity<Set<Cliente>> getClientes(@RequestParam(value = "id", defaultValue = "") String id) {
        Set<Cliente> cliente = null;
        Set<Cliente> cliente2 = null;
        if (id.equals(""))
            cliente = clienteService.findAll();
        else
            cliente2 = clienteService.findByDni(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @Operation(summary = "Obtiene el clientes por su DNI")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Cliente por su DNI",
                    content = @Content(
                            array = @ArraySchema(
                                    schema = @Schema(
                                            implementation = Cliente.class)))),
    })
    @GetMapping("/clientes/{dni}")
    public ResponseEntity<Set<Cliente>> getClienteByDni(@RequestParam(value = "dni", defaultValue = "") String dni) {
        Set<Cliente> cliente = null;
        if (dni.equals(""))
            cliente = clienteService.findAll();
        else
        cliente = clienteService.findByDni(dni);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @Operation(summary = "Obtiene el clientes por su nombre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Cliente por su nombre",
                    content = @Content(
                            array = @ArraySchema(
                                    schema = @Schema(
                                            implementation = Cliente.class)))),
    })
    @GetMapping("/clienteNombre")
    public ResponseEntity<Set<Cliente>> getClienteByNombre(@RequestParam(value = "nombre", defaultValue = "") String nombre) {
        Set<Cliente> cliente = null;
        if (nombre.equals(""))
            cliente = clienteService.findAll();
        else
        cliente = clienteService.findByNombre(nombre);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @Operation(summary = "Registra un nuevo cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se registra el cliente",
                    content = @Content(schema = @Schema(implementation = Cliente.class)))
    })
    @PostMapping("/clientes")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
        Cliente addedCliente = clienteService.addCliente(cliente);
        return new ResponseEntity<>(addedCliente, HttpStatus.OK);
    }

    @Operation(summary = "Modifica un cliente en el catálogo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se modifica el cliente",
                    content = @Content(schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "404", description = "El cliente no existe",
                    content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @PutMapping(value = "/clientes/{dni}", produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<Cliente> modifyCliente(@PathVariable String dni, @RequestBody Cliente newCliente) {
        Cliente cliente = clienteService.modifyCliente(dni, newCliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @Operation(summary = "Elimina un cliente por su DNI")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se elimina el cliente",
                    content = @Content(schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "404", description = "El cliente no existe",
                    content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @DeleteMapping(value = "/clientes/{dni}", produces = "application/json")
    public ResponseEntity<Response> deleteClienteByDni(@PathVariable String dni)
    {
        clienteService.deleteByDni(dni);
        return new ResponseEntity<>(Response.noErrorResponse(),
                HttpStatus.OK);
    }


    @ExceptionHandler(HabitacionNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response>handleException(HabitacionNotFoundException pnfe) {
        Response response = Response.errorResponse(Response.NOT_FOUND,
                pnfe.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
