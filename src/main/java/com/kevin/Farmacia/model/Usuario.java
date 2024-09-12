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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column (unique = true)
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String nombre;
    @NotBlank
    private String aPaterno;
    @NotBlank
    private String aMaterno;
    @NotBlank
    @Pattern (regexp = "\\{9}", message = "El numero de celular tiene que ser de 9 digitos")
    private String telefono;
    private String email;
    
    @ManyToOne
    @JoinColumn (name = "rol_id", nullable = false)
    private Rol rol;
    @OneToMany (mappedBy = "usuario")
    private Set<Soporte> soportes;
    @OneToMany (mappedBy = "usuario")
    private Set<Log> logs;

}
