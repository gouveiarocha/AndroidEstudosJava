package com.example.alura_android_1_agenda.ui.activity;

import static com.example.alura_android_1_agenda.ui.activity.ConstantesActivities.CHAVE_ALUNO;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.alura_android_1_agenda.R;
import com.example.alura_android_1_agenda.dao.AlunoDAO;
import com.example.alura_android_1_agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR_NOVO_ALUNO = "Cadastrar Novo Aluno: ";
    private static final String TITULO_APPBAR_EDITA_ALUNO = "Editar Aluno: ";

    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private final AlunoDAO dao = new AlunoDAO();
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        initConfigs();

        //configuraBotaoSalvar(); //implementação substituida pelo menu de contexto.

        carregaAluno();

    }

    private void initConfigs() {
        campoNome = findViewById(R.id.form_aluno_nome);
        campoTelefone = findViewById(R.id.form_aluno_telefone);
        campoEmail = findViewById(R.id.form_aluno_email);
    }

    //implementação substituida pelo menu de contexto.
//    private void configuraBotaoSalvar() {
//        Button botaoSalvar = findViewById(R.id.form_aluno_botao_salvar);
//        botaoSalvar.setOnClickListener(view -> {
//            finalizaFormulario();
//        });
//    }

    private void carregaAluno() {
        Intent dados = getIntent();
        if (dados.hasExtra(CHAVE_ALUNO)) {
            setTitle(TITULO_APPBAR_EDITA_ALUNO);
            aluno = (Aluno) dados.getSerializableExtra(CHAVE_ALUNO);
            preencheCampos();
        } else {
            aluno = new Aluno();
            setTitle(TITULO_APPBAR_NOVO_ALUNO);
        }
    }

    private void preencheCampos() {
        campoNome.setText(aluno.getNome());
        campoTelefone.setText(aluno.getTelefone());
        campoEmail.setText(aluno.getEmail());
    }

    private void finalizaFormulario() {
        preencheAluno();
        if (aluno.temIdValido()) {
            dao.edita(aluno);
        } else {
            dao.salva(aluno);
        }
        finish();
    }

    private void preencheAluno() {

        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);

    }

    /**
     * Menu de Contexto...
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_formulario_aluno_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_formulario_aluno_menu_salvar){
            finalizaFormulario();
        }
        return super.onOptionsItemSelected(item);
    }
}