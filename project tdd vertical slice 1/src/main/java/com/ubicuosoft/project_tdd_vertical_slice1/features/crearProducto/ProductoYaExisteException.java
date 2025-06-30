package com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto;

public class ProductoYaExisteException extends RuntimeException {
    public ProductoYaExisteException(Object nombre) {
        super("El producto con nombre '" + nombre + "' ya existe.");
    }
}
