package com.example.gouveiarocha.appsaulas.Classes.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gouveiarocha.appsaulas.Classes.Modelos.Item;
import com.example.gouveiarocha.appsaulas.Classes.Modelos.Tarefa;
import com.example.gouveiarocha.appsaulas.R;

import java.util.List;

public class TarefasAdapter extends RecyclerView.Adapter<TarefasAdapter.MyViwerHolder> {

    private List<Tarefa> listaTarefas;

    public TarefasAdapter(List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    @NonNull
    @Override
    public MyViwerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_tarefas, parent, false);
        return new MyViwerHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViwerHolder holder, int position) {
        Tarefa tarefa = listaTarefas.get(position);
        holder.tarefa.setText(tarefa.getTitulo());
    }

    @Override
    public int getItemCount() {
        return this.listaTarefas.size();
    }

    public static class MyViwerHolder extends RecyclerView.ViewHolder {

        TextView tarefa;

        public MyViwerHolder(@NonNull View itemView) {
            super(itemView);
            tarefa = itemView.findViewById(R.id.txt_tarefa);
        }
    }

}
