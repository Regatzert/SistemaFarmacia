package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.DetalleVenta;
import com.kevin.Farmacia.repository.DetalleVentaRepository;

import jakarta.validation.Valid;

@Service
public class DetalleVentaService {
    
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;
    
    public DetalleVenta saveDetalleVenta(@Valid DetalleVenta detalleVenta){
        return detalleVentaRepository.save(detalleVenta);
    }

    public List<DetalleVenta> findDetalleVentas(){
        return detalleVentaRepository.findAll();
    }

    public Optional<DetalleVenta> findById (Long id){
        return detalleVentaRepository.findById(id);
    }
    public void deleteById (Long id){
        detalleVentaRepository.deleteById(id);
    }
    public DetalleVenta updateDetalleVenta(Long id, @Valid DetalleVenta detalleVenta){
        if (!detalleVentaRepository.existsById(id)) {
            throw new ResourceNotFoundException("detalleVenta no encontrado con id: " + id);
        }

        DetalleVenta existeDetalleVenta = detalleVentaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("DetalleVenta no encontrado con id: " + id));

        existeDetalleVenta.setCantidad(detalleVenta.getCantidad());
        existeDetalleVenta.setPrecio(detalleVenta.getPrecio());

        return detalleVentaRepository.save(existeDetalleVenta);
    }

}
