package br.com.alura.leilao.ui.activity;

import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import br.com.alura.leilao.api.retrofit.client.LeilaoWebClient;
import br.com.alura.leilao.model.Leilao;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class ListaLeilaoTelaTest {

    // instancia da act que será testada
    @Rule
    public ActivityTestRule<ListaLeilaoActivity> activity = new ActivityTestRule<>(
            ListaLeilaoActivity.class, // activity
            true, // habilita o modo de toque
            true); // se deseja inicializar a act ou não

    @Test
    public void deve_AparecerUmLeilao_QuandoCarregarUmLeilaoNaAPI() throws IOException {

        Leilao leilaoSalvo = new LeilaoWebClient().salva(new Leilao("Carro"));
        if (leilaoSalvo == null){
            Assert.fail("Leilão não foi salvo...");
        }

        activity.launchActivity(new Intent());

        // pega um view com caracteristica textual, onde o texto desejado é "Casa" e com o .check
        // verificamos no isDisplayed, se ela esta aparecendo na ui
        onView(withText("Carro")).check(matches(isDisplayed()));

    }

}