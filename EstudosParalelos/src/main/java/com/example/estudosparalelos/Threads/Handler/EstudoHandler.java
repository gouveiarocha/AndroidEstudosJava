package com.example.estudosparalelos.Threads.Handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.estudosparalelos.R;

public class EstudoHandler extends AppCompatActivity {

    private TextView textView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudo_handler);

//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                Toast.makeText(Handler.this, "Teste de Erro", Toast.LENGTH_SHORT).show();
//            }
//        }.start();

        textView = (TextView) findViewById(R.id.handle_text);

        //chamo um método para o tratamento da mensagem
        //e melhor organização do código.
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                //chamo um método para melhor organização.
                updateUI(msg);
            }
        };

        //Thread responsável pelo processamento de dados.
        //O handler é passado para que sejá possível atualizar a tela.
        ThreadProcessamento threadProcessamento = new ThreadProcessamento(handler);
        threadProcessamento.start();

    }

    /**
     * Método responsável pelo controle de Message do Handler
     *
     * @param msg Message
     */
    private void updateUI(Message msg) {
        if (msg.what == 1) {
            //Converto o object para string (pois foi o que eu passei)
            String texto = (String) msg.obj;
            //defino no meu TextView o texto.
            textView.setText(texto);
        } else if (msg.what == 2) {
            //finalizo a activity
            Toast.makeText(this, "Android Handler - DevMedia", Toast.LENGTH_LONG).show();
            finish();
        }
    }

}