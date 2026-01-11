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
        //---Given

        //---When
        servicio.procesar();
        //---Then
        verify(repositorio).guardar();
    }

    @Test
    void deberiaGuardarDosVeces(){
        //---Given

        //---When
        servicio.procesar();
        servicio.procesar();
        //---Then
        verify(repositorio,times(2)).guardar();
    }

    @Test
    void deberiaLlamarGuardarConNombreEspecifico(){
        //---Given

        //---When
        servicio.registrar("Victor");
        //---Then
        verify(repositorio).guardar(eq("Victor"));
    }

    @Test
    void deberiaVerificarOrdeLlamadas(){
        //---Given
        InOrder inOrder= Mockito.inOrder(repositorio);
        //---When
        servicio.procesar();
        //---Then
        inOrder.verify(repositorio).guardar();
        inOrder.verify(repositorio).eliminar(anyLong());
    }
}
