package com.sintad.PruebaTenica.utils.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//exception ESTATUS 404
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiNotfound extends  Exception{
    public ApiNotfound(String message){
        super(message);
    }
}
