package com.example.gouveiarocha.appsaulas.Classes.Estudos;

public class Passaro extends Animal {

    //ATRIBUTOS
    public String tipo;

    //GETTERS E SETTERS
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //METODOS
    public void voar() {
        System.out.println("Voando...");
    }

    @Override
    public void correr() {
        super.correr();
        System.out.println("Passaro!");
    }
}
