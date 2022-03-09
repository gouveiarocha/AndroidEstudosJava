package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.Tarefas.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "tarefas";


    public DatabaseHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL) ";

        try {
            db.execSQL(sql);
            Log.i("INFO DB", "Tabela ->" + TABELA_TAREFAS + "<- criada com sucesso");
        } catch (Exception e) {
            Log.i("INFO DB", "Erro ao criar tabela ->" + TABELA_TAREFAS + "<- " + e.getMessage());
        }

    }

    //vai executar caso a versão mude...
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS " + TABELA_TAREFAS;

        try {
            db.execSQL(sql);
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar o APP...");
        } catch (Exception e) {
            Log.i("INFO DB", "Erro ao deletar atualizar o APP..." + e.getMessage());
        }
    }
}
