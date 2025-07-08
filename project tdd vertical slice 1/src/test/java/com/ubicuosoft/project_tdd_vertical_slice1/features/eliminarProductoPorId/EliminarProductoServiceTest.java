package com.ubicuosoft.project_tdd_vertical_slice1.features.eliminarProductoPorId;

import com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
public class EliminarProductoServiceTest {
    //AUDITORIA DE  TEST
    //Test 1 - Deberia eliminar un Producto por Id
    //Test 2 - Deberia lanzar error si el Producto no existe

    @MockBean
    private ProductoRepository productoRepository;
    @Autowired
    private EliminarProductoService eliminarProductoService;

    @Test
    void deberiaEliminarProductoPorId(){
        //Given (Contexto inicial)
        EliminarProductoCommand eliminarProductoCommand=new EliminarProductoCommand(10L);
        doNothing().when(productoRepository).eliminar(eliminarProductoCommand.getId());
        //When (Accion del usuario)
        eliminarProductoService.execute(eliminarProductoCommand.getId());
        //Then (Resultado esperado)
        verify(productoRepository, times(1)).eliminar(eliminarProductoCommand.getId());
    }

    @Test
    void deberiaEliminarProductoPorIdv2(){
        //Given (Contexto inicial)
        EliminarProductoCommand eliminarProductoCommand=new EliminarProductoCommand(10L);
        doNothing().when(productoRepository).eliminar(eliminarProductoCommand.getId());
        //When (Accion del usuario)
        eliminarProductoService.execute(eliminarProductoCommand.getId());
        //Then (Resultado esperado)
        verify(productoRepository, times(1)).eliminar(eliminarProductoCommand.getId());
    }
}
