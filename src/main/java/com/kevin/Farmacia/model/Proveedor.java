package com.kevin.Farmacia.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Size(min = 1, max = 1, message = "El campo esActivo debe tener un solo carácter")
    @Pattern(regexp = "[01]", message = "El campo esActivo solo puede contener '0' o '1'")
    private String esActivo;
    
    @OneToMany (mappedBy = "proveedor")
    private Set<Compra> compras;
    
}
