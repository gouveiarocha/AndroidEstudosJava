package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.Tarefas.dao;

import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.Tarefas.model.Tarefa;

import java.util.List;

public interface ITarefasDAO {

    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();

}
