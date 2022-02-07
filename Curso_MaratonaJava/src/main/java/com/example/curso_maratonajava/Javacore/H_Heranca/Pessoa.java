package com.example.curso_maratonajava.Javacore.H_Heranca;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected Endereco endereco;
    
    //BLOCOS DE INICIALIZAÇÃO...
    static {
        System.out.println("Bloco de inicialização de pessoa estatico...");
    }
    
    {
        System.out.println("Bloco de inicialização de pessoa 1...");
    }
    
    {
        System.out.println("Bloco de inicialização de pessoa 2...");
    }
    
    //CONSTRUTORES...
    public Pessoa(){
        System.out.println("Dentro do construtor de pessoas[LIMPO]...");
    }
    
    public Pessoa(String nome){
        System.out.println("Dentro do construtor de pessoas[COM NOME]...");
        this.nome = nome;
    }
    
    //METODOS...
    public void imprimeDados() {
        System.out.println("Pessoa{" + 
                            "nome=" + this.nome + 
                            ", cpf=" + this.cpf + 
                            ", rua=" + this.endereco.getLogradouro() + 
                            ", bairro=" + this.endereco.getBairro() + '}');
    }
    
    //GET AND SETS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
}
