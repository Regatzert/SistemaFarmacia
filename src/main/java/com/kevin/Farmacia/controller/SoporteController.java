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

import com.kevin.Farmacia.model.Soporte;
import com.kevin.Farmacia.service.SoporteService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/soporte")
@Validated
public class SoporteController {
    
    @Autowired
    private SoporteService soporteService;

    @PostMapping //Metodo para guardar un nuevo Soporte
    public ResponseEntity<Soporte> saveSoporte(@Valid @RequestBody Soporte Soporte){
        Soporte guardarSoporte = soporteService.saveSoporte(Soporte);
        return new ResponseEntity<>(guardarSoporte, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los Soportes
    public ResponseEntity<List<Soporte>> getAllSoporte(){
        List<Soporte> listSoportes = soporteService.findSoportes();
        return ResponseEntity.ok(listSoportes);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo Soporte por ID
    public ResponseEntity<Soporte> getSoporteById(@PathVariable Long id){
        Optional<Soporte> Soporte = soporteService.findById(id);
        return Soporte.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSoporte(@PathVariable Long id){
        if (soporteService.findById(id).isPresent()) {
            soporteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Soporte> updateSoporte(@PathVariable Long id){
        if (soporteService.findById(id).isPresent()) {
            soporteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
