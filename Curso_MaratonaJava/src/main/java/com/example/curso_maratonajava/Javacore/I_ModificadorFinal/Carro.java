package com.example.curso_maratonajava.Javacore.I_ModificadorFinal;

public class Carro {
    
    public static final double VELOCIDADE_MAXIMA = 220;
    private final Comprador comprador = new Comprador();
    private String nome;
    private String marca;

    @Override
    public String toString() {
        return "Carro{" + "nome=" + nome + ", marca=" + marca + '}';
    }
    
    //Um métodos final não pode ser sobrescrito pela subclasse.
    public final void imprimeDados(){
            System.out.println("Dados do carro...");
    }

    public static double getVELOCIDADE_MAXIMA() {
        return VELOCIDADE_MAXIMA;
    }

    public Comprador getComprador() {
        return comprador;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
}
