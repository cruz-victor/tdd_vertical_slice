package com.ubicuosoft.project_test_v0.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class CalculadoraServiceTest {
    //AUDITORIA DE TEST
    //Test 1 - Deberia sumar dos numeros
    //Test 2 - Deberia restar dos numeros
    //Test 3 - Deberia multiplicar dos numeros
    //Test 4 - Deberia dividir dos numeros

    @InjectMocks
    private CalculadoraService calculadoraService;

    @Test
    void deberiaSumarDosNumeros(){
        //GIVEN (Conexto inicial)
        int numero1=5;
        int numero2=7;
        //WHEN (Accion del usuario)
        int resultado=calculadoraService.sumar(numero1, numero2);
        //THEN (Resultado esperado)
        assertThat(resultado).isEqualTo(12);
    }
}
