package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Reserva;

import java.util.Set;

public interface ReservaService {
    Set<Reserva> findAll();
    Set<Reserva> findById(long id);
    Reserva addReserva(Reserva reserva);
    Reserva modifyReserva(long id, Reserva reserva);
    void deleteReserva(long id);
}
