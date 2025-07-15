package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockVerificarLlamadaTest {

    @Mock
    private RepositorioMock repositorio;
    @InjectMocks
    private ServicioMock servicio;

    @Test
    void deberiaLlamarAlMetodoGuardar() {
        servicio.procesar();
        verify(repositorio).guardar();
    }

    @Test
    void deberiaGuardarDosVeces(){
        servicio.procesar();
        servicio.procesar();
        verify(repositorio,times(2)).guardar();
    }

    @Test
    void deberiaLlamarGuardarConNombreEspecifico(){
        servicio.registrar("Victor");
        verify(repositorio).guardar(eq("Victor"));
    }

    @Test
    void deberiaVerificarOrdeLlamadas(){
        InOrder inOrder= Mockito.inOrder(repositorio);

        servicio.procesar();

        inOrder.verify(repositorio).guardar();
        inOrder.verify(repositorio).eliminar(anyLong());
    }
}
