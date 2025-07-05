package com.ubicuosoft.project_tdd_vertical_slice1.features.eliminarProductoPorId;

import com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EliminarProductoService {
    @Autowired
    private final ProductoRepository productoRepository;

    public EliminarProductoService(ProductoRepository productoRepository){
        this.productoRepository=productoRepository;
    }

    public void execute(long id) {
//        throw new UnsupportedOperationException("Not yet implemented");
        productoRepository.eliminar(id);
    }
}
