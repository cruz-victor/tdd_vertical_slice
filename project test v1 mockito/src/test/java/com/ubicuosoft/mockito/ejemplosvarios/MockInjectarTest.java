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
    @InjectMocks //Crea un objeto real e injecta dobles falsos
    private ServicioMock servicio;
    @Mock //Crea un doble falso.
    private RepositorioMock repositorio;

    @Test
    void deberiaSaludarConNombreMockeado() {
        //---Given
        when(repositorio.obtenerNombre()).thenReturn("Grace");
        //---When
        String saludo = servicio.saludar();
        //---Then
        assertThat(saludo).isEqualTo("Hola Grace");
    }
}
