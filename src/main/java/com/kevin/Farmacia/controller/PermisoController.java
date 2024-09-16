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

import com.kevin.Farmacia.model.Permiso;
import com.kevin.Farmacia.service.PermisoService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/permiso")
@Validated
public class PermisoController {
    
    @Autowired
    private PermisoService permisoService;

    @PostMapping //Metodo para guardar un nuevo Permiso
    public ResponseEntity<Permiso> savePermiso(@Valid @RequestBody Permiso Permiso){
        Permiso guardarPermiso = permisoService.savePermiso(Permiso);
        return new ResponseEntity<>(guardarPermiso, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los Permisos
    public ResponseEntity<List<Permiso>> getAllPermiso(){
        List<Permiso> listPermisos = permisoService.findPermisos();
        return ResponseEntity.ok(listPermisos);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo Permiso por ID
    public ResponseEntity<Permiso> getPermisoById(@PathVariable Long id){
        Optional<Permiso> Permiso = permisoService.findById(id);
        return Permiso.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermiso(@PathVariable Long id){
        if (permisoService.findById(id).isPresent()) {
            permisoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permiso> updatePermiso(@PathVariable Long id){
        if (permisoService.findById(id).isPresent()) {
            permisoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
