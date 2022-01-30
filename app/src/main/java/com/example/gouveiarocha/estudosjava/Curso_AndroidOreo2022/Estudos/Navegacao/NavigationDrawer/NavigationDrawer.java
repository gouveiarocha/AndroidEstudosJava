package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Navegacao.NavigationDrawer;

import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.gouveiarocha.estudosjava.R;

public class NavigationDrawer extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        //Configura a barra de navegação...
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //REF. Drawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        //REF. Area de navegação
        NavigationView navigationView = findViewById(R.id.nav_view);

        //Configura os itens de navegação do Drawer
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send, R.id.nav_contato)
                .setDrawerLayout(drawer)
                .build();

        //Configura a area que irá carregar os fragments
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //Configura e exibe o menu de navegação superior
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        //Configura a navegação no NavView. (Sem isso, os cliques no menu ficam sem ação)
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
