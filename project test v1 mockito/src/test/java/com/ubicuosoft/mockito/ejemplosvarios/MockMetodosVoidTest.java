package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockMetodosVoidTest {
    @Mock
    private RepositorioMock repositorio;

    @Test
    void deberiaLanzarExcepcionAlEliminar() {
        //---Given
        doThrow(new IllegalArgumentException("Id invalido"))
                .when(repositorio).eliminar(999L);
        //---When
        Throwable lanzado = catchThrowable(() -> {
            repositorio.eliminar(999L);
        });
        //---Then
        assertThat(lanzado)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalido");
    }
}
