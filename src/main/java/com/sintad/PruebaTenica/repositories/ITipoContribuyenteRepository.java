package com.sintad.PruebaTenica.repositories;

import com.sintad.PruebaTenica.models.TipoContribuyenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoContribuyenteRepository extends JpaRepository<TipoContribuyenteModel,Integer> {
}
