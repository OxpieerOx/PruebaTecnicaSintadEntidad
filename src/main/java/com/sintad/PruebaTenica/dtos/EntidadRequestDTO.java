package com.sintad.PruebaTenica.dtos;

import com.sintad.PruebaTenica.models.TipoContribuyenteModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class EntidadRequestDTO implements Serializable {

    private Integer tipoDocumentoid;
    private String nro_documento;
    private String razon_social;
    private String nombre_comercial;
    private Integer tipoContribuyenteid;
    private String direccion;
    private String telefono;
}
