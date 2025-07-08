package com.ubicuosoft.project_test_v0.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FacturaServiceTest {
    @Mock
    private CalculadoraService calculadorService;
    @InjectMocks
    private FacturaService facturaService;

    @Test
    void deberiaCalcularTotalConImpuesto() {
        //GIVEN
        int subtotal = 100;
        int impuesto = 15;
        when(calculadorService.sumar(subtotal, impuesto))
                .thenReturn(115);
        //WHEN
        int total = facturaService.calcularTotalConImpuesto(subtotal, impuesto);
        //THEN
        assertThat(total).isEqualTo(115);
    }
}
