package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;

import java.util.Set;

public interface ClienteService {
    Set<Cliente> findAll();
    Set<Cliente> findByDni(String dni);
    Set<Cliente> findByNombre(String nombre);
    Cliente addCliente(Cliente cliente);
    Cliente modifyCliente(String dni, Cliente cliente);
    void deleteByDni(String dni);
    void deleteAllByDni(String dni);
    //void deleteByNombre(String nombre);
}
