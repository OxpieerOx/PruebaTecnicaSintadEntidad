package com.sintad.PruebaTenica.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class EntidadUpdateRequestDTO implements Serializable {
    private Integer tipoDocumentoid;
    private String nro_documento;
    private String razon_social;
    private String nombre_comercial;
    private Integer tipoContribuyenteid;
    private String direccion;
    private String telefono;
    private boolean estado;
}

