package com.alurachallenger.conversordemonedas.excepciones;

public class ConversorExcepcion extends RuntimeException {
    public ConversorExcepcion(String mensaje) {
        super(mensaje);
    }

    //error original que provoco el error(causa)
    public ConversorExcepcion(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}
