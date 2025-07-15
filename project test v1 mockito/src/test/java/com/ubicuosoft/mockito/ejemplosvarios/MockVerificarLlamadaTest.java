package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockVerificarLlamadaTest {

    @Mock
    private RepositorioMock repositorio;
    @InjectMocks
    private ServicioMock servicio;

    @Test
    void deberiaLlamarAlMetodoGuardar() {
        servicio.procesar();
        verify(repositorio).guardar();
    }
}
