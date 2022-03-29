package br.com.alura.leilao.ui.activity;

import android.content.Intent;

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
import br.com.alura.leilao.model.Usuario;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

public class LancesLeilaoTelaTeste extends BaseTesteIntegracao {

    @Rule
    public ActivityTestRule<ListaLeilaoActivity> mainActivity =
            new ActivityTestRule<>(ListaLeilaoActivity.class, true, false);

    @Before
    public void setup() throws IOException {
        limpaBaseDeDadosDaAPI();
        limpaBancoDeDadoInterno();
    }

    @Test
    public void deve_AtualizarLanceDoLeilao_QuandoReceberUmLance() throws IOException {

        // salvar leilão na api
        tentaSalvarLeilaoNaAPI(new Leilao("Carro"));

        // inicializar a main activity
        mainActivity.launchActivity(new Intent());

        // clica no leilão
        onView(withId(R.id.lista_leilao_recyclerview))
                .perform(actionOnItemAtPosition(0, click()));

        // clica no fab da tela de lances do leilão
        onView(withId(R.id.lances_leilao_fab_adiciona))
                .perform(click());

        // verifica se aparece dialog de aviso por não ter usuário com titulo e mensagem  esperada
        onView(withText("Usuários não encontrados"))
                .check(matches(isDisplayed()));
        onView(withText("Não existe usuários cadastrados! Cadastre um usuário para propor o lance."))
                .check(matches(isDisplayed()));

        // clica no botão "Cadastrar Usuário"
        onView(withText("Cadastrar usuário")).perform(click());

        // clica no fab tela de lista de usuários
        onView(allOf(withId(R.id.lista_usuario_fab_adiciona),
                isDisplayed())).perform(click());

        // clica no EditText e preenche com o nome do usuário
        onView(allOf(withId(R.id.form_usuario_nome),
                isDisplayed())).perform(click());

        onView(allOf(withId(R.id.form_usuario_nome_edittext),
                isDisplayed())).perform(replaceText("Douglas"), closeSoftKeyboard());

        // clica em adicionar
        onView(allOf(withId(android.R.id.button1), withText("Adicionar")))
                .perform(scrollTo(), click());

        // clica no back do android
        pressBack();

        // clica no fab lances do leilão
        onView(withId(R.id.lances_leilao_fab_adiciona))
                .perform(click());

        // verifica visibilidade do dialog com o titulo esperado
        onView(withText("Novo lance"))
                .check(matches(isDisplayed()));

        // clica no edit text de valor e presente
        onView(withId(R.id.form_usuario_nome_edittext))
                .perform(click(), replaceText("200"), closeSoftKeyboard());

        // seleciona o usuario (spinner)
        onView(withId(R.id.form_lance_usuario))
                .perform(click());
        onData(is(new Usuario(1, "Douglas")))
                .inRoot(isPlatformPopup())
                .perform(click());

        // clica no botão propor
        onView(withText("Propor"))
                .perform(click());

        // fazer assertion para as views de maior e menor lance, e tambem para os maiores lances
        FormatadorDeMoeda formatador = new FormatadorDeMoeda();
        onView(withId(R.id.lances_leilao_maior_lance))
                .check(matches(allOf(withText(formatador.formata(200)), isDisplayed())));
        onView(withId(R.id.lances_leilao_menor_lance))
                .check(matches(allOf(withText(formatador.formata(200)), isDisplayed())));
        onView(withId(R.id.lances_leilao_maiores_lances))
                .check(matches(allOf(withText(formatador.formata(200) + " - (1) Douglas\n"), isDisplayed())));

    }

    @Test
    public void deve_AtualizarLanceDoLeilao_QuandoReceberUmLance_Refatorado() throws IOException {

        tentaSalvarLeilaoNaAPI(new Leilao("Carro"));

        mainActivity.launchActivity(new Intent());

        onView(withId(R.id.lista_leilao_recyclerview))
                .perform(actionOnItemAtPosition(0, click()));

        onView(allOf(withId(R.id.lances_leilao_fab_adiciona), isDisplayed()))
                .perform(click());

        onView(allOf(withText("Usuários não encontrados"), withId(R.id.alertTitle)))
                .check(matches(isDisplayed()));
        onView(allOf(withText("Não existe usuários cadastrados! Cadastre um usuário para propor o lance."), withId(android.R.id.message)))
                .check(matches(isDisplayed()));

        onView(allOf(withText("Cadastrar usuário"), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.lista_usuario_fab_adiciona),
                isDisplayed())).perform(click());

        onView(allOf(withId(R.id.form_usuario_nome_edittext),
                isDisplayed())).perform(click(), typeText("Douglas"), closeSoftKeyboard());

        onView(allOf(withId(android.R.id.button1), withText("Adicionar")))
                .perform(scrollTo(), click());

        pressBack();

        onView(allOf(withId(R.id.lances_leilao_fab_adiciona), isDisplayed()))
                .perform(click());

        propoeNovoLance("200", 1, "Douglas");

        FormatadorDeMoeda formatador = new FormatadorDeMoeda();
        onView(withId(R.id.lances_leilao_maior_lance))
                .check(matches(allOf(withText(formatador.formata(200)), isDisplayed())));
        onView(withId(R.id.lances_leilao_menor_lance))
                .check(matches(allOf(withText(formatador.formata(200)), isDisplayed())));
        onView(withId(R.id.lances_leilao_maiores_lances))
                .check(matches(allOf(withText(formatador.formata(200) + " - (1) Douglas\n"), isDisplayed())));

    }

    @Test
    public void deve_AtualizarLancesDoLeilao_QuandoReceberTresLances_Refatorado2() throws IOException {

        tentaSalvarLeilaoNaAPI(new Leilao("Carro"));

        tentaSalvarUsuariosNoBancoDeDados(new Usuario("Douglas"), new Usuario("Fran"));

        mainActivity.launchActivity(new Intent());

        onView(withId(R.id.lista_leilao_recyclerview))
                .perform(actionOnItemAtPosition(0, click()));

        propoeNovoLance("200", 1, "Douglas");
        propoeNovoLance("300", 2, "Fran");
        propoeNovoLance("400", 1, "Douglas");

        FormatadorDeMoeda formatador = new FormatadorDeMoeda();
        onView(withId(R.id.lances_leilao_maior_lance))
                .check(matches(allOf(withText(formatador.formata(400)), isDisplayed())));
        onView(withId(R.id.lances_leilao_menor_lance))
                .check(matches(allOf(withText(formatador.formata(200)), isDisplayed())));
        onView(withId(R.id.lances_leilao_maiores_lances))
                .check(matches(allOf(withText(formatador.formata(400) + " - (1) Douglas\n" +
                        formatador.formata(200) + " - (2) Fran\n" +
                        formatador.formata(400) + " - (1) Douglas\n"), isDisplayed())));

    }

    @Test
    public void deve_AtualizarLancesDoLeilao_QuandoReceberUmLanceMuitoAlto() throws IOException {

        tentaSalvarLeilaoNaAPI(new Leilao("Carro"));

        tentaSalvarUsuariosNoBancoDeDados(new Usuario("Douglas"));

        propoeNovoLance("2000000000", 1, "Douglas");

        FormatadorDeMoeda formatador = new FormatadorDeMoeda();
        onView(withId(R.id.lances_leilao_maior_lance))
                .check(matches(allOf(withText(formatador.formata(2000000000)), isDisplayed())));
        onView(withId(R.id.lances_leilao_menor_lance))
                .check(matches(allOf(withText(formatador.formata(2000000000)), isDisplayed())));
        onView(withId(R.id.lances_leilao_maiores_lances))
                .check(matches(allOf(withText(formatador.formata(2000000000) + " - (1) Douglas\n"), isDisplayed())));

    }

    @After
    public void tearDown() throws IOException {
        limpaBaseDeDadosDaAPI();
        limpaBancoDeDadoInterno();
    }

}
