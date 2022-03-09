package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Views.CardView;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gouveiarocha.estudosjava.R;

import java.util.ArrayList;
import java.util.List;

public class CardViewActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPostagem;
    private List<PostagemModel> postagens = new ArrayList<>();

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
        PostagemModel p = new PostagemModel();

        p = new PostagemModel("Jamilton", "#viajando...", R.drawable.img1);
        this.postagens.add(p);

        p = new PostagemModel("Douglas", "#soalgreia...", R.drawable.img2);
        this.postagens.add(p);

        p = new PostagemModel("Caroline", "#feliz...", R.drawable.img3);
        this.postagens.add(p);

    }

}
