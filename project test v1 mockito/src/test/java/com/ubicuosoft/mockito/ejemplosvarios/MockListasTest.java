package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockListasTest {

    @Test
    void deberiaSimularListas() {
        List<String> listaMock = mock(List.class);
        when(listaMock.get(0)).thenReturn("dato");

        assertThat(listaMock.get(0)).isEqualTo("dato");

        verify(listaMock).get(0);
    }

    @Mock
    RepositorioMock repositorio;

    @Test
    void deberiaRetornarOptional() {
        when(repositorio.buscarOptional(anyLong())).thenReturn(Optional.of("Victor"));

        Optional<String> resultado = repositorio.buscarOptional(1L);

        assertThat(resultado).isPresent();
        assertThat(resultado.get()).isEqualTo("Victor");
    }
}
