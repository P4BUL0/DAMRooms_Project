package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Reserva;

import java.util.Optional;
import java.util.Set;

public interface ReservaService {
    Set<Reserva> findAll();
    Optional<Reserva> findById(long id);
    Set<Reserva> findByFechaInicio(String fechaInicio);
    Reserva addReserva(Reserva reserva);
    Reserva modifyReserva(long id, Reserva reserva);
    Reserva modifyReservaEstado(long id, String estado, Reserva reserva);
    void deleteReserva(long id);
}
