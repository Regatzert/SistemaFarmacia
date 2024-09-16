package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Almacen;
import com.kevin.Farmacia.repository.AlmacenRepository;

import jakarta.validation.Valid;

@Service
public class AlmacenService {
    
    @Autowired
    private AlmacenRepository almacenRepository;

    public Almacen saveAlmacen(@Valid Almacen almacen){
        return almacenRepository.save(almacen);
    }

    
    public List<Almacen> findAlmacens(){
        return almacenRepository.findAll();
    }

    public Optional<Almacen> findById (Long id){
        return almacenRepository.findById(id);
    }
    public void deleteById (Long id){
        almacenRepository.deleteById(id);
    }
    public Almacen updateAlmacen(Long id, @Valid Almacen almacenDetalle){
        if (!almacenRepository.existsById(id)) {
            throw new ResourceNotFoundException("Almacen no encontrado con id: " + id);
        }

        Almacen existeAlmacen = almacenRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Almacen no encontrado con id: " + id));

        existeAlmacen.setNombre(almacenDetalle.getNombre());
        existeAlmacen.setUbicacion(almacenDetalle.getUbicacion());
        existeAlmacen.setEsActivo(almacenDetalle.getEsActivo());

        return almacenRepository.save(existeAlmacen);
    }

}
