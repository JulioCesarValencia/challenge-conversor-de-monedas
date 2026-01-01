package com.alurachallenger.conversordemonedas.consumoapi;
import java.util.Map;

public record ApiCambioResponse(String base, Map<String, Double> rates, String date) {

@Override
public String toString() {
    return "ApiCambioResponse{" +
            "base='" + base + '\'' +
            ", rates=" + rates +
            ", date='" + date + '\'' +
            '}';
}
}