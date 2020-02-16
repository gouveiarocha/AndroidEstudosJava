package com.example.gouveiarocha.appsaulas.ActsAplicativos;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gouveiarocha.appsaulas.R;

public class AppCombustivel extends AppCompatActivity {

    private EditText etAlcool, etGasolina;
    private TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_combustivel);

        //REF COMPONENTES
        etAlcool = findViewById(R.id.comb_editAlcool);
        etGasolina = findViewById(R.id.comb_editGasolina);
        txtRes = findViewById(R.id.comb_txtRes);

    }

    public void verificar(View view) {

        String alcool = etAlcool.getText().toString();
        String gasolina = etGasolina.getText().toString();

        if (this.validarCampos(alcool, gasolina)) {

            Double precoAlcool = Double.parseDouble(alcool);
            Double precoGasolina = Double.parseDouble(gasolina);

            if (precoAlcool / precoGasolina <= 0.7) {
                txtRes.setText("ABASTEÇA COM ALCOOL");
            } else {
                txtRes.setText("ABASTEÇA COM GASOLINA");
            }
        } else {
            txtRes.setText("VERIFIQUE OS VALORES DIGITADOS");
        }

    }

    public Boolean validarCampos(String alcool, String gasolina) {
        Boolean camposValidados = true;
        if (alcool == null || alcool.equals("")) {
            camposValidados = false;
        } else if (gasolina == null || gasolina.equals("")) {
            camposValidados = false;
        }
        return camposValidados;

    }

}
