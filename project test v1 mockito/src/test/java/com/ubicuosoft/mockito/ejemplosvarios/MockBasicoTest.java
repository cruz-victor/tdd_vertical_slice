package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockBasicoTest {

    @Mock
    private RepositorioMock repositorio;

    @Test
    void deberiaRetornarNombreDesdeMock(){
        when(repositorio.obtenerNombre()).thenReturn("Juan");
        String nombre=repositorio.obtenerNombre();
        assertThat(nombre).isEqualTo("Juan");
    }
}
