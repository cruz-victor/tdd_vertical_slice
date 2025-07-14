package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AssertExcepcionesV1Test {
    /*Vocabulario*/
    //throw = lanzar = Palabra que lanza una excepcion. Ej. throw new Exception()
    //thrown = lanzado = Se refiere a la excepcion que ya fue lanzado.
    //throwable = lanzable = Clase base de todas las excepciones y errores.
    //catch = atrapar = Atrapar o capturar una excepcion con catch(Throwable t).
    //catchTrowable = Atrapar la excepcion = Captura una excepcion lanzada.
    //assertThatThrownBy() = Afirmar que fue lanzada por = Afirma el ressltado de una excepcion.

//    @Mock
//    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void deberiaLanzarExcepcion() {
        assertThatThrownBy(
                () -> {
                    throw new IllegalArgumentException("Nombre invalido");
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Nombre invalido");
    }

    @Test
    void deberiaLanzarExcepcionPorNull() {
        assertThatThrownBy(
                () -> {
                    throw new NullPointerException("Falta el email");
                }
        )
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("email");
    }

    @Test
    void deberiaLanzarExcepcionConCatchThrowable() {
        Throwable throwable = catchThrowable(
                () -> {
                    throw new IllegalStateException("Error en estado");
                }
        );
        assertThat(throwable)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("estado");
    }

    @Test
    void deberiaLanzarExcepcionesSiIdEsNull() {
        //doNothing().when(usuarioRepository).deleteById(anyLong());

        assertThatThrownBy(() -> usuarioService.eliminarPorId(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ID no puede ser null");
    }

    @Test
    void deberiaLanzarExcepcionConCausa() {
        Throwable causa = new NullPointerException("detalle");

        assertThatThrownBy(() -> {
            throw new RuntimeException("fallo", causa);
        })
                .hasCauseInstanceOf(NullPointerException.class)
                .hasRootCauseMessage("detalle");
    }
}
