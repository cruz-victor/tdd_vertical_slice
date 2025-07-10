package com.ubicuosoft.mockito.ejemplosvarios;

//@Service
public class FacturaService {
    private final CalculadoraService calculadoraService;

    public FacturaService(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    public int calcularTotalConImpuesto(int subtotal, int impuesto) {
        //throw new UnsupportedOperationException("Not yet implemented");
        return calculadoraService.sumar(subtotal, impuesto);
    }
}
