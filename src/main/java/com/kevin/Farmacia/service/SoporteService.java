package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Soporte;
import com.kevin.Farmacia.repository.SoporteRepository;

import jakarta.validation.Valid;

@Service
public class SoporteService {
    
    @Autowired
    private SoporteRepository soporteRepository;
    
    public Soporte saveSoporte(@Valid Soporte soporte){
        return soporteRepository.save(soporte);
    }

    public List<Soporte> findSoportes(){
        return soporteRepository.findAll();
    }

    public Optional<Soporte> findById (Long id){
        return soporteRepository.findById(id);
    }
    public void deleteById (Long id){
        soporteRepository.deleteById(id);
    }
    public Soporte updateSoporte(Long id, @Valid Soporte soporteDetalle){
        if (!soporteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Soporte no encontrado con id: " + id);
        }

        Soporte existeSoporte = soporteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Soporte no encontrado con id: " + id));

        existeSoporte.setDescripcion(soporteDetalle.getDescripcion());
        existeSoporte.setFechaCreacion(soporteDetalle.getFechaCreacion());
        existeSoporte.setEstado(soporteDetalle.getEstado());
        existeSoporte.setEsActivo(soporteDetalle.getEsActivo());

        return soporteRepository.save(existeSoporte);
    }

}
