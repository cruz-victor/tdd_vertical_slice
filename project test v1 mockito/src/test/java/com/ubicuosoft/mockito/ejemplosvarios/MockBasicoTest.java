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

    @Test
    void deberiaRetornarNombreYedadDesdeMock(){
        when(repositorio.obtenerNombre()).thenReturn("Victor");
        when(repositorio.obtenerEdad()).thenReturn(25);

        String nombre=repositorio.obtenerNombre();
        int edad=repositorio.obtenerEdad();

        assertThat(nombre).isEqualTo("Victor");
        assertThat(edad).isEqualTo(25);
    }

    @Test
    void deberiaSimularRespustasDifierentes(){
        when(repositorio.obtenerNombre())
                .thenReturn("Victor")
                .thenReturn("Juan")
                .thenReturn("Pedro");

        assertThat(repositorio.obtenerNombre()).isEqualTo("Victor");
        assertThat(repositorio.obtenerNombre()).isEqualTo("Juan");
        assertThat(repositorio.obtenerNombre()).isEqualTo("Pedro");
    }

}
