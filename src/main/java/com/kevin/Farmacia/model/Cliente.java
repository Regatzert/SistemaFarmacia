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
    @OneToMany (mappedBy ="cliente")
    private Set<Venta> ventas;
}
