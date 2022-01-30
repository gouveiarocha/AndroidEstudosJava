package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Views.CardView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gouveiarocha.estudosjava.R;

import java.util.List;

public class PostagensAdapter extends RecyclerView.Adapter<PostagensAdapter.MyViewHolder> {

    private List<PostagemModel> postagens;

    public PostagensAdapter(List<PostagemModel> listaPostagens) {
        this.postagens = listaPostagens;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.lista_postagens_detalhe, viewGroup, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        PostagemModel postagem = postagens.get(i);
        myViewHolder.nomePostagem.setText(postagem.getNome());
        myViewHolder.imgPostagem.setImageResource(postagem.getImagem());
        myViewHolder.textoPostagem.setText(postagem.getPostagem());
    }

    @Override
    public int getItemCount() {
        return postagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nomePostagem, textoPostagem;
        private ImageView imgPostagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomePostagem = itemView.findViewById(R.id.txt_postagens_nome);
            imgPostagem = itemView.findViewById(R.id.img_postagens_imagem);
            textoPostagem = itemView.findViewById(R.id.txt_postagens_post);
        }
    }

}
