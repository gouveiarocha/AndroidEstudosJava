package com.example.curso_maratonajava.Javacore.Z_B_ClassesInternas.Teste;

public class TesteClassesLocais {

    private String nome = "Douglas";

    public void fazAlgo() {
        class Interna {
            public void imprimeNomeExterno(){
                System.out.println(nome);
            }
        }
        Interna in = new Interna(); //-> Fora desse bloco não é possivel acessar os atributos e metodos da classe local interna
        in.imprimeNomeExterno();    //->
    }

    public static void main(String[] args) {
        TesteClassesLocais externa = new TesteClassesLocais();
        externa.fazAlgo();
    }
}
