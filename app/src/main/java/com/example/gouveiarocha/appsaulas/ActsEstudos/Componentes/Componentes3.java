package com.example.gouveiarocha.appsaulas.ActsEstudos.Componentes;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gouveiarocha.appsaulas.R;

public class Componentes3 extends AppCompatActivity {

    private Button btnAbrirSnackBar, btnFecharSnackbar;
    private TextView txtSnackbar;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componentes3);

        //REF COMPONENTES
        btnAbrirSnackBar = findViewById(R.id.btn_snackbar_abrir);
        btnFecharSnackbar = findViewById(R.id.btn_snackbar_fechar);
        txtSnackbar = findViewById(R.id.txt_snackbar);

        //COMANDOS SNACKBAR
        btnAbrirSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cria a snackbar, passando a view, o texto e a duração...
                snackbar = Snackbar.make(view, "BOTÃO PRESSIONADO", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Confirmar", new View.OnClickListener() { //Texto e evento de click na snackbar...
                            @Override
                            public void onClick(View v) {
                                txtSnackbar.setText("Texto alterado...");
                            }
                        }).setActionTextColor(getResources().getColor(android.R.color.white)); //Altera a cor do botão da snackbar...
                snackbar.show();    //Exibe a SnackBar.
            }
        });

        btnFecharSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss(); //fecha a ActionBar
            }
        });

        //CONFIGURAÇÃO TOOLBAR
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //CONFIGURAÇÃO FLOAT ACTION BAR
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "FAB PRESSIONADO...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
