package ies.mz.ProyectoDAMROOMS.repository;

import ies.mz.ProyectoDAMROOMS.domain.Habitaciones;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.Set;

@Repository
public interface HabitacionRepository extends CrudRepository<Habitaciones, Long> {
    Set<Habitaciones> findAll();
    Optional<Habitaciones> findById(long id);
    Set<Habitaciones> deleteByTipo(String tipo);
}
