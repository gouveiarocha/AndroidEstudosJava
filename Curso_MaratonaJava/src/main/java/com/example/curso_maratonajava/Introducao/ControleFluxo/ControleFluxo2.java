package com.example.curso_maratonajava.Introducao.ControleFluxo;

public class ControleFluxo2 {

    public static void main(String[] args) {
        int idade = 15;
        String status;
        status = idade < 18 ? "Nao adulto" : "adulto"; //Operador ternario.
        System.out.println(status);
    }
}
