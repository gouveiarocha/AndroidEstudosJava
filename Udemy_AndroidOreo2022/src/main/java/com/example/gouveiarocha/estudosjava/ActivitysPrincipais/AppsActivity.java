package com.example.gouveiarocha.estudosjava.ActivitysPrincipais;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.AprendaIngles.AppAprendaIngles;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.ATMConsultoria.AppAtmConsultoria;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.CaraCoroa.AppCaraCoroa;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.AppCombustivel;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.AppFrasesDia;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.AppGorjeta;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.AppJokenpo;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.AppMinhasAnotacoes;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.AppSorteio;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.Tarefas.activity.AppTarefasActivity;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Views.RecyclerView.adapter.ItensAdapter;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Views.RecyclerView.util.RecyclerItemClickListener;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Views.RecyclerView.model.Item;
import com.example.gouveiarocha.estudosjava.R;

import java.util.ArrayList;
import java.util.List;

public class AppsActivity extends AppCompatActivity {

    private RecyclerView recyclerview_apps;
    private List<Item> listaItens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps);

        recyclerview_apps = findViewById(R.id.recyclerview_apps);

        criarItens();

        ItensAdapter adapter = new ItensAdapter(listaItens);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview_apps.setLayoutManager(layoutManager);
        recyclerview_apps.setHasFixedSize(true);
        recyclerview_apps.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerview_apps.setAdapter(adapter);

        eventoClique();
    }

    public void eventoClique(){
        recyclerview_apps.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerview_apps, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Item item = listaItens.get(position);
                        String vSelecionado = item.getTitulo();
                        mudarActivity(vSelecionado);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Item item = listaItens.get(position);
                        Toast.makeText(AppsActivity.this, "TEXTO LONGO " + item.getTitulo(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
                )
        );
    }

    public void criarItens() {

        Item item;

        item = new Item("SORTEIO", "Seção 5");
        this.listaItens.add(item);

        item = new Item("FRASES DO DIA", "Seção 6");
        this.listaItens.add(item);

        item = new Item("JOKENPO", "Seção 7");
        this.listaItens.add(item);

        item = new Item("CALCULADORA COMBUSTIVEL", "Seção 9");
        this.listaItens.add(item);

        item = new Item("CALCULADORA DE GORJETA", "Seção 9");
        this.listaItens.add(item);

        item = new Item("CARA OU COROA", "Seção 11");
        this.listaItens.add(item);

        item = new Item("ATM CONSULTORIA", "Seção 11");
        this.listaItens.add(item);

        item = new Item("APRENDA INGLÊS", "Seção 12");
        this.listaItens.add(item);

        item = new Item("MINHAS ANOTAÇÕES", "Seção 13 - Classe Para SharedPreferences");
        this.listaItens.add(item);

        item = new Item("TAREFAS", "Seção 13 - Conceitos reais para utilização de banco de dados");
        this.listaItens.add(item);

    }

    public void mudarActivity(String valor) {

        switch (valor) {
            case "SORTEIO":
                startActivity(new Intent(AppsActivity.this, AppSorteio.class));
                break;
            case "FRASES DO DIA":
                startActivity(new Intent(AppsActivity.this, AppFrasesDia.class));
                break;
            case "JOKENPO":
                startActivity(new Intent(AppsActivity.this, AppJokenpo.class));
                break;
            case "CALCULADORA COMBUSTIVEL":
                startActivity(new Intent(AppsActivity.this, AppCombustivel.class));
                break;
            case "CALCULADORA DE GORJETA":
                startActivity(new Intent(AppsActivity.this, AppGorjeta.class));
                break;
            case "CARA OU COROA":
                startActivity(new Intent(AppsActivity.this, AppCaraCoroa.class));
                break;
            case "ATM CONSULTORIA":
                startActivity(new Intent(AppsActivity.this, AppAtmConsultoria.class));
                break;
            case "APRENDA INGLÊS":
                startActivity(new Intent(AppsActivity.this, AppAprendaIngles.class));
                break;
            case "MINHAS ANOTAÇÕES":
                startActivity(new Intent(AppsActivity.this, AppMinhasAnotacoes.class));
                break;
            case "TAREFAS":
                startActivity(new Intent(AppsActivity.this, AppTarefasActivity.class));
                break;
        }

    }
}
