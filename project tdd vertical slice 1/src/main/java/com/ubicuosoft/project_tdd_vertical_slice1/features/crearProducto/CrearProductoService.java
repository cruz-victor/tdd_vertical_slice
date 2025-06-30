package com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto;

import org.springframework.stereotype.Service;

@Service
public class CrearProductoService {

    private ProductoRepository productoRepository;

    public CrearProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public void execute(CrearProductoCommand command) {
        verficarExistenciaDelProducto(command);
        guardarProducto(command);
    }

    private void guardarProducto(CrearProductoCommand command) {
        Producto nuevoProducto = new Producto(command.getNombre(), command.getPrecio());
        productoRepository.guardar(nuevoProducto);
    }

    private void verficarExistenciaDelProducto(CrearProductoCommand command) {
//        if (productoRepository.buscarPorNombre(command.getNombre()).isPresent()) {
//            throw new IllegalArgumentException("El producto ya existe");
//        }

        productoRepository.buscarPorNombre(command.getNombre())
                .ifPresent(producto -> {
                    throw new ProductoYaExisteException(command.getNombre());
                });
    }
}
