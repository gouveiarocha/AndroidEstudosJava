package br.com.alura.leilao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        double valorLance = lance.getValor();

        if (maiorLance > valorLance){
            return;
        }

        lances.add(lance);

        if (lances.size() == 1){
            maiorLance = valorLance;
            menorLance = valorLance;
        }

        Collections.sort(lances); //seta a lista em ordem decrescente do valor

        calculaMaiorLance(valorLance);
        calculaMenorLance(valorLance);

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

    public String getDescricao() {
        return descricao;
    }

    public double getMaiorLance() {
        return maiorLance;
    }

    public double getMenorLance() {
        return menorLance;
    }

    public List<Lance> getLances() {
        return lances;
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
