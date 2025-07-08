package com.ubicuosoft.project_test_v0.features.obtenerProductoPorId;

import com.ubicuosoft.project_test_v0.features.crearProducto.Producto;
import com.ubicuosoft.project_test_v0.features.crearProducto.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ObtnerProductoServiceTest {
    @MockBean
    private ProductoRepository productRepository;
    @Autowired
    private ObtenerProductoPorIdService obtenerProductoPorIdService;
    //AUDITORIA DE TEST
    //Test 1 - Deberia obtener producto por id
    //Test 2 - Deberia lanzar un error cuando el id del producto no existe


    //Test 1 - Deberia obtener producto por id
    @Test
    void deberiaObtenerProductoPorId(){
        //Given (Contexto inicial)
        ObtenerProductoPorIdCommand obtenerProductoPorIdCommand=new  ObtenerProductoPorIdCommand(1L);
        when(productRepository.buscarPorId(obtenerProductoPorIdCommand.getId()))
                .thenReturn(Optional.of(new Producto("Lapicero",1.5)));
        //When (Accion del usuario)
        Producto result= obtenerProductoPorIdService.execute(obtenerProductoPorIdCommand);
        //Then (Resultado esperado)
        assertEquals("Lapicero", result.getNombre());
    }
}


