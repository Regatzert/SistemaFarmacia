package com.kevin.Farmacia.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Ingrese el nombre del almacen")
    private String nombre;
    @NotBlank(message =  "Ingrese la direccion del almacen")
    private String ubicacion;
    @OneToMany(mappedBy = "almacen")
    private Set<Inventario> inventarios;
}
