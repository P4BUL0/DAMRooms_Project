package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.exception.HabitacionNotFoundException;
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
        return clienteRepository.findByDni(dni);
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
        Cliente c = (Cliente) clienteRepository.findByDni(dni);
        newCliente.setDni(c.getDni());
        return clienteRepository.save(newCliente);
    }

    @Override
    public void deleteCliente(String dni){
        clienteRepository.findByDni(dni);
        clienteRepository.deleteByDni(dni);
    }

    @Override
    public void deleteByDni(String dni) {
        clienteRepository.deleteByDni(dni);
    }

}
