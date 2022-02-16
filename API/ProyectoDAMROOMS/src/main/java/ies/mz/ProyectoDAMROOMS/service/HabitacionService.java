package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Habitacion;

import java.util.Optional;
import java.util.Set;


public interface HabitacionService {
    Set<Habitacion> findAll();
    Optional<Habitacion> findById(long id);
    Habitacion addHabitacion(Habitacion habitacion);
    Habitacion modifyHabitacion(long id, Habitacion habitacion);
    void deleteHabitacion(long id);
    void deleteAll(String tipo);
}
