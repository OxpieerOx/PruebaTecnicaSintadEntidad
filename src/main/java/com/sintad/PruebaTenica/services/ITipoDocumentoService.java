package com.sintad.PruebaTenica.services;

import com.sintad.PruebaTenica.models.TipoDocumentoModel;

import java.util.List;
import java.util.Optional;

public interface ITipoDocumentoService {
    public List<TipoDocumentoModel> ListarTodo();
    public TipoDocumentoModel getbyId(Integer id);
    void deleteTipoDocumento(Integer id);
    public TipoDocumentoModel saveOrUpdate( TipoDocumentoModel tipoDocumento);
}
