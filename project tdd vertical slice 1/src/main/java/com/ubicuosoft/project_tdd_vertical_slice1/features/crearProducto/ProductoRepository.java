package com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto;

import java.util.Optional;

public interface ProductoRepository {
    void guardar(Producto producto);
    Optional<Producto> buscarPorNombre(Object nombre);

    Optional<Producto> buscarPorId(long id);
}
