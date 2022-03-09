package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps;

import android.os.Bundle;

import com.example.gouveiarocha.estudosjava.Outros.Tools.ToolsPreferences;
import com.example.gouveiarocha.estudosjava.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;

public class AppMinhasAnotacoes extends AppCompatActivity {

    private EditText editAnotacao;
    private ToolsPreferences toolsPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_minhas_anotacoes);

        editAnotacao = findViewById(R.id.etxt_anotacao);

        toolsPreferences = new ToolsPreferences(getApplicationContext());

        //Salvar...
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txtRecuperado = editAnotacao.getText().toString();

                if (txtRecuperado.equals("") || txtRecuperado == null) {
                    Snackbar.make(view, "Digite uma anotação para continuar...", Snackbar.LENGTH_LONG).show();
                } else {
                    toolsPreferences.salvar(txtRecuperado);
                    Snackbar.make(view, "Anotação salva com sucesso!!!", Snackbar.LENGTH_LONG).show();
                }

            }
        });

        //Recuperar
        String anotacao = toolsPreferences.recuperar();
        if (!anotacao.equals("")) {
            editAnotacao.setText(anotacao);
        }
    }

}
