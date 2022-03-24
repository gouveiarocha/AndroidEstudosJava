package br.com.alura.leilao.ui.activity;

import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import org.hamcrest.core.AllOf;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import br.com.alura.leilao.R;
import br.com.alura.leilao.api.retrofit.client.TesteWebClient;
import br.com.alura.leilao.formatter.FormatadorDeMoeda;
import br.com.alura.leilao.model.Leilao;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.*;

public class ListaLeilaoTelaTest {

    private static final String ERRO_LIMPEZA_DADOS_API = "Banco de dados não foi limpo...";
    private static final String ERRO_LEILÃO_NÃO_FOI_SALVO = "Leilão não foi salvo... ";

    private final TesteWebClient webClient = new TesteWebClient();
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

        onView(allOf(
                withText("Carro"),
                withId(R.id.item_leilao_descricao)))
                .check(matches(isDisplayed()));

        String formatoEsperadoParaCarro = formatadorDeMoeda.formata(0.00);
        onView(allOf(
                withText(formatoEsperadoParaCarro),
                withId(R.id.lances_leilao_maior_lance)))
                .check(matches(isDisplayed()));

        onView(allOf(
                withText("Computador"),
                withId(R.id.item_leilao_descricao)))
                .check(matches(isDisplayed()));

        String formatoEsperadoParaComputador = formatadorDeMoeda.formata(0.00);
        onView(allOf(
                withText(formatoEsperadoParaComputador),
                withId(R.id.lances_leilao_maior_lance)))
                .check(matches(isDisplayed()));

    }

    @After
    public void tearDown() throws IOException {
        limpaBaseDeDadosDaAPI();
    }

    // MÉTODOS ->>>

    private void limpaBaseDeDadosDaAPI() throws IOException {
        boolean bancoDeDadosNaoFoiLimpo = !webClient.limpaBancoDeDados();
        if (bancoDeDadosNaoFoiLimpo) {
            Assert.fail(ERRO_LIMPEZA_DADOS_API);
        }
    }

    private void tentaSalvarLeilaoNaAPI(Leilao... leiloes) throws IOException {
        for (Leilao leilao : leiloes) {
            Leilao leilaoSalvo = webClient.salva(leilao);
            if (leilaoSalvo == null) {
                Assert.fail(ERRO_LEILÃO_NÃO_FOI_SALVO + leilao.getDescricao());
            }
        }
    }

}