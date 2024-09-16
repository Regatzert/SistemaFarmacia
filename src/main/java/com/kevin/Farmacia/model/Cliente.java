package com.kevin.Farmacia.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank (message = "Digite el Nombre")
    private String nombre;
    @NotBlank (message = "Digite el Apellido Paterno")
    private String aPaterno;
    @NotBlank (message = "Digite el Apellido Materno")
    private String aMaterno;
    @Column (unique = true)
    @NotBlank (message = "Digite el DNI")
    @Pattern(regexp = "\\d{8}", message = "El DNI debe tener exactamente 8 digitos")
    private String dni;
    private String email;
    @Pattern(regexp = "\\d{9}", message = "El numero de Celular tiene que tener exactamente 9 digitos")
    private String telefono;
    @Size(min = 1, max = 1, message = "El campo esActivo debe tener un solo carácter")
    @Pattern(regexp = "[01]", message = "El campo esActivo solo puede contener '0' o '1'")
    private String esActivo;
    @OneToMany (mappedBy ="cliente")
    private Set<Venta> ventas;
}
