package com.example.gouveiarocha.appsaulas.ActsEstudos.ManipulacaoDados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gouveiarocha.appsaulas.R;
import com.google.android.material.textfield.TextInputEditText;

public class EstudoSharedPreferences extends AppCompatActivity {

    private TextInputEditText etxtDigitado;
    private TextView txtRecuperado;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        getSupportActionBar().setTitle("Shared Preferences");

        etxtDigitado = findViewById(R.id.etxt_digitado);
        txtRecuperado = findViewById(R.id.txt_recuperado);

        recuperar();

    }

    public void salvar(View view) {

        //Cria o objeto preferences
        SharedPreferences preferences = getSharedPreferences(
                ARQUIVO_PREFERENCIA,   //Nome do arquivo
                0);             //Modo: 0 - Privado. Somente o app podera manipular o arquivo.

        SharedPreferences.Editor editor = preferences.edit();   //Permite edição...

        //Validar conteudo digitado
        if (etxtDigitado.getText().equals("")) {
            Toast.makeText(this, "Atenção: Nenhum texto encontrado!", Toast.LENGTH_LONG).show();
        } else {
            editor.putString(
                    "txt",                                  //Key.
                    etxtDigitado.getText().toString());     //Texto para ser gravado.
            editor.commit();    //Salva os dados.

            txtRecuperado.setText(etxtDigitado.getText().toString());
        }

    }

    public void recuperar() {
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        //Validar se o conteudo(key) existe
        if (preferences.contains("txt")) {
            txtRecuperado.setText(preferences.getString(
                    "txt",                              //Key
                    "Texto não definido..."));      //Default, caso não encontre pela key.
        }else{
            txtRecuperado.setText("Texto não definido...");
        }
    }

}
