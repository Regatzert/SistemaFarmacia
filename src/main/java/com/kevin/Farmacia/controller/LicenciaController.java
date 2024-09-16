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

import com.kevin.Farmacia.model.Licencia;
import com.kevin.Farmacia.service.LicenciaService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/licencia")
@Validated
public class LicenciaController {
    
    @Autowired
    private LicenciaService licenciaService;

    @PostMapping //Metodo para guardar un nuevo Licencia
    public ResponseEntity<Licencia> saveLicencia(@Valid @RequestBody Licencia Licencia){
        Licencia guardarLicencia = licenciaService.saveLicencia(Licencia);
        return new ResponseEntity<>(guardarLicencia, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los Licencias
    public ResponseEntity<List<Licencia>> getAllLicencia(){
        List<Licencia> listLicencias = licenciaService.findLicencias();
        return ResponseEntity.ok(listLicencias);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo Licencia por ID
    public ResponseEntity<Licencia> getLicenciaById(@PathVariable Long id){
        Optional<Licencia> Licencia = licenciaService.findById(id);
        return Licencia.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLicencia(@PathVariable Long id){
        if (licenciaService.findById(id).isPresent()) {
            licenciaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Licencia> updateLicencia(@PathVariable Long id){
        if (licenciaService.findById(id).isPresent()) {
            licenciaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
