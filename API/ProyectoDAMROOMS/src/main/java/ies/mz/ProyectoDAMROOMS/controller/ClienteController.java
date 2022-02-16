package ies.mz.ProyectoDAMROOMS.controller;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.domain.Reserva;
import ies.mz.ProyectoDAMROOMS.exception.HabitacionNotFoundException;
import ies.mz.ProyectoDAMROOMS.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

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

    @GetMapping("/clientesdni")
    public ResponseEntity<Set<Cliente>> getClienteByDni(@RequestParam(value = "dni", defaultValue = "") String dni) {
        Set<Cliente> cliente = null;
        if (dni.equals(""))
            cliente = clienteService.findAll();
        else
        cliente = clienteService.findByDni(dni);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/clientesNombre")
    public ResponseEntity<Set<Cliente>> getClienteByNombre(@RequestParam(value = "nombre", defaultValue = "") String nombre) {
        Set<Cliente> cliente = null;
        if (nombre.equals(""))
            cliente = clienteService.findAll();
        else
        cliente = clienteService.findByNombre(nombre);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
        Cliente addedCliente = clienteService.addCliente(cliente);
        return new ResponseEntity<>(addedCliente, HttpStatus.OK);
    }

    @PutMapping("/clientes/{dni}")
    public ResponseEntity<Cliente> modifyCliente(@PathVariable String dni, @RequestBody Cliente newCliente) {
        Cliente cliente = clienteService.modifyCliente(dni, newCliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{dni}")
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
