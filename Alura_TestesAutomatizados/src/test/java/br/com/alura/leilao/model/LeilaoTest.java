package br.com.alura.leilao.model;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import br.com.alura.leilao.builder.LeilaoBuilder;
import br.com.alura.leilao.exception.ExcedeuQuantidadeLanceException;
import br.com.alura.leilao.exception.MesmoUsuarioUltimoLanceException;

import static br.com.alura.leilao.utils.LeilaoConstants.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class LeilaoTest {

    private final double DELTA = 0.0001;
    private final Leilao LEILAO = new Leilao("LeilãoTeste"); //objeto usado para todos os testes.
    private final Usuario USUARIO1 = new Usuario("Douglas");
    private final Usuario USUARIO2 = new Usuario("Carol");

    //Expected Exception
    @Rule
    public ExpectedException exception = ExpectedException.none(); //obrigatorio iniciar com o .none() - que é uma instancia vazia

    // sugestão de estrutura dos testes
    // 1 [nome do metodo] [estado de teste] [resultado esperado]
    // 2 [deve] [resultado esperado] [estado de teste]
    // 3 [resultado esperado] [estado de teste]

    // ex1
    @Test
    public void getDescricao_QuandoRecebeDescricao() {

        // criar cenario de teste
        Leilao console = new Leilao("Console");

        // ação esperada
        String descricaoDevolvida = console.getDescricao();

        // testar resultado
        //assertEquals("Console", descricaoDevolvida);
        assertThat(descricaoDevolvida, is(equalTo("Console")));

    }

    //ex2
    @Test
    public void deve_RetornarMaiorLance_QuandoRecebeApenasUmLance() {
        LEILAO.propoe(new Lance(USUARIO1, 100.0));

        //assertEquals(100, LEILAO.getMaiorLance(), DELTA);
        // usando o closeTo para numeros com ponto flutuante - significa 'perto de'
        assertThat(LEILAO.getMaiorLance(), closeTo(100.0, DELTA));
    }

    //ex3
    @Test
    public void retornarMaiorLance_QuandoRecebeValorEmOrdemCrescente() {
        LEILAO.propoe(new Lance(USUARIO1, 100.0));
        LEILAO.propoe(new Lance(USUARIO2, 200.0));
        assertEquals(200.0, LEILAO.getMaiorLance(), DELTA);
    }

    @Test
    public void retornarMenorLance_QuandoRecebeApenasUmLance() {
        LEILAO.propoe(new Lance(USUARIO1, 100.0));
        assertEquals(100, LEILAO.getMenorLance(), DELTA);
    }

    @Test
    public void retornarMenorLance_QuandoRecebeValorEmOrdemCrescente() {
        LEILAO.propoe(new Lance(USUARIO1, 100));
        LEILAO.propoe(new Lance(USUARIO2, 200.0));
        assertEquals(100, LEILAO.getMenorLance(), DELTA);
    }

    @Test
    public void retornarTresMaioresLancesDoMaiorParaOMenor_QuandoNaoRecebeLances() {
        List<Lance> retornoTresMaioresLances = LEILAO.getTresMaioresLances();
        assertEquals(0, retornoTresMaioresLances.size());
    }

    @Test
    public void retornarTresMaioresLancesDoMaiorParaOMenor_QuandoRecebeSomenteUmLance() {
        LEILAO.propoe(new Lance(USUARIO1, 200.0));
        List<Lance> retornoTresMaioresLances = LEILAO.getTresMaioresLances();
        assertEquals(1, retornoTresMaioresLances.size());
    }

    @Test
    public void retornarTresMaioresLancesDoMaiorParaOMenor_QuandoRecebeSomenteDoisLances() {
        LEILAO.propoe(new Lance(USUARIO1, 200.0));
        LEILAO.propoe(new Lance(USUARIO2, 300.0));
        List<Lance> retornoTresMaioresLances = LEILAO.getTresMaioresLances();
        assertEquals(2, retornoTresMaioresLances.size());
        assertEquals(300.0, retornoTresMaioresLances.get(0).getValor(), DELTA);
    }

    @Test
    public void retornarTresMaioresLancesDoMaiorParaOMenor_QuandoRecebeSomenteTresLances() {
        LEILAO.propoe(new Lance(USUARIO1, 100));
        LEILAO.propoe(new Lance(USUARIO2, 200));
        LEILAO.propoe(new Lance(new Usuario("Pipoca"), 300));
        List<Lance> retornoTresMaioresLances = LEILAO.getTresMaioresLances();

        //assertEquals(3, retornoTresMaioresLances.size());
        // usando hasSize
        assertThat(retornoTresMaioresLances, hasSize(equalTo(3)));

        //assertEquals(300, retornoTresMaioresLances.get(0).getValor(), DELTA);
        // usando hasItem, aqui, foi necessário implementar o equals e hashcode na classe Lance.
        assertThat(retornoTresMaioresLances, hasItem(new Lance(new Usuario("Pipoca"), 300)));

        //assertEquals(200, retornoTresMaioresLances.get(1).getValor(), DELTA);
        //assertEquals(100, retornoTresMaioresLances.get(2).getValor(), DELTA);

        // assertThat com lista
        assertThat(retornoTresMaioresLances, contains(
                new Lance(new Usuario("Pipoca"), 300),
                new Lance(USUARIO2, 200),
                new Lance(USUARIO1, 100)));

        // unico assertThat para atender tudo usando both(ambos) e and(e) - todos os testes acima
        // são dispensaveis, mantive apenas para ter o exemplo do hasSize, hasItem e constains
        assertThat(retornoTresMaioresLances, both(
                Matchers.<Lance>hasSize(3))
                .and(contains(
                        new Lance(new Usuario("Pipoca"), 300),
                        new Lance(USUARIO2, 200),
                        new Lance(USUARIO1, 100))));
    }

    @Test
    public void retornarTresMaioresLancesDoMaiorParaOMenor_QuandoRecebeMaisDeTresLances() {
        LEILAO.propoe(new Lance(USUARIO1, 100));
        LEILAO.propoe(new Lance(USUARIO2, 200));
        LEILAO.propoe(new Lance(new Usuario("Silvia"), 300));
        LEILAO.propoe(new Lance(new Usuario("Carla"), 400));
        List<Lance> retornoTresMaioresLances = LEILAO.getTresMaioresLances();
        assertEquals(3, retornoTresMaioresLances.size());
        assertEquals(400.0, retornoTresMaioresLances.get(0).getValor(), DELTA);
    }

    @Test
    public void retornarValorZeroParaMaiorLance_QuandoNaoHouverLances() {
        double retornoMaiorLance = LEILAO.getMaiorLance();
        assertEquals(0.0, retornoMaiorLance, DELTA);
    }

    @Test
    public void retornarValorZeroParaMenorLance_QuandoNaoHouverLances() {
        double retornoMenorLance = LEILAO.getMenorLance();
        assertEquals(0.0, retornoMenorLance, DELTA);
    }

    // abaixo simulamos testes com exceptions.
    // no curso, o professor ensina a fazer manualmente o lançamento das excecoes no teste, e depois automatiza usando o junit
    // vou manter pelo menos 1 teste como cada forma abordada no curso.

    // teste duplicado para manter a forma manual de aplicação de teste com exceptions
    @Test
    public void naoDeve_AdicionarLance_QuandoForMenorQueOMaiorLance_DuplicadoComExceptionsManual() {
        LEILAO.propoe(new Lance(USUARIO1, 200));
        try {
            LEILAO.propoe(new Lance(USUARIO2, 100));
            // vamos avisar o junit que precisa parar caso não seja lançada a exception e passar uma mensagem de falha
            fail(ESPERADO_EXCEPTION); // avisamos o junit que precisa parar caso não seja lançada a exception
        } catch (RuntimeException exception) {
            // teste passou, mas queremos comparar a mensagem com o assert equals para validar o teste
            assertEquals(ERRO_LANCE_MENOR_QUE_ULTIMO_LANCE, exception.getMessage());
        }
    }

    // Usando Expected Exception
    // 1 regra: tem que ser atributo de classe.
    @Test
    public void naoDeve_AdicionarLance_QuandoForMenorQueOMaiorLance() {
        exception.expect(RuntimeException.class); // ref ao tipo de exception.
        exception.expectMessage(ERRO_LANCE_MENOR_QUE_ULTIMO_LANCE);  // mensagem experada.
        LEILAO.propoe(new Lance(USUARIO1, 200));
        LEILAO.propoe(new Lance(USUARIO2, 100));
    }

    // Usando Expected Exception com uma exception especifica, que nós mesmos criamos. Aqui não
    // precisa mais passar a mensagem, ele compara o tipo da exception lançada
    @Test
    public void naoDeve_AdicionarLance_QuandoForMesmoUsuarioUltimoLance() {
        exception.expect(MesmoUsuarioUltimoLanceException.class);
        LEILAO.propoe(new Lance(USUARIO1, 100));
        LEILAO.propoe(new Lance(USUARIO1, 200));
    }

    // Melhor ainda!!! Agora vamos usar o expected, mas na declaração do teste!!!
    @Test(expected = ExcedeuQuantidadeLanceException.class)
    public void naoDeve_AdicionarLance_QuandoForOSextoLanceDoMesmoUsuario() {
        final Leilao LEILAO = new LeilaoBuilder("LeilãoTeste")
                .lance(USUARIO1, 100.0).lance(USUARIO2, 200.0)
                .lance(USUARIO1, 300.0).lance(USUARIO2, 400.0)
                .lance(USUARIO1, 500.0).lance(USUARIO2, 600.0)
                .lance(USUARIO1, 700.0).lance(USUARIO2, 800.0)
                .lance(USUARIO1, 900.0).lance(USUARIO2, 1000.0)
                .lance(USUARIO1, 1100.0) //n pode ocorrer
                .build();
    }

}