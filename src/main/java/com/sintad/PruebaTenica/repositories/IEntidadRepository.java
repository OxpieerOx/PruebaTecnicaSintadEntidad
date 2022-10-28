package com.sintad.PruebaTenica.repositories;

import com.sintad.PruebaTenica.models.EntidadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface IEntidadRepository extends JpaRepository<EntidadModel,Integer> {

    @Query(nativeQuery = true, value ="SELECT * FROM tb_entidad WHERE nro_documento=:nrdocumento")
    public EntidadModel getEntidadByDni(String nrdocumento);

    @Query(nativeQuery = true, value ="SELECT COUNT(*) FROM tb_entidad WHERE  nro_documento=:nrdocumento")
    public int validarDocumento(String nrdocumento);

}
