package com.ubicuosoft.mockito.ejemplosvarios;

import jakarta.validation.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ValidacionesV3Test {
    //TODO: Invocando clase validador sin patron Builder y mocks.

    @Mock
    private Usuario usuario;
    @InjectMocks
    private UsuarioValidatorSinConstructor validador;

    @Test
    void deberiaValidarUsuarioValido() {
        //GIVEN
        when(usuario.getNombre()).thenReturn("Victor");
        when(usuario.getEmail()).thenReturn("victor@gmail.com");
        when(usuario.getEdad()).thenReturn(18);

        //WHEN
        Throwable lanzado = catchThrowable(() -> {
            validador.tieneNombreValido()
                    .tieneCorreoValido()
                    .esMayorDeEdad()
                    .verificar();
        });
        //THEN
        assertThat(lanzado).doesNotThrowAnyException();

    }

    @Test
    void deberiaFallarSiNombreVacio() {
        //GIVEN
        when(usuario.getNombre()).thenReturn("");
        //WHEN
        Throwable lanzado = catchThrowable(() -> {
            validador.tieneNombreValido()
                    .verificar();
        });

        //THEN
        assertThat(lanzado)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("nombre");
    }

    @Test
    void deberiaFallarSiCorreoInvalido() {
        //GIVEN
        when(usuario.getEmail()).thenReturn("micorreo_gmail.com");
        //WHEN
        Throwable lanzado = catchThrowable(() -> {
            validador.tieneCorreoValido()
                    .verificar();
        });
        //THEN
        assertThat(lanzado)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("correo");
    }

    @Test
    void deberiaFallarSiMenorDeEdad() {
        //GIVEN
        when(usuario.getEdad()).thenReturn(15);
        //WHEN
        Throwable lanzado = catchThrowable(() -> {
            validador.esMayorDeEdad()
                    .verificar();
        });
        //THEN
        assertThat(lanzado)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("edad");
    }
}
