package com.ubicuosoft.mockito.ejemplosvarios;

interface RepositorioMock {
    String obtenerNombre();
    int obtenerEdad();
    int sumar(int a, int b);
    void guardar();
    void guardar(String nombre);
    void eliminar(Long id);
    String buscar(Long id);
}
