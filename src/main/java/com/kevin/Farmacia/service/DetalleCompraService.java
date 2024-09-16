package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.DetalleCompra;
import com.kevin.Farmacia.repository.DetalleCompraRepository;

import jakarta.validation.Valid;

@Service
public class DetalleCompraService {
    
    @Autowired
    private DetalleCompraRepository detalleCompraRepository;
    
    public DetalleCompra saveDetalleCompra(@Valid DetalleCompra detalleCompra){
        return detalleCompraRepository.save(detalleCompra);
    }

    public List<DetalleCompra> findDetalleCompras(){
        return detalleCompraRepository.findAll();
    }

    public Optional<DetalleCompra> findById (Long id){
        return detalleCompraRepository.findById(id);
    }
    public void deleteById (Long id){
        detalleCompraRepository.deleteById(id);
    }
    public DetalleCompra updateDetalleCompra(Long id, @Valid DetalleCompra detalleCompra){
        if (!detalleCompraRepository.existsById(id)) {
            throw new ResourceNotFoundException("DetalleCompra no encontrado con id: " + id);
        }

        DetalleCompra existeDetalleCompra = detalleCompraRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("DetalleCompra no encontrado con id: " + id));

        existeDetalleCompra.setCantidad(detalleCompra.getCantidad());
        existeDetalleCompra.setPrecio(detalleCompra.getPrecio());

        return detalleCompraRepository.save(existeDetalleCompra);
    }

}
