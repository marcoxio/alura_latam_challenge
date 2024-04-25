package com.alura.challenge.principal;

import com.alura.challenge.api.ConsultarExchange;
import com.alura.challenge.exception.CurrencyNotFoundException;
import com.alura.challenge.model.Exchange;

import java.util.Map;
import java.util.Scanner;

public class Principal {
    private static final Scanner lectura = new Scanner(System.in);
    private static final Scanner convertirValor = new Scanner(System.in);
    private static final ConsultarExchange consulta = new ConsultarExchange();

    private static final String baseCurrencyUSD = "USD";
    private static final String baseCurrencyEUR = "EUR";
    private static final String baseCurrencyCLP = "CLP";
    private static final String baseCurrencyARS = "ARS";

    public static void main(String[] args) {
        String opcion = "";
        while (!opcion.equals("7")) {
            displayMenu();
            opcion = lectura.nextLine();
            handleOption(opcion);
        }
    }

    private static void displayMenu() {
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        System.out.println("1. Dolar ==> Peso Argentino");
        System.out.println("2. Peso Argentino ==> Dolar");
        System.out.println("3. Dolar ==> Peso Chileno");
        System.out.println("4. Peso Chileno ==> Dolar");
        System.out.println("5. Dolar ==> Euro");
        System.out.println("6. Euro ==> Dolar");
        System.out.println("7. Salir");
        System.out.println("Elige una opción valida:");
        System.out.println("*************************************************");
        System.out.println();

    }

    private static void handleOption(String opcion) {
        switch (opcion) {
            case "1":
                handleConversion(baseCurrencyUSD, baseCurrencyARS);
                break;
            case "2":
                handleConversion(baseCurrencyARS, baseCurrencyUSD);
                break;
            case "3":
                handleConversion(baseCurrencyUSD, baseCurrencyCLP);
                break;
            case "4":
                handleConversion(baseCurrencyCLP, baseCurrencyUSD);
                break;
            case "5":
                handleConversion(baseCurrencyUSD, baseCurrencyEUR);
                break;
            case "6":
                handleConversion(baseCurrencyEUR, baseCurrencyUSD);
                break;
            case "7":
                System.exit(0);
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void handleConversion(String baseCurrency, String targetCurrency) {
        System.out.println("Ingrese el valor que desea convertir:");
        var valorConvertir = convertirValor.nextDouble();
        Exchange exchange = consulta.buscaExchange(baseCurrency);
        Map<String, Double> conversionRates = exchange.conversion_rates();
        if (!conversionRates.containsKey(targetCurrency)) {
            throw new CurrencyNotFoundException("La moneda " + targetCurrency + "no existe.");
        }
        double tasaDeCambio = conversionRates.getOrDefault(targetCurrency, 0.0);
        double resultado = valorConvertir * tasaDeCambio;
        System.out.println("el valor" + " " + valorConvertir + " " + baseCurrency + " corresponde al valor final de ==>" + " " + resultado + " " + targetCurrency);
        System.out.println();
        System.out.println("*************************************************");
    }
}
