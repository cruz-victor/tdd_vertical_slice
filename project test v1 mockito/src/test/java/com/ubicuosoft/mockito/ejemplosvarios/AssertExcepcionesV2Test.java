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
        //---Given
        //---When
        //---Then
        assertThatThrownBy(() -> {
            throw new IllegalArgumentException("ID invalido");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ID invalido");
    }

    @Test
    void deberiaVerificarMensaje_conCatchThrowable() {
        //---Given
        Throwable lanzado = catchThrowable(() -> {
            throw new IllegalArgumentException("ID invalido");
        });
        //---When

        //---Then
        assertThat(lanzado)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ID invalido");
    }

    @Test
    void deberiaVerificarMensajeParcial_conAssertThatThrownBy() {
        //---Given
        //---When
        //---Then
        assertThatThrownBy(() -> {
            throw new NullPointerException("Falta el nombre");
        })
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("nombre");
    }

    @Test
    void deberiaVerificarMensajeParcial_conCatchThrowable() {
        //---Given
        Throwable thown = catchThrowable(() -> {
            throw new NullPointerException("Falta el nombre");
        });
        //---When

        //---Then
        assertThat(thown)
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("nombre");
    }

    @Test
    void deberiaVerificarMensajeDeMetodoReal_conAssertThatThrownBy() {
        //---Given
        //---When
        //---Then
        assertThatThrownBy(() -> usuarioService.eliminarPorId(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ID no puede ser null");
    }

    @Test
    void deberiaVerificarMensajeDeMetodoReal_conCatchThrowable() {
        //---Given
        Throwable lanzado = catchThrowable(() -> usuarioService.eliminarPorId(null));
        //---When

        //---Then
        assertThat(lanzado)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ID no puede ser null");
    }
}
