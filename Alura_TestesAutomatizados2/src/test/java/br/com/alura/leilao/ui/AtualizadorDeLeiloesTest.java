package br.com.alura.leilao.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.alura.leilao.api.retrofit.client.LeilaoWebClient;
import br.com.alura.leilao.api.retrofit.client.RespostaListener;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaLeilaoAdapter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AtualizadorDeLeiloesTest {

    @Mock
    private ListaLeilaoAdapter adapter;

    @Mock
    private LeilaoWebClient client;

    @Mock
    private AtualizadorDeLeiloes.ErroCarregaLeiloesListener listener;

    @Test
    public void deve_AtualizarListaDeLeiloes_QuandoBuscarLeiloesDaAPI() throws InterruptedException {

        AtualizadorDeLeiloes atualizador = new AtualizadorDeLeiloes();

        // answer modifica o comportamento do argumento, no caso o(os) métodos do RespostaListener
        // o objetivo final é que, quando o método .todos for chamado, ele fará a execução
        // interna do answer, que é o trecho argument.sucesso - criando uma lista de leilão.
        // interessante observar que no momento que estou fazendo o curso, não consegui configurar
        // o server da API, ainda assim consigo simular o teste. graças ao answer.
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) {
                RespostaListener<List<Leilao>> argument = invocation.getArgument(0);
                // agora! - o codigo abaixo substitui a implementação original do nosso sistema
                argument.sucesso(new ArrayList<>(Arrays.asList(
                        new Leilao("PC"),
                        new Leilao("Carro")
                )));
                return null;
            }
        }).when(client).todos(any(RespostaListener.class));

        atualizador.buscaLeiloes(adapter, client, listener);

        // apos refatorar, o teste agora deve garantir que o metodo todos e o metodo atualiza
        // são chamados
        verify(client).todos(any(RespostaListener.class));
        verify(adapter).atualiza(new ArrayList<>(Arrays.asList(
                new Leilao("PC"),
                new Leilao("Carro")
        )));

    }

    @Test
    public void deve_ApresentarMensagemDeFalha_QuandoFalharABuscaDeLeiloes(){

        AtualizadorDeLeiloes atualizador = (new AtualizadorDeLeiloes());

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                RespostaListener<List<Leilao>> argument = invocation.getArgument(0);
                argument.falha(anyString());
                return null;
            }
        }).when(client).todos(any(RespostaListener.class));

        atualizador.buscaLeiloes(adapter, client, listener);

        verify(listener).ErroAoCarregar(anyString());

    }

}