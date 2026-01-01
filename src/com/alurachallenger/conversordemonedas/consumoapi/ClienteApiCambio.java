package com.alurachallenger.conversordemonedas.consumoapi;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteApiCambio {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";


    public ApiCambioResponse obtenerCambios(String base) {


        try {
            URI direccion = URI.create(API_URL + base);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            // Enviar la solicitud y obtener la respuesta como String
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), ApiCambioResponse.class);

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener datos de la API");

        }


    }


}