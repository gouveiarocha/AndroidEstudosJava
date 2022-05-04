package com.example.notificacoes_temp_udemyandroidoreo2022.model;

public class NotificacaoDados {

    //estrutura de dados para enviar ao firebase
    /*
    {
        "to": "topicos ou token",
        "notification": {
            "title": "Titulo da msg",
            "body" : "Corpo da msg"
            }
    }
    */

    private String to;
    private Notificacao notification;

    public NotificacaoDados(String to, Notificacao notification) {
        this.to = to;
        this.notification = notification;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Notificacao getNotification() {
        return notification;
    }

    public void setNotification(Notificacao notification) {
        this.notification = notification;
    }

}
