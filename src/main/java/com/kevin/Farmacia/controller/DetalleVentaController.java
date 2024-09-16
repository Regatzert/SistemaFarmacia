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

import com.kevin.Farmacia.model.DetalleVenta;
import com.kevin.Farmacia.service.DetalleVentaService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detalleVenta")
@Validated
public class DetalleVentaController {
    
    @Autowired
    private DetalleVentaService detalleVentaService;

    @PostMapping //Metodo para guardar un nuevo cliente
    public ResponseEntity<DetalleVenta> saveDetalleVenta(@Valid @RequestBody DetalleVenta detalleVenta){
        DetalleVenta guardarDetalleVenta = detalleVentaService.saveDetalleVenta(detalleVenta);
        return new ResponseEntity<>(guardarDetalleVenta, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los DetalleVentas
    public ResponseEntity<List<DetalleVenta>> getAllDetalleVenta(){
        List<DetalleVenta> listDetalleVentas = detalleVentaService.findDetalleVentas();
        return ResponseEntity.ok(listDetalleVentas);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo DetalleVenta por ID
    public ResponseEntity<DetalleVenta> getDetalleVentaById(@PathVariable Long id){
        Optional<DetalleVenta> detalleVenta = detalleVentaService.findById(id);
        return detalleVenta.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleVenta(@PathVariable Long id){
        if (detalleVentaService.findById(id).isPresent()) {
            detalleVentaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVenta> updateDetalleVenta(@PathVariable Long id){
        if (detalleVentaService.findById(id).isPresent()) {
            detalleVentaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
