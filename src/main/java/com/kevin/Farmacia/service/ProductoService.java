package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Producto;
import com.kevin.Farmacia.repository.ProductoRepository;

import jakarta.validation.Valid;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    public Producto saveProducto(@Valid Producto producto){
        return productoRepository.save(producto);
    }

    public List<Producto> findProductos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> findById (Long id){
        return productoRepository.findById(id);
    }
    public void deleteById (Long id){
        productoRepository.deleteById(id);
    }
    public Producto updateProducto(Long id, @Valid Producto productoDetalle){
        if (!productoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Producto no encontrado con id: " + id);
        }

        Producto existeProducto = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + id));

        existeProducto.setCodigo(productoDetalle.getCodigo());
        existeProducto.setNombre(productoDetalle.getNombre());
        existeProducto.setDescripcion(productoDetalle.getDescripcion());
        existeProducto.setEsActivo(productoDetalle.getEsActivo());

        return productoRepository.save(existeProducto);
    }

}
