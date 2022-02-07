package com.example.curso_maratonajava.Javacore.L_ClassesAbstratas;

public class Vendedor extends Funcionario{
    private double totalVendas;
    private double totalComissao;
    private final double PERCENTUAL_COMISSÃO = 0.05;

    public Vendedor() {
    }

    public Vendedor(String nome, String ctps, double salario, double totalVendas) {
        super(nome, ctps, salario);
        this.totalVendas = totalVendas;
    }
    
    @Override
    public void imprime() { //Classe implementad(obrigatoriamente) da classe Pessoa.
        System.out.println("Imprimindo Vendedor...");
    }
    
    @Override
    public void calcularSalario() { //Classe implementad(obrigatoriamente) da classe Funcionario.
        //Acrescenta comissão de 5%
        totalComissao = totalVendas * PERCENTUAL_COMISSÃO;
        this.salario = salario + totalComissao;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", ctps=" + ctps + ", comissao=" + totalComissao + ", salario=" + salario + '}';
    }


}
