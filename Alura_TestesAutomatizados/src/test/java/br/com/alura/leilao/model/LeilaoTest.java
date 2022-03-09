package br.com.alura.leilao.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    double delta = 0.0001;

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
    public void deve_RetornarMaiorLance_QuandoRecebeApenasUmLance(){
        Leilao leilao = new Leilao("Console");
        leilao.propoe(new Lance(new Usuario("Douglas"), 100.0));
        assertEquals(100, leilao.getMaiorLance(), delta);
    }

    //ex3
    @Test
    public void retornarMaiorLance_QuandoRecebeValorEmOrdemCrescente(){
        Leilao leilao = new Leilao("Computador");
        leilao.propoe(new Lance(new Usuario("Douglas"), 100.0));
        leilao.propoe(new Lance(new Usuario("Carol"), 200.0));
        assertEquals(200.0, leilao.getMaiorLance(), delta);
    }

    //ex3
    @Test
    public void retornarMaiorLance_QuandoRecebeValorEmOrdemDecrescente(){
        Leilao leilao = new Leilao("Computador");
        leilao.propoe(new Lance(new Usuario("Douglas"), 200.0));
        leilao.propoe(new Lance(new Usuario("Carol"), 100.0));
        assertEquals(200.0, leilao.getMaiorLance(), delta);
    }

    @Test
    public void retornarMenorLance_QuandoRecebeApenasUmLance(){
        Leilao leilao = new Leilao("Console");
        leilao.propoe(new Lance(new Usuario("Douglas"), 100.0));
        assertEquals(100, leilao.getMenorLance(), delta);
    }

    @Test
    public void retornarMenorLance_QuandoRecebeValorEmOrdemCrescente(){
        Leilao leilao = new Leilao("Computador");
        leilao.propoe(new Lance(new Usuario("Douglas"), 100));
        leilao.propoe(new Lance(new Usuario("Carol"), 200.0));
        assertEquals(100, leilao.getMenorLance(), delta);
    }

    @Test
    public void retornarMenorLance_QuandoRecebeValorEmOrdemDecrescente(){
        Leilao leilao = new Leilao("Computador");
        leilao.propoe(new Lance(new Usuario("Douglas"), 200.0));
        leilao.propoe(new Lance(new Usuario("Carol"), 100.0));
        assertEquals(100, leilao.getMenorLance(), delta);
    }

}