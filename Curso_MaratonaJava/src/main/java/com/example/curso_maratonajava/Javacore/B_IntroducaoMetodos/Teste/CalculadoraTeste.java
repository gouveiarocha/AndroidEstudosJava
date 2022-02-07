package com.example.curso_maratonajava.Javacore.B_IntroducaoMetodos.Teste;

import com.example.curso_maratonajava.Javacore.B_IntroducaoMetodos.Calculadora;

public class CalculadoraTeste {

    public static void main(String[] args) {

        //Calculadora calculadora = new Calculadora(); //Cria um objeto. //Desnecessário apos mudar os metodos para estaticos.

        Calculadora.somaDoisNumeros();  //Executa o metodo.
        Calculadora.subtrairDoisNumeros(); //Executa o metodo.
        Calculadora.multiplicaDoisNumeros(2, 5); //Executa o metodo com dois argumentos.

        //O metodo abaixo executa o calculo e imprie-o diretamente, sem retorno.
        Calculadora.imprimeDoisNumerosDividos(50, 0);

        //O metodo abaixo retorna um valor, portanto podemos, por exemplo, imprim-lo direto, como abaixo:
        Calculadora.divideDoisNumeros(50, 5);
        System.out.println(Calculadora.divideDoisNumeros(50, 5));; //Imprimindo direto...

        //Ou podemos criar um variavel e atribuir o retorno do metodo:
        int res = Calculadora.divideDoisNumeros(50, 2);
        System.out.println(res);

        //REF METODOS COM VARARGS
        int[] numeros = {1, 2, 3, 4, 5};
        //Primeiro o metodo passando um array:
        Calculadora.somaArray(numeros);
        //Usando o VarArgs podemos passar um array, ou os numeros diretamente:
        Calculadora.somaVarArgs(numeros);
        Calculadora.somaVarArgs(1, 2, 3, 4, 5);

    }

}
