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

import com.kevin.Farmacia.model.Producto;
import com.kevin.Farmacia.service.ProductoService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/producto")
@Validated
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @PostMapping //Metodo para guardar un nuevo Producto
    public ResponseEntity<Producto> saveProducto(@Valid @RequestBody Producto Producto){
        Producto guardarProducto = productoService.saveProducto(Producto);
        return new ResponseEntity<>(guardarProducto, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los Productos
    public ResponseEntity<List<Producto>> getAllProducto(){
        List<Producto> listProductos = productoService.findProductos();
        return ResponseEntity.ok(listProductos);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo Producto por ID
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id){
        Optional<Producto> Producto = productoService.findById(id);
        return Producto.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id){
        if (productoService.findById(id).isPresent()) {
            productoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id){
        if (productoService.findById(id).isPresent()) {
            productoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
