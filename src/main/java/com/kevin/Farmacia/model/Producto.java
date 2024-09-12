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
    private int stockMinimo;
    private int stockMaximo;

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
