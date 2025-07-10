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
public class UsuarioTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void deberiaDevolverUsuarioPorId(){
        //GIVEN
        Usuario usuarioEsperado=new Usuario(10L,"Victor","victor@gmail.com");
        when(usuarioRepository.findById(usuarioEsperado.getId()))
                .thenReturn(Optional.of(usuarioEsperado));
        //WHEN
        Usuario resultado=usuarioService.obtenerUsuarioPorId(usuarioEsperado.getId());
        //THEN
        assertThat(resultado.getId()).isEqualTo(10L);
        assertThat(resultado.getNombre()).isEqualTo("Victor");
        assertThat(resultado.getEmail()).isEqualTo("victor@gmail.com");
    }
}
