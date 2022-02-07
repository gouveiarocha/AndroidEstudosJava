package com.example.curso_maratonajava.Javacore.A_IntroducaoClasses;

public class Professor {

    public String nome;
    public String RG;
    public String CPF;
    public double salario;

    public Professor() {
    }

    public Professor(String nome, String RG, String CPF, double salario) {
        this.nome = nome;
        this.RG = RG;
        this.CPF = CPF;
        this.salario = salario;
    }

    //Metodo com retorno String para imprimir os dados...
    public String imprimeDados() {
        return "Professor{" + "nome=" + nome + ", RG=" + RG + ", CPF=" + CPF + ", salario=" + salario + '}';
    }

    //Metodo tipo reference para imprimir os dados...
    public void imprimeDadosReference(Professor professor) {
        System.out.println("Professor{" + "nome=" + professor.nome + ", RG=" + professor.RG + ", CPF=" + professor.CPF + ", salario=" + professor.salario + '}');
    }

    //Metodo void utilizando o this para imprimir os dados, este é o metodo mais recomendavel
    public void imprimeDadosThis() {
        System.out.println("Professor{" + "nome=" + this.nome + ", RG=" + this.RG + ", CPF=" + this.CPF + ", salario=" + this.salario + '}');
    }

}
