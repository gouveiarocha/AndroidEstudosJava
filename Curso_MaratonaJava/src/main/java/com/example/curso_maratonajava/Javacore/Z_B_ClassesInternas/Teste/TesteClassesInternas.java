package com.example.curso_maratonajava.Javacore.Z_B_ClassesInternas.Teste;

public class TesteClassesInternas {

    private String nome = "Douglas";

    //Classe interna antes do metodo estatico
    class Interna {

        public void verClasseExterna() {
            System.out.println(nome);
            System.out.println(this); //this da classe que esta sendo chamado em questão
            System.out.println(TesteClassesInternas.this); //this da classe externa.
        }
    }

    public static void main(String[] args) {
        //Acessando a classe interna atraves da externa e depois acessando o método da classe interna.
        TesteClassesInternas externa = new TesteClassesInternas();
        Interna in = externa.new Interna();
        Interna in2 = new TesteClassesInternas().new Interna(); //Outra forma...
        in.verClasseExterna();
        in2.verClasseExterna();
    }
}

//Classe interna depois do metodo estatico.
class Externa {

    private String nome = "Douglas";

    class Interna {

        public void verClasseExterna() {
            System.out.println(nome); //A classe interna tem acesso a todos os atributos da classe externa, mesmo privados.
        }
    }

}
