package br.com.alura.leilao.ui.activity;

import android.content.Intent;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import br.com.alura.leilao.BaseTesteIntegracao;
import br.com.alura.leilao.R;
import br.com.alura.leilao.formatter.FormatadorDeMoeda;
import br.com.alura.leilao.model.Leilao;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static br.com.alura.leilao.matchers.ViewMatcherPersonalizado.apareceLeilaoNaPosicao;
import static br.com.alura.leilao.matchers.ViewMatcherPersonalizado.apareceLeilaoNaPosicaoRefatorado;
import static org.hamcrest.core.AllOf.allOf;

public class ListaLeilaoTelaTest extends BaseTesteIntegracao {

    private final FormatadorDeMoeda formatadorDeMoeda = new FormatadorDeMoeda();

    // instancia da act que será testada
    @Rule
    public ActivityTestRule<ListaLeilaoActivity> activity = new ActivityTestRule<>(
            ListaLeilaoActivity.class, // activity
            true, // habilita o modo de toque
            true); // se deseja inicializar a act ou não

    @Before
    public void setup() throws IOException {
        limpaBaseDeDadosDaAPI();
    }

    @Test
    public void deve_AparecerUmLeilao_QuandoCarregarUmLeilaoNaAPI() throws IOException {

        // Essa implementação foi abordada no curso, mas não é recomendada... a melhor implementação está no método:
        // 'deve_AparecerDoisLeiloes_QuandoCarregarDoisLeiloesDaAPIRefatorado'

        tentaSalvarLeilaoNaAPI(new Leilao("Carro"));

        activity.launchActivity(new Intent());

        // pega um view com caracteristica textual, onde o texto desejado é "Casa" e com o .check
        // verificamos no isDisplayed, se ela esta aparecendo na ui
        // o allOf garante que ele vai pegar\combinar todos os matchers
        onView(allOf(
                withText("Carro"),
                withId(R.id.item_leilao_descricao)))
                .check(matches(isDisplayed()));

        String formatoEsperado = formatadorDeMoeda.formata(0.00);
        onView(allOf(
                withText(formatoEsperado),
                withId(R.id.lances_leilao_maior_lance)))
                .check(matches(isDisplayed()));

    }

    @Test
    public void deve_AparecerDoisLeiloes_QuandoCarregarDoisLeiloesDaAPI() throws IOException {

        tentaSalvarLeilaoNaAPI(new Leilao("Carro"), new Leilao("Computador"));

        activity.launchActivity(new Intent());

//        onView(allOf(
//                withText("Carro"),
//                withId(R.id.item_leilao_descricao)))
//                .check(matches(isDisplayed()));
//
//        String formatoEsperadoParaCarro = formatadorDeMoeda.formata(0.00);
//        onView(allOf(
//                withText(formatoEsperadoParaCarro),
//                withId(R.id.lances_leilao_maior_lance)))
//                .check(matches(isDisplayed()));
//
//        onView(allOf(
//                withText("Computador"),
//                withId(R.id.item_leilao_descricao)))
//                .check(matches(isDisplayed()));
//
//        String formatoEsperadoParaComputador = formatadorDeMoeda.formata(0.00);
//        onView(allOf(
//                withText(formatoEsperadoParaComputador),
//                withId(R.id.lances_leilao_maior_lance)))
//                .check(matches(isDisplayed()));

        onView(withId(R.id.lista_leilao_recyclerview))
                .check(matches(apareceLeilaoNaPosicao(
                        0,
                        "Carro",
                        0.00)));

    }

    @Test
    public void deve_AparecerDoisLeiloes_QuandoCarregarDoisLeiloesDaAPIRefatorado() throws IOException {

        tentaSalvarLeilaoNaAPI(new Leilao("Carro"), new Leilao("Computador"));

        activity.launchActivity(new Intent());

        onView(withId(R.id.lista_leilao_recyclerview))
                .check(matches(apareceLeilaoNaPosicaoRefatorado(0,
                        "Carro", 0.00)));

        onView(withId(R.id.lista_leilao_recyclerview))
                .check(matches(apareceLeilaoNaPosicaoRefatorado(1,
                        "Computador", 0.00)));

    }

    @Test
    public void deve_AparecerUltimoLeilao_QuandoCarregarDezLeiloesDaAPI() throws IOException {

        tentaSalvarLeilaoNaAPI(
                new Leilao("Carro"), new Leilao("Computador"),
                new Leilao("TV"), new Leilao("Notebook"),
                new Leilao("Console"), new Leilao("Jogo"),
                new Leilao("Estante"), new Leilao("Quadro"),
                new Leilao("Smartphone"), new Leilao("Casa"));

        activity.launchActivity(new Intent());

        onView(withId(R.id.lista_leilao_recyclerview))
                .perform(RecyclerViewActions.scrollToPosition(9))
                .check(matches(apareceLeilaoNaPosicaoRefatorado(9,
                        "Casa", 0.00)));

    }

    @After
    public void tearDown() throws IOException {
        limpaBaseDeDadosDaAPI();
    }

}