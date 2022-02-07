package com.example.curso_maratonajava.Javacore.C_SobrecargaMetodos;

public class Funcionario {

    private String nome, CPF, RG;
    private double salario;
    
    //Método de inicialização...
    public void init(String nome, String CPF, String RG){
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
    }
    
    //Sobrecarga do método de inicialização...
    public void init(String nome, String CPF, String RG, double salario){
        this.init(nome, CPF, RG);
        this.salario = salario;
    }

    public void imprimeDados() {
        System.out.println("Funcionario{" + "nome=" + this.nome + ", CPF=" + this.CPF + ", salario=" + this.salario + '}');
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
