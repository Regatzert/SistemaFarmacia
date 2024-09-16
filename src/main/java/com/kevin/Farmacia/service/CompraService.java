package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Compra;
import com.kevin.Farmacia.repository.CompraRepository;

import jakarta.validation.Valid;

@Service
public class CompraService {
    
    @Autowired
    private CompraRepository compraRepository;
    
    public Compra saveCliente(@Valid Compra compra){
        return compraRepository.save(compra);
    }

    public List<Compra> findCompras(){
        return compraRepository.findAll();
    }

    public Optional<Compra> findById (Long id){
        return compraRepository.findById(id);
    }
    public void deleteById (Long id){
        compraRepository.deleteById(id);
    }
    public Compra updateCompra(Long id, @Valid Compra compraDetalle){
        if (!compraRepository.existsById(id)) {
            throw new ResourceNotFoundException("Compra no encontrado con id: " + id);
        }

        Compra existeCompra = compraRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Compra no encontrado con id: " + id));

        existeCompra.setProveedor(compraDetalle.getProveedor());
        existeCompra.setFecha(compraDetalle.getFecha());

        return compraRepository.save(existeCompra);
    }

}
