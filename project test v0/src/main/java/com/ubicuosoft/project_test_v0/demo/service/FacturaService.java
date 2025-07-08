package com.ubicuosoft.project_test_v0.demo.service;

public class FacturaService {

    private CalculadoraService calculadoraService;

    public FacturaService(CalculadoraService calculadoraService){
        this.calculadoraService=calculadoraService;
    }

    public int calcularTotalConImpuesto(int subtotal, int impuesto) {
        //throw new UnsupportedOperationException("Not yet implemented");
        return calculadoraService.sumar(subtotal, impuesto);
    }
}
