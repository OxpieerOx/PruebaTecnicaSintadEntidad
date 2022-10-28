package com.sintad.PruebaTenica.services.impl;

import com.sintad.PruebaTenica.models.TipoContribuyenteModel;
import com.sintad.PruebaTenica.repositories.ITipoContribuyenteRepository;
import com.sintad.PruebaTenica.services.ITipoContribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoContribuyenteService implements ITipoContribuyenteService {

    @Autowired
    ITipoContribuyenteRepository tipoContribuyenteRepository;

    @Override
    public List<TipoContribuyenteModel> ListarTodo() {
        return this.tipoContribuyenteRepository.findAll();
    }

    @Override
    public TipoContribuyenteModel getbyId(Integer id) {
        return this.tipoContribuyenteRepository.findById(id).orElse(null
        );
    }

    @Override
    public void deletetipoContribuyente(Integer id) {

    }

    @Override
    public TipoContribuyenteModel saveOrUpdate(TipoContribuyenteModel tipoContribuyente) {
        return this.tipoContribuyenteRepository.save(tipoContribuyente);
    }
}
