package com.example.gouveiarocha.appsaulas.ActsPrincipais;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.gouveiarocha.appsaulas.ActsEstudos.Componentes.Componentes4;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Firebase.FirebaseTeste;
import com.example.gouveiarocha.appsaulas.ActsEstudos.ManipulacaoDados.BancoSQLite;
import com.example.gouveiarocha.appsaulas.ActsEstudos.ManipulacaoDados.EstudoSharedPreferences;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Navegacao.Abas;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Navegacao.MenusToolbar;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Outros.Calendario;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Outros.CicloActivity;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Navegacao.NavigationDrawer;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Componentes.Componentes1;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Componentes.Componentes2;
import com.example.gouveiarocha.appsaulas.ActsEstudos.EnviaRecebeDados.EnviaDados;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Navegacao.Fragments;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Layouts.Alinhamento;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Componentes.Componentes3;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Outros.EventoClique;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Layouts.GridLayout;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Layouts.InterfaceNetflix;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Media.MediaPlayerEstudo;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Threads.Threads;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Views.Slides;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Views.MeuCardView;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Views.MeuListView;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Layouts.LinearLayout;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Layouts.FrameLayout;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Media.VideoPlayerEstudo;
import com.example.gouveiarocha.appsaulas.ActsEstudos.Views.MeuRecyclerView;
import com.example.gouveiarocha.appsaulas.Classes.Adapters.ItensAdapter;
import com.example.gouveiarocha.appsaulas.Classes.Importadas.RecyclerItemClickListener;
import com.example.gouveiarocha.appsaulas.Classes.Modelos.Item;
import com.example.gouveiarocha.appsaulas.R;

import java.util.ArrayList;
import java.util.List;

public class EstudosActivity extends AppCompatActivity {

    private RecyclerView recyclerview_estudos;
    private List<Item> listaItens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudos);

        recyclerview_estudos = findViewById(R.id.recyclerview_estudos);

        criarItens();

        ItensAdapter adapter = new ItensAdapter(listaItens);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview_estudos.setLayoutManager(layoutManager);
        recyclerview_estudos.setHasFixedSize(true);
        recyclerview_estudos.addItemDecoration(new DividerItemDecoration(this, android.widget.LinearLayout.VERTICAL));
        recyclerview_estudos.setAdapter(adapter);

        eventoClique();

    }

    public void eventoClique() {
        recyclerview_estudos.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerview_estudos, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Item item = listaItens.get(position);
                        String vSelecionado = item.getTitulo();
                        mudarActivity(vSelecionado);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Item item = listaItens.get(position);
                        Toast.makeText(EstudosActivity.this, "TEXTO LONGO " + item.getTitulo(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                })
        );
    }

    public void criarItens() {

        Item item;

        item = new Item("EVENTO CLIQUE", "Seção 5");
        this.listaItens.add(item);

        item = new Item("INTERFACE NETFLIX", "Seção 6 [Icones - Linhas Guia]");
        this.listaItens.add(item);

        item = new Item("ALINHAMENTO", "Seção 6 [Chain - Truques de Alinhamento]");
        this.listaItens.add(item);

        item = new Item("LINEARLAYOUT", "Seção 6");
        this.listaItens.add(item);

        item = new Item("FRAMELAYOUT", "Seção 6");
        this.listaItens.add(item);

        item = new Item("GRIDLAYOUT", "Seção 6");
        this.listaItens.add(item);

        item = new Item("COMPONENTES 1", "Seção 9 [EditText, CheckBox, RadioGroup e RadioButton]");
        this.listaItens.add(item);

        item = new Item("COMPONENTES 2", "Seção 9 [Switch, ToggleButton, Toast, AlertDialog, ProgressBar, SeekBar]");
        this.listaItens.add(item);

        item = new Item("LISTVIEW", "Seção 10");
        this.listaItens.add(item);

        item = new Item("RECYCLERVIEW", "Seção 10 - Com SWIPE(Seção 16)");
        this.listaItens.add(item);

        item = new Item("CARDVIEW", "Seção 10");
        this.listaItens.add(item);

        item = new Item("CICLO DE VIDA ACTIVITY", "Seção 11");
        this.listaItens.add(item);

        item = new Item("PASSANDO DADOS ENTRE ACTIVITYS", "Seção 11");
        this.listaItens.add(item);

        item = new Item("FRAGMENTS", "Seção 11");
        this.listaItens.add(item);

        item = new Item("COMPONENTES 3", "Seção 11 [SnackBar, FloatActionBar]");
        this.listaItens.add(item);

        item = new Item("NAVIGATION DRAWER", "Seção 11");
        this.listaItens.add(item);

        item = new Item("MEDIA PLAYER", "Seção 12");
        this.listaItens.add(item);

        item = new Item("VIDEO PLAYER", "Seção 12");
        this.listaItens.add(item);

        item = new Item("ABAS", "Seção 12");
        this.listaItens.add(item);

        item = new Item("SHARED PREFERENCES", "Seção 13");
        this.listaItens.add(item);

        item = new Item("BANCO SQLITE", "Seção 13");
        this.listaItens.add(item);

        item = new Item("MENUS TOOLBAR", "Seção 13 [Configurar e incorporar menus na Toolbar]");
        this.listaItens.add(item);

        item = new Item("FIREBASE", "Seção 14 [Realtime Database, Auth, Storage]");
        this.listaItens.add(item);

        item = new Item("SLIDES", "Seção 15");
        this.listaItens.add(item);

        item = new Item("COMPONENTES 4", "Seção 16 [FloatActionButton/Menu]");
        this.listaItens.add(item);

        item = new Item("CALENDARIO", "Seção 16");
        this.listaItens.add(item);

        item = new Item("THREADS", "Seção 20");
        this.listaItens.add(item);
    }

    public void mudarActivity(String valor) {

        switch (valor) {
            case "EVENTO CLIQUE":
                startActivity(new Intent(EstudosActivity.this, EventoClique.class));
                break;
            case "INTERFACE NETFLIX":
                startActivity(new Intent(EstudosActivity.this, InterfaceNetflix.class));
                break;
            case "ALINHAMENTO":
                startActivity(new Intent(EstudosActivity.this, Alinhamento.class));
                break;
            case "LINEARLAYOUT":
                startActivity(new Intent(EstudosActivity.this, LinearLayout.class));
                break;
            case "FRAMELAYOUT":
                startActivity(new Intent(EstudosActivity.this, FrameLayout.class));
                break;
            case "GRIDLAYOUT":
                startActivity(new Intent(EstudosActivity.this, GridLayout.class));
                break;
            case "COMPONENTES 1":
                startActivity(new Intent(EstudosActivity.this, Componentes1.class));
                break;
            case "COMPONENTES 2":
                startActivity(new Intent(EstudosActivity.this, Componentes2.class));
                break;
            case "LISTVIEW":
                startActivity(new Intent(EstudosActivity.this, MeuListView.class));
                break;
            case "RECYCLERVIEW":
                startActivity(new Intent(EstudosActivity.this, MeuRecyclerView.class));
                break;
            case "CARDVIEW":
                startActivity(new Intent(EstudosActivity.this, MeuCardView.class));
                break;
            case "CICLO DE VIDA ACTIVITY":
                startActivity(new Intent(EstudosActivity.this, CicloActivity.class));
                break;
            case "PASSANDO DADOS ENTRE ACTIVITYS":
                startActivity(new Intent(EstudosActivity.this, EnviaDados.class));
                break;
            case "FRAGMENTS":
                startActivity(new Intent(EstudosActivity.this, Fragments.class));
                break;
            case "COMPONENTES 3":
                startActivity(new Intent(EstudosActivity.this, Componentes3.class));
                break;
            case "NAVIGATION DRAWER":
                startActivity(new Intent(EstudosActivity.this, NavigationDrawer.class));
                break;
            case "MEDIA PLAYER":
                startActivity(new Intent(EstudosActivity.this, MediaPlayerEstudo.class));
                break;
            case "VIDEO PLAYER":
                startActivity(new Intent(EstudosActivity.this, VideoPlayerEstudo.class));
                break;
            case "ABAS":
                startActivity(new Intent(EstudosActivity.this, Abas.class));
                break;
            case "SHARED PREFERENCES":
                startActivity(new Intent(EstudosActivity.this, EstudoSharedPreferences.class));
                break;
            case "BANCO SQLITE":
                startActivity(new Intent(EstudosActivity.this, BancoSQLite.class));
                break;
            case "MENUS TOOLBAR":
                startActivity(new Intent(EstudosActivity.this, MenusToolbar.class));
                break;
            case "FIREBASE":
                startActivity(new Intent(EstudosActivity.this, FirebaseTeste.class));
                break;
            case "SLIDES":
                startActivity(new Intent(EstudosActivity.this, Slides.class));
                break;
            case "COMPONENTES 4":
                startActivity(new Intent(EstudosActivity.this, Componentes4.class));
                break;
            case "CALENDARIO":
                startActivity(new Intent(EstudosActivity.this, Calendario.class));
                break;
            case "THREADS":
                startActivity(new Intent(EstudosActivity.this, Threads.class));
                break;
        }

    }

}

