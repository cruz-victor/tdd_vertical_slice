package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockArgumentoFlexibleTest {

    @Mock
    private RepositorioMock repositorio;

    @Test
    void deberiaRetornarValorParaCualquierId(){
        //---Given
        when(repositorio.buscar(anyLong())).thenReturn("OK");
        //---When
        String resultado=repositorio.buscar(222L);
        //---Then
        assertThat(resultado).isEqualTo("OK");
    }
}
