package com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CrearProductoServiceTest {
    //AUDITORIA DE TEST
    //Test 1 - Deberia crear producto si el nombre del mismo no existe
    //Test 2 - Deberia lanzar un error si el producto ya existe

    @MockBean
    private ProductoRepository productoRepository;
    @Autowired
    private CrearProductoService crearProductoService;

    //Test 1 - Deberia crear producto si el nombre del mismo no existe
    @Test
    void deberiaCrearProductoSiNombreNoExiste(){
        //Given (Contexto inicial)
        CrearProductoCommand crearProductoCommand=new CrearProductoCommand("Lapicero",2.5);
        when(productoRepository.buscarPorNombre(crearProductoCommand.getNombre()))
                .thenReturn(Optional.empty());
        //When (Accion del usuario)
        crearProductoService.execute(crearProductoCommand);
        //Then (Resultado esperado)
        verify(productoRepository).guardar(any());
    }

    //Test 2 - Deberia lanzar un error si el producto ya existe
    @Test
    void deberiaLanzarErrorSiProductoYaExiste(){
        //Given (Contexto inicial)
        ProductoYaExisteException exception = null;
        CrearProductoCommand crearProductoCommand=new CrearProductoCommand("Lapicero", 2.5);
        when(productoRepository.buscarPorNombre(crearProductoCommand.getNombre()))
                .thenReturn(Optional.of(new Producto("Lapicero", 2.5)));
        //When (Accion del usuario)
        try{
            crearProductoService.execute(crearProductoCommand);
            fail("Esperaba que se lanzara ProductoYaExisteException");
        }catch (ProductoYaExisteException e){
            exception = e;
        }
        //Then (Resultado esperado)
        assertNotNull(exception);
        assertTrue(exception.getMessage().contains("ya existe"));
    }
}
