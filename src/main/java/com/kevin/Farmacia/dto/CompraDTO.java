package com.kevin.Farmacia.dto;

import lombok.Data;

@Data
public class CompraDTO {
    private Long id;
    private Long compraId;
    private Long productoId;
    private int cantidad;
}
