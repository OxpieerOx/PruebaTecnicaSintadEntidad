package com.sintad.PruebaTenica.models;


import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "tb_entidad")
@Data
public class EntidadModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidad", length = 11)
    private Integer id_entidad;

    @ManyToOne()
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumentoModel TipoDocumento;

    @Column(name = "nro_documento", nullable = false, length = 25)
    private String nro_documento;

    @Column(name = "razon_social", nullable = false, length = 100)
    private String razon_social;

    @Column(name = "nombre_comercial", nullable = false, length = 100)
    private String nombre_comercial;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contribuyente")
    private TipoContribuyenteModel TipoContribuyente;

    @Column(name = "direccion", nullable = true, length = 100)
    private String direccion;

    @Column(name = "telefono", nullable = true, length = 100)
    private String telefono;

    @Column(name = "estado", nullable = false, length = 100)
    private boolean estado = true;

}
