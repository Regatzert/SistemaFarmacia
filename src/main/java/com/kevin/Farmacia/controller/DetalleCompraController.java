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

import com.kevin.Farmacia.model.DetalleCompra;
import com.kevin.Farmacia.service.DetalleCompraService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detalleCompra")
@Validated
public class DetalleCompraController {
    
    @Autowired
    private DetalleCompraService detalleCompraService;

    @PostMapping //Metodo para guardar un nuevo cliente
    public ResponseEntity<DetalleCompra> saveDetalleCompra(@Valid @RequestBody DetalleCompra detalleCompra){
        DetalleCompra guardarDetalleCompra = detalleCompraService.saveDetalleCompra(detalleCompra);
        return new ResponseEntity<>(guardarDetalleCompra, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los clientes
    public ResponseEntity<List<DetalleCompra>> getAllDetalleCompra(){
        List<DetalleCompra> listDetalleCompras = detalleCompraService.findDetalleCompras();
        return ResponseEntity.ok(listDetalleCompras);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo DetalleCompra por ID
    public ResponseEntity<DetalleCompra> getDetalleCompraById(@PathVariable Long id){
        Optional<DetalleCompra> detalleCompra = detalleCompraService.findById(id);
        return detalleCompra.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleCompra(@PathVariable Long id){
        if (detalleCompraService.findById(id).isPresent()) {
            detalleCompraService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleCompra> updateDetalleCompra(@PathVariable Long id){
        if (detalleCompraService.findById(id).isPresent()) {
            detalleCompraService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
