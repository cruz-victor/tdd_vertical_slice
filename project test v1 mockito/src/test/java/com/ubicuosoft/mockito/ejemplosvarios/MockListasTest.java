package com.ubicuosoft.mockito.ejemplosvarios;

import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
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

    @Test
    void deberiaSimularLista(){
        List<String> listaMock=mock(List.class);

        when(listaMock.size()).thenReturn(3);
        when(listaMock.get(0)).thenReturn("Uno");
        when(listaMock.get(1)).thenReturn("Dos");

        assertThat(listaMock.size()).isEqualTo(3);
        assertThat(listaMock.get(0)).isEqualTo("Uno");
        assertThat(listaMock.get(1)).isEqualTo("Dos");
    }

    @Test
    void deberiaSimularMap(){
        Map<String, String> mapMock=mock(Map.class);

        when(mapMock.size()).thenReturn(3);
        when(mapMock.get("clave1")).thenReturn("valor1");
        when(mapMock.containsKey("clave1")).thenReturn(true);

        assertThat(mapMock.size()).isEqualTo(3);
        assertThat(mapMock.get("clave1")).isEqualTo("valor1");
        assertThat(mapMock.containsKey("clave1")).isTrue();
        assertThat(mapMock.get("clavex")).isNull();
    }

    @Test
    void deberiaSimularSet(){
        Set<String> setMock=mock(Set.class);

        when(setMock.size()).thenReturn(3);
        when(setMock.contains("x")).thenReturn(true);

        assertThat(setMock.size()).isEqualTo(3);
        assertThat(setMock.contains("x")).isTrue();
        assertThat(setMock.contains("y")).isFalse();
    }

    @Test
    void deberiaLanzarExcepcion(){
        List<String> listaMock=mock(List.class);

        when(listaMock.get(10)).thenThrow(new IndexOutOfBoundsException("Indice invalido"));

        Throwable lanzado=catchThrowable(()->{
            listaMock.get(10);
        });

        assertThat(lanzado)
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Indice");
    }

    @Test
    void deberiaVerificarLlamadasaLista(){
        List<String> listaMock=mock(List.class);

        listaMock.add("Hola");
        listaMock.clear();

        verify(listaMock).add("Hola");
        verify(listaMock).clear();
        verify(listaMock, times(1)).add(anyString());
    }
}