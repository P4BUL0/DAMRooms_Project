package ies.mz.ProyectoDAMROOMS.controller;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.domain.Reserva;
import ies.mz.ProyectoDAMROOMS.domain.ReservaId;
import ies.mz.ProyectoDAMROOMS.exception.HabitacionNotFoundException;
import ies.mz.ProyectoDAMROOMS.service.ClienteService;
import ies.mz.ProyectoDAMROOMS.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/reservas")
    public ResponseEntity<Set<Reserva>> getReservas(@RequestParam(value =
            "id", defaultValue = "") String id) {
        Set<Reserva> reservas = null;
        Optional<Reserva> reservas2 = null;
        if (id.equals(""))
            reservas = reservaService.findAll();
        else
            reservas2 = reservaService.findById(Long.parseLong(id));
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/reservas/{idReserva}")
    public ResponseEntity<Optional<Reserva>> getReservaById(@PathVariable long idReserva) {
        Optional<Reserva> reserva = null;
        reserva = reservaService.findById(idReserva);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PostMapping("/reservas/{fechaFin}")
    public ResponseEntity<Reserva> addReserva(@RequestBody ReservaId reservaId, @PathVariable LocalDate fechaFin) {

        reservaId.getDni();

        Cliente cliente = new Cliente();


        cliente = (Cliente) clienteService.findByDni(reservaId.getDni());

        Reserva reserva = new Reserva();

        System.out.println(cliente.toString());

        //reserva.calcImporteTotal(reserva.getHabitaciones().getImporte_noche());

        Reserva addedReserva = reservaService.addReserva(reserva);

        return new ResponseEntity<>(addedReserva, HttpStatus.OK);
    }

    @PutMapping("/reservas/{idReserva}")
    public ResponseEntity<Reserva> modifyReserva(@PathVariable long id, @RequestBody Reserva newReserva) {
        Reserva reserva = reservaService.modifyReserva(id, newReserva);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PutMapping("/reservas/{idReserva}/checkIn")
    public ResponseEntity<Reserva> modifyReservaCheckIn(@PathVariable long id, @RequestBody Reserva newReserva) {
        Reserva reserva = reservaService.modifyReserva(id, newReserva);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @DeleteMapping("/reservas/{id}")
    public ResponseEntity<Response> deleteReserva(@PathVariable long id)
    {
        reservaService.deleteReserva(id);
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
