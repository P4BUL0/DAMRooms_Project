package ies.mz.ProyectoDAMROOMS.controller;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.domain.Habitaciones;
import ies.mz.ProyectoDAMROOMS.domain.Reserva;
import ies.mz.ProyectoDAMROOMS.exception.HabitacionNotFoundException;
import ies.mz.ProyectoDAMROOMS.service.ClienteService;
import ies.mz.ProyectoDAMROOMS.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/reservas/{idReserva}")
    public ResponseEntity<Optional<Reserva>> getReservasById(@PathVariable long idReserva) {
        Optional<Reserva> reservas = null;
        reservas = reservaService.findById(idReserva);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/reservasFecha")
    public ResponseEntity<Set<Reserva>> getReserva(@RequestParam String fechaInicio) {
        Set<Reserva> reservas = null;

        if (reservas.equals(""))
            reservas = reservaService.findAll();
        else
        reservas = reservaService.findByFechaInicio(fechaInicio);

        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @PostMapping("/reservas")
    public ResponseEntity<Reserva> addReserva(@RequestBody Reserva reserva) {
        Habitaciones habitaciones = null;
        Reserva addedReserva = reservaService.addReserva(reserva);
        float importeNoche = habitaciones.getImporte_noche();
        addedReserva.calcImporteTotal(importeNoche);
        return new ResponseEntity<>(addedReserva, HttpStatus.OK);
    }

    @PutMapping("/reservas/{idReserva}")
    public ResponseEntity<Reserva> modifyReserva(@PathVariable long idReserva, @RequestBody Reserva newReserva) {
        newReserva.setEstado("Reservada");
        Reserva reserva = reservaService.modifyReserva(idReserva, newReserva);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PutMapping("/reservas/{idReserva}/estado")
    public ResponseEntity<Reserva> modifyReservaEstado(@PathVariable long idReserva, String estado, @RequestBody Reserva newReserva) {
        if (estado.equals("checkIn")) {
            newReserva.setEstado("Ocupada");
        }else if (estado.equals("checkOut")) {
            newReserva.setEstado("Libre");
        }
        Reserva reserva = reservaService.modifyReservaEstado(idReserva, estado, newReserva);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

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
