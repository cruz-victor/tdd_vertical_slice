package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockExcepcionTest {
    @Mock
    private RepositorioMock repositorio;

    @Test
    void deberiaLanzarExcepcionDesdeMock() {
        //---Given
        when(repositorio.buscar(99L)).thenThrow(new RuntimeException("No encontrado"));
        //---When
        Throwable lanzado = catchThrowable(() -> {
            repositorio.buscar(99L);
        });
        //---Then
        assertThat(lanzado)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("No encontrado");
    }
}
