package com.kevin.Farmacia.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Proveedor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
    private String ruc;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    @OneToMany (mappedBy = "proveedor")
    private Set<Compra> compras;
    
}
