package com.sintad.PruebaTenica.services;

import com.sintad.PruebaTenica.models.TipoContribuyenteModel;

import java.util.List;

public interface ITipoContribuyenteService {
    public List<TipoContribuyenteModel> ListarTodo();
    public TipoContribuyenteModel getbyId(Integer id);
    void deletetipoContribuyente(Integer id);
    public TipoContribuyenteModel saveOrUpdate( TipoContribuyenteModel tipoContribuyente);
}
