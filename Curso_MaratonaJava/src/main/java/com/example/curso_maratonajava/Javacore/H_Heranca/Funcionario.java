package com.example.curso_maratonajava.Javacore.H_Heranca;

public class Funcionario extends Pessoa {
    
    private double salario;
    
    //BLOCOS DE INICIALIZAÇÃO
    static {
        System.out.println("Bloco de inicialização de funcionario estatico...");
    }
    
    {
        System.out.println("Bloco de inicialização de funcionario 1...");
    }
    
    {
        System.out.println("Bloco de inicialização de funcionario 2...");
    }
    
    //CONSTRUTORES
    public Funcionario(){
        super(); //Chama o construtor vazio da superclasse. //OBRIGATORIAMENTE SER NA PRIMEIRA LINHA
        System.out.println("Dentro do contrutor de funcionario[LIMPO]...");
    }
    
    public Funcionario(String nome, double salario){
        super(nome); //Chama o construtor com nome da superclasse. //OBRIGATORIAMENTE SER NA PRIMEIRA LINHA
        this.salario = salario;
        System.out.println("Dentro do contrutor de funcionario[COM NOME E SALARIO]...");
    }
    
    //Sobrecarga de metodo. O metodo imprimeDados abaixo substitui o metodo imprimeDados da superclasse Pessoa.
    public void imprimeDados() {
        System.out.println("Imprimindo metodo imprimeDados da subclasse Funcionário, com sobrecarga.");
        super.imprimeDados(); //Usamos o super para acessar/executar os metodos da SuperClasse.
        System.out.println("salario= " + this.salario);
    }
    
    public void imprimeReciboDePagamento(){
        
        //No método abaixo, imprimo o nome do funcionário, que é um atributo da superclasse, usando o super.
        //isso esta sendo possivel por que configuramos esse atributo como protected, onde a propria classe
        //e as suas sub classes conseguem ter acesso.
        System.out.println("Eu, " + super.nome + " recebi o pagamento de " + this.salario);
        
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
