package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.AprendaIngles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.AprendaIngles.fragments.InglesBichosFragment;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.AprendaIngles.fragments.InglesNumerosFragment;
import com.example.gouveiarocha.estudosjava.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class AppAprendaIngles extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_aprenda_ingles);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Aprendendo Inglês");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#835A4B")));

        smartTabLayout = findViewById(R.id.view_pager_tab);
        viewPager = findViewById(R.id.view_pager);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("BICHOS", InglesBichosFragment.class)
                .add("NÚMEROS", InglesNumerosFragment.class)
                .create()
        );

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);

    }
}
