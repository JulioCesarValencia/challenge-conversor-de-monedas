package com.alurachallenger.conversordemonedas.modelo;

import java.time.LocalDateTime;

public record Conversion(String monedaBase, String monedaDestino,
                         double cantidad, double resultado, LocalDateTime fecha) {
    @Override
    public String toString() {
        return  "[" + fecha + "]" + cantidad + " " + monedaBase + " => " + resultado + " " + monedaDestino;
    }
}
