package com.example.gouveiarocha.appsaulas.ActsAplicativos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gouveiarocha.appsaulas.R;

public class AppGorjeta extends AppCompatActivity {

    private TextView txt_porc_gorjeta, txt_valor_gorjeta, txt_valor_total;
    private SeekBar sb_porc_gorjeta;
    private EditText et_valor_venda;

    private double porcentagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_gorjeta);

        //REF COMPONENTES
        sb_porc_gorjeta = findViewById(R.id.sb_porc_gorjeta);
        txt_porc_gorjeta = findViewById(R.id.txt_porc_gorjeta);
        et_valor_venda = findViewById(R.id.et_valor_venda);
        txt_valor_gorjeta = findViewById(R.id.txt_valor_gorjeta);
        txt_valor_total = findViewById(R.id.txt_valor_total);

        //SeekBar Listener
        sb_porc_gorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = i;
                txt_porc_gorjeta.setText(Math.round(porcentagem) + "%"); //Math.round - Serve para arredondar o número.
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular() {

        String valorRecuperado = et_valor_venda.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")) {
            Toast.makeText(this, "Atenção - Digite um valor...", Toast.LENGTH_SHORT).show();
        } else {
            double valorDigitado = Double.parseDouble(valorRecuperado);
            double gorjeta = valorDigitado * (porcentagem / 100);
            double total = valorDigitado + gorjeta;
            txt_valor_gorjeta.setText("R$ " + gorjeta);
            txt_valor_total.setText("R$ " + total);
        }

    }

}
