package com.ubicuosoft.project_test_v0.features.crearProducto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {
    void guardar(Producto producto);
    Optional<Producto> buscarPorNombre(Object nombre);
    Optional<Producto> buscarPorId(long id);
    List<Producto> listar();
    void eliminar(long id);
}
