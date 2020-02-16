package com.example.gouveiarocha.appsaulas.Classes.DAO;

import com.example.gouveiarocha.appsaulas.Classes.Modelos.Tarefa;

import java.util.List;

public interface ITarefasDAO {

    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();

}
