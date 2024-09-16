package com.kevin.Farmacia.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Soporte {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private String estado;
    @Size(min = 1, max = 1, message = "El campo esActivo debe tener un solo carácter")
    @Pattern(regexp = "[01]", message = "El campo esActivo solo puede contener '0' o '1'")
    private String esActivo;
    
    @ManyToOne
    @JoinColumn (name = "usuario_id", nullable = false)
    private Usuario usuario;
}
