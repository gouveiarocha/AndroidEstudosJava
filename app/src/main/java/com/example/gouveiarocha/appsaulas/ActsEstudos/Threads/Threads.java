package com.example.gouveiarocha.appsaulas.ActsEstudos.Threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.gouveiarocha.appsaulas.R;

public class Threads extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads);
    }

    public void iniciarThread(View view) {

        //Caso eu modifique a classe principal como abaixo, a Thread principal ira trava e não conseguiremos usar os componentes de tela.
        /*
        for (int i = 0; i <= 15; i++) {
            Log.d("Thread", "contador" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/


        //Agora usando as minhas classesproprias de Thread, a thread principal não irá travar.

        //1º forma
        //MyThread thread = new MyThread();
        //thread.start();

        //2º forma
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();

    }

    //Usando a minha Thread - 1º forma(Extendendo a classe Thread)
    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i <= 15; i++) {
                Log.d("Thread", "contador" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Usando a minha Thread - 2º forma(Implementando a classe Runnable)
    class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 15; i++) {
                Log.d("Thread", "contador" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
