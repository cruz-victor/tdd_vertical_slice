package com.ubicuosoft.project_test_v0.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public CalculadoraService(){

    }

    public int sumar(int numero1, int numero2) {
        //throw new UnsupportedOperationException("Vic not yet implemented");
        return numero1+numero2;
    }
}
