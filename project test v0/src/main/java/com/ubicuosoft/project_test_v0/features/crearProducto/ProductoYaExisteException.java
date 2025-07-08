package com.ubicuosoft.project_test_v0.features.crearProducto;

public class ProductoYaExisteException extends RuntimeException {
    public ProductoYaExisteException(Object nombre) {
        super("El producto con nombre '" + nombre + "' ya existe.");
    }
}
