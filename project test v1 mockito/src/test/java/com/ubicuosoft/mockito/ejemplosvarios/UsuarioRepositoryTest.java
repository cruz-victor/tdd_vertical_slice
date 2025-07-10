package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void deberiaGuardarYRecuperarUsuario(){
        //TODO: Configurar el archivo application.properties y habilitar la base de datos H2.
        //TODO: Para ver los datos insertados, correr la app y luego ingresar a la url http://localhost:8080/h2-console.
        //---GIVEN
        String nombre="Victor";
        String email="victor@gmail.com";
        Usuario usuario = new Usuario(null, nombre, email);
        //---WHEN
        Usuario usuarioGuardado=usuarioRepository.save(usuario);
        //---THEN
        Optional<Usuario> usuarioEncontrado=usuarioRepository.findById(usuarioGuardado.getId());
        assertThat(usuarioEncontrado).isPresent();
        assertThat(usuarioEncontrado.get().getNombre()).isEqualTo("Victor");
    }
}
