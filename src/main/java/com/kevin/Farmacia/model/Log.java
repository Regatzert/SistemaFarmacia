package com.kevin.Farmacia.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Log {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Long id;
    private String message;
    private LocalDateTime fechahora;
    @Size(min = 1, max = 1, message = "El campo esActivo debe tener un solo carácter")
    @Pattern(regexp = "[01]", message = "El campo esActivo solo puede contener '0' o '1'")
    private String esActivo;
    
    @Enumerated(EnumType.STRING)
    private LogLevel nivel;
}

enum LogLevel{
    INFO, WARN, ERROR
}
