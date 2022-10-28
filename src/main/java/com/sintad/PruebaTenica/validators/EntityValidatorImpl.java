package com.sintad.PruebaTenica.validators;

import com.sintad.PruebaTenica.dtos.EntidadRequestDTO;
import com.sintad.PruebaTenica.utils.Exception.AniUnprocessEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EntityValidatorImpl implements  EntityValidator{



    private void messagea(String message) throws AniUnprocessEntity{
            throw new AniUnprocessEntity(message);
    }

    @Override
    public void validator(EntidadRequestDTO request) throws AniUnprocessEntity {
        if (request.getNro_documento() == null || request.getNro_documento().isEmpty()) {
            this.messagea("NroDocumento es obligatorio");
        }
        if (request.getRazon_social() == null || request.getRazon_social().isEmpty()) {
            this.messagea("Razon Social es obligatorio");
        }
        if (request.getNombre_comercial() == null || request.getNombre_comercial().isEmpty()) {
            this.messagea("Nombre Comercial es obligatorio");
        }
        if (request.getTipoContribuyenteid() == null) {
            this.messagea("!El Tipo Contribuyente no puede ser nulo!");
        }
    }
}
