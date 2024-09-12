package com.kevin.Farmacia.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Promocion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
    private String codigo;
    private String descripcion;
    private Double descuento;
    private LocalDate fechainicio;
    private LocalDate fechafin;

    @ManyToMany
    @JoinTable(
        name = "promocion_productos",
        joinColumns = @JoinColumn(name = "promocion_id"),
        inverseJoinColumns = @JoinColumn (name = "producto_id")
    )
    private Set<Producto> producto;
}
