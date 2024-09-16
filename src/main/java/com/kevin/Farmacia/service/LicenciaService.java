package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Licencia;
import com.kevin.Farmacia.repository.LicenciaRepository;

import jakarta.validation.Valid;

@Service
public class LicenciaService {
    
    @Autowired
    private LicenciaRepository licenciaRepository;
    
    public Licencia saveLicencia(@Valid Licencia licencia){
        return licenciaRepository.save(licencia);
    }

    public List<Licencia> findLicencias(){
        return licenciaRepository.findAll();
    }

    public Optional<Licencia> findById (Long id){
        return licenciaRepository.findById(id);
    }
    public void deleteById (Long id){
        licenciaRepository.deleteById(id);
    }
    public Licencia updateLicencia(Long id, @Valid Licencia licenciaDetalle){
        if (!licenciaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Licencia no encontrado con id: " + id);
        }

        Licencia existeLicencia = licenciaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Licencia no encontrado con id: " + id));

        existeLicencia.setNumero(licenciaDetalle.getNumero());
        existeLicencia.setEmisor(licenciaDetalle.getEmisor());
        existeLicencia.setFechaEmision(licenciaDetalle.getFechaEmision());
        existeLicencia.setFechaExpiracion(licenciaDetalle.getFechaExpiracion());
        existeLicencia.setEsActivo(licenciaDetalle.getEsActivo());

        return licenciaRepository.save(existeLicencia);
    }

}
