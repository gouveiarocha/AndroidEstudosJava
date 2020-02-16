package com.example.gouveiarocha.appsaulas.ActsEstudos.EnviaRecebeDados;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gouveiarocha.appsaulas.Classes.Estudos.Cao;
import com.example.gouveiarocha.appsaulas.R;

public class EnviaDados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envia_dados);
    }

    public void enviaDados(View view) {

        //Cria uma intent
        Intent intent = new Intent(getApplicationContext(), RecebeDados.class);

        //Passando dados...
        intent.putExtra("nome", "Douglas");
        intent.putExtra("idade", 30);

        //Passando objetos...
        Cao cao = new Cao("Vira-Lata");
        //Passando um objeto, usando o Serializable - a classe cao implementa o Serializable, permitindo passar o objeto entre activitys...
        intent.putExtra("objeto", cao);
        //Iniciando a activity informando no intent
        startActivity(intent);
    }

}
