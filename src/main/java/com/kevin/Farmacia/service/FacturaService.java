package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Factura;
import com.kevin.Farmacia.repository.FacturaRepository;

import jakarta.validation.Valid;

@Service
public class FacturaService {
    
    @Autowired
    private FacturaRepository facturaRepository;
    
    public Factura saveFactura(@Valid Factura factura){
        return facturaRepository.save(factura);
    }

    public List<Factura> findFacturas(){
        return facturaRepository.findAll();
    }

    public Optional<Factura> findById (Long id){
        return facturaRepository.findById(id);
    }
    public void deleteById (Long id){
        facturaRepository.deleteById(id);
    }
    public Factura updateFactura(Long id, @Valid Factura factura){
        if (!facturaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Factura no encontrado con id: " + id);
        }

        Factura existeFactura = facturaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Factura no encontrado con id: " + id));

        existeFactura.setNumero(factura.getNumero());
        existeFactura.setFecha(factura.getFecha());
        existeFactura.setTotal(factura.getTotal());

        return facturaRepository.save(existeFactura);
    }

}
