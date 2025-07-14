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
public class ValidacionesV2Test {
    //TODO: Invocando clase validador sin patron Builder.

    @Test
    void deberiaValidarUsuarioValido() {
        //GIVEN
        long id = 10L;
        String nombre = "Victor";
        String correo = "victor@gmail.com";
        int edad = 18;
        Usuario usuario = new Usuario(id, nombre, correo, edad);
        UsuarioValidatorSinConstructor validador = new UsuarioValidatorSinConstructor(usuario);
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
        long id = 10L;
        String nombre = "";
        String correo = "victor@gmail.com";
        int edad = 18;
        Usuario usuario = new Usuario(id, nombre, correo, edad);
        UsuarioValidatorSinConstructor validador = new UsuarioValidatorSinConstructor(usuario);
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
        long id = 10L;
        String nombre = "Victor";
        String correo = "victorgmail.com";
        int edad = 18;
        Usuario usuario = new Usuario(id, nombre, correo, edad);
        UsuarioValidatorSinConstructor validador = new UsuarioValidatorSinConstructor(usuario);
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
        long id = 10L;
        String nombre = "Victor";
        String correo = "victor@gmail.com";
        int edad = 15;
        Usuario usuario = new Usuario(id, nombre, correo, edad);
        UsuarioValidatorSinConstructor validador = new UsuarioValidatorSinConstructor(usuario);
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
