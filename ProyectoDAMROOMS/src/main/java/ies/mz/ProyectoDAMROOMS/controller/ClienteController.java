package ies.mz.ProyectoDAMROOMS.controller;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@Tag(name = "Clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes/nombre")
    public ResponseEntity<Set<Cliente>> getClienteByNombre(@RequestParam(value = "nombre", defaultValue = "") String nombre) {
        Set<Cliente> vuelos = null;
        vuelos = clienteService.findByNombre(nombre);
        return new ResponseEntity<>(vuelos, HttpStatus.OK);
    }
}
