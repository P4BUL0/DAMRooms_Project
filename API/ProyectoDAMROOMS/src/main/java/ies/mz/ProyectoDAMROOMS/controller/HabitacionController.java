package ies.mz.ProyectoDAMROOMS.controller;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.domain.Habitacion;
import ies.mz.ProyectoDAMROOMS.service.HabitacionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/habitaciones/id")
    public ResponseEntity<Set<Habitacion>> getHabitacionById(@RequestParam(value = "id", defaultValue = "") long id) {
        Set<Habitacion> h = null;
        h = habitacionService.findById(id);
        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    @PostMapping("/habitaciones")
    public ResponseEntity<Habitacion> addHabitacion(@RequestBody Habitacion h) {
        Habitacion addedHabitacion = habitacionService.addHabitacion(h);
        return new ResponseEntity<>(addedHabitacion, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Habitacion> modifyHabitacion(@PathVariable long id, @RequestBody Habitacion newHabitacion) {
        Habitacion h = habitacionService.modifyHabitacion(id, newHabitacion);
        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    @DeleteMapping("/habitaciones/id")
    public ResponseEntity<Response> deleteHabitacion(@PathVariable long id)
    {
        habitacionService.deleteHabitacion(id);
        return new ResponseEntity<>(Response.noErrorResponse(),
                HttpStatus.OK);
    }

}
