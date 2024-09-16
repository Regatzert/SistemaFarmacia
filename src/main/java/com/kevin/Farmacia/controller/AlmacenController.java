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

import com.kevin.Farmacia.model.Almacen;
import com.kevin.Farmacia.service.AlmacenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/almacen")
@Validated
public class AlmacenController {
    
    @Autowired
    private AlmacenService AlmacenService;

    @PostMapping //Metodo para guardar un nuevo cliente
    public ResponseEntity<Almacen> saveAlmacen(@Valid @RequestBody Almacen almacen){
        Almacen guardarAlmacen = AlmacenService.saveAlmacen(almacen);
        return new ResponseEntity<>(guardarAlmacen, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los clientes
    public ResponseEntity<List<Almacen>> getAllAlmacen(){
        List<Almacen> listAlmacens = AlmacenService.findAlmacens();
        return ResponseEntity.ok(listAlmacens);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo cliente por ID
    public ResponseEntity<Almacen> getAlmacenById(@PathVariable Long id){
        Optional<Almacen> almacen = AlmacenService.findById(id);
        return almacen.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlmacen(@PathVariable Long id){
        if (AlmacenService.findById(id).isPresent()) {
            AlmacenService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Almacen> updateAlmacen(@PathVariable Long id){
        if (AlmacenService.findById(id).isPresent()) {
            AlmacenService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
