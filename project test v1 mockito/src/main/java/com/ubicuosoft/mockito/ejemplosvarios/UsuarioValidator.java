package com.ubicuosoft.mockito.ejemplosvarios;

import jakarta.validation.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class UsuarioValidator {
    private final Usuario usuario;
    private final List<String> errores=new ArrayList<>();

    //Factory method
    public static UsuarioValidator validar(Usuario usuario){
        return new UsuarioValidator(usuario);
    }

    private UsuarioValidator(Usuario usuario){
        this.usuario=usuario;
    }

    //Metodos con estilo fluido
    public UsuarioValidator tieneNombreValido() {
        if (usuario.getNombre()==null || usuario.getNombre().isBlank()){
            errores.add("El nombre es obligatorio");
        }
        return this;
    }

    public UsuarioValidator tieneCorreoValido() {
        if (usuario.getEmail()==null || !usuario.getEmail().contains("@")){
            errores.add("El correo es invalido");
        }
        return this;
    }

    public UsuarioValidator esMayorDeEdad() {
        if (usuario.getEdad()<18){
            errores.add("La edad debe ser mayor o igula a 18");
        }
        return this;
    }

    public void verificar() {
        if (!errores.isEmpty()){
            throw new ValidationException(String.join(" | ",errores));
        }
    }
}
