package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Promocion;
import com.kevin.Farmacia.repository.PromocionRepository;

import jakarta.validation.Valid;

@Service
public class PromocionService {
    
    @Autowired
    private PromocionRepository promocionRepository;
    
    public Promocion savePromocion(@Valid Promocion promocion){
        return promocionRepository.save(promocion);
    }

    public List<Promocion> findPromocions(){
        return promocionRepository.findAll();
    }

    public Optional<Promocion> findById (Long id){
        return promocionRepository.findById(id);
    }
    public void deleteById (Long id){
        promocionRepository.deleteById(id);
    }
    public Promocion updatePromocion(Long id, @Valid Promocion promocionDetalle){
        if (!promocionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Promocion no encontrado con id: " + id);
        }

        Promocion existePromocion = promocionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Promocion no encontrado con id: " + id));

        existePromocion.setCodigo(promocionDetalle.getCodigo());
        existePromocion.setDescripcion(promocionDetalle.getDescripcion());
        existePromocion.setDescuento(promocionDetalle.getDescuento());
        existePromocion.setFechainicio(promocionDetalle.getFechainicio());
        existePromocion.setFechafin(promocionDetalle.getFechafin());
        existePromocion.setEsActivo(promocionDetalle.getEsActivo());

        return promocionRepository.save(existePromocion);
    }

}
