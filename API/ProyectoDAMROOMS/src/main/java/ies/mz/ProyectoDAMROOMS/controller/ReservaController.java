package ies.mz.ProyectoDAMROOMS.controller;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.domain.Reserva;
import ies.mz.ProyectoDAMROOMS.exception.HabitacionNotFoundException;
import ies.mz.ProyectoDAMROOMS.service.ClienteService;
import ies.mz.ProyectoDAMROOMS.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        Optional<Reserva> reservas;
        reservas = reservaService.findById(idReserva);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/reservas")
    public ResponseEntity<Set<Reserva>> getReservas(@RequestParam(value = "id", defaultValue = "") String id) {
        Set<Reserva> reserva = null;
        if (id.equals(""))
            reserva = reservaService.findAll();
        return new ResponseEntity<>(reserva, HttpStatus.OK);
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

    @GetMapping("/reservas/getDni/{id}")
    public ResponseEntity<String> getDniFromReserva(@PathVariable long id){
        Optional<Reserva> reserva = reservaService.findById(id);
        String dni = reservaService.getDni(reserva);

        return new ResponseEntity<>(dni, HttpStatus.OK);
    }

    @GetMapping("/reservas/cliente/{dni}")
    public ResponseEntity<List<Reserva>> getReservasFromDni(@PathVariable String dni){
        Set<Cliente> cliente = clienteService.findByDni(dni);
        Cliente cliente1 = cliente.iterator().next();
        List<Reserva> reservas = cliente1.getReservas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @PostMapping("/reservas")
    public ResponseEntity<Reserva> addReserva(@RequestBody Reserva reserva) {
        System.out.println("-------------------------------");
        System.out.println(reserva.toString());
        Reserva addedReserva = reservaService.addReserva(reserva);
        return new ResponseEntity<>(addedReserva, HttpStatus.OK);
    }

    @PutMapping("/reservas/{idReserva}")
    public ResponseEntity<Reserva> modifyReserva(@PathVariable long idReserva, @RequestBody Reserva newReserva) {
        //newReserva.setEstado("Reservada");
        Reserva reserva = reservaService.modifyReserva(idReserva, newReserva);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PutMapping("/reservas/{idReserva}/checkIn")
    public ResponseEntity<Reserva> modifyReservaCheckIn(@PathVariable long idReserva,  @RequestBody Reserva newReserva) {
        Reserva modifyReserva = reservaService.modifyReservaCheckIn(idReserva, newReserva);
        return new ResponseEntity<>(modifyReserva, HttpStatus.OK);
    }

    @PutMapping("/reservas/{idReserva}/checkOut")
    public ResponseEntity<Reserva> modifyReservaCheckOut(@PathVariable long idReserva, @RequestBody Reserva newReserva) {
        Reserva modifyReserva = reservaService.modifyReservaCheckOut(idReserva, newReserva);
        return new ResponseEntity<>(modifyReserva, HttpStatus.OK);
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
