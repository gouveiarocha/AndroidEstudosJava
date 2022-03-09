package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.ManipulacaoDados;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.example.gouveiarocha.estudosjava.R;

public class BancoSQLite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco_sqlite);

        getSupportActionBar().setTitle("Banco de Dados SQLITE");
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#262020")));

        try {

            //Criar (ou Abrir) um banco de dados.
            SQLiteDatabase database = openOrCreateDatabase(
                    "Estudos SQLite",     //nome
                    MODE_PRIVATE,               //modo
                    null);

            //Criar tabelas
            database.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");

            //Excluir totalmente tabela
            //database.execSQL("DROP TABLE pessoas");

            //Inserir registros
            //database.execSQL("INSERT INTO pessoas(nome, idade)VALUES('Adriano', 50)");
            //database.execSQL("INSERT INTO pessoas(nome, idade)VALUES('Douglas', 30)");

            //Atualizar registros
            //database.execSQL("UPDATE pessoas SET nome = 'Ageu', idade = 85 WHERE id = 2 ");

            //Excluir registros
            //database.execSQL("DELETE FROM pessoas WHERE id=3");


            //Codigos de consultas
            String consulta = "SELECT * FROM pessoas";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome = 'Douglas' AND idade = 30 ";   //e...
            //String consulta = "SELECT nome, idade FROM pessoas WHERE idade = 30 OR idade = 50 ";          //ou...
            //String consulta = "SELECT nome, idade FROM pessoas WHERE idade BETWEEN 30 and 35 ";
            //String consulta = "SELECT nome, idade FROM pessoas WHERE nome LIKE 'Dou%' ";                    //como...
            //String consulta = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY nome ASC";                //organiza nome
            //String consulta = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY idade DESC";              //organiza numero
            //String consulta = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY idade LIMIT 3";           //organiza com limite

            //Recuperar registros
            Cursor cursor = database.rawQuery(consulta, null);  //Cria um cursor para retornar todos os dados da tabela

            int indiceId = cursor.getColumnIndex("id");         //Indices coluna id
            int indiceNome = cursor.getColumnIndex("nome");     //Indices coluna nome
            int indiceIdade = cursor.getColumnIndex("idade");   //Indices coluna idade

            cursor.moveToFirst();   //Retornar o cursor para o primeiro registro da tabela

            while (cursor != null) {

                String id = cursor.getString(indiceId);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i("RES - ID ", id + " - Nome: " + nome + " - Idade: " + idade);

                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
