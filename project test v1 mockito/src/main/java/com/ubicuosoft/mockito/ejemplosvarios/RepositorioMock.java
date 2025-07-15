package com.ubicuosoft.mockito.ejemplosvarios;

import java.util.Optional;

interface RepositorioMock {
    String obtenerNombre();
    int obtenerEdad();
    int sumar(int a, int b);
    void guardar();
    void guardar(String nombre);
    void eliminar(Long id);
    String buscar(Long id);
    Optional<String> buscarOptional(Long id);
}
