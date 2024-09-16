package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Permiso;
import com.kevin.Farmacia.repository.PermisoRepository;

import jakarta.validation.Valid;

@Service
public class PermisoService {
    
    @Autowired
    private PermisoRepository permisoRepository;
    
    public Permiso savePermiso(@Valid Permiso permiso){
        return permisoRepository.save(permiso);
    }

    public List<Permiso> findPermisos(){
        return permisoRepository.findAll();
    }

    public Optional<Permiso> findById (Long id){
        return permisoRepository.findById(id);
    }
    public void deleteById (Long id){
        permisoRepository.deleteById(id);
    }
    public Permiso updatePermiso(Long id, @Valid Permiso permisoDetalle){
        if (!permisoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Permiso no encontrado con id: " + id);
        }

        Permiso existePermiso = permisoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Permiso no encontrado con id: " + id));

        existePermiso.setNombre(permisoDetalle.getNombre());
        existePermiso.setDescripcion(permisoDetalle.getDescripcion());
        existePermiso.setEsActivo(permisoDetalle.getEsActivo());

        return permisoRepository.save(existePermiso);
    }

}
