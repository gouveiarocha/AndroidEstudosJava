package br.com.alura.leilao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.leilao.utils.LeilaoConstants;
import br.com.alura.leilao.exception.ExcedeuQuantidadeLanceException;
import br.com.alura.leilao.exception.MesmoUsuarioUltimoLanceException;

public class Leilao implements Serializable {

    private final String descricao;
    private final List<Lance> lances;
    private double maiorLance = 0.0;
    private double menorLance = 0.0;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<>();
    }

    public void propoe(Lance lance) {
        validaLance(lance);

        lances.add(lance);

        double valorLance = lance.getValor();

        if (configuraMaiorMenorlance(valorLance)) return;

        Collections.sort(lances); //seta a lista em ordem decrescente do valor

        calculaMaiorLance(valorLance);
        //calculaMenorLance(valorLance); // n e mais necessario

    }


    private void validaLance(Lance lance) {
        if (lanceMenorQueOUltimo(lance))
            throw new RuntimeException(LeilaoConstants.ERRO_LANCE_MENOR_QUE_ULTIMO_LANCE);

        if (!lances.isEmpty()) {
            Usuario usuarioNovo = lance.getUsuario();

            if (mesmoUsuarioUltimoLance(usuarioNovo))
                throw new MesmoUsuarioUltimoLanceException();

            if (usuarioDeuCincoLances(usuarioNovo))
                throw new ExcedeuQuantidadeLanceException();
        }
    }


    /**
     * Micro Validações
     */

    private boolean lanceMenorQueOUltimo(Lance lance) {
        if (maiorLance > lance.getValor()) {
            return true;
        }
        return false;
    }

    private boolean mesmoUsuarioUltimoLance(Usuario usuarioNovo) {
        Usuario ultimoUsuario = lances.get(0).getUsuario();
        if (usuarioNovo.equals(ultimoUsuario)) {
            return true;
        }
        return false;
    }

    private boolean usuarioDeuCincoLances(Usuario usuarioNovo) {
        int lancesDoUsuario = 0;
        for (Lance l : lances) {
            Usuario usuarioExistente = l.getUsuario();
            if (usuarioExistente.equals(usuarioNovo)) {
                lancesDoUsuario++;
                if (lancesDoUsuario == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Calcula maior e menor lance
     */

    private boolean configuraMaiorMenorlance(double valorLance) {
        if (lances.size() == 1) {
            maiorLance = valorLance;
            menorLance = valorLance;
            return true;
        }
        return false;
    }

    private void calculaMaiorLance(double valorLance) {
        if (valorLance > maiorLance) {
            maiorLance = valorLance;
        }
    }

    private void calculaMenorLance(double valorLance) {
        if (valorLance < menorLance) {
            menorLance = valorLance;
        }
    }

    /**
     * Get and Sets
     */

    public String getDescricao() {
        return descricao;
    }

    public double getMaiorLance() {
        return maiorLance;
    }

    public double getMenorLance() {
        return menorLance;
    }

    public List<Lance> getTresMaioresLances() {
        int qtdTotalLances = lances.size();
        if (qtdTotalLances > 3) qtdTotalLances = 3;
        return lances.subList(0, qtdTotalLances);
    }

    public int getQuantidadeLances() {
        return lances.size();
    }

}
