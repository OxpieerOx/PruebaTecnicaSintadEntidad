package com.sintad.PruebaTenica.repositories;

import com.sintad.PruebaTenica.models.TipoDocumentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumentoModel,Integer> {
}
