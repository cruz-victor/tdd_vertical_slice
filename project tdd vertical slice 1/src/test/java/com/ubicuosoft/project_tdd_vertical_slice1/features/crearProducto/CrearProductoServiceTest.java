package com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto;

import com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto.CrearProductoCommand;
import com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto.CrearProductoService;
import com.ubicuosoft.project_tdd_vertical_slice1.features.crearProducto.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CrearProductoServiceTest {
    //AUDITAR TEST
    @MockBean
    private ProductoRepository productoRepository;
    @Autowired
    private CrearProductoService handler;

    //Test 1 - Debe crear producto si el nombre del mismo no existe
    @Test
    void debeCrearProductoSiNombreNoExiste(){
        //Given
        CrearProductoCommand command=new CrearProductoCommand("Lapicero",2.5);
        when(productoRepository.buscarPorNombre(command.getNombre())).thenReturn(Optional.empty());
        //When
        handler.execute(command);
        //Then
        verify(productoRepository).guardar(any());
    }

    //Test 2 - Debe lanzar un error si el producto ya existe (IMPLEMENTAR)
//    void debeLanzarErrorSiProductoYaExiste(){
//        //Given
//
//        //When
//
//        //Then
//    }
}
