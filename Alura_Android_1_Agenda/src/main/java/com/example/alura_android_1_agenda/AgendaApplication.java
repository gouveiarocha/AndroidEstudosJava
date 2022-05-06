package com.example.alura_android_1_agenda;

import android.app.Application;

import com.example.alura_android_1_agenda.dao.AlunoDAO;
import com.example.alura_android_1_agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        criaAlunosDeTeste();

    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();

        //for utilizado apenas para inserir mais Alunos afim de testes
        for (int i = 0; i < 1; i++) {
            dao.salva(new Aluno("Douglas", "11980484482", ""));
            dao.salva(new Aluno("Davi", "", ""));
        }
    }

}
