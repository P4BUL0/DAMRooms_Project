package ies.mz.ProyectoDAMROOMS.controller;

import ies.mz.ProyectoDAMROOMS.domain.Habitacion;
import ies.mz.ProyectoDAMROOMS.exception.HabitacionNotFoundException;
import ies.mz.ProyectoDAMROOMS.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/habitacionesId")
    public ResponseEntity<Optional<Habitacion>> getHabitacionById(@RequestParam(value = "id", defaultValue = "") long id) {
        Optional<Habitacion> habitacion = null;
        Set<Habitacion> habitacions = null;
        if (id < 0)
            habitacions = habitacionService.findAll();
        else
            habitacion = habitacionService.findById(id);
        return new ResponseEntity<>(habitacion, HttpStatus.OK);
    }

    @PostMapping("/habitaciones")
    public ResponseEntity<Habitacion> addHabitacion(@RequestBody Habitacion habitacion) {
        Habitacion addedHabitacion = habitacionService.addHabitacion(habitacion);
        return new ResponseEntity<>(addedHabitacion, HttpStatus.OK);
    }

    @PutMapping("/habitaciones/{id}")
    public ResponseEntity<Habitacion> modifyHabitacion(@PathVariable long id, @RequestBody Habitacion newHabitacion) {
        Habitacion h = habitacionService.modifyHabitacion(id, newHabitacion);
        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    @DeleteMapping("/habitaciones/{id}")
    public ResponseEntity<Response> deleteHabitacion(@PathVariable long id)
    {
        habitacionService.deleteHabitacion(id);
        return new ResponseEntity<>(Response.noErrorResponse(),
                HttpStatus.OK);
    }

    @ExceptionHandler(HabitacionNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response>
    handleException(HabitacionNotFoundException pnfe) {
        Response response = Response.errorResponse(Response.NOT_FOUND,
                pnfe.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
