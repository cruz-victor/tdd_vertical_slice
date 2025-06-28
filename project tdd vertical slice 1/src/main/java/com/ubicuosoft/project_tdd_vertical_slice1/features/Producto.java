package com.ubicuosoft.project_tdd_vertical_slice1.features;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Producto {
    private String nombre;
    private double precio;
//    public Producto(String nombre, double precio) {
//        this.nombre=nombre;
//        this.precio=precio;
//    }
}