package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Java;

public class Funcionario {

    //ATRIBUTOS
    public String nome;
    public double salario;

    //METODOS
    public double recuperarSalario(double bonus, double descAdicional) {
        this.salario = this.salario - (this.salario * 0.1);
        return this.salario + bonus - descAdicional;
        //System.out.println("Salario: " + this.salario);
    }

}
