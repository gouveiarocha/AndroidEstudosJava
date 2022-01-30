package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Java;

import java.io.Serializable;

public class Cao extends Animal implements Serializable {

    //ATRIBUTOS
    public String raça;

    //CONSTRUTORES
    public Cao() {
    }

    public Cao(String raça) {
        this.raça = raça;
    }

    //GETTER E SETTERS
    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    //METODOS
    public void latir() {
        System.out.println("Latindo...");
    }

    public void correr() {
        super.correr();
        System.out.println("Cão!");
    }
}
