package com.kevin.Farmacia.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Log {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Long id;
    private String message;
    private LocalDateTime fechahora;
    
    @Enumerated(EnumType.STRING)
    private LogLevel nivel;
}

enum LogLevel{
    INFO, WARN, ERROR
}
