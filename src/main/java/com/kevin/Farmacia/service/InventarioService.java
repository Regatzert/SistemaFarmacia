package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Inventario;
import com.kevin.Farmacia.repository.InventarioRepository;

import jakarta.validation.Valid;

@Service
public class InventarioService {
    
    @Autowired
    private InventarioRepository inventarioRepository;
    
    public Inventario saveInventario(@Valid Inventario inventario){
        return inventarioRepository.save(inventario);
    }

    public List<Inventario> findInventarios(){
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> findById (Long id){
        return inventarioRepository.findById(id);
    }
    public void deleteById (Long id){
        inventarioRepository.deleteById(id);
    }
    public Inventario updateInventario(Long id, @Valid Inventario inventarioDetalle){
        if (!inventarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Inventario no encontrado con id: " + id);
        }

        Inventario existeInventario = inventarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Inventario no encontrado con id: " + id));

        existeInventario.setCantidad(inventarioDetalle.getCantidad());
        existeInventario.setStockMinimo(inventarioDetalle.getStockMinimo());
        existeInventario.setStockMaximo(inventarioDetalle.getStockMaximo());
        existeInventario.setEsActivo(inventarioDetalle.getEsActivo());

        return inventarioRepository.save(existeInventario);
    }

}
