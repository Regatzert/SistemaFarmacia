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

import com.kevin.Farmacia.model.Rol;
import com.kevin.Farmacia.service.RolService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/rol")
@Validated
public class RolController {
    
    @Autowired
    private RolService rolService;

    @PostMapping //Metodo para guardar un nuevo Rol
    public ResponseEntity<Rol> saveRol(@Valid @RequestBody Rol Rol){
        Rol guardarRol = rolService.saveRol(Rol);
        return new ResponseEntity<>(guardarRol, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los Rols
    public ResponseEntity<List<Rol>> getAllRol(){
        List<Rol> listRols = rolService.findRols();
        return ResponseEntity.ok(listRols);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo Rol por ID
    public ResponseEntity<Rol> getRolById(@PathVariable Long id){
        Optional<Rol> Rol = rolService.findById(id);
        return Rol.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id){
        if (rolService.findById(id).isPresent()) {
            rolService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Long id){
        if (rolService.findById(id).isPresent()) {
            rolService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
