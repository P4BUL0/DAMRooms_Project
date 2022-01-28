package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Habitacion;

import java.util.Set;

public interface HabitacionService {
    Set<Habitacion> findAll();
    Set<Habitacion> findById(long id);
    Habitacion addHabitacion();
    Habitacion modifyHabitacion();
    void deleteHabitacion(long id);
}
