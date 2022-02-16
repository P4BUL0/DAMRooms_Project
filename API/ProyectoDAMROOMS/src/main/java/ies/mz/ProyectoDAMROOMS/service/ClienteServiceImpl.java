package ies.mz.ProyectoDAMROOMS.service;

import ies.mz.ProyectoDAMROOMS.domain.Cliente;
import ies.mz.ProyectoDAMROOMS.exception.ClienteNotFoundException;
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
    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente modifyCliente(String dni, Cliente newCliente) {
        Cliente cliente = clienteRepository.findByDni(dni).stream().findFirst().get();
        newCliente.setDni(cliente.getDni());

        return clienteRepository.save(newCliente);
    }

    @Override
    public void deleteByDni(String dni){
        try{
            clienteRepository.findByDni(dni);
        }catch (ClienteNotFoundException cnfe){
           cnfe.printStackTrace();
           cnfe.getMessage();
        }

        clienteRepository.deleteByDni(dni);
    }

    @Override
    public void deleteAllByDni(String dni) {
        clienteRepository.deleteByDni(dni);
    }

}
