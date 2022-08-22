package com.example.estudosparalelos.Threads.Handler;

import android.os.Handler;
import android.os.Message;

public class ThreadProcessamento extends Thread {

    private Handler handler;

    public ThreadProcessamento(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 10; i++) {
            Message message = new Message();
            //defino um codigo para controle.
            message.what = 1;

            //aqui posso passar qualquer objeto.
            //No caso estou passando uma String
            if (i < 9) {
                message.obj = "Contador: " + i;
            } else {
                message.obj = "Finalizando...";
            }

            //Envio da mensagem.
            handler.sendMessage(message);

            try {
                //simula processamento de 1seg
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Note que mudei o código de controle.
        //O controle dessa mensagem será diferente.
        Message message = new Message();
        message.what = 2;
        handler.sendMessage(message);

    }
}
