package ies.mz.ProyectoDAMROOMS.controller;

import ies.mz.ProyectoDAMROOMS.domain.Habitaciones;
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

    @GetMapping("/habitaciones/{numero}")
    public ResponseEntity<Optional<Habitaciones>> getHabitacionById(@PathVariable long numero) {
        Optional<Habitaciones> habitacion = null;
            habitacion = habitacionService.findById(numero);
        return new ResponseEntity<>(habitacion, HttpStatus.OK);
    }

    @PostMapping("/habitaciones")
    public ResponseEntity<Habitaciones> addHabitacion(@RequestBody Habitaciones habitacion) {
        Habitaciones addedHabitacion = habitacionService.addHabitacion(habitacion);
        return new ResponseEntity<>(addedHabitacion, HttpStatus.OK);
    }

    @PutMapping("/habitaciones/{numero}")
    public ResponseEntity<Habitaciones> modifyHabitacion(@PathVariable long numero, @RequestBody Habitaciones newHabitacion) {
        Habitaciones habitacion = habitacionService.modifyHabitacion(numero, newHabitacion);
        return new ResponseEntity<>(habitacion, HttpStatus.OK);
    }

    @DeleteMapping("/habitaciones/{numero}")
    public ResponseEntity<Response> deleteHabitacion(@PathVariable long numero)
    {
        habitacionService.deleteHabitacion(numero);
        return new ResponseEntity<>(Response.noErrorResponse(),
                HttpStatus.OK);
    }

    @DeleteMapping("/HabitacionesTipo/{tipo}")
    public ResponseEntity<Response> deletAllHabitaciones(@PathVariable String tipo)
    {
        habitacionService.deleteAll(tipo);
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
