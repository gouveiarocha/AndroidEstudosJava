package com.example.gouveiarocha.appsaulas.ActsEstudos.Views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gouveiarocha.appsaulas.Classes.Adapters.PostagensAdapter;
import com.example.gouveiarocha.appsaulas.Classes.Modelos.Postagem;
import com.example.gouveiarocha.appsaulas.R;

import java.util.ArrayList;
import java.util.List;

public class MeuCardView extends AppCompatActivity {

    private RecyclerView recyclerViewPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_card_view);

        recyclerViewPostagem = findViewById(R.id.recycler_view_postagens);

        //Criar as postagens
        this.criarPostagens();

        //Criar o adapter
        PostagensAdapter adapter = new PostagensAdapter(postagens);

        //Criar e configurar o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());    //cria o layout
        recyclerViewPostagem.setLayoutManager(layoutManager);                                           //define o layout
        recyclerViewPostagem.setAdapter(adapter);                                                       //setar o adapter

    }

    public void criarPostagens() {
        Postagem p = new Postagem();

        p = new Postagem("Jamilton", "#viajando...", R.drawable.img1);
        this.postagens.add(p);

        p = new Postagem("Douglas", "#soalgreia...", R.drawable.img2);
        this.postagens.add(p);

        p = new Postagem("Caroline", "#feliz...", R.drawable.img3);
        this.postagens.add(p);

    }

}
