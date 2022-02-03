package ies.mz.ProyectoDAMROOMS.repository;

import ies.mz.ProyectoDAMROOMS.domain.Habitaciones;
import ies.mz.ProyectoDAMROOMS.domain.Reserva;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface ReservaRepository extends CrudRepository<Reserva, Long> {
    Set<Reserva> findAll();
    Optional<Reserva> findById(long id);

}
