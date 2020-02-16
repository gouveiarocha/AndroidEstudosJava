package com.example.gouveiarocha.appsaulas.ActsEstudos.Navegacao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.gouveiarocha.appsaulas.Fragments.EstudoAbas.AbasEmAltaFragment;
import com.example.gouveiarocha.appsaulas.Fragments.EstudoAbas.AbasHomeFragment;
import com.example.gouveiarocha.appsaulas.Fragments.EstudoAbas.AbasInscricoesFragment;
import com.example.gouveiarocha.appsaulas.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class Abas extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abas);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Abas");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#D32F2F")));

        smartTabLayout = findViewById(R.id.view_pager_tab);
        viewPager = findViewById(R.id.view_pager);

        //Configura adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Home", AbasHomeFragment.class)
                .add("Inscrições", AbasInscricoesFragment.class)
                .add("Em alta", AbasEmAltaFragment.class)
                .create()
        );

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);

    }
}
