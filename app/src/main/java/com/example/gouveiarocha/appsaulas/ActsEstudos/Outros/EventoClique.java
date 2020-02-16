package com.example.gouveiarocha.appsaulas.ActsEstudos.Outros;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gouveiarocha.appsaulas.R;

public class EventoClique extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_clique);
    }

    public void alterarTexto(View view){

        //Elementos
        final TextView textoExibicao = findViewById(R.id.textView22);
        Button botaoAlterar = findViewById(R.id.button);

        //Evento de Clique
        botaoAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ação do Evento
                textoExibicao.setText("Texto alterado... :D");
            }
        });

    }

}
