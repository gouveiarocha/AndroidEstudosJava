package com.example.curso_maratonajava.Javacore.B_IntroducaoMetodos;

public class Estudante {

    private String nome;
    private int idade;
    private double[] notas;
    private boolean aprovado;

    public Estudante(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void imprimeDados() {
        System.out.println("Estudante {" + "nome=" + nome + ", idade=" + idade + '}');
    }
    
    /**
     * Exercicio: Criar um novo atributo notas. Criar metodo para calcular a media e caso seja maior ou igual a 6,
     *            imprimir aprovado, senão reprovado.
     */
    
    public void calcularMedia(double... notas) {
        this.notas = notas;
        double media = 0;
        for(double nota : notas){
            media += nota;
        }
        media = media / notas.length;
        if (media > 6) {
            this.aprovado = true;
            System.out.println("Média: " + media + " - Aluno " + this.nome + " esta aprovado.");
        } else {
            this.aprovado = false;
            System.out.println("Média: " + media + " - Aluno " + this.nome + " esta reprovado.");
        }
    }
        
    //GETTERS ANT SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public boolean isAprovado() {
        return aprovado;
    }
    
}
