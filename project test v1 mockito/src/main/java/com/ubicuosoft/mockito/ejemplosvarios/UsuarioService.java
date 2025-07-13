package com.ubicuosoft.mockito.ejemplosvarios;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("No existe el usuario"));
    }

    public void eliminarPorId(Long id){
        if (id==null)
            throw new IllegalArgumentException("ID no puede ser null");
        usuarioRepository.deleteById(id);
    }

}
