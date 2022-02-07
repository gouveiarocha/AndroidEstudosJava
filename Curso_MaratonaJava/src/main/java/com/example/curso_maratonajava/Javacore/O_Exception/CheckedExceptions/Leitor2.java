package com.example.curso_maratonajava.Javacore.O_Exception.CheckedExceptions;

public class Leitor2 implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("Fechando Leitor2");
    }

}
