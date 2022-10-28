package com.sintad.PruebaTenica.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipo_documento")
@Data
public class TipoDocumentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento")
    private Integer id_tipo_documento;

    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", nullable = true, length = 200)
    private String descripcion;

    @Column(name = "estado", nullable = false, length = 1)
    private char estado;

}
