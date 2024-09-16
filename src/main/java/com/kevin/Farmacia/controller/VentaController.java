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

import com.kevin.Farmacia.model.Venta;
import com.kevin.Farmacia.service.VentaService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/venta")
@Validated
public class VentaController {
    
    @Autowired
    private VentaService ventaService;

    @PostMapping //Metodo para guardar un nuevo Venta
    public ResponseEntity<Venta> saveVenta(@Valid @RequestBody Venta Venta){
        Venta guardarVenta = ventaService.saveVenta(Venta);
        return new ResponseEntity<>(guardarVenta, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los Ventas
    public ResponseEntity<List<Venta>> getAllVenta(){
        List<Venta> listVentas = ventaService.findVentas();
        return ResponseEntity.ok(listVentas);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo Venta por ID
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id){
        Optional<Venta> Venta = ventaService.findById(id);
        return Venta.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id){
        if (ventaService.findById(id).isPresent()) {
            ventaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Long id){
        if (ventaService.findById(id).isPresent()) {
            ventaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
