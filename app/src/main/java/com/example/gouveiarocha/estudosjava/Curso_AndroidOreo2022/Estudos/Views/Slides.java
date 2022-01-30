package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Views;

import android.os.Bundle;

import com.example.gouveiarocha.estudosjava.R;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

/**
 * Github: https://github.com/heinrichreimer/material-intro
 */

public class Slides extends IntroActivity {    //Trocar extensão para 'IntroActivity'...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sliders);    //Não usar o setContentView...

        setButtonBackVisible(false);    //esconde o botão voltar...
        setButtonNextVisible(false);    //esconde o botão avançar...

        simpleSlides();       //Adiciona sliders simples
        //fragmentsSlides();    //Adiciona sliders usando fragments

    }

    public void simpleSlides(){

        addSlide(new SimpleSlide.Builder()
                .title("Titulo1")
                .description("Descrição1")
                .image(R.drawable.slider_um)
                .background(android.R.color.holo_orange_light)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Titulo2")
                .description("Descrição2")
                .image(R.drawable.slider_dois)
                .background(android.R.color.holo_orange_light)
                .build());
    }

    public void fragmentsSlides(){
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.fragment_sliders_intro1)
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.fragment_sliders_intro1)
                .build());
    }

}
