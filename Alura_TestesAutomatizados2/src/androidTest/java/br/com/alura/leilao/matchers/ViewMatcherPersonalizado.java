package br.com.alura.leilao.matchers;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import br.com.alura.leilao.R;
import br.com.alura.leilao.formatter.FormatadorDeMoeda;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

public class ViewMatcherPersonalizado {

    // matcher personalizado
    public static Matcher<? super View> apareceLeilaoNaPosicao(final int posicao, final String descricaoEsperada, final double maiorLanceEsperado) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) {

            }

            @Override
            protected boolean matchesSafely(RecyclerView item) {

                // aqui vamos pegar a view do view holder
                View viewDoViewHolder = item.findViewHolderForAdapterPosition(posicao).itemView;

                // agora pegamos o elemento view item leilao
                TextView textViewDescricao =
                        viewDoViewHolder.findViewById(R.id.item_leilao_descricao);

                // e vamos verificar se é igual a descrição, já extraindo o resultado em um boolean
                boolean temDescricaoEsperada =
                        textViewDescricao.getText().toString().equals(descricaoEsperada);

                // mesmo ex acima, no fim, vamos verificar se é igual ao maior lance, extraindo
                // para um boolean
                TextView textViewMaiorLance =
                        viewDoViewHolder.findViewById(R.id.item_leilao_maior_lance);
                FormatadorDeMoeda formatador = new FormatadorDeMoeda();
                boolean temMaiorLanceEsperado =
                        textViewMaiorLance.getText().toString().equals(formatador.formata(maiorLanceEsperado));

                // por fim, o retorno irá validar nosso matcher.
                return temDescricaoEsperada && temMaiorLanceEsperado && isDisplayed().matches(viewDoViewHolder);

            }
        };
    }

    // matcher personalizado refatorado
    public static Matcher<? super View> apareceLeilaoNaPosicaoRefatorado(final int posicaoEsperada, final String descricaoEsperada, final double maiorLanceEsperado) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {

            private Matcher<View> displayed = isDisplayed();

            private final String maiorLanceFormatadoEsperado
                    = new FormatadorDeMoeda().formata(maiorLanceEsperado);

            @Override
            public void describeTo(Description description) {
                // informa mensagem de referencia no erro
                description.appendText("View com descrição ").appendValue(descricaoEsperada)
                        .appendText(", maior lance ").appendValue(maiorLanceFormatadoEsperado)
                        .appendText(" na posição ").appendValue(posicaoEsperada).appendText(" ");
                description.appendDescriptionOf(displayed);
            }

            @Override
            protected boolean matchesSafely(RecyclerView item) {

                RecyclerView.ViewHolder viewHolderDevolvido = item.findViewHolderForAdapterPosition(posicaoEsperada);
                if (viewHolderDevolvido == null) {
                    throw new IndexOutOfBoundsException("ViewHolder na posição: " + posicaoEsperada + " não foi encontrada...");
                }

                View viewDoViewHolder = viewHolderDevolvido.itemView;
                boolean temDescricaoEsperada = verificaDescricaoEsperada(viewDoViewHolder);
                boolean temMaiorLanceEsperado = verificaMaiorLanceEsperado(viewDoViewHolder);

                displayed = isDisplayed();
                return temDescricaoEsperada && temMaiorLanceEsperado && displayed.matches(viewDoViewHolder);

            }

            private boolean verificaMaiorLanceEsperado(View viewDoViewHolder) {
                TextView textViewMaiorLance =
                        viewDoViewHolder.findViewById(R.id.item_leilao_maior_lance);
                return textViewMaiorLance.getText().toString().equals(maiorLanceFormatadoEsperado);
            }

            private boolean verificaDescricaoEsperada(View viewDoViewHolder) {
                TextView textViewDescricao =
                        viewDoViewHolder.findViewById(R.id.item_leilao_descricao);
                return textViewDescricao.getText().toString().equals(descricaoEsperada);
            }

        };
    }

}
