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

import com.kevin.Farmacia.model.Compra;
import com.kevin.Farmacia.service.CompraService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/compra")
@Validated
public class CompraController {
    
    @Autowired
    private CompraService compraService;

    @PostMapping //Metodo para guardar un nuevo cliente
    public ResponseEntity<Compra> saveCompra(@Valid @RequestBody Compra compra){
        Compra guardarCompra = compraService.saveCompra(compra);
        return new ResponseEntity<>(guardarCompra, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los clientes
    public ResponseEntity<List<Compra>> getAllCompra(){
        List<Compra> listCompras = compraService.findCompras();
        return ResponseEntity.ok(listCompras);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo Compra por ID
    public ResponseEntity<Compra> getCompraById(@PathVariable Long id){
        Optional<Compra> compra = compraService.findById(id);
        return compra.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompra(@PathVariable Long id){
        if (compraService.findById(id).isPresent()) {
            compraService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> updateCompra(@PathVariable Long id){
        if (compraService.findById(id).isPresent()) {
            compraService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
