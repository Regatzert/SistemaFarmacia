package com.kevin.Farmacia.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Producto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
    private String codigo;
    private String nombre;
    private String descripcion;
    @Size(min = 1, max = 1, message = "El campo esActivo debe tener un solo carácter")
    @Pattern(regexp = "[01]", message = "El campo esActivo solo puede contener '0' o '1'")
    private String esActivo;

    @ManyToOne
    @JoinColumn (name = "categoria_id", nullable = false)
    private Categoria categoria;
    @OneToMany (mappedBy = "producto")
    private Set<DetalleCompra> detalleCompras;
    @OneToMany (mappedBy = "producto")
    private Set<DetalleVenta> detalleVentas;
    @OneToMany (mappedBy = "producto")
    private Set <Inventario> inventarios;

}
