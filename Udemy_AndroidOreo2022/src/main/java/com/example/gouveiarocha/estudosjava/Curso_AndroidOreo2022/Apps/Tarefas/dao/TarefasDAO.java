package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.Tarefas.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.Tarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefasDAO implements ITarefasDAO {

    private SQLiteDatabase write, read;

    public TarefasDAO(Context context) {
        DatabaseHelper database = new DatabaseHelper(context);
        write = database.getWritableDatabase();
        read = database.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", tarefa.getTitulo());

        try {
            write.insert(DatabaseHelper.TABELA_TAREFAS, null, contentValues);
            Log.i("TarefasDAO INFO", "Tarefa salva com sucesso... ");
        } catch (Exception e) {
            Log.i("TarefasDAO INFO", "Erro ao salvar tarefa... " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", tarefa.getTitulo());

        try {
            String[] args = {String.valueOf(tarefa.getId())};

            //Atenção para os parametros do método update. Aula 155, Aprox. Minuto 19.
            write.update(
                    DatabaseHelper.TABELA_TAREFAS,  //nome da tabela
                    contentValues,                  //valores
                    "id=?",             //clausula where...
                    args);                          //...e args para ref. a clausula where

            Log.i("TarefasDAO INFO", "Tarefa atualizada com sucesso... ");
        } catch (Exception e) {
            Log.i("TarefasDAO INFO", "Erro ao atualizar tarefa... " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {

        try{
            String[] args = {String.valueOf(tarefa.getId())};
            write.delete(DatabaseHelper.TABELA_TAREFAS, "id=?", args);
            Log.i("TarefasDAO INFO", "Tarefa deletada com sucesso... ");
        }catch (Exception e){
            Log.i("TarefasDAO INFO", "Erro ao deletar tarefa... " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DatabaseHelper.TABELA_TAREFAS + " ;";

        Cursor cursor = read.rawQuery(sql, null);

        while (cursor.moveToNext()) {

            Integer id = cursor.getInt(cursor.getColumnIndex("id"));
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));

            Tarefa tarefa = new Tarefa();
            tarefa.setId(id);
            tarefa.setTitulo(titulo);

            tarefas.add(tarefa);

        }

        return tarefas;

    }

}
