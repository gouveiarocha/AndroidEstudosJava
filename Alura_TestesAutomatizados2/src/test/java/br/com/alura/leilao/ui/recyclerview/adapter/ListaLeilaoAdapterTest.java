package br.com.alura.leilao.ui.recyclerview.adapter;


import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.alura.leilao.model.Leilao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

// a anotação RunWith retira a necessidade de executar o initMocks a cada teste, ela fará isso de forma automatica
@RunWith(MockitoJUnitRunner.class)
public class ListaLeilaoAdapterTest {

    // mockito cria um objeto simulado para utilizarmos e evitar criar instancia do objeto
    //Context context = Mockito.mock(Context.class);
    // criando o mesmo objeto mockado com a anotação Mock (conceito de injeção de dependencia)
    @Mock
    private Context context;

    // vai criar a instancia a partir de um objeto espião (.spy)
    //ListaLeilaoAdapter adapter = Mockito.spy(new ListaLeilaoAdapter(context));
    // criando o mesmo objeto spy com a anotação Spy (conceito de injeção de dependencia)
    @Spy
    private ListaLeilaoAdapter adapter = new ListaLeilaoAdapter(context);

    @Test
    public void deve_AtualizarListaDeLeiloes_QuandoReceberListaDeLeiloes() {

        // essa chamada inicializa os objetos simulados (no caso o 'context' e o 'adapter')
        //MockitoAnnotations.initMocks(this); n mais necessário devido o @RunWith(MockitoJUnitRunner.class)

        // aqui, instruimos o mockito a não chamar o método real (atualizaLista()) durante o teste
        doNothing().when(adapter).atualizaLista();

        adapter.atualiza(new ArrayList<>(Arrays.asList(
                new Leilao("Console"),
                new Leilao("Computador")
        )));

        int quantidadeLeiloesDevolvida = adapter.getItemCount();

        // instruimos ao mockito que o atualizaLista deve ser chamado. se não, for, o teste falha
        verify(adapter).atualizaLista();

        assertThat(quantidadeLeiloesDevolvida, is(2));

    }

}