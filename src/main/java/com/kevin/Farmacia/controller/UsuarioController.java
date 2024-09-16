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

import com.kevin.Farmacia.model.Usuario;
import com.kevin.Farmacia.service.UsuarioService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
@Validated
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping //Metodo para guardar un nuevo Usuario
    public ResponseEntity<Usuario> saveUsuario(@Valid @RequestBody Usuario Usuario){
        Usuario guardarUsuario = usuarioService.saveUsuario(Usuario);
        return new ResponseEntity<>(guardarUsuario, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los Usuarios
    public ResponseEntity<List<Usuario>> getAllUsuario(){
        List<Usuario> listUsuarios = usuarioService.findUsuarios();
        return ResponseEntity.ok(listUsuarios);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo Usuario por ID
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id){
        Optional<Usuario> Usuario = usuarioService.findById(id);
        return Usuario.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        if (usuarioService.findById(id).isPresent()) {
            usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id){
        if (usuarioService.findById(id).isPresent()) {
            usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
