package com.sintad.PruebaTenica.validators;

import com.sintad.PruebaTenica.dtos.EntidadRequestDTO;
import com.sintad.PruebaTenica.utils.Exception.AniUnprocessEntity;
import org.springframework.stereotype.Service;


@Service
public interface EntityValidator {
    void validator(EntidadRequestDTO request) throws AniUnprocessEntity;


}
