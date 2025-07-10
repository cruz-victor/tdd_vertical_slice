package com.ubicuosoft.mockito.ejemplosvarios;

import java.util.Optional;

interface UsuarioRepository {
    Optional<Usuario> findById(Long id);
}
