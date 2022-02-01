package ies.mz.ProyectoDAMROOMS.repository;

import ies.mz.ProyectoDAMROOMS.domain.Habitacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.Set;

@Repository
public interface HabitacionRepository extends CrudRepository<Habitacion, Long> {
    Set<Habitacion> findAll();
    Optional<Habitacion> findById(long id);
}
