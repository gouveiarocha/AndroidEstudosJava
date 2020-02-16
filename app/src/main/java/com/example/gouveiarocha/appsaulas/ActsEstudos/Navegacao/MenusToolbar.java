package com.example.gouveiarocha.appsaulas.ActsEstudos.Navegacao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gouveiarocha.appsaulas.R;

public class MenusToolbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus_toolbar);
        getSupportActionBar().setTitle("Menus Toolbar");
    }

    //Sobescrever método onCreateOptionMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Incorpora o menu...
        getMenuInflater().inflate(R.menu.menu_estudos_menus, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Sobescrever método onOptionsItemSelected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuaction_estudos_facebook:
                Toast.makeText(this, "Clicou no Menu FaceBook...", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
