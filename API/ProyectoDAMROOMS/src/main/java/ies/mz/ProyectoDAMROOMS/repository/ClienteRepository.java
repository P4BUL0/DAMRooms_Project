package ies.mz.ProyectoDAMROOMS.repository;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.domain.Habitacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Set<Cliente> findAll();
    Set<Cliente> findByNombre(String nombre);
    Set<Cliente> findByDni(String dni);
    void deleteByDni(String dni);
    Set<Habitacion> deleteAllByDni(String dni);
}
