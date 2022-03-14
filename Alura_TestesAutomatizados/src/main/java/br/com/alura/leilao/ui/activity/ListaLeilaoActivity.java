package br.com.alura.leilao.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.alura.leilao.R;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaLeilaoAdapter;

public class ListaLeilaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_leilao);
        ListaLeilaoAdapter adapter = new ListaLeilaoAdapter(this, leiloesDeExemplo());
        RecyclerView recyclerView = findViewById(R.id.lista_leilao_recyclerview);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new ListaLeilaoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Leilao leilao) {
                Intent vaiParaLancesLeilao = new Intent(ListaLeilaoActivity.this, LancesLeilaoActivity.class);
                vaiParaLancesLeilao.putExtra("leilao", leilao);
                startActivity(vaiParaLancesLeilao);
            }
        });
    }

    private List<Leilao> leiloesDeExemplo() {

        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("Douglas"), 200.0));
        console.propoe(new Lance(new Usuario("Fábio"), 550.0));
        console.propoe(new Lance(new Usuario("Carol"), 1050.0));
        console.propoe(new Lance(new Usuario("Júlio"), 150000.0));

        Leilao carro = new Leilao("Carro");
        carro.propoe(new Lance(new Usuario("Douglas"), 5200.0));
        carro.propoe(new Lance(new Usuario("Fábio"), 6350.0));
        carro.propoe(new Lance(new Usuario("Davi"), 26320.0));
        carro.propoe(new Lance(new Usuario("Heitor"), 18350000.0));

        Leilao casa = new Leilao("Casa");
        casa.propoe(new Lance(new Usuario("Douglas"), 50200.0));
        casa.propoe(new Lance(new Usuario("Júlio"), 355350.0));
        casa.propoe(new Lance(new Usuario("Oliverio"), 253500000.0));
        casa.propoe(new Lance(new Usuario("Leila"), 6535000000000.0));

        return new ArrayList<>(Arrays.asList(
                console, carro, casa
        ));
    }

}
