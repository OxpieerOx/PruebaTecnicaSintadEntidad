package com.sintad.PruebaTenica.controllers;

import com.sintad.PruebaTenica.services.ITipoContribuyenteService;
import com.sintad.PruebaTenica.services.ITipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipodocumento")
public class TipoDocumentoController {

    @Autowired
    private ITipoDocumentoService tipoDocumentoService;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> get()
    {
        return ResponseEntity.ok(this.tipoDocumentoService.ListarTodo());
    }
}
