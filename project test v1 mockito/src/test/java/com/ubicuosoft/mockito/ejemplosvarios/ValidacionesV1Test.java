package com.ubicuosoft.mockito.ejemplosvarios;

import jakarta.validation.ValidationException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ValidacionesV1Test {
    //TODO: Invocando clase validador con patron Builder.

    @Test
    void deberiaValidarUsuarioValido(){
        //GIVEN
        long id = 10L;
        String nombre = "Victor";
        String correo = "victor@gmail.com";
        int edad = 18;
        Usuario usuario = new Usuario(id, nombre, correo, edad);
        //WHEN
        Throwable lanzado=catchThrowable(()->{
            UsuarioValidator.validar(usuario)
                    .tieneNombreValido()
                    .tieneCorreoValido()
                    .esMayorDeEdad()
                    .verificar();
        });
        //THEN
        assertThat(lanzado).doesNotThrowAnyException();

    }

    @Test
    void deberiaFallarSiNombreVacio(){
        //GIVEN
        long id = 10L;
        String nombre = "";
        String correo = "victor@gmail.com";
        int edad = 18;
        Usuario usuario = new Usuario(id, nombre, correo, edad);
        //WHEN
        Throwable lanzado=catchThrowable(()->{
            UsuarioValidator.validar(usuario)
                    .tieneNombreValido()
                    .verificar();
        });

        //THEN
        assertThat(lanzado)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("nombre");
    }

    @Test
    void deberiaFallarSiCorreoInvalido(){
        //GIVEN
        long id = 10L;
        String nombre = "Victor";
        String correo = "victorgmail.com";
        int edad = 18;
        Usuario usuario = new Usuario(id, nombre, correo, edad);
        //WHEN
        Throwable lanzado=catchThrowable(()->{
            UsuarioValidator.validar(usuario)
                    .tieneCorreoValido()
                    .verificar();
        });
        //THEN
        assertThat(lanzado)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("correo");
    }

    @Test
    void deberiaFallarSiMenorDeEdad(){
        //GIVEN
        long id = 10L;
        String nombre = "Victor";
        String correo = "victor@gmail.com";
        int edad = 15;
        Usuario usuario = new Usuario(id, nombre, correo, edad);
        //WHEN
        Throwable lanzado=catchThrowable(()->{
            UsuarioValidator.validar(usuario)
                    .esMayorDeEdad()
                    .verificar();
        });
        //THEN
        assertThat(lanzado)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("edad");
    }
}
