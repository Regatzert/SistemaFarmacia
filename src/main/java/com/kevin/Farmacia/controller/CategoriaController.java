package com.kevin.Farmacia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.Farmacia.model.Categoria;
import com.kevin.Farmacia.service.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categoria")
@Validated
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping //Metodo para guardar un nuevo cliente
    public ResponseEntity<Categoria> saveCategoria(@Valid @RequestBody Categoria categoria){
        Categoria guardarCategoria = categoriaService.saveCategoria(categoria);
        return new ResponseEntity<>(guardarCategoria, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los clientes
    public ResponseEntity<List<Categoria>> getAllCategoria(){
        List<Categoria> listCategorias = categoriaService.findCategorias();
        return ResponseEntity.ok(listCategorias);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo Categoria por ID
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id){
        Optional<Categoria> categoria = categoriaService.findById(id);
        return categoria.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id){
        if (categoriaService.findById(id).isPresent()) {
            categoriaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id){
        if (categoriaService.findById(id).isPresent()) {
            categoriaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
