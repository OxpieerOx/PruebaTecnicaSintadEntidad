package com.sintad.PruebaTenica.controllers;
import com.sintad.PruebaTenica.dtos.EntidadRequestDTO;
import com.sintad.PruebaTenica.dtos.EntidadUpdateRequestDTO;
import com.sintad.PruebaTenica.utils.Exception.AniUnprocessEntity;
import com.sintad.PruebaTenica.models.EntidadModel;
import com.sintad.PruebaTenica.services.IEntidadService;
import com.sintad.PruebaTenica.validators.EntityValidator;
import com.sintad.PruebaTenica.validators.EntityValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entidad")
public class EntidadController {

    @Autowired
    private IEntidadService entidadService;

    @Autowired
    private EntityValidatorImpl validatorEnti;


    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> get()
    {
        return ResponseEntity.ok(this.entidadService.ListarTodo());
    }

    @GetMapping(value = "/bydocument/{nrdocumento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> GetEntidadPorDNI(@PathVariable("nrdocumento") String nrdocumento)
    {
        return ResponseEntity.ok(this.entidadService.getEntidadByDni(nrdocumento));
    }

    @GetMapping(value = "/byid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> GetEntidadPorID(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(this.entidadService.ObtenerEntidadPorID(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> CrearEntidad(@RequestBody EntidadRequestDTO requestentidad) throws AniUnprocessEntity {
        this.validatorEnti.validator(requestentidad);
        return ResponseEntity.ok(this.entidadService.CrearEntidad(requestentidad));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> EliminarPersona(@PathVariable(value="id")Integer id){

        return ResponseEntity.ok(this.entidadService.deletepersona(id));
    }

    @PostMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> editarPersona(@RequestBody EntidadUpdateRequestDTO requestentidad, @PathVariable int id) throws Exception{

        return ResponseEntity.ok(this.entidadService.actualizar(requestentidad, id));
    }
}


