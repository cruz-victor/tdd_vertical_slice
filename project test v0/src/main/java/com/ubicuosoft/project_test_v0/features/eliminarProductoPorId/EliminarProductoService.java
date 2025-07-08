package com.ubicuosoft.project_test_v0.features.eliminarProductoPorId;

import com.ubicuosoft.project_test_v0.features.crearProducto.ProductoRepository;
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
