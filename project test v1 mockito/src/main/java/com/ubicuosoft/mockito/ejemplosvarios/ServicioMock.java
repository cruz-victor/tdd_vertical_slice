package com.ubicuosoft.mockito.ejemplosvarios;

public class ServicioMock {
    private final RepositorioMock repositorio;

    public ServicioMock(RepositorioMock repositorio) {
        this.repositorio = repositorio;
    }

    String saludar(){
        return "Hola "+repositorio.obtenerNombre();
    }

    void procesar(){
        repositorio.guardar();
        repositorio.eliminar(10L);//*
    }

    void registrar(String nombre){
        repositorio.guardar(nombre);
    }
}
