package com.ubicuosoft.mockito.ejemplosvarios;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable long id){
        Usuario usuario=usuarioService.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }
}
