package ies.mz.ProyectoDAMROOMS.repository;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.domain.Habitacion;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface HabitacionRepository extends CrudRepository<Habitacion, Long> {
    Set<Habitacion> findAll();
    Set<Habitacion> findById();
}
