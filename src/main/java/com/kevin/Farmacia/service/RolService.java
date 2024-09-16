package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Rol;
import com.kevin.Farmacia.repository.RolRepository;

import jakarta.validation.Valid;

@Service
public class RolService {
    
    @Autowired
    private RolRepository rolRepository;
    
    public Rol saveRol(@Valid Rol rol){
        return rolRepository.save(rol);
    }

    public List<Rol> findRols(){
        return rolRepository.findAll();
    }

    public Optional<Rol> findById (Long id){
        return rolRepository.findById(id);
    }
    public void deleteById (Long id){
        rolRepository.deleteById(id);
    }
    public Rol updateRol(Long id, @Valid Rol rolDetalle){
        if (!rolRepository.existsById(id)) {
            throw new ResourceNotFoundException("Rol no encontrado con id: " + id);
        }

        Rol existeRol = rolRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + id));

        existeRol.setNombre(rolDetalle.getNombre());
        existeRol.setDescripcion(rolDetalle.getDescripcion());
        existeRol.setEsActivo(rolDetalle.getEsActivo());

        return rolRepository.save(existeRol);
    }

}
