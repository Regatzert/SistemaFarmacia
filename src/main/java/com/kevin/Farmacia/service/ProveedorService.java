package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Proveedor;
import com.kevin.Farmacia.repository.ProveedorRepository;

import jakarta.validation.Valid;

@Service
public class ProveedorService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;
    
    public Proveedor saveProveedor(@Valid Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    public List<Proveedor> findProveedors(){
        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> findById (Long id){
        return proveedorRepository.findById(id);
    }
    public void deleteById (Long id){
        proveedorRepository.deleteById(id);
    }
    public Proveedor updateProveedor(Long id, @Valid Proveedor proveedorDetalle){
        if (!proveedorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Proveedor no encontrado con id: " + id);
        }

        Proveedor existeProveedor = proveedorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con id: " + id));

        existeProveedor.setRuc(proveedorDetalle.getRuc());
        existeProveedor.setNombre(proveedorDetalle.getNombre());
        existeProveedor.setDireccion(proveedorDetalle.getDireccion());
        existeProveedor.setTelefono(proveedorDetalle.getTelefono());
        existeProveedor.setEmail(proveedorDetalle.getEmail());
        existeProveedor.setEmail(proveedorDetalle.getEmail());

        return proveedorRepository.save(existeProveedor);
    }

}
