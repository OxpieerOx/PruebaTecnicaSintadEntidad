package com.sintad.PruebaTenica.utils.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//exception ESTATUS 422
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class AniUnprocessEntity extends  Exception{

    public AniUnprocessEntity(String message){
        super(message);
    }
}
