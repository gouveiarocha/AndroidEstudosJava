package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.Tarefas.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.Tarefas.model.Tarefa;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.Tarefas.dao.TarefasDAO;
import com.example.gouveiarocha.estudosjava.R;
import com.google.android.material.textfield.TextInputEditText;

public class TarefasAddActivity extends AppCompatActivity {

    private TextInputEditText etxtTarefa;
    private Tarefa tarefaRecuperada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefas_adicionar);
        getSupportActionBar().setTitle("Adicionar tarefa...");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9c27b0")));

        etxtTarefa = findViewById(R.id.etxt_tarefas_tarefa);

        //Recuperando dados...
        tarefaRecuperada = (Tarefa) getIntent().getSerializableExtra("tarefa"); //Recupera a Tarefa

        //Caso não seja null, significa que a Tarefa esta em edição.
        if (tarefaRecuperada != null) {
            etxtTarefa.setText(tarefaRecuperada.getTitulo());       //Configura o txt do EditText.
            getSupportActionBar().setTitle("Atualizar tarefa...");  //Configura o titulo da ActionBar.
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app_tarefas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        controleOperacao();

        return super.onOptionsItemSelected(item);

    }

    //Método de controle de Operação(Inserir, Editar, Deletar)
    public void controleOperacao() {

        TarefasDAO tarefasDAO = new TarefasDAO(getApplicationContext());

        String op;
        if (tarefaRecuperada == null) {
            op = "Inserir";
        } else {
            op = "Editar";
        }

        switch (op) {
            case "Inserir":
                if (!etxtTarefa.getText().toString().isEmpty()) {
                    if (tarefasDAO.salvar(new Tarefa(etxtTarefa.getText().toString()))) {
                        finish();
                        Toast.makeText(this, "Tarefa Salva com sucesso!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Erro ao Salvar Tarefa...", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "ATENÇÃO: Digite uma tarefa para continuar...", Toast.LENGTH_SHORT).show();
                }
                break;
            case "Editar":
                if (!etxtTarefa.getText().toString().isEmpty()) {
                    Tarefa tarefa = new Tarefa(tarefaRecuperada.getId(), etxtTarefa.getText().toString()); //Cria uma tarefa e define o ID da Tarefa recuperada e o Texto digitado(atualização) no EditText.
                    if (tarefasDAO.atualizar(tarefa)) {
                        finish();
                        Toast.makeText(this, "Tarefa Atualizada com Sucesso!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Erro ao Atualizar Tarefa..", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }

    }

}
