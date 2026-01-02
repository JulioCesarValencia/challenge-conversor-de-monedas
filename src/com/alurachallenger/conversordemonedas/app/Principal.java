package com.alurachallenger.conversordemonedas.app;


import com.alurachallenger.conversordemonedas.servicios.ConsultaCambioMoneda;
import com.alurachallenger.conversordemonedas.servicios.ConvertidorMoneda;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int opcion = 0;
        System.out.println("\n*******************Bienvenido al Conversor de Monedas****************************************\n");

        ConsultaCambioMoneda consulta = new ConsultaCambioMoneda();

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
                    case 1 -> {
                        try {
                            System.out.print("Ingrese el valor que desea convertir: ");
                            double cantidad = lectura.nextDouble();

                            var respuesta = consulta.obtenerCambio("USD");
                            var convertidor = new ConvertidorMoneda(respuesta.rates());
                            double resultado = convertidor.convertir("COP", cantidad);

                            System.out.println("El valor " + cantidad + " USD corresponde al valor final =>>> " + resultado + " COP");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            lectura.nextLine(); // limpiar buffer
                        }
                    }
                    case 2-> {
                        try {
                            System.out.print("Ingrese el valor que desea convertir: ");
                            double cantidad = lectura.nextDouble();

                            var respuesta = consulta.obtenerCambio("COP");
                            var convertidor = new ConvertidorMoneda(respuesta.rates());
                            double resultado = convertidor.convertir("USD", cantidad);

                            System.out.println(cantidad + " COP = " + resultado + " USD");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            lectura.nextLine(); // limpiar buffer
                        }
                    }
                    case 3-> {
                        try {
                            System.out.print("Ingrese el valor que desea convertir: ");
                            double cantidad = lectura.nextDouble();

                            var respuesta = consulta.obtenerCambio("USD");
                            var convertidor = new ConvertidorMoneda(respuesta.rates());
                            double resultado = convertidor.convertir("BRL", cantidad);

                            System.out.println(cantidad + " USD = " + resultado + " BRL");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            lectura.nextLine(); // limpiar buffer
                        }
                    }
                    case 4-> {
                        try {
                            System.out.print("Ingrese el valor que desea convertir: ");
                            double cantidad = lectura.nextDouble();

                            var respuesta = consulta.obtenerCambio("BRL");
                            var convertidor = new ConvertidorMoneda(respuesta.rates());
                            double resultado = convertidor.convertir("USD", cantidad);

                            System.out.println(cantidad + " BRL = " + resultado + " USD");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            lectura.nextLine(); // limpiar buffer
                        }
                    }
                    case 5-> {
                        try {
                            System.out.print("Ingrese el valor que desea convertir: ");
                            double cantidad = lectura.nextDouble();

                            var respuesta = consulta.obtenerCambio("USD");
                            var convertidor = new ConvertidorMoneda(respuesta.rates());
                            double resultado = convertidor.convertir("MXN", cantidad);

                            System.out.println(cantidad + " USD = " + resultado + " MXN");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            lectura.nextLine(); // limpiar buffer
                        }
                    }
                    case 6-> {
                        try {
                            System.out.print("Ingrese el valor que desea convertir: ");
                            double cantidad = lectura.nextDouble();

                            var respuesta = consulta.obtenerCambio("MXN");
                            var convertidor = new ConvertidorMoneda(respuesta.rates());
                            double resultado = convertidor.convertir("USD", cantidad);

                            System.out.println(cantidad + " MXN = " + resultado + " USD");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            lectura.nextLine(); // limpiar buffer
                        }
                    }
                    case 7-> {
                        try {
                            System.out.print("Ingrese el valor que desea convertir: ");
                            double cantidad = lectura.nextDouble();

                            var respuesta = consulta.obtenerCambio("EUR");
                            var convertidor = new ConvertidorMoneda(respuesta.rates());
                            double resultado = convertidor.convertir("JPY", cantidad);

                            System.out.println(cantidad + " EUR = " + resultado + " JPY");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            lectura.nextLine(); // limpiar buffer
                        }
                    }
                        case 8-> {
                            try {
                                System.out.print("Ingrese el valor que desea convertir: ");
                                double cantidad = lectura.nextDouble();

                                var respuesta = consulta.obtenerCambio("GBP");
                                var convertidor = new ConvertidorMoneda(respuesta.rates());
                                double resultado = convertidor.convertir("CNY", cantidad);

                                System.out.println(cantidad + " GBP = " + resultado + " CNY");
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage());
                                lectura.nextLine(); // limpiar buffer
                            }
                        }

                }

            } catch (Exception e) {
                // Capturo cualquier error de lectura o convercion
                System.out.println("Error: " + e.getMessage());
                lectura.nextLine(); // Limpio buffer en caso de error de entrada
            }
        }
    }



}