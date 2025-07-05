package com.ubicuosoft.project_tdd_vertical_slice1.features.listarProductos;

import com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto.CrearProductoService;
import com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto.Producto;
import com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ListarProductosServiceTest {
    //AUDITORIA DE TEST
    //Test 1 - Deberia listar todos los productos
    //Test 2 - Deberia lanzar un error si no existe productos

    @MockBean
    private ProductoRepository productoRepository;
    @Autowired
    private ListarProductosService listarProductosService;

    @Test
    void deberiaListarTodosLosProductos() {
        //Given (Contexto inicial)
        List<Producto> productos = List.of(new Producto("Lapicero", 3.5), new Producto("Cuaderno", 5.5));
        when(productoRepository.listar())
                .thenReturn(productos);
        //When (Accion del usuario)
        List<Producto> resultado = listarProductosService.execute();
        //Then (Resultado esperado)
        assertEquals(2, resultado.size());
    }
}
