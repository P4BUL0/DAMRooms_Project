package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;

import java.util.Optional;
import java.util.Set;

public interface ClienteService {
    Set<Cliente> findByNombre(String nombre);
}
