package com.ubicuosoft.project_test_v0.features.obtenerProductoPorId;

import com.ubicuosoft.project_test_v0.features.crearProducto.Producto;
import com.ubicuosoft.project_test_v0.features.crearProducto.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObtenerProductoPorIdService {

    @Autowired
    private final ProductoRepository productoRepository;

    public ObtenerProductoPorIdService(ProductoRepository productoRepository){
        this.productoRepository=productoRepository;
    }

    public Producto execute(ObtenerProductoPorIdCommand obtenerProductoPorIdCommand) {
        return productoRepository.buscarPorId(obtenerProductoPorIdCommand.getId()).orElseThrow();
    }
}
