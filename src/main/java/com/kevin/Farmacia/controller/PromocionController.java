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

import com.kevin.Farmacia.model.Promocion;
import com.kevin.Farmacia.service.PromocionService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/promocion")
@Validated
public class PromocionController {
    
    @Autowired
    private PromocionService promocionService;

    @PostMapping //Metodo para guardar un nuevo Promocion
    public ResponseEntity<Promocion> savePromocion(@Valid @RequestBody Promocion Promocion){
        Promocion guardarPromocion = promocionService.savePromocion(Promocion);
        return new ResponseEntity<>(guardarPromocion, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los Promocions
    public ResponseEntity<List<Promocion>> getAllPromocion(){
        List<Promocion> listPromocions = promocionService.findPromocions();
        return ResponseEntity.ok(listPromocions);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo Promocion por ID
    public ResponseEntity<Promocion> getPromocionById(@PathVariable Long id){
        Optional<Promocion> Promocion = promocionService.findById(id);
        return Promocion.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromocion(@PathVariable Long id){
        if (promocionService.findById(id).isPresent()) {
            promocionService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promocion> updatePromocion(@PathVariable Long id){
        if (promocionService.findById(id).isPresent()) {
            promocionService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
