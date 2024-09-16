package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Venta;
import com.kevin.Farmacia.repository.VentaRepository;

import jakarta.validation.Valid;

@Service
public class VentaService {
    
    @Autowired
    private VentaRepository ventaRepository;
    
    public Venta saveVenta(@Valid Venta venta){
        return ventaRepository.save(venta);
    }

    public List<Venta> findVentas(){
        return ventaRepository.findAll();
    }

    public Optional<Venta> findById (Long id){
        return ventaRepository.findById(id);
    }
    public void deleteById (Long id){
        ventaRepository.deleteById(id);
    }
    public Venta updateVenta(Long id, @Valid Venta ventaDetalle){
        if (!ventaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Venta no encontrado con id: " + id);
        }

        Venta existeVenta = ventaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Venta no encontrado con id: " + id));

        existeVenta.setFecha(ventaDetalle.getFecha());
        existeVenta.setTotal(ventaDetalle.getTotal());
        existeVenta.setEsActivo(ventaDetalle.getEsActivo());

        return ventaRepository.save(existeVenta);
    }

}
