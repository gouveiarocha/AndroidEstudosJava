package com.example.curso_maratonajava.Javacore.P_Assertions.Teste;

public class TesteAssert {

    /**
     * Ná prática, as Assertivas servem para certificarmos de que determinado
     * valor não irá alcançar um número que, de fato não deve nunca alcançar -
     * por exemplo abaixo, o salario nunca deve ser um valor negativo.
     * Convencionalmente, usamos o if else para garantir que o número nunca será
     * negativo. Mas, quando usamos o if, automaticamente o compilador ocupa
     * recurso para o else, desnecessáriamente - aí importancia das assertivas.
     * As assertivas devem ser ativadas na IDE e servem apenas para a fase de
     * testes do programa, em produção elas seram ignoradas.
     * Recomendação1: Usar somente em métodos privados.
     */
    
    public static void main(String[] args) {
        calculaSalario2(-1000);
    }

    //Convencionalmente...
    private static void calculaSalario1(double salario) {
        if (salario > 0) {
            System.out.println("Calculando o salário...");
        } else {
            System.out.println("Nunca deveria acontecer...");
        }
    }

    //Usando o assert
    private static void calculaSalario2(double salario) {
        //Com o assert, você esta garantindo para a jvm que o valor nunca sera diferente do declarado, 
        //nesse caso menor ou igual a 0. Aqui, dispensa-se o uso do if else.
        assert (salario > 0): "O Salário não deve ser menor que 0...";
    }

}
