package com.example.gouveiarocha.appsaulas.ActsEstudos.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.gouveiarocha.appsaulas.Classes.Adapters.FilmesAdapter;
import com.example.gouveiarocha.appsaulas.Classes.Importadas.RecyclerItemClickListener;
import com.example.gouveiarocha.appsaulas.Classes.Modelos.Filme;
import com.example.gouveiarocha.appsaulas.R;

import java.util.ArrayList;
import java.util.List;

public class MeuRecyclerView extends AppCompatActivity {

    private RecyclerView recyclerViewFilmes;
    private List<Filme> listaFilmes = new ArrayList<>();

    private FilmesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_recycler_view);

        recyclerViewFilmes = findViewById(R.id.recycler_view_filmes);

        //Criar filmes
        this.criarFilmes();

        //Criar o adapter
        adapter = new FilmesAdapter(listaFilmes);

        //Criar e configurar o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());            //cria o layout
        recyclerViewFilmes.setLayoutManager(layoutManager);                                                     //define o laytou
        recyclerViewFilmes.setHasFixedSize(true);                                                               //otimiza o recyclerview
        recyclerViewFilmes.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));   //adiciona um divisor de itens
        recyclerViewFilmes.setAdapter(adapter);                                                                 //setar o adapter

        //Evento de clique
        eventoClique();

        //Swipe
        iniciarSwipe();

    }

    public void eventoClique() {
        recyclerViewFilmes.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerViewFilmes, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Filme filme = listaFilmes.get(position);
                Toast.makeText(MeuRecyclerView.this, "Texto Pressionado -" + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Filme filme = listaFilmes.get(position);
                Toast.makeText(MeuRecyclerView.this, "Texto Longo Pressionado -" + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    public void criarFilmes() {
        Filme filme = new Filme();

        filme = new Filme("MeuFilme1", "Ação", "2015");
        this.listaFilmes.add(filme);

        filme = new Filme("O Voo", "Suspense", "2014");
        this.listaFilmes.add(filme);

        filme = new Filme("Espetacular Homem Aranha 2", "Ação", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A volta dos que nunca foram", "Comédia", "2015");
        this.listaFilmes.add(filme);

        filme = new Filme("DBZ2", "Animação", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Palmeiras", "Esporte", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Vikings", "Guerra", "2014");
        this.listaFilmes.add(filme);

        filme = new Filme("June", "Mitologia", "2010");
        this.listaFilmes.add(filme);

    }

    //Movimentos de deslizar...
    public void iniciarSwipe() {
        ItemTouchHelper.Callback itemTouch = new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {

                int dragsFlags = ItemTouchHelper.ACTION_STATE_IDLE;             //define que não pode arrastar para cima ou baixo
                int swipeFlags = ItemTouchHelper.END | ItemTouchHelper.START;   //define os movimentos de iniciarSwipe (start para o inicio e end para o fim)
                return makeMovementFlags(dragsFlags, swipeFlags);

            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                if (direction == ItemTouchHelper.END) {
                    Toast.makeText(MeuRecyclerView.this, "Arrastou para o fim...", Toast.LENGTH_SHORT).show();
                    recyclerViewFilmes.setAdapter(adapter);
                } else if (direction == ItemTouchHelper.START) {
                    Toast.makeText(MeuRecyclerView.this, "Arrastou para o inicio...", Toast.LENGTH_SHORT).show();
                    recyclerViewFilmes.setAdapter(adapter);
                }

            }
        };

        new ItemTouchHelper(itemTouch).attachToRecyclerView(recyclerViewFilmes);

    }

}
