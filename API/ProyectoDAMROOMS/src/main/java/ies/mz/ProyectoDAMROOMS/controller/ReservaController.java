package ies.mz.ProyectoDAMROOMS.controller;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.domain.Habitacion;
import ies.mz.ProyectoDAMROOMS.domain.Reserva;
import ies.mz.ProyectoDAMROOMS.exception.HabitacionNotFoundException;
import ies.mz.ProyectoDAMROOMS.service.ClienteService;
import ies.mz.ProyectoDAMROOMS.service.ReservaService;
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

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@Tag(name = "Reservas", description = "Catálogo de reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Obtiene una reserva por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Reserva por su id",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Reserva.class)))),
    })
    @GetMapping(value = "/reservas/{idReserva}", produces = "application/json")
    public ResponseEntity<Optional<Reserva>> getReservasById(@PathVariable long idReserva) {
        Optional<Reserva> reservas;
        reservas = reservaService.findById(idReserva);

        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @Operation(summary = "Obtiene el listado de reservas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Listado de reservas",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Reserva.class)))),
    })
    @GetMapping(value = "/reservas", produces = "application/json")
    public ResponseEntity<Set<Reserva>> getReservas(@RequestParam(value = "id", defaultValue = "") String id) {
        Set<Reserva> reserva = null;
        if (id.equals(""))
            reserva = reservaService.findAll();

        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @Operation(summary = "Obtiene la reserva por su fecha")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Reserva por su fecha",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Reserva.class)))),
    })
    @GetMapping(value = "/reservasFecha", produces = "application/json")
    public ResponseEntity<Set<Reserva>> getReserva(@RequestParam String fechaInicio) {
        Set<Reserva> reservas = null;

        if (reservas.equals(""))
            reservas = reservaService.findAll();
        else
        reservas = reservaService.findByFechaInicio(fechaInicio);

        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @Operation(summary = "Obtiene el DNI del cliente por la id de reserva")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "DNI del cliente por la id de reserva",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Reserva.class)))),
    })
    @GetMapping(value = "/reservas/getDni/{id}", produces = "application/json")
    public ResponseEntity<String> getDniFromReserva(@PathVariable long id){
        Optional<Reserva> reserva = reservaService.findById(id);
        String dni = reservaService.getDni(reserva);

        return new ResponseEntity<>(dni, HttpStatus.OK);
    }

    @Operation(summary = "Obtiene la reserva por el DNI del cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Obtiene la reserva por el DNI del cliente",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Reserva.class)))),
    })
    @GetMapping("/reservas/cliente/{dni}")
    public ResponseEntity<List<Reserva>> getReservasFromDni(@PathVariable String dni){
        Set<Cliente> cliente = clienteService.findByDni(dni);
        Cliente cliente1 = cliente.iterator().next();
        List<Reserva> reservas = cliente1.getReservas();

        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @Operation(summary = "Registra una nueva reserva")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se registra la reserva",
                    content = @Content(schema = @Schema(implementation = Reserva.class)))
    })
    @PostMapping(value = "/reservas", produces = "application/json")
    public ResponseEntity<Reserva> addReserva(@RequestBody Reserva reserva) {
        System.out.println("-------------------------------");
        System.out.println(reserva.toString());
        Reserva addedReserva = reservaService.addReserva(reserva);

        return new ResponseEntity<>(addedReserva, HttpStatus.OK);
    }

    @Operation(summary = "Modifica una reserva en el listado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se modifica la reserva",
                    content = @Content(schema = @Schema(implementation = Reserva.class))),
            @ApiResponse(responseCode = "404", description = "La reserva no existe",
                    content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @PutMapping(value = "/reservas/{idReserva}", produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<Reserva> modifyReserva(@PathVariable long idReserva, @RequestBody Reserva newReserva) {
        Reserva reserva = reservaService.modifyReserva(idReserva, newReserva);

        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @Operation(summary = "Modifica el estado de una reserva a 'Activa'")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se modifica el estado de la reserva",
                    content = @Content(schema = @Schema(implementation = Reserva.class))),
            @ApiResponse(responseCode = "404", description = "La reserva no existe",
                    content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @PutMapping(value = "/reservas/{idReserva}/checkIn", produces = "application/json",
            consumes = "application/json" )
    public ResponseEntity<Reserva> modifyReservaCheckIn(@PathVariable long idReserva) {
        Reserva modifyReserva = reservaService.modifyReservaCheckIn(idReserva);

        return new ResponseEntity<>(modifyReserva, HttpStatus.OK);
    }

    @Operation(summary = "Modifica el estado de una reserva a 'Finalizada'")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se modifica el estado de la reserva",
                    content = @Content(schema = @Schema(implementation = Reserva.class))),
            @ApiResponse(responseCode = "404", description = "La reserva no existe",
                    content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @PutMapping(value = "/reservas/{idReserva}/checkOut", produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<Reserva> modifyReservaCheckOut(@PathVariable long idReserva) {
        Reserva modifyReserva = reservaService.modifyReservaCheckOut(idReserva);

        return new ResponseEntity<>(modifyReserva, HttpStatus.OK);
    }

    @Operation(summary = "Elimina una reserva")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se elimina la reserva",
                    content = @Content(schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "404", description = "La reserva no existe",
                    content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @DeleteMapping("/reservas/{idReserva}")
    public ResponseEntity<Response> deleteReserva(@PathVariable long idReserva)
    {
        reservaService.deleteReserva(idReserva);

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