package com.example.curso_maratonajava.Javacore.B_IntroducaoMetodos;

public class Calculadora {

    /**
     * Na aula de modificadores estaticos, alteramos essa classe, transformando
     * todos os metodos estaticos, pois não acessam atributos da classe,
     * possibilitando acessa-los diretamente, sem a ref de um objeto.
     */
    
    //Métodos sem parametros:
    public static void somaDoisNumeros() {
        System.out.println(5 + 5);
    }

    public static void subtrairDoisNumeros() {
        System.out.println(5 - 5);
    }

    //Metodos com parametros:
    public static void multiplicaDoisNumeros(int num1, int num2) {
        int res = num1 * num2;
        System.out.println("Resultado da multiplicação: " + res);
    }

    //Metodo sem retorno
    public static void imprimeDoisNumerosDividos(double num1, double num2) {
        if (num2 != 0) {
            System.out.println(num1 / num2);
        } else {
            System.out.println("Não é possivel dividir por 0...");
        }
    }

    //Metodos com retorno:
    //Neste caso, declaramos o tipo primitivo na criação do método e retornamos um valor desse mesmo tipo.
    public static int divideDoisNumeros(int num1, int num2) {
        if (num2 != 0) {
            return num1 / num2;
        }
        return 0;
    }

    //Método para somar um array.
    public static void somaArray(int[] numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        System.out.println(soma);
    }

    //Método para somar um array, utilizando varargs.  (Neste casp, o VarArgs transforma o resultado em um array)
    public static void somaVarArgs(int... numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        System.out.println(soma);
    }

}
