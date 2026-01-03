package com.alurachallenger.conversordemonedas.app;


import com.alurachallenger.conversordemonedas.servicios.ConsultaCambioMoneda;
import com.alurachallenger.conversordemonedas.servicios.ConvertidorMoneda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int opcion = 0;
        System.out.println("\n*******************Bienvenido al Conversor de Monedas****************************************\n");

        String menu = """
                                
                * 1. Dólar (USD) =>> Peso Colombiano (COP)   *
                * 2. Peso Colombiano (COP) =>> Dólar (USD)   *
                * 3. Dólar (USD) =>> Real Brasileño (BRL)    *
                * 4. Real Brasileño (BRL) =>> Dólar (USD)    *
                * 5. Dólar (USD) =>> Peso Mexicano (MXN)     *
                * 6. Peso Mexicano (MXN) =>> Dólar (USD)     *
                * 7. Euro (EUR) =>> Yen Japonés (JPY)        *
                * 8. Libra Esterlina (GBP) =>> Yuan Chino (CNY) *
                * 9. Salir                             *
                ****************************************
                Elija una opción válida:""";


        ConsultaCambioMoneda consulta = new ConsultaCambioMoneda();
        Scanner lectura = new Scanner(System.in);

        while (opcion != 9) {
            System.out.println(menu);

            try {
                opcion = lectura.nextInt();

                if (opcion == 9) {
                    System.out.println("¡Gracias por elejirnos!");
                    break;
                }


                switch (opcion) {
                    case 1 -> convertirMoneda(consulta, lectura, "USD", "COP");
                    case 2 -> convertirMoneda(consulta, lectura, "COP", "USD");
                    case 3 -> convertirMoneda(consulta, lectura, "USD", "BRL");
                    case 4 -> convertirMoneda(consulta, lectura, "BRL", "USD");
                    case 5 -> convertirMoneda(consulta, lectura, "USD", "MXN");
                    case 6 -> convertirMoneda(consulta, lectura, "MXN", "USD");
                    case 7 -> convertirMoneda(consulta, lectura, "EUR", "JPY");
                    case 8 -> convertirMoneda(consulta, lectura, "GBP", "CNY");
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

    private static void convertirMoneda (ConsultaCambioMoneda consulta, Scanner lectura, String monedaBase, String monedaDestino) {
        try {
            System.out.print("Ingrese el valor que desea convertir: ");
            double cantidad = lectura.nextDouble();

            var respuesta = consulta.obtenerCambio(monedaBase);
            var convertidor = new ConvertidorMoneda(respuesta.rates());
            double resultado = convertidor.convertir(monedaDestino, cantidad);

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

