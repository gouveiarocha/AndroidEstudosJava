package com.example.notificacoes_temp_udemyandroidoreo2022.model;

public class Notificacao {

    private String title;
    private String body;

    public Notificacao(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
