package ies.mz.ProyectoDAMROOMS.controller;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Tag(name = "Clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes/{dni}")
    public ResponseEntity<Cliente> getCliente(@PathVariable String dni) {
        Cliente c = (Cliente) clienteService.findByDni(dni);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping("/clientes/nombre")
    public ResponseEntity<Set<Cliente>> getClienteByNombre(@RequestParam(value = "nombre", defaultValue = "") String nombre) {
        Set<Cliente> c = null;
        c = clienteService.findByNombre(nombre);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente c) {
        Cliente addedCliente = clienteService.addCliente(c);
        return new ResponseEntity<>(addedCliente, HttpStatus.OK);
    }
}
