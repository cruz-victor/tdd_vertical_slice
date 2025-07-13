package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AssertExcepcionesTestV1 {
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
