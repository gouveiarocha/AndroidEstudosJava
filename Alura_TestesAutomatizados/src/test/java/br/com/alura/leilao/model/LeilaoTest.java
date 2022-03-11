package br.com.alura.leilao.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeilaoTest {

    private final double DELTA = 0.0001;
    private final Leilao LEILAO = new Leilao("LeilãoTeste"); //objeto usado para todos os testes.
    private final Usuario USUARIO1 = new Usuario("Douglas");
    private final Usuario USUARIO2 = new Usuario("Carol");

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
        assertEquals("Console", descricaoDevolvida);

    }

    //ex2
    @Test
    public void deve_RetornarMaiorLance_QuandoRecebeApenasUmLance() {
        LEILAO.propoe(new Lance(USUARIO1, 100.0));
        assertEquals(100, LEILAO.getMaiorLance(), DELTA);
    }

    //ex3
    @Test
    public void retornarMaiorLance_QuandoRecebeValorEmOrdemCrescente() {
        LEILAO.propoe(new Lance(USUARIO1, 100.0));
        LEILAO.propoe(new Lance(USUARIO2, 200.0));
        assertEquals(200.0, LEILAO.getMaiorLance(), DELTA);
    }

    //ex3
    @Test
    public void retornarMaiorLance_QuandoRecebeValorEmOrdemDecrescente() {
        LEILAO.propoe(new Lance(USUARIO1, 200.0));
        LEILAO.propoe(new Lance(USUARIO2, 100.0));
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
    public void retornarMenorLance_QuandoRecebeValorEmOrdemDecrescente() {
        LEILAO.propoe(new Lance(USUARIO1, 200.0));
        LEILAO.propoe(new Lance(USUARIO2, 100.0));
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
        LEILAO.propoe(new Lance(USUARIO1, 300.0));
        List<Lance> retornoTresMaioresLances = LEILAO.getTresMaioresLances();
        assertEquals(2, retornoTresMaioresLances.size());
        assertEquals(300.0, retornoTresMaioresLances.get(0).getValor(), DELTA);
    }

    @Test
    public void retornarTresMaioresLancesDoMaiorParaOMenor_QuandoRecebeSomenteTresLances() {
        LEILAO.propoe(new Lance(USUARIO1, 100));
        LEILAO.propoe(new Lance(USUARIO1, 200));
        LEILAO.propoe(new Lance(USUARIO1, 300));
        List<Lance> retornoTresMaioresLances = LEILAO.getTresMaioresLances();
        assertEquals(3, retornoTresMaioresLances.size());
        assertEquals(300, retornoTresMaioresLances.get(0).getValor(), DELTA);
        assertEquals(200, retornoTresMaioresLances.get(1).getValor(), DELTA);
        assertEquals(100, retornoTresMaioresLances.get(2).getValor(), DELTA);
    }

    @Test
    public void retornarTresMaioresLancesDoMaiorParaOMenor_QuandoRecebeMaisDeTresLances() {
        LEILAO.propoe(new Lance(USUARIO1, 100));
        LEILAO.propoe(new Lance(USUARIO1, 200));
        LEILAO.propoe(new Lance(USUARIO1, 300));
        LEILAO.propoe(new Lance(USUARIO1, 400));
        List<Lance> retornoTresMaioresLances = LEILAO.getTresMaioresLances();
        assertEquals(3, retornoTresMaioresLances.size());
        assertEquals(400.0, retornoTresMaioresLances.get(0).getValor(), DELTA);
    }

}