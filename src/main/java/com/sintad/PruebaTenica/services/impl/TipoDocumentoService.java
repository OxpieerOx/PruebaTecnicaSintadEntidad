package com.sintad.PruebaTenica.services.impl;


import com.sintad.PruebaTenica.models.TipoDocumentoModel;

import com.sintad.PruebaTenica.repositories.ITipoDocumentoRepository;
import com.sintad.PruebaTenica.services.ITipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoService implements ITipoDocumentoService{

    @Autowired
    ITipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumentoModel> ListarTodo() {
        return this.tipoDocumentoRepository.findAll();
    }

    @Override
    public TipoDocumentoModel getbyId(Integer id) {
        return this.tipoDocumentoRepository.findById(id).orElse(null
        );

    }

    @Override
    public void deleteTipoDocumento(Integer id) {

    }

    @Override
    public TipoDocumentoModel saveOrUpdate(TipoDocumentoModel tipoDocumento) {
        return this.tipoDocumentoRepository.save(tipoDocumento);
    }
}
