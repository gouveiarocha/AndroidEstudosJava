package com.example.curso_maratonajava.Javacore.O_Exception.CheckedExceptions.Teste;

import com.example.curso_maratonajava.Javacore.O_Exception.CheckedExceptions.Leitor1;
import com.example.curso_maratonajava.Javacore.O_Exception.CheckedExceptions.Leitor2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TesteTryWithResources {

    public static void main(String[] args) {
        lerArquivoNovoExemplo();
    }

    //Como era trabalho no java6
    public static void lerArquivo() {
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Como é possivel trabalhar no java7 - o proprio java se encarrega de fechar o arquivo
    //Regra: A classe declarada dentro no try tem que implementar, obrigatoriamente, a classe 'Closeable' e/ou 'AutoCloseable'.
    public static void lerArquivoNovo() throws IOException {
        try (Reader reader = new BufferedReader(new FileReader("text.txt"))) {
        } //catch (IOException e) {
        //e.printStackTrace();
        //}
    }

    //Exemplo prático
    public static void lerArquivoNovoExemplo() {
        try (Leitor1 leitor1 = new Leitor1();
             Leitor2 leitor2 = new Leitor2()) {
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
