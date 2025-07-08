package com.ubicuosoft.project_test_v0.features.crearProducto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private String nombre;
    private double precio;
//    public Producto(String nombre, double precio) {
//        this.nombre=nombre;
//        this.precio=precio;
//    }
}