package br.com.alura.leilao.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.leilao.R;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;

public class LancesLeilaoActivity extends AppCompatActivity {

    private TextView descricao;
    private TextView maiorLance;
    private TextView menorLance;
    private TextView maioresLances;

    private void setViews() {
        descricao = findViewById(R.id.lances_leilao_descricao);
        maiorLance = findViewById(R.id.lances_leilao_maior_lance);
        menorLance = findViewById(R.id.lances_leilao_menor_lance);
        maioresLances = findViewById(R.id.lances_leilao_maiores_lances);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lances_leilao);

        setViews();

        Intent dadosRecebidos = getIntent();
        if (dadosRecebidos.hasExtra("leilao")) {
            Leilao leilao = (Leilao) dadosRecebidos.getSerializableExtra("leilao");
            descricao.setText(leilao.getDescricao());
            maiorLance.setText(String.valueOf(leilao.getMaiorLance()));
            menorLance.setText(String.valueOf(leilao.getMenorLance()));

            StringBuilder sb = new StringBuilder();
            for (Lance lance : leilao.getTresMaioresLances()) {
                sb.append(lance.getValor() + "\n");
            }
            String maioresLancesEmTexto = sb.toString();
            maioresLances.setText(maioresLancesEmTexto);

        }

    }

}
