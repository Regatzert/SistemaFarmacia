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
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    private Venta venta;
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

}
