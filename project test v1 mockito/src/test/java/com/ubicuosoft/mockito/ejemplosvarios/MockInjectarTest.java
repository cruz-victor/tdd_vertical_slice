package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockInjectarTest {
    @Mock
    private RepositorioMock repositorio;
    @InjectMocks
    private ServicioMock servicio;

    @Test
    void deberiaSaludarConNombreMockeado(){
        when(repositorio.obtenerNombre()).thenReturn("Grace");
        String saludo=servicio.saludar();
        assertThat(saludo).isEqualTo("Hola Grace");
    }


}
