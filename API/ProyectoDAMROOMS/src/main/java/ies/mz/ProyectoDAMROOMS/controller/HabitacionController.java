package ies.mz.ProyectoDAMROOMS.controller;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.domain.Habitacion;
import ies.mz.ProyectoDAMROOMS.exception.HabitacionNotFoundException;
import ies.mz.ProyectoDAMROOMS.service.HabitacionService;
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

import java.util.Optional;
import java.util.Set;

@RestController
@Tag(name = "Habitaciones", description = "Catálogo de habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;

    @Operation(summary = "Obtiene una habitacion por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Habitacion por su id",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Habitacion.class)))),
    })
    @GetMapping(value = "/habitaciones/{numero}", produces = "application/json")
    public ResponseEntity<Optional<Habitacion>> getHabitacionById(@PathVariable long numero) {
        Optional<Habitacion> habitacion = null;
            habitacion = habitacionService.findById(numero);
        return new ResponseEntity<>(habitacion, HttpStatus.OK);
    }

    @Operation(summary = "Obtiene el listado de habitaciones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Listado de habitaciones",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Habitacion.class)))),
    })
    @GetMapping(value = "/habitaciones", produces = "application/json")
    public ResponseEntity<Set<Habitacion>> getHabitaciones(@RequestParam(value = "id", defaultValue = "") String id){
        Set<Habitacion> habitacion = null;
        if (id.equals(""))
            habitacion = habitacionService.findAll();
        return new ResponseEntity<>(habitacion, HttpStatus.OK);
    }

    @Operation(summary = "Registra una nueva habitacion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se registra la habitacion",
                    content = @Content(schema = @Schema(implementation = Habitacion.class)))
    })
    @PostMapping(value = "/habitaciones", produces = "application/json")
    public ResponseEntity<Habitacion> addHabitacion(@RequestBody Habitacion habitacion) {
        Habitacion addedHabitacion = habitacionService.addHabitacion(habitacion);
        return new ResponseEntity<>(addedHabitacion, HttpStatus.OK);
    }

    @Operation(summary = "Modifica una habitacion en el listado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se modifica la habitacion",
                    content = @Content(schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "404", description = "la habitacion no existe",
                    content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @PutMapping("/habitaciones/{numero}")
    public ResponseEntity<Habitacion> modifyHabitacion(@PathVariable long numero, @RequestBody Habitacion newHabitacion) {
        Habitacion habitacion = habitacionService.modifyHabitacion(numero, newHabitacion);
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
