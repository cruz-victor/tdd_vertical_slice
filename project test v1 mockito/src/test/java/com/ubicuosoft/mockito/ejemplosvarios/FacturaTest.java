package com.ubicuosoft.mockito.ejemplosvarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FacturaTest {
    @Mock
    private CalculadoraService calculadoraService;
    @InjectMocks
    private FacturaService facturaService;


    @Test
    void deberiaCalcularTotalConImpuesto() {
        //---Given
        int subtotal = 100;
        int impuesto = 15;

        when(calculadoraService.sumar(subtotal,impuesto)).thenReturn(115);

        //---When
        int total = facturaService.calcularTotalConImpuesto(subtotal, impuesto);

        //---Then
        assertThat(total).isEqualTo(115);

    }
}
