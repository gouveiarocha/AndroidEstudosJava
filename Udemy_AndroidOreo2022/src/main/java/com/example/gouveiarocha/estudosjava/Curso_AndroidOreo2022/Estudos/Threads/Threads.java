package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.gouveiarocha.estudosjava.R;

public class Threads extends AppCompatActivity {

    private Button botaoIniciar;
    private int numero;
    private Handler handler = new Handler();
    private boolean pararExecucao = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads);

        botaoIniciar = findViewById(R.id.btn_thread_iniciar);

    }

    public void iniciarThread(View view) {

        pararExecucao = false;

        /*
        //Caso eu modifique a classe principal como abaixo, a Thread principal ira travar e não conseguiremos usar os componentes de tela.
        for (int i = 0; i <= 15; i++) {
            Log.d("Thread", "contador" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        */

        //Agora usando as minhas classes proprias de Thread, a thread principal não irá travar.

        /*
        //1º Forma
        MyThread thread = new MyThread();
        thread.start();
        */

        //2º Forma
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();

    }

    public void pararThread(View view){
        pararExecucao = true;
    }

    //Usando a minha Thread - 1º forma (Extendendo a classe Thread)
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

    //Usando a minha Thread - 2º forma (Implementando a classe Runnable)
    class MyRunnable implements Runnable {
        @Override
        public void run() {

            for (int i = 0; i <= 15; i++) {

                if (pararExecucao){
                    return; //o return vazio encerra o for...
                }

                numero = i;
                Log.d("Thread", "contador: " + i);

                //Executando na Thread principal...
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        botaoIniciar.setText("contador: " + numero);
                    }
                });

                /*
                //Utilizando Handler (é a mesma coisa que usar o runOnUiThread)
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        botaoIniciar.setText("contador: " + numero);
                    }
                });
                */

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
