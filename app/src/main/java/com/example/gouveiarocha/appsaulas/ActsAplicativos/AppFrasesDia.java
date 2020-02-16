package com.example.gouveiarocha.appsaulas.ActsAplicativos;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.gouveiarocha.appsaulas.R;

import java.util.Random;

public class AppFrasesDia extends AppCompatActivity {

    String[] frases = {"Da vida não quero muito. Quero apenas saber que tentei tudo o que quis, tive tudo o que pude, " +
            "amei tudo o que valia e perdi apenas o que, no fundo, nunca foi meu.",
            "Ninguém vai bater mais forte do que a vida. Não importa como você bate e sim o quanto aguenta apanhar e " +
                    "continuar lutando; o quanto pode suportar e seguir em frente. É assim que se ganha.",
            "Nova Frase 3",
            "Nova Frase 4",
            "Nova Frase 5"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_frases_dia);
    }

    public void trocarFraseAleatoriamente(View view) {
        TextView fraseDia = findViewById(R.id.frasedia_txt_frase);
        int nRandom = new Random().nextInt(frases.length);
        fraseDia.setText(frases[nRandom]);
    }

    public void trocarFraseSequencialmente(View view){
        int n = 0;
        TextView fraseDia = findViewById(R.id.frasedia_txt_frase);
        if (n != frases.length){
            fraseDia.setText(frases[n]);
            n++;
        }else{
            n = 0;
            fraseDia.setText(frases[n]);
        }
    }

}
