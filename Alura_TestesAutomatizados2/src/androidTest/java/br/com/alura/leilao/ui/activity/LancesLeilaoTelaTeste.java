package br.com.alura.leilao.ui.activity;

import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import br.com.alura.leilao.BaseTesteIntegracao;
import br.com.alura.leilao.R;
import br.com.alura.leilao.model.Leilao;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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

        // clica no EditText e preenche com o nome do usuário

    }

    @After
    public void tearDown() throws IOException {
        limpaBaseDeDadosDaAPI();
        limpaBancoDeDadoInterno();
    }

}
