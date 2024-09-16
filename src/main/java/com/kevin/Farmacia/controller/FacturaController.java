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

import com.kevin.Farmacia.model.Factura;
import com.kevin.Farmacia.service.FacturaService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/factura")
@Validated
public class FacturaController {
    
    @Autowired
    private FacturaService facturaService;

    @PostMapping //Metodo para guardar un nuevo cliente
    public ResponseEntity<Factura> saveFactura(@Valid @RequestBody Factura factura){
        Factura guardarFactura = facturaService.saveFactura(factura);
        return new ResponseEntity<>(guardarFactura, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los Facturas
    public ResponseEntity<List<Factura>> getAllFactura(){
        List<Factura> listFacturas = facturaService.findFacturas();
        return ResponseEntity.ok(listFacturas);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo Factura por ID
    public ResponseEntity<Factura> getFacturaById(@PathVariable Long id){
        Optional<Factura> Factura = facturaService.findById(id);
        return Factura.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFactura(@PathVariable Long id){
        if (facturaService.findById(id).isPresent()) {
            facturaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> updateFactura(@PathVariable Long id){
        if (facturaService.findById(id).isPresent()) {
            facturaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
