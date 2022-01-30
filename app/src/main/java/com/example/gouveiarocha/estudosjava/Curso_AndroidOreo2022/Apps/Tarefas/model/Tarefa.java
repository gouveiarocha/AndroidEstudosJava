package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.Tarefas.model;

import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Views.RecyclerView.model.Item;

import java.io.Serializable;

public class Tarefa extends Item implements Serializable {

    private int id;

    public Tarefa() {
    }

    public Tarefa(String titulo) {
        super(titulo);
    }

    public Tarefa(int id) {
        this.id = id;
    }

    public Tarefa(int id, String titulo) {
        super(titulo);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
