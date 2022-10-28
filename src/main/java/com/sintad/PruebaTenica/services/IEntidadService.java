package com.sintad.PruebaTenica.services;
import java.util.List;

import com.sintad.PruebaTenica.dtos.EntidadRequestDTO;
import com.sintad.PruebaTenica.dtos.EntidadResponseDTO;
import com.sintad.PruebaTenica.dtos.EntidadUpdateRequestDTO;
import com.sintad.PruebaTenica.models.EntidadModel;


public interface IEntidadService {

    public EntidadResponseDTO ListarTodo();
    public EntidadModel ObtenerEntidadPorID(Integer id);

    public EntidadResponseDTO getEntidadByDni(String nrdocumento);
    public EntidadResponseDTO deletepersona(Integer id);

    public EntidadResponseDTO CrearEntidad( EntidadRequestDTO Entidad);

    public EntidadResponseDTO actualizar(EntidadUpdateRequestDTO Entidad, int Entidadid);

}
