package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Views.RecyclerView.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Views.RecyclerView.model.Item;
import com.example.gouveiarocha.estudosjava.R;

import java.util.List;

public class ItensAdapter extends RecyclerView.Adapter<ItensAdapter.MyViwerHolder> {

    private List<Item> listaItens;

    public ItensAdapter(List<Item> lista) {
        this.listaItens = lista;
    }

    @NonNull
    @Override
    public MyViwerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_itens, viewGroup, false);
        return new MyViwerHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViwerHolder myViwerHolder, int i) {
        Item item = listaItens.get(i);
        myViwerHolder.titulo.setText(item.getTitulo());
        myViwerHolder.subtitulo.setText(item.getSubTitulo());
    }

    @Override
    public int getItemCount() {
        return listaItens.size();
    }

    public static class MyViwerHolder extends RecyclerView.ViewHolder {

        TextView titulo, subtitulo;

        public MyViwerHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txt_itens_titulo);
            subtitulo = itemView.findViewById(R.id.txt_itens_subtitulo);
        }
    }

}
