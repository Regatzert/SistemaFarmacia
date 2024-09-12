package com.kevin.Farmacia.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn (name = "usuario_id", nullable = false)
    private Usuario usuario;
}
