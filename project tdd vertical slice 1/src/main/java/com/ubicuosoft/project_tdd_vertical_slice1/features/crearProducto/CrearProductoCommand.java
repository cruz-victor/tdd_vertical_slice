package com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CrearProductoCommand {
    private String nombre;
    private double precio;

//    public CrearProductoCommand(String nombre, double precio) {
//        this.nombre = nombre;
//        this.precio = precio;
//    }

//    public String getNombre() {
//        return nombre;
//    }
//
//    public double getPrecio() {
//        return precio;
//    }
}
