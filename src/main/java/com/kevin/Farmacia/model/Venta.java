package com.kevin.Farmacia.model;

import java.time.LocalDate;
import java.util.Set;

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
public class Venta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private double total;

    @ManyToOne
    @JoinColumn (name = "cliente_id")
    private Cliente cliente;
    @OneToMany (mappedBy = "venta")
    private Factura factura;
    @OneToMany (mappedBy = "venta")
    private Set<DetalleVenta> detalleVentas;
}
