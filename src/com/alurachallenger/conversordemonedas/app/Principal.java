/*
 * Copyright (c) 2026 Julio Cesar Valencia
 * Licensed under the MIT License.
 */

package com.alurachallenger.conversordemonedas.app;

import com.alurachallenger.conversordemonedas.modelo.Conversion;
import com.alurachallenger.conversordemonedas.servicios.ConsultaCambioMoneda;
import com.alurachallenger.conversordemonedas.servicios.ConvertidorMoneda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int opcion = 0;
        System.out.println("\n*******************Bienvenido al Conversor de Monedas****************************************\n");

        String menu = """
                                
                * 1. Dólar (USD) =>> Peso Colombiano (COP)      *
                * 2. Peso Colombiano (COP) =>> Dólar (USD)      *
                * 3. Dólar (USD) =>> Real Brasileño (BRL)       *
                * 4. Real Brasileño (BRL) =>> Dólar (USD)       *
                * 5. Dólar (USD) =>> Peso Mexicano (MXN)        *
                * 6. Peso Mexicano (MXN) =>> Dólar (USD)        *
                * 7. Euro (EUR) =>> Yen Japonés (JPY)           *
                * 8. Libra Esterlina (GBP) =>> Yuan Chino (CNY) *
                * 9. Ver historial de conversiones              *
                * 10. Salir                                     *
                                      
                ****************************************
                Elija una opción válida:""";


        ConsultaCambioMoneda consulta = new ConsultaCambioMoneda();
        Scanner lectura = new Scanner(System.in);
        List<Conversion> historial = new ArrayList<>();


        while (opcion != 10) {
            System.out.println(menu);

            try {
                opcion = lectura.nextInt();

                if (opcion == 10) {
                    System.out.println("¡Gracias por elejirnos!");
                    break;
                }


                switch (opcion) {
                    case 1 -> convertirMoneda(consulta, lectura, "USD", "COP", historial);
                    case 2 -> convertirMoneda(consulta, lectura, "COP", "USD", historial);
                    case 3 -> convertirMoneda(consulta, lectura, "USD", "BRL", historial);
                    case 4 -> convertirMoneda(consulta, lectura, "BRL", "USD", historial);
                    case 5 -> convertirMoneda(consulta, lectura, "USD", "MXN", historial);
                    case 6 -> convertirMoneda(consulta, lectura, "MXN", "USD", historial);
                    case 7 -> convertirMoneda(consulta, lectura, "EUR", "JPY", historial);
                    case 8 -> convertirMoneda(consulta, lectura, "GBP", "CNY", historial);
                    case 9 -> mostrarHistorial(historial);
                    default -> System.out.println("Opción no válida");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número valido.");
                lectura.nextLine();
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado.");
            }
        }

    }

    private static void mostrarHistorial(List<Conversion> historial) {
        if (historial.isEmpty()) {
            System.out.println("No hay conversiones registradas aún.");
            return;
        }

        System.out.println("\n📜 Historial de conversiones:");
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
    }

    private static void convertirMoneda (ConsultaCambioMoneda consulta, Scanner lectura, String monedaBase, String monedaDestino, List<Conversion> historial) {
        try {
            System.out.print("Ingrese el valor que desea convertir: ");
            double cantidad = lectura.nextDouble();

            var respuesta = consulta.obtenerCambio(monedaBase);
            var convertidor = new ConvertidorMoneda(respuesta.rates());
            double resultado = convertidor.convertir(monedaDestino, cantidad);

            historial.add(new Conversion(
                    monedaBase,
                    monedaDestino,
                    cantidad,
                    resultado,
                    LocalDateTime.now()
            ));

            System.out.println(
                    "El valor " + cantidad + " " + monedaBase +
                            " corresponde al valor final =>>> " +
                            resultado + " " + monedaDestino
            );

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            lectura.nextLine();
        }
    }
}

