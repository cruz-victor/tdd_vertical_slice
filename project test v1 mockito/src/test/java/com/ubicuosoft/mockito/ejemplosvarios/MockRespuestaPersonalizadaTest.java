package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockRespuestaPersonalizadaTest {
    @Mock
    private RepositorioMock repositorio;

    @Test
    void deberiaSumarDinamicamente() {
        when(repositorio.sumar(anyInt(), anyInt()))
                .thenAnswer(fun -> {
                    int a = fun.getArgument(0);
                    int b = fun.getArgument(1);
                    return a + b;
                });
        int resultado = repositorio.sumar(3, 7);
        assertThat(resultado).isEqualTo(10);
    }
}
