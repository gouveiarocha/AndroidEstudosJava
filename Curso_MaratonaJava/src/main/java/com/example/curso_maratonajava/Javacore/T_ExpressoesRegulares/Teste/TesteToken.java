package com.example.curso_maratonajava.Javacore.T_ExpressoesRegulares.Teste;

public class TesteToken {

    public static void main(String[] args) {

        //Como separar os nomes abaixo em um array de strings - usando o método split da classe String.
        String str = "Sansa, Daenarys, Tyrion, Cersei, Aya, Ned";
        String[] tokens = str.split(","); //o método split ret. um array de Strings - no construtor, colocamos o limitador, que, nesse caso, pode ser a virgula ou o espaço.
        for (String arr : tokens) { //Percorrer e imprimir o array
            System.out.println(arr.trim());
        }

    }

}
