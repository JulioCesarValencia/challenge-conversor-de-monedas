package com.alurachallenger.conversordemonedas.app;

import com.alurachallenger.conversordemonedas.consumoapi.ClienteApiCambio;
import com.alurachallenger.conversordemonedas.consumoapi.ApiCambioResponse;

public class Principal {

    public static void main(String[] args) {

        System.out.println("\n*******************Bienvenido al Conversor de Monedas\n");

        // Prueba de consumo de API
        ClienteApiCambio cliente = new ClienteApiCambio();
        ApiCambioResponse response = cliente.obtenerCambios("USD");

        System.out.println(response);
    }
}