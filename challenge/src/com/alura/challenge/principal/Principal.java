package com.alura.challenge.principal;

import com.alura.challenge.api.ConsultarExchange;
import com.alura.challenge.api.GeneradorDeArchivo;
import com.alura.challenge.model.Exchange;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        ConsultarExchange consulta = new ConsultarExchange();

        Scanner lectura = new Scanner(System.in);
        var opcion = lectura.nextLine();
        String baseCurrencyUSD = "USD";
        String baseCurrencyEUR = "EUR";
        String baseCurrencyCLP = "CLP";
        String baseCurrencyARS = "ARS";




        try{
            while(true) {

                System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
                System.out.println("1) Dolar ==> Peso Argentino");
                System.out.println("2) Peso Argentino ==> Dolar");
                System.out.println("3) Dolar ==> Peso Chileno");
                System.out.println("4) Peso Chileno ==> Dolar");
                System.out.println("5) Dolar ==> Euro");
                System.out.println("6) Euro ==> Dolar");
                System.out.println("7) Salir");
                System.out.println("Elige una opción valida:");
                System.out.println("*************************************************");

                switch (opcion) {
                    case "1":
                        System.out.println("Ingrese el valor que desea convertir:");
                        var valorConvertir = lectura.nextDouble();
                        Exchange exchange = consulta.buscaExchange(baseCurrencyUSD);
                        Map<String, Double> conversionRates = exchange.conversion_rates();
                        String monedaElegida = baseCurrencyARS;
                        double tasaDeCambio = conversionRates.getOrDefault(monedaElegida, 0.0);
                        double resultado = valorConvertir * tasaDeCambio;
                        System.out.println("el valor" + " " + valorConvertir + " " + baseCurrencyUSD + " corresponde al valor final de ==>" + " " + resultado + " " + baseCurrencyARS);
                        System.out.println();
                        System.out.println("*************************************************");
                        break;

                    case "7":
                        return;

                    case "8":
//                        GeneradorDeArchivo generadorDeArchivo = new GeneradorDeArchivo();
//                        generadorDeArchivo.guardarJson(exchange);

                    default:
                        System.out.println("Opción no válida.");
                }

            }

        } catch (NumberFormatException e){
            System.out.println("Número no encontrado "+e.getMessage());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}
