package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Java;

public class Conta {

    private int numeroConta;
    private double saldo;

    public double recuperarSaldo() {
        return this.saldo;
    }

    public void depositar(double valorDeposito) {
        this.saldo = this.saldo + valorDeposito;
    }

    public void sacar(double valorSaque) {
        this.saldo = this.saldo + valorSaque;
    }

}
