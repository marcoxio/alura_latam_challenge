package com.alura.challenge.api;

import com.alura.challenge.model.Exchange;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarExchange {
    public Exchange buscaExchange(String currencyCode){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/YOUR_API_KEY/latest/"+currencyCode);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();



        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Exchange.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré ese Currency Code");
        }
    }
}
