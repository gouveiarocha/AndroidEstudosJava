package com.example.curso_maratonajava.Javacore.L_ClassesAbstratas;

/** Classe Abstract **
Uma classe abtract não pode ser instanciada, ela servirá apenas como modelo para as subclasses, 
isso se aplica no mundo real, onde este exemplo(Funcionario) é de fato um termo abstrato, o 'Funcionario' 
de fato, não existe - é apenas uma classificação.
-Não pode ser instanciada */

public abstract class Funcionario extends Pessoa {
    protected String ctps;
    protected double salario;

    public Funcionario() {
    }

    public Funcionario(String nome, String ctps, double salario) {
        this.nome = nome;
        this.ctps = ctps;
        this.salario = salario;
    }
    
    /** Métodos Abstract (toString e calcularSalario)**
    -Obrigatoriamente as subclasses devem sobescrever esse método.
    -Obrigatoriamente não possui corpo */
    
    @Override
    public abstract String toString();
    
    public abstract void calcularSalario();
   
    //GETS AND SETS
    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
