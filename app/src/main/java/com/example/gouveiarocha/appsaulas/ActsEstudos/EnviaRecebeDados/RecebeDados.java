package com.example.gouveiarocha.appsaulas.ActsEstudos.EnviaRecebeDados;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gouveiarocha.appsaulas.Classes.Estudos.Cao;
import com.example.gouveiarocha.appsaulas.R;

public class RecebeDados extends AppCompatActivity {

    private TextView txtNome, txtIdade, txtRaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebe_dados);

        //REF COMPONENETES
        txtNome = findViewById(R.id.txt_dados_nome);
        txtIdade = findViewById(R.id.txt_dados_idade);
        txtRaca = findViewById(R.id.txt_dados_raca);

        //Objeto Bundle que cria a intenção de recuperar os dados.
        Bundle dados = getIntent().getExtras();

        //Recupera os dados enviados
        String nome = dados.getString("nome");
        int idade = dados.getInt("idade");
        //Seta o texto.
        txtNome.setText(nome);
        txtIdade.setText(String.valueOf(idade));

        //Recuperaos dados enviados(objeto)
        Cao cao = (Cao) dados.getSerializable("objeto");
        //Seta o texto(objeto)
        txtRaca.setText(cao.getRaça());

    }
}
