package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Set<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Set<Cliente> findByDni(String dni) {
        return clienteRepository.findByNombre(dni);
    }

    @Override
    public Set<Cliente> findByNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    @Override
    public Cliente addCliente(Cliente vuelo) {
        return clienteRepository.save(vuelo);
    }

    @Override
    public Cliente modifyCliente(String dni, Cliente newCliente) {
        Cliente vuelo = (Cliente) clienteRepository.findByDni(dni);
        newCliente.setDni(vuelo.getDni());
        return clienteRepository.save(newCliente);
    }

}
