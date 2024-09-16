package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Usuario;
import com.kevin.Farmacia.repository.UsuarioRepository;

import jakarta.validation.Valid;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario saveUsuario(@Valid Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById (Long id){
        return usuarioRepository.findById(id);
    }
    public void deleteById (Long id){
        usuarioRepository.deleteById(id);
    }
    public Usuario updateUsuario(Long id, @Valid Usuario usuarioDetalle){
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado con id: " + id);
        }

        Usuario existeUsuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));

        existeUsuario.setUsername(usuarioDetalle.getUsername());
        existeUsuario.setPassword(usuarioDetalle.getPassword());
        existeUsuario.setNombre(usuarioDetalle.getNombre());
        existeUsuario.setAPaterno(usuarioDetalle.getAPaterno());
        existeUsuario.setAMaterno(usuarioDetalle.getAMaterno());
        existeUsuario.setTelefono(usuarioDetalle.getTelefono());
        existeUsuario.setEmail(usuarioDetalle.getEmail());
        existeUsuario.setEsActivo(usuarioDetalle.getEsActivo());

        return usuarioRepository.save(existeUsuario);
    }

}
