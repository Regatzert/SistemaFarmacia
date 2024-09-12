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
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Digite el nombre de la categoria")
    private String nombre;
    @NotBlank()
    private String descripcion;
    @OneToMany(mappedBy = "categoria")
    private Set<Producto> productos;
}
