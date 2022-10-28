package com.sintad.PruebaTenica.controllers;


import com.sintad.PruebaTenica.services.IEntidadService;
import com.sintad.PruebaTenica.services.ITipoContribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contribuyente")
public class TipoContribuyenteController {
    @Autowired
    private ITipoContribuyenteService tipoContribuyenteService;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> get()
    {
        return ResponseEntity.ok(this.tipoContribuyenteService.ListarTodo());
    }

}
