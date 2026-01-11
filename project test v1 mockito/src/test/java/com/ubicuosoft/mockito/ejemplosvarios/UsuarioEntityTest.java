package com.ubicuosoft.mockito.ejemplosvarios;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;


public class UsuarioEntityTest {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    //TODO: Agregar la dependencia spring-boot-starter-validation
    //TODO: Match, coincidencia. Ej. Juan y Maria hicieron Match en sus gustos.
    //TODO: anyMatch, alguno coincide.
    //TODO: noneMatch, ninguno coincide.

    @Test
    void deberiaFallarSiElNombreDeUsuarioEsMuyCorto() {
        //---GIVEN
        Usuario usuario = new Usuario();
        usuario.setNombre("ab");
        //---WHEN
        Set<ConstraintViolation<Usuario>> violaciones = validator.validate(usuario);
        System.out.println(violaciones);
        //---THEN
        //El test es valido cuando se comprueba que la validacion del campo nombre se activa porque no cumple con la restriccion (entre 3 y 20 caracteres).
        //Validar que el campo nombre tiene una violacion por tamaño.
        assertThat(violaciones)
                .anyMatch(v -> v.getPropertyPath().toString().equals("nombre"));
        //Validar que el campo nombre no esta vacio
        assertThat(violaciones)
                .anyMatch(v -> v.getPropertyPath().toString().equals("nombre") &&
                        v.getMessage().contains("entre 3 y 20 caracteres"));
    }

    @Test
    void deberiaFallarSiElCorreoEsInvalido() {
        //---GIVEN
        Usuario usuario = new Usuario();
        usuario.setEmail("vic");
        //---WHEN
        Set<ConstraintViolation<Usuario>> violaciones = validator.validate(usuario);
        System.out.println(violaciones);
        //---THEN
        //El test es valido cuando se comprueba que la validacion del campo email se activo porque no cumple con la restriccion (correo con formato a@b.c)
        // Validar que hay una violación específicamente en el campo 'email'
        assertThat(violaciones)
                .anyMatch(v -> v.getPropertyPath().toString().equals("email"));
        // Validar que el mensaje corresponde a formato inválido
        assertThat(violaciones)
                .anyMatch(v -> v.getPropertyPath().toString().equals("email")
                        && v.getMessage().contains("El formato del correo no es válido"));
        // Validar que no sea por campo vacío
        assertThat(violaciones)
                .noneMatch(v -> v.getMessage().contains("El correo es obligatorio"));
    }

    @Test
    void debePasarSiTodosLosCamposSonValidos() {
        //---GIVEN
        Usuario usuario = new Usuario();
        usuario.setNombre("Victor");
        usuario.setEmail("victor@gmail.com");
        //---WHEN
        Set<ConstraintViolation<Usuario>> violaciones = validator.validate(usuario);
        //---THEN
        //El test es valido cuando se comprueba que los campos nombre y email cumplen con la restricciones.
        //Validar que todos los campos sean validos. No hay ninguna violacion.
        assertThat(violaciones).isEmpty();
        //Validar que el campo nombre no tiene errores.
        assertThat(violaciones)
                .noneMatch(v -> v.getPropertyPath().toString().equals("nombre"));
        //Validar que el campo email no tiene errores.
        assertThat(violaciones)
                .noneMatch(v -> v.getPropertyPath().toString().equals("email"));
    }
}
