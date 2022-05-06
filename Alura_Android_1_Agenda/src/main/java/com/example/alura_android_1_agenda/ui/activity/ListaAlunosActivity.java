package com.example.alura_android_1_agenda.ui.activity;

import static com.example.alura_android_1_agenda.ui.activity.ConstantesActivities.CHAVE_ALUNO;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.alura_android_1_agenda.R;
import com.example.alura_android_1_agenda.model.Aluno;
import com.example.alura_android_1_agenda.ui.ListaAlunosView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Alunos";
    //private final AlunoDAO dao = new AlunoDAO();
    //private ArrayAdapter<Aluno> adapter;
    //private ListaAlunosAdapter adapter;
    private final ListaAlunosView listaAlunosView = new ListaAlunosView(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);

        configuraFabNovoAluno();
        configuraLista();

    }

    @Override
    protected void onResume() {
        super.onResume();
        listaAlunosView.atualizaAlunos();
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoAdicionarAluno = findViewById(R.id.fab_add_aluno);
        botaoAdicionarAluno.setOnClickListener(view -> abreFormularioModoInsereAluno());
    }

    private void configuraLista() {

        ListView listaDeAlunos = findViewById(R.id.listview_lista_alunos);

        listaAlunosView.configuraAdapter(listaDeAlunos);
        configuraListenerDeCliquePorItem(listaDeAlunos);
        //configuraListenerDeCliqueLongoPorItem(listaDeAlunos);

        registerForContextMenu(listaDeAlunos);

    }

//    private void configuraListenerDeCliqueLongoPorItem(ListView listaDeAlunos) {
//        listaDeAlunos.setOnItemLongClickListener((adapterView, view, posicao, l) -> {
//            Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao);
//            remove(alunoEscolhido);
//            return false;
//        });
//    }

    private void configuraListenerDeCliquePorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener((adapterView, view, posicao, l) -> {
            Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao);
            abreFormularioModoEditaAluno(alunoEscolhido);
        });
    }

    private void abreFormularioModoInsereAluno() {
        startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
    }

    private void abreFormularioModoEditaAluno(Aluno aluno) {
        Intent vaiParaFormularioActivity = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, aluno);
        startActivity(vaiParaFormularioActivity);
    }


    /**
     * Menu de Contexto...
     */

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //menu.add("Remover"); //adicionando item de menu de forma programática
        getMenuInflater().inflate(R.menu.activity_lista_alunos_menu, menu); //inflate do menu estatico
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.act_lista_alunos_menu_remover) {
            listaAlunosView.confirmaRemocao(item);
        } else if (itemId == R.id.act_lista_alunos_menu_teste) {
            Toast.makeText(this, "Só um teste!!!", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

}