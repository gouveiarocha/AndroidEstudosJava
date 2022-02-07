package com.example.curso_maratonajava.Javacore.N_Polimorfismo;

public class Vendedor extends Funcionario{
    private double totalVendas;
    private double comissaoFinal;
    private final double PERCENTUAL_COMISSAO = 0.05;
    
    public Vendedor(String nome, double salario, double totalVendas) {
        super(nome, salario);
        this.totalVendas = totalVendas;
    }
    
    @Override
    public void calcularPagamento() {
        comissaoFinal = this.salario + (totalVendas * PERCENTUAL_COMISSAO);
        this.salario = this.salario + comissaoFinal;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public double getComissaoFinal() {
        return comissaoFinal;
    }
    
}
