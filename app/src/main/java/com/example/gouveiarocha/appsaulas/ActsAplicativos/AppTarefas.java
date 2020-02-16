package com.example.gouveiarocha.appsaulas.ActsAplicativos;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.gouveiarocha.appsaulas.ActsAplicativos.Secundarias.TarefasAdicionar;
import com.example.gouveiarocha.appsaulas.Classes.Adapters.TarefasAdapter;
import com.example.gouveiarocha.appsaulas.Classes.DAO.TarefasDAO;
import com.example.gouveiarocha.appsaulas.Classes.Importadas.RecyclerItemClickListener;
import com.example.gouveiarocha.appsaulas.Classes.Modelos.Tarefa;
import com.example.gouveiarocha.appsaulas.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AppTarefas extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Tarefa> listaTarefas = new ArrayList<>();
    private Tarefa tarefaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_tarefas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("APP Lista de Tarefas");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9c27b0")));

        recyclerView = findViewById(R.id.recycler_view_app_tarefas);

        eventoClique();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TarefasAdicionar.class));
            }
        });

    }

    @Override
    protected void onStart() {
        carregarListaTarefas();
        super.onStart();
    }

    public void carregarListaTarefas() {

        //Listar Tarefas
        TarefasDAO tarefasDAO = new TarefasDAO(getApplicationContext());
        listaTarefas = tarefasDAO.listar();

        //Configurar Adapter
        TarefasAdapter adapter = new TarefasAdapter(listaTarefas);

        //Configura RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

    }

    public void eventoClique() {

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                //Recuperar Tarefa para edição...
                Tarefa tarefa = listaTarefas.get(position);

                //Envia Tarefa para tela de adicionar...
                Intent intent = new Intent(getApplicationContext(), TarefasAdicionar.class);
                intent.putExtra("tarefa", tarefa);

                startActivity(intent);

            }

            @Override
            public void onLongItemClick(View view, int position) {

                tarefaSelecionada = listaTarefas.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(AppTarefas.this);
                builder.setTitle("ATENÇÃO!");
                builder.setIcon(R.drawable.img_jokenpo_pedra);
                builder.setMessage("Confirma deletar a Tarefa: \n" + tarefaSelecionada.getTitulo() + " ?");

                builder.setPositiveButton("DELETAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TarefasDAO tarefasDAO = new TarefasDAO(getApplicationContext());
                        if (tarefasDAO.deletar(tarefaSelecionada)) {
                            Toast.makeText(AppTarefas.this, "Tarefa deletada com sucesso!", Toast.LENGTH_SHORT).show();
                            carregarListaTarefas();
                        } else {
                            Toast.makeText(AppTarefas.this, "Erro ao deletar tarefa...", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                builder.setNegativeButton("CANCELAR", null );

                builder.create();
                builder.show();

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }
}
