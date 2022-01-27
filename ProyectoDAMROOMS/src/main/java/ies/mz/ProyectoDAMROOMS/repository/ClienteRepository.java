package ies.mz.ProyectoDAMROOMS.repository;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Set<Cliente> findByNombre(String nombre);
}
