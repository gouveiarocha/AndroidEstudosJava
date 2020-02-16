package com.example.gouveiarocha.appsaulas.Classes.Modelos;

import java.io.Serializable;

public class Item implements Serializable {

    private String titulo;
    private String subTitulo;

    public Item() {
    }

    public Item(String titulo) {
        this.titulo = titulo;
    }

    public Item(String titulo, String subTitulo) {
        this.titulo = titulo;
        this.subTitulo = subTitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }
}
