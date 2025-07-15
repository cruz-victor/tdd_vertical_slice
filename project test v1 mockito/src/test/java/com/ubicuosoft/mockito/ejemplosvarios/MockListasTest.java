package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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
}
