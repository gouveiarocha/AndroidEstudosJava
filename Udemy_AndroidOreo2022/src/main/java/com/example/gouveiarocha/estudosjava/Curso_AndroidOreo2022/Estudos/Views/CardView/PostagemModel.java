package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Views.CardView;

public class PostagemModel {

    private String nome;
    private String postagem;
    private int imagem;

    public PostagemModel() {
    }

    public PostagemModel(String nome, String postagem, int imagem) {
        this.nome = nome;
        this.postagem = postagem;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPostagem() {
        return postagem;
    }

    public void setPostagem(String postagem) {
        this.postagem = postagem;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
