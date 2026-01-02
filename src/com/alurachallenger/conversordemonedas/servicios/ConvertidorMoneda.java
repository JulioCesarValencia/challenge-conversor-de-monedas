package com.alurachallenger.conversordemonedas.servicios;

import com.alurachallenger.conversordemonedas.excepciones.ConversorExcepcion;

import java.util.Map;


public class ConvertidorMoneda {
   private Map<String, Double> tasas;

   public ConvertidorMoneda(Map<String, Double> tasas) {
      this.tasas = tasas;
   }

   public double convertir(String monedaDestino, double cantidad) {
   //verificacion
      if (cantidad <= 0) {
         throw new ConversorExcepcion("La cantidad debe ser mayor a cero");
      }

      Double tasa = tasas.get(monedaDestino);
      if (tasa == null) {
         throw new ConversorExcepcion("Moneda a cambiar no soportada");
      }
      return cantidad * tasa;
   }

}