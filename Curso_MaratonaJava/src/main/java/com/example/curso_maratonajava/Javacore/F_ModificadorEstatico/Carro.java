package com.example.curso_maratonajava.Javacore.F_ModificadorEstatico;

/**
 * OPERADOR ESTATICO - O operador estatico transforma o atributo/metodo em um
 * membro da classe e não do objeto, ou seja será sempre o mesmo dado para todos
 * os objetos dessa classe.
 */
public class Carro {

    //ATRIBUTOS ESTATICOS(DA CLASSE)
    private static double velocidadeLimite = 240; //Limite máximo para todos os carros construidos(240km/h).

    //ATRIBUTOS DO OBJETO
    private String nome;
    private double velocidadeMaxima; //Velocidade máxima do veiculo.

    //CONSTRUTORES
    public Carro() {
        
    }

    public Carro(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    //PRINT INFO
    public void printInfo() {
        System.out.println("Carro{" + "nome=" + nome + ", velocidadeMaxima=" + velocidadeMaxima + ", velocidadeLimite=" + velocidadeLimite + '}');
    }

    //GETTERS AND SETTERS ESTATICOS
    public static double getVelocidadeLimite() { return velocidadeLimite;
    
    }

    public static void setVelocidadeLimite(double velocidadeLimite) {
        //this.velocidadeLimite = velocidadeLimite; //Não podemos usar o this, pois associa ao objeto, e o metodo é membro da classe.
        Carro.velocidadeLimite = velocidadeLimite;  //Forma correta...
    }
    
    //GETTERS AND SETTERS
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

}
