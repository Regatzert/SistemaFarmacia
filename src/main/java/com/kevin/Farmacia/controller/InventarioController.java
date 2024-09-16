package com.kevin.Farmacia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.Farmacia.model.Inventario;
import com.kevin.Farmacia.service.InventarioService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/inventario")
@Validated
public class InventarioController {
    
    @Autowired
    private InventarioService inventarioService;

    @PostMapping //Metodo para guardar un nuevo Inventario
    public ResponseEntity<Inventario> saveInventario(@Valid @RequestBody Inventario Inventario){
        Inventario guardarInventario = inventarioService.saveInventario(Inventario);
        return new ResponseEntity<>(guardarInventario, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los Inventarios
    public ResponseEntity<List<Inventario>> getAllInventario(){
        List<Inventario> listInventarios = inventarioService.findInventarios();
        return ResponseEntity.ok(listInventarios);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo Inventario por ID
    public ResponseEntity<Inventario> getInventarioById(@PathVariable Long id){
        Optional<Inventario> Inventario = inventarioService.findById(id);
        return Inventario.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable Long id){
        if (inventarioService.findById(id).isPresent()) {
            inventarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> updateInventario(@PathVariable Long id){
        if (inventarioService.findById(id).isPresent()) {
            inventarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
