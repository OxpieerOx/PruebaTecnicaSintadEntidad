package com.sintad.PruebaTenica.services.impl;

import com.google.gson.Gson;
import com.sintad.PruebaTenica.dtos.EntidadResponseDTO;
import com.sintad.PruebaTenica.services.IEntidadService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import com.sintad.PruebaTenica.repositories.IEntidadRepository;
import com.sintad.PruebaTenica.models.EntidadModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EntidadServiceTest {
    @Mock
    private IEntidadRepository entidadRepository;

    @InjectMocks
    private EntidadService entidadService;

    @BeforeEach
    public void setInit(){
        MockitoAnnotations.initMocks(this);

    }

    Gson gson = new Gson();

    @Test
    public void ListarTodoTest() throws FileNotFoundException {
        List<EntidadModel> entidadModelList = gson.fromJson(new FileReader("D:\\Sinat Prueba tecnica\\PruebaTenica\\PruebaTenica\\src\\test\\resources\\Entidad\\EntidadRepository.json"), ArrayList.class);
        Mockito.when(entidadRepository.findAll()).thenReturn(entidadModelList);
        EntidadResponseDTO responseExpected = gson.fromJson(new FileReader("D:\\Sinat Prueba tecnica\\PruebaTenica\\PruebaTenica\\src\\test\\resources\\Entidad\\responseEntidadDTOtestsusscesusfull.json"), EntidadResponseDTO.class);
        Assertions.assertEquals(responseExpected,entidadService.ListarTodo());
    }
}
