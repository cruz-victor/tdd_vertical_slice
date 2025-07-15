package com.ubicuosoft.mockito.ejemplosvarios;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockCaptureArgumentoTest {
    @Mock
    private RepositorioMock repositorio;
    @InjectMocks
    private ServicioMock servicio;
    @Captor
    private ArgumentCaptor<String> nombreCaptor;

    @Test
    void deberiaCapturarArgumento() {
        servicio.registrar("Victor");
        verify(repositorio).guardar(nombreCaptor.capture());//Captura el parametro del metodo registrar(parametro){repositorio.guardar(parametro);}
        assertThat(nombreCaptor.getValue()).isEqualTo("Victor");
    }
}
