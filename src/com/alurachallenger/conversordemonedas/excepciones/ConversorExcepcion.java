package com.alurachallenger.conversordemonedas.excepciones;

public class ConversorExcepcion extends RuntimeException {
    public ConversorExcepcion(String mensaje) {
        super(mensaje);
    }

    //error original qu provoco un error
    public ConversorExcepcion(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}
