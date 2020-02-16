package com.example.gouveiarocha.appsaulas.Classes.Estudos;

public class Animal {

    //ATRIBUTOS
    public String nome;
    public String cor;
    public double peso;

    //GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    //METODOS
    public void dormir() {
        System.out.println("Dormindo...");
    }

    public void correr() {
        System.out.println("Correr como um ");
    }

}
