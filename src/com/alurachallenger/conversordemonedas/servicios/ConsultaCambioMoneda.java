package com.alurachallenger.conversordemonedas.servicios;

import com.alurachallenger.conversordemonedas.consumoapi.ApiCambioResponse;
import com.alurachallenger.conversordemonedas.consumoapi.ClienteApiCambio;

public class ConsultaCambioMoneda {
    private final ClienteApiCambio cliente = new ClienteApiCambio();

    public ApiCambioResponse obtenerCambio(String monedaBase) {
        return cliente.obtenerCambios(monedaBase);
    }
}
