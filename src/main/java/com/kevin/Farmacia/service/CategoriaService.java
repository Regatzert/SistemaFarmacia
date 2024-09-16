package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Categoria;
import com.kevin.Farmacia.repository.CategoriaRepository;

import jakarta.validation.Valid;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public Categoria saveCategoria(@Valid Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> findCategorias(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById (Long id){
        return categoriaRepository.findById(id);
    }
    public void deleteById (Long id){
        categoriaRepository.deleteById(id);
    }
    public Categoria updateCategoria(Long id, @Valid Categoria categoriaDetalle){
        if (!categoriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Categoria no encontrado con id: " + id);
        }

        Categoria existeCategoria = categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria no encontrado con id: " + id));

        existeCategoria.setNombre(categoriaDetalle.getNombre());
        existeCategoria.setDescripcion(categoriaDetalle.getDescripcion());

        return categoriaRepository.save(existeCategoria);
    }

}
