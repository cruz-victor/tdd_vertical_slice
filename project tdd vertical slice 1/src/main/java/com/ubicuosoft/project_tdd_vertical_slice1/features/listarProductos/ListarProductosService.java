package com.ubicuosoft.project_tdd_vertical_slice1.features.listarProductos;


import com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto.Producto;
import com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarProductosService {
    @Autowired
    private ProductoRepository productoRepository;

    public ListarProductosService(ProductoRepository productoRepository){
        this.productoRepository=productoRepository;
    }

    public List<Producto> execute() {
//        throw new UnsupportedOperationException("Yet implement");
        return productoRepository.listar();
    }
}
