package com.alura.challenge.api;

import com.alura.challenge.model.Exchange;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public void guardarJson(Exchange exchange) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(exchange.base_code()+".json");
        escritura.write(gson.toJson(exchange));
        escritura.close();
    }
}
