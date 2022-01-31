package ies.mz.ProyectoDAMROOMS.controller;

import ies.mz.ProyectoDAMROOMS.domain.Reserva;
import ies.mz.ProyectoDAMROOMS.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/reservas/id")
    public ResponseEntity<Set<Reserva>> getReservaById(@RequestParam(value = "id", defaultValue = "") long id) {
        Set<Reserva> reserva = null;
        reserva = reservaService.findById(id);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PostMapping("/reservas")
    public ResponseEntity<Reserva> addReserva(@RequestBody Reserva reserva) {
        Reserva addedReserva = reservaService.addReserva(reserva);
        return new ResponseEntity<>(addedReserva, HttpStatus.OK);
    }

    @PutMapping("/habitaciones/id")
    public ResponseEntity<Reserva> modifyReserva(@PathVariable long id, @RequestBody Reserva newReserva) {
        Reserva reserva = reservaService.modifyReserva(id, newReserva);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @DeleteMapping("/habitaciones/id")
    public ResponseEntity<Response> deleteReserva(@PathVariable long id)
    {
        reservaService.deleteReserva(id);
        return new ResponseEntity<>(Response.noErrorResponse(),
                HttpStatus.OK);
    }

}
