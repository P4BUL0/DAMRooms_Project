package ies.mz.ProyectoDAMROOMS.controller;

import ies.mz.ProyectoDAMROOMS.domain.Reserva;
import ies.mz.ProyectoDAMROOMS.exception.HabitacionNotFoundException;
import ies.mz.ProyectoDAMROOMS.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/reservas/{idReserva}")
    public ResponseEntity<Optional<Reserva>> getReservaById(@PathVariable long idReserva) {
        Optional<Reserva> reserva = null;
        reserva = reservaService.findById(idReserva);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PostMapping("/reservas")
    public ResponseEntity<Reserva> addReserva(@RequestBody Reserva reserva) {

        Reserva addedReserva = reservaService.addReserva(reserva);
        return new ResponseEntity<>(addedReserva, HttpStatus.OK);
    }

    @PutMapping("/reservas/{id}")
    public ResponseEntity<Reserva> modifyReserva(@PathVariable long id, @RequestBody Reserva newReserva) {
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
