package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class CalculadoraTest {

    @InjectMocks
    private CalculadoraService calculadoraService;

    @Test
    void deberiaSumarDosNumeros(){
        //---Given
        int numero1=10;
        int numero2=5;
        //---When
        int resultado=calculadoraService.sumar(numero1,numero2);
        //---Then
        assertThat(resultado).isEqualTo(15);
    }
}
