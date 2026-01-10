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
        //---Given
        when(repositorio.obtenerNombre()).thenReturn("Juan");
        //---When
        String nombre=repositorio.obtenerNombre();
        //---Then
        assertThat(nombre).isEqualTo("Juan");
    }

    @Test
    void deberiaRetornarNombreYedadDesdeMock(){
        //---Given
        when(repositorio.obtenerNombre()).thenReturn("Victor");
        when(repositorio.obtenerEdad()).thenReturn(25);
        //---When
        String nombre=repositorio.obtenerNombre();
        int edad=repositorio.obtenerEdad();
        //---Then
        assertThat(nombre).isEqualTo("Victor");
        assertThat(edad).isEqualTo(25);
    }

    @Test
    void deberiaSimularRespustasDifierentes(){
        //---Given
        when(repositorio.obtenerNombre())
                .thenReturn("Victor")
                .thenReturn("Juan")
                .thenReturn("Pedro");
        //---When
        //---Then
        assertThat(repositorio.obtenerNombre()).isEqualTo("Victor");
        assertThat(repositorio.obtenerNombre()).isEqualTo("Juan");
        assertThat(repositorio.obtenerNombre()).isEqualTo("Pedro");
    }

}
