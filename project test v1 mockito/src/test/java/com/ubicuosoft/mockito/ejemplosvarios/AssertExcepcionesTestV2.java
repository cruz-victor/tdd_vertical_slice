package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AssertExcepcionesTestV2 {

    @Test
    void deberiaVerificarMensaje_conAssertThatThrownBy() {
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
}
