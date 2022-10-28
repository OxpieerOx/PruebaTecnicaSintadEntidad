package com.sintad.PruebaTenica.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipo_contribuyente")
@Data
public class TipoContribuyenteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_contribuyente", length = 11)
    private Integer id_tipo_contribuyente;


    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "estado", nullable = false, length = 1)
    private char estado;

}
