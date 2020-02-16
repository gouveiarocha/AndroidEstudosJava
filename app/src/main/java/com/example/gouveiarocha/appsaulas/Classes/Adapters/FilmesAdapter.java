package com.example.gouveiarocha.appsaulas.Classes.Adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gouveiarocha.appsaulas.Classes.Modelos.Filme;
import com.example.gouveiarocha.appsaulas.R;

import java.util.List;

public class FilmesAdapter extends RecyclerView.Adapter<FilmesAdapter.MyViwerHolder> {

    //Cria a lista de filmes...
    private List<Filme> listaFilmes;

    //Construtor
    public FilmesAdapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    public MyViwerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_filmes, viewGroup, false);
        return new MyViwerHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViwerHolder myViwerHolder, int i) {
        Filme filme = listaFilmes.get(i);
        myViwerHolder.titulo.setText(filme.getTituloFilme());
        myViwerHolder.genero.setText(filme.getGenero());
        myViwerHolder.ano.setText(filme.getAno());
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    //Classe VieweHolder...
    public static class MyViwerHolder extends RecyclerView.ViewHolder {

        TextView titulo, genero, ano;

        public MyViwerHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txt_filmes_titulo);
            genero = itemView.findViewById(R.id.txt_filmes_genero);
            ano = itemView.findViewById(R.id.txt_filmes_ano);
        }
    }

}
