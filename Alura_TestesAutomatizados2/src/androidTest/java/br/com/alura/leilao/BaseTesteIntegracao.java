package br.com.alura.leilao;

import android.content.Context;

import androidx.test.InstrumentationRegistry;

import org.junit.Assert;

import java.io.IOException;

import br.com.alura.leilao.api.retrofit.client.TesteWebClient;
import br.com.alura.leilao.model.Leilao;

public abstract class BaseTesteIntegracao {

    private static final String ERRO_LIMPEZA_DADOS_API = "Banco de dados não foi limpo...";
    private static final String ERRO_LEILÃO_NÃO_FOI_SALVO = "Leilão não foi salvo... ";

    private final TesteWebClient webClient = new TesteWebClient();

    protected void limpaBaseDeDadosDaAPI() throws IOException {
        boolean bancoDeDadosNaoFoiLimpo = !webClient.limpaBancoDeDados();
        if (bancoDeDadosNaoFoiLimpo) {
            Assert.fail(ERRO_LIMPEZA_DADOS_API);
        }
    }

    protected void tentaSalvarLeilaoNaAPI(Leilao... leiloes) throws IOException {
        for (Leilao leilao : leiloes) {
            Leilao leilaoSalvo = webClient.salva(leilao);
            if (leilaoSalvo == null) {
                Assert.fail(ERRO_LEILÃO_NÃO_FOI_SALVO + leilao.getDescricao());
            }
        }
    }

    protected void limpaBancoDeDadoInterno() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        appContext.deleteDatabase(BuildConfig.BANCO_DE_DADOS);
    }

}
