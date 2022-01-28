package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;

import java.util.Optional;
import java.util.Set;

public interface ClienteService {
    Set<Cliente> findAll();
    Set<Cliente> findByDni(String dni);
    Set<Cliente> findByNombre(String nombre);
    Cliente addCliente(Cliente vuelo);
    Cliente modifyCliente(String dni, Cliente newCliente);

}
