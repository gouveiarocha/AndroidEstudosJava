package com.example.curso_maratonajava.Javacore.Z_A_Generics;

public class Carro {
    
    private String nome;

    public Carro(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Carro{" + "nome=" + nome + '}';
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
