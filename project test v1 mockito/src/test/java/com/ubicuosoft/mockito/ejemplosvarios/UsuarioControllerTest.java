package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {
    @Autowired //Similar to InjectMock
    private MockMvc mockMvc;
    @MockBean //Similar to Mock
    private UsuarioService usuarioService;

    @Test
    void deberiaObtenerUsuarioPorId() throws Exception {
        //--- GIVEN
        long id = 10L;
        String nombre = "Victor";
        String email = "victor@gmail.com";
        int edad = 15;
        Usuario usuarioEsperado = new Usuario(id, nombre, email, edad);
        when(usuarioService.obtenerUsuarioPorId(id))
                .thenReturn(usuarioEsperado);
        //--- WHEN
        ResultActions respuesta = mockMvc.perform(get("/usuarios/{id}", id));
        //--- THEN
        respuesta
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Victor"))
                .andExpect(jsonPath("$.email").value("victor@gmail.com"));
    }
}
