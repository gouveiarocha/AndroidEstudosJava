package br.com.alura.leilao;

import android.content.Context;

import androidx.test.InstrumentationRegistry;

import org.junit.Assert;

import java.io.IOException;

import br.com.alura.leilao.api.retrofit.client.TesteWebClient;
import br.com.alura.leilao.database.dao.UsuarioDAO;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

public abstract class BaseTesteIntegracao {

    private static final String ERRO_LIMPEZA_DADOS_API = "Banco de dados não foi limpo...";
    private static final String ERRO_LEILÃO_NÃO_FOI_SALVO = "Leilão não foi salvo... ";

    private final TesteWebClient webClient = new TesteWebClient();

    protected void propoeNovoLance(String valorLance, int idUsuario, String nomeUsuario) {

        onView(allOf(withId(R.id.lances_leilao_fab_adiciona), isDisplayed()))
                .perform(click());

        onView(allOf(withText("Novo lance"), withId(R.id.alertTitle)))
                .check(matches(isDisplayed()));

        onView(allOf(withId(R.id.form_usuario_nome_edittext), isDisplayed()))
                .perform(click(), typeText(valorLance), closeSoftKeyboard());

        onView(allOf(withId(R.id.form_lance_usuario), isDisplayed()))
                .perform(click());
        onData(is(new Usuario(idUsuario, nomeUsuario))).inRoot(isPlatformPopup())
                .perform(click());

        onView(allOf(withText("Propor"), isDisplayed()))
                .perform(click());

    }

    protected void tentaSalvarLeilaoNaAPI(Leilao... leiloes) throws IOException {
        for (Leilao leilao : leiloes) {
            Leilao leilaoSalvo = webClient.salva(leilao);
            if (leilaoSalvo == null) {
                Assert.fail(ERRO_LEILÃO_NÃO_FOI_SALVO + leilao.getDescricao());
            }
        }
    }

    protected void tentaSalvarUsuariosNoBancoDeDados(Usuario... usuarios) {
        UsuarioDAO dao = new UsuarioDAO(InstrumentationRegistry.getTargetContext());
        for (Usuario usuario : usuarios) {
            Usuario usuarioSalvo = dao.salva(usuario);
            if (usuarioSalvo == null) {
                Assert.fail("Usuário " + usuario + " não foi salvo...");
            }
        }
    }

    protected void limpaBaseDeDadosDaAPI() throws IOException {
        boolean bancoDeDadosNaoFoiLimpo = !webClient.limpaBancoDeDados();
        if (bancoDeDadosNaoFoiLimpo) {
            Assert.fail(ERRO_LIMPEZA_DADOS_API);
        }
    }

    protected void limpaBancoDeDadoInterno() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        appContext.deleteDatabase(BuildConfig.BANCO_DE_DADOS);
    }

}
