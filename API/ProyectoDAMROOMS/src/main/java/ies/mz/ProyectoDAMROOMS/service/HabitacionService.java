package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Habitaciones;

import java.util.Optional;
import java.util.Set;


public interface HabitacionService {
    Set<Habitaciones> findAll();
    Optional<Habitaciones> findById(long id);
    Habitaciones addHabitacion(Habitaciones habitacion);
    Habitaciones modifyHabitacion(long id, Habitaciones habitacion);
    void deleteHabitacion(long id);
    void deleteAll(String tipo);
}
