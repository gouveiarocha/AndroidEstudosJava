package com.example.gouveiarocha.appsaulas.ActsEstudos.Componentes;

import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.gouveiarocha.appsaulas.R;

public class Componentes1 extends AppCompatActivity {

    private TextInputEditText et_nome, et_email;
    private CheckBox check_azul, check_verde, check_vermelho;
    private RadioGroup rg_opcao;
    private RadioButton rb_masculino, rb_feminino;
    private TextView txt_resultado, txt_res_radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componentes1);

        //REF COMPONENTES EDITTEXT
        et_nome = findViewById(R.id.et_nome);
        et_email = findViewById(R.id.et_email);

        //REF COMPONENTES CHECKBOX
        check_azul = findViewById(R.id.cb_azul);
        check_verde = findViewById(R.id.cb_verde);
        check_vermelho = findViewById(R.id.cb_vermelho);

        //REF COMPONENTES RADIO GROUP E BUTTON
        rg_opcao = findViewById(R.id.rg_opcao);
        rb_masculino = findViewById(R.id.rb_masculino);
        rb_feminino = findViewById(R.id.rb_feminino);

        //REF COMPONENETES RESULTADOS
        txt_resultado = findViewById(R.id.txt_resultado);
        txt_res_radio = findViewById(R.id.txt_res_radio);

        //Chama método ouvinte para o RadioGroup e Buttons Masculino e Feminimo
        radioGroupOuvinte();

    }

    public void enviar(View view) {

        //RES EditText
        String res1 = "Nome: " + et_nome.getText().toString() + "\n" + "E-mail: " + et_email.getText().toString();

        //RES CheckBox
        String res2 = "";
        if (check_azul.isChecked()) {
            res2 = "Azul Marcado \n";
        } else {
            res2 = "Azul Desmarcado \n";
        }

        if (check_verde.isChecked()) {
            res2 = res2 + "Verde Marcado \n";
        } else {
            res2 = res2 + "Verde Desmarcado \n";
        }

        if (check_vermelho.isChecked()) {
            res2 = res2 + "Vermelho Marcado";
        } else {
            res2 = res2 + "Vermelho Desmarcado";
        }

        //RES Radio Group e Button
        String res3 = "";
        if (rb_masculino.isChecked()) {
            res3 = "Sexo Masculino";
        } else if (rb_feminino.isChecked()) {
            res3 = "Sexo Feminino";
        }

        txt_resultado.setText(res1 + "\n" + res2 + "\n" + res3);

    }

    public void radioGroupOuvinte() {
        rg_opcao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_masculino) {
                    txt_res_radio.setText("Selecionando em Tempo Real: Masculino");
                } else if (i == R.id.rb_feminino) {
                    txt_res_radio.setText("Selecionando em Tempo Real: Feminimo");
                }
            }
        });
    }

    public void limpar(View view) {
        txt_resultado.setText("");
    }

}
