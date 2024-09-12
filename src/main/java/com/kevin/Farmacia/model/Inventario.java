package com.kevin.Farmacia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Inventario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    
    @ManyToOne
    @JoinColumn (name = "almacen_id",  nullable = false)
    private Almacen almacen;
    @ManyToOne
    @JoinColumn (name = "producto_id", nullable = false)
    private Producto producto;
}
