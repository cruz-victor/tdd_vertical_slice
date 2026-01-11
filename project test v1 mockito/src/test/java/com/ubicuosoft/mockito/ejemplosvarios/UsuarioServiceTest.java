package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void deberiaRetornarUsuarioCuandoExisteId() {
        //---GIVEN
        long id = 10;
        String nombre = "Victor";
        String email = "victor@gmail.com";
        int edad = 15;
        Usuario usuarioEsperado = new Usuario(id, nombre, email, edad);
        when(usuarioRepository.findById(id))
                .thenReturn(Optional.of(usuarioEsperado));
        //---WHEN
        Usuario resultado = usuarioService.obtenerUsuarioPorId(id);
        //---THEN
        assertThat(resultado.getId()).isEqualTo(10L);
        assertThat(resultado.getNombre()).isEqualTo("Victor");
        assertThat(resultado.getEmail()).isEqualTo("victor@gmail.com");
    }
}
