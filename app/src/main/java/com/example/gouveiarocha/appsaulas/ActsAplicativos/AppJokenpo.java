package com.example.gouveiarocha.appsaulas.ActsAplicativos;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gouveiarocha.appsaulas.R;

import java.util.Random;

public class AppJokenpo extends AppCompatActivity {

    //Elementos
    private ImageView jokenpo_img_pedra;
    private ImageView jokenpo_img_papel;
    private ImageView jokenpo_img_tesoura;

    //Variaveis
    private int escolhaUsuario;
    private int escolhaApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_jokenpo);

        jokenpo_img_pedra = findViewById(R.id.jokenpo_img_pedra);
        jokenpo_img_papel = findViewById(R.id.jokenpo_img_papel);
        jokenpo_img_tesoura = findViewById(R.id.jokenpo_img_tesoura);

        jokenpo_img_pedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escolhaUsuario = 0;
                escolhaApp = new Random().nextInt(3);
                verificarVencedor();
            }
        });

        jokenpo_img_papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escolhaUsuario = 1;
                escolhaApp = new Random().nextInt(3);
                verificarVencedor();
            }
        });

        jokenpo_img_tesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escolhaUsuario = 2;
                escolhaApp = new Random().nextInt(3);
                verificarVencedor();
            }
        });

    }

    public void verificarVencedor() {

        //Elementos
        TextView texto = findViewById(R.id.JOKENPO_TXTVENCEDOR);
        ImageView imageViewApp = findViewById(R.id.JOKENPO_ESCOLHA_APP);
        ImageView imageViewUsuario = findViewById(R.id.JOKENPO_ESCOLHA_USUARIO);
        ImageView imageViewVencedor = findViewById(R.id.JOKENPO_IMGVENCEDOR);

        switch (escolhaApp) {
            case 0:
                imageViewApp.setImageResource(R.drawable.img_jokenpo_pedra);
                break;
            case 1:
                imageViewApp.setImageResource(R.drawable.img_jokenpo_papel);
                break;
            case 2:
                imageViewApp.setImageResource(R.drawable.img_jokenpo_tesoura);
                break;
        }

        switch (escolhaUsuario) {
            case 0:
                imageViewUsuario.setImageResource(R.drawable.img_jokenpo_pedra);
                break;
            case 1:
                imageViewUsuario.setImageResource(R.drawable.img_jokenpo_papel);
                break;
            case 2:
                imageViewUsuario.setImageResource(R.drawable.img_jokenpo_tesoura);
                break;
        }

        if ((escolhaUsuario == 1 && escolhaApp == 0) ||
                (escolhaUsuario == 0 && escolhaApp == 2) ||
                (escolhaUsuario == 2 && escolhaApp == 1)) {
            texto.setText("USUARIO GANHOU!!!");
            switch (escolhaUsuario) {
                case 0:
                    imageViewVencedor.setImageResource(R.drawable.img_jokenpo_pedra);
                    break;
                case 1:
                    imageViewVencedor.setImageResource(R.drawable.img_jokenpo_papel);
                    break;
                case 2:
                    imageViewVencedor.setImageResource(R.drawable.img_jokenpo_tesoura);
                    break;
            }

        } else if ((escolhaUsuario == 2 && escolhaApp == 0) ||
                (escolhaUsuario == 1 && escolhaApp == 2) ||
                (escolhaUsuario == 0 && escolhaApp == 1)) {
            texto.setText("APP GANHOU!!!");
            switch (escolhaApp) {
                case 0:
                    imageViewVencedor.setImageResource(R.drawable.img_jokenpo_pedra);
                    break;
                case 1:
                    imageViewVencedor.setImageResource(R.drawable.img_jokenpo_papel);
                    break;
                case 2:
                    imageViewVencedor.setImageResource(R.drawable.img_jokenpo_tesoura);
                    break;
            }

        } else {
            texto.setText("EMPATE!!!");
            switch (escolhaApp) {
                case 0:
                    imageViewVencedor.setImageResource(R.drawable.img_jokenpo_pedra);
                    break;
                case 1:
                    imageViewVencedor.setImageResource(R.drawable.img_jokenpo_papel);
                    break;
                case 2:
                    imageViewVencedor.setImageResource(R.drawable.img_jokenpo_tesoura);
                    break;
            }

        }

    }

}
