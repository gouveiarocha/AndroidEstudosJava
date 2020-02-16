package com.example.gouveiarocha.appsaulas.ActsEstudos.Componentes;

import android.os.Bundle;

import com.github.clans.fab.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

import com.example.gouveiarocha.appsaulas.R;

public class Componentes4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componentes4);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton menu1 = findViewById(R.id.menu_item1);
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Componentes4.this, "Menu1 Pressionado...", Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton menu2 = findViewById(R.id.menu_item2);
        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Componentes4.this, "Menu2 Pressionado...", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
