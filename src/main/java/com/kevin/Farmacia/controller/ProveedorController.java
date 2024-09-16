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

import com.kevin.Farmacia.model.Proveedor;
import com.kevin.Farmacia.service.ProveedorService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/proveedor")
@Validated
public class ProveedorController {
    
    @Autowired
    private ProveedorService proveedorService;

    @PostMapping //Metodo para guardar un nuevo Proveedor
    public ResponseEntity<Proveedor> saveProveedor(@Valid @RequestBody Proveedor Proveedor){
        Proveedor guardarProveedor = proveedorService.saveProveedor(Proveedor);
        return new ResponseEntity<>(guardarProveedor, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los Proveedors
    public ResponseEntity<List<Proveedor>> getAllProveedor(){
        List<Proveedor> listProveedors = proveedorService.findProveedors();
        return ResponseEntity.ok(listProveedors);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo Proveedor por ID
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable Long id){
        Optional<Proveedor> Proveedor = proveedorService.findById(id);
        return Proveedor.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id){
        if (proveedorService.findById(id).isPresent()) {
            proveedorService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> updateProveedor(@PathVariable Long id){
        if (proveedorService.findById(id).isPresent()) {
            proveedorService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
