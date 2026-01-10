package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class AssertExcepcionesV2Test {

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void deberiaVerificarMensaje_conAssertThatThrownBy() {
        assertThatThrownBy(() -> {
            throw new IllegalArgumentException("ID invalido");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ID invalido");
    }

    @Test
    void deberiaVerificarMensaje_conAssertThatThrownBy2() {
        assertThatThrownBy(() -> {
            throw new IllegalArgumentException("ID invalido");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ID invalido");
    }

    @Test
    void deberiaVerificarMensaje_conCatchThrowable() {
        Throwable lanzado = catchThrowable(() -> {
            throw new IllegalArgumentException("ID invalido");
        });

        assertThat(lanzado)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ID invalido");
    }

    @Test
    void deberiaVerificarMensajeParcial_conAssertThatThrownBy() {
        assertThatThrownBy(() -> {
            throw new NullPointerException("Falta el nombre");
        })
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("nombre");
    }

    @Test
    void deberiaVerificarMensajeParcial_conCatchThrowable() {
        Throwable thown= catchThrowable(()->{
            throw new NullPointerException("Falta el nombre");
        });

        assertThat(thown)
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("nombre");
    }

    @Test
    void deberiaVerificarMensajeDeMetodoReal_conAssertThatThrownBy(){
        assertThatThrownBy(()->usuarioService.eliminarPorId(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ID no puede ser null");
    }

    @Test
    void deberiaVerificarMensajeDeMetodoReal_conCatchThrowable(){
        Throwable lanzado=catchThrowable(()->usuarioService.eliminarPorId(null));

        assertThat(lanzado)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ID no puede ser null");
    }
}
