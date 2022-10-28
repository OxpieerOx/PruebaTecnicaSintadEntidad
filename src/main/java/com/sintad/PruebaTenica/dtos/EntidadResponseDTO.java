package com.sintad.PruebaTenica.dtos;


import lombok.Data;

@Data
public class EntidadResponseDTO<T> {

    private String message;

    private boolean success;

    private Object data;
}
