package com.example.curso_maratonajava.Javacore.L_ClassesAbstratas;

public class Gerente extends Funcionario{

    public Gerente() {
    }

    public Gerente(String nome, String ctps, double salario) {
        super(nome, ctps, salario);
    }
    
    @Override
    public void imprime() { //Classe implementada(obrigatoriamente) da classe Pessoa.
        System.out.println("Imprimindo Gerente...");
    }
    
    @Override
    public void calcularSalario() { //Classe implementada(obrigatoriamente) da classe Funcionario.
        //Acrescenta mais 20%.
        this.salario = salario + (salario * 0.2);
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", ctps=" + ctps + ", salario=" + salario + '}';
    }
    
}
