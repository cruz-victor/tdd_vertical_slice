package com.ubicuosoft.mockito.ejemplosvarios;

import jakarta.validation.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class UsuarioValidatorSinConstructor {
    private final Usuario usuario;
    private final List<String> errores = new ArrayList<>();

    public UsuarioValidatorSinConstructor(Usuario usuario) {
        this.usuario = usuario;
    }

    //Metodos con estilo fluido
    public UsuarioValidatorSinConstructor tieneNombreValido() {
        if (usuario.getNombre() == null || usuario.getNombre().isBlank()) {
            errores.add("El nombre es obligatorio");
        }
        return this;
    }

    public UsuarioValidatorSinConstructor tieneCorreoValido() {
        if (usuario.getEmail() == null || !usuario.getEmail().contains("@")) {
            errores.add("El correo es invalido");
        }
        return this;
    }

    public UsuarioValidatorSinConstructor esMayorDeEdad() {
        if (usuario.getEdad() < 18) {
            errores.add("La edad debe ser mayor o igula a 18");
        }
        return this;
    }

    public void verificar() {
        if (!errores.isEmpty()) {
            throw new ValidationException(String.join(" | ", errores));
        }
    }
}
