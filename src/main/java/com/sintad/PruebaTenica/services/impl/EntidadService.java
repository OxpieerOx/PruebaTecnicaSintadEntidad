package com.sintad.PruebaTenica.services.impl;
import com.sintad.PruebaTenica.dtos.EntidadResponseDTO;
import com.sintad.PruebaTenica.dtos.EntidadUpdateRequestDTO;
import com.sintad.PruebaTenica.models.TipoDocumentoModel;
import com.sintad.PruebaTenica.models.TipoContribuyenteModel;
import com.sintad.PruebaTenica.dtos.EntidadRequestDTO;
import com.sintad.PruebaTenica.models.EntidadModel;
import com.sintad.PruebaTenica.repositories.IEntidadRepository;
import com.sintad.PruebaTenica.services.IEntidadService;
import com.sintad.PruebaTenica.services.ITipoContribuyenteService;
import com.sintad.PruebaTenica.services.ITipoDocumentoService;
import com.sintad.PruebaTenica.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntidadService implements IEntidadService {


    @Autowired
    IEntidadRepository repositoryEntidad;
    @Autowired
    ITipoDocumentoService servicetipoDocumento;

    @Autowired
    ITipoContribuyenteService serviceTipoContribuyente;



    @Override
    public EntidadResponseDTO ListarTodo() {
        List<EntidadModel> Listaentidad = new ArrayList<>();
        EntidadResponseDTO response = new EntidadResponseDTO();
        Listaentidad =  (List<EntidadModel>)repositoryEntidad.findAll();
        if(Listaentidad.size()<0){
            response.setMessage("!No hay ni una entidad en la lista!");
            response.setSuccess(false);
            response.setData(Listaentidad);
            return response;
        }
        response.setMessage("!Se Encontro Entidades en la BD!");
        response.setSuccess(true);
        response.setData(Listaentidad);
        return response;
    }

    @Override
    public EntidadModel ObtenerEntidadPorID(Integer id) {
        return repositoryEntidad.findById(id).orElseThrow(()-> new IllegalArgumentException("El codigo con id: " + id + " No pudo ser encontrado"));
    }

    @Override
    public EntidadResponseDTO getEntidadByDni(String nrdocumento) {
        EntidadModel Entidadtraida = this.repositoryEntidad.getEntidadByDni(nrdocumento);
        EntidadResponseDTO response = new EntidadResponseDTO();
        if(Entidadtraida==null){
            response.setMessage("No se encontro una entidad con ese Nr de Documento");
            response.setSuccess(false);
            response.setData(Entidadtraida);
            return response;
        }
        response.setMessage("!Se encontro la entidad!");
        response.setSuccess(true);
        response.setData(Entidadtraida);
        return response;
    }

    @Override
    public EntidadResponseDTO deletepersona(Integer id) {
        EntidadResponseDTO response = new EntidadResponseDTO();
        try {
            EntidadModel EntidadEliminada = this.repositoryEntidad.getById(id);
            this.repositoryEntidad.deleteById(id);
            response.setMessage("Se elimino correctamente la entidad");
            response.setSuccess(true);
            return response;
        } catch (Exception e) {
            response.setMessage("Esa entidad no se encuentra en la bd");
            response.setSuccess(false);
            return response;
        }
    }



    @Override
    public EntidadResponseDTO actualizar(EntidadUpdateRequestDTO Entidad, int Entidadid) {
        EntidadResponseDTO response = new EntidadResponseDTO();
        EntidadModel entidad = this.repositoryEntidad.findById(Entidadid).orElse(null);
        TipoDocumentoModel tipoDocumento = servicetipoDocumento.getbyId(Entidad.getTipoDocumentoid());
        TipoContribuyenteModel TipoContribuyente = serviceTipoContribuyente.getbyId(Entidad.getTipoContribuyenteid());
        int validacion =repositoryEntidad.validarDocumento(Entidad.getNro_documento());
        try {
            if( validacion <= 0) {
                entidad.setTipoDocumento(tipoDocumento);
                entidad.setNro_documento(Entidad.getNro_documento());
                entidad.setRazon_social(Entidad.getRazon_social());
                entidad.setNombre_comercial(Entidad.getNombre_comercial());
                entidad.setTipoContribuyente(TipoContribuyente);
                entidad.setDireccion(Entidad.getDireccion());
                entidad.setTelefono(Entidad.getTelefono());
                entidad.setEstado(Entidad.isEstado());
                this.repositoryEntidad.save(entidad);

                response.setMessage("!Editadod");
                response.setSuccess(true);
                response.setData(entidad);
                return response;

            }
            response.setMessage("!No puede Repetir un mismo DNI!");
            response.setSuccess(false);
            response.setData(Entidad.getNro_documento());
            return response;
        }catch(Exception e){
            response.setMessage("Esa entidad no se encuentra en la bd");
            response.setSuccess(false);
            return response;
        }
    }

    @Override
    public EntidadResponseDTO CrearEntidad(EntidadRequestDTO Entidad) {
        EntidadModel entidadmodelo = MHelpers.modelMapper().map(Entidad,EntidadModel.class);
        String nrDocumento = Entidad.getNro_documento();
        EntidadResponseDTO response = new EntidadResponseDTO();

        try{
            int validacion =repositoryEntidad.validarDocumento(nrDocumento);
            if( validacion <= 0) {
                TipoDocumentoModel tipoDocumento = servicetipoDocumento.getbyId(Entidad.getTipoDocumentoid());
                TipoContribuyenteModel TipoContribuyente = serviceTipoContribuyente.getbyId(Entidad.getTipoContribuyenteid());
                entidadmodelo.setTipoDocumento(tipoDocumento);
                entidadmodelo.setTipoContribuyente(TipoContribuyente);
                this.repositoryEntidad.save(entidadmodelo);
                response.setMessage("Se Guardo correctamente la entidad");
                response.setSuccess(true);
                response.setData(entidadmodelo);
                return response;
            }
            response.setMessage("No puede Repetir un mismo DNI");
            response.setSuccess(false);
            response.setData(entidadmodelo.getNro_documento());
            return response;

        }catch (Exception e){
            response.setMessage("Revisar que algunos campos no sean nulls");
            response.setSuccess(false);
            return response;
        }

    }
}
