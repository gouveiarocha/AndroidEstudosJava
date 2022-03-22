package br.com.alura.leilao.ui.activity;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

public class ListaLeilaoTelaTest {

    // instancia da act que será testada
    @Rule
    public ActivityTestRule activity = new ActivityTestRule(
            ListaLeilaoActivity.class, // activity
            true, // habilita o modo de toque
            true); // se deseja inicializar a act ou não

    @Test
    public void deve_AparecerUmLeilao_QuandoCarregarUmLeilaoNaAPI() {

        // pega um view com caracteristica textual, onde o texto desejado é "Casa" e com o .check
        // verificamos no isDisplayed, se ela esta aparecendo na ui
        Espresso.onView(ViewMatchers.withText("Casa"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

    }

}