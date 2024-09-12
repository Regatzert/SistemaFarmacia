package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Cliente;
import com.kevin.Farmacia.repository.ClienteRepository;

import jakarta.validation.Valid;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente saveCliente(@Valid Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findClientes(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById (Long id){
        return clienteRepository.findById(id);
    }
    public void deleteById (Long id){
        clienteRepository.deleteById(id);
    }
    public Cliente updaCliente(Long id, @Valid Cliente clienteDetalle){
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente no encontrado con id: " + id);
        }

        Cliente existeCliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));

        existeCliente.setNombre(clienteDetalle.getNombre());
        existeCliente.setAPaterno(clienteDetalle.getAPaterno());
        existeCliente.setAMaterno(clienteDetalle.getAMaterno());
        existeCliente.setDni(clienteDetalle.getDni());
        existeCliente.setEmail(clienteDetalle.getEmail());
        existeCliente.setTelefono(clienteDetalle.getTelefono());

        return clienteRepository.save(existeCliente);
    }

}
