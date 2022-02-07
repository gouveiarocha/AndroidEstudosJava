package com.example.curso_maratonajava.Javacore.Z_B_ClassesInternas.Teste;

class Externa2 {

    private String nome = "DouglasNãoEstatico";
    private static String nome2 = "DouglasEstatico";

    static class Interna {

        public void imprimir() {
            System.out.println("Imprimindo algo...");
            //System.out.println(nome);     //Não vai funcionar pois a classe Interna é estatica.
            //System.out.println(nome2);    //OK - Pois a variavel tbm é estatica.
        }

    }
}

public class TesteClassesInternasEstaticas {

    public static void main(String[] args) {
        //Com a classe interna extatica, criar um objeto fica muito mais facil, observar abaixo:
        Externa2.Interna in = new Externa2.Interna();
        in.imprimir();
        
        //Quando a classe esta dentro do metodo main
        Interna2 in2 = new Interna2();
        in2.imprimir();
        System.out.println(in2.nome);
        
    }

    static class Interna2 {
        
        String nome = "Douglas";

        public void imprimir() {
            System.out.println("Imprimindo algo no interna 2...");
        }

    }
}
