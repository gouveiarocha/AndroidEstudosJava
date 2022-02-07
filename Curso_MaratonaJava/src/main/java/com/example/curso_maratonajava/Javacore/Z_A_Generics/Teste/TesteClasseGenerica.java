package com.example.curso_maratonajava.Javacore.Z_A_Generics.Teste;


import com.example.curso_maratonajava.Javacore.Z_A_Generics.Carro;
import com.example.curso_maratonajava.Javacore.Z_A_Generics.Computador;

import java.util.ArrayList;
import java.util.List;

public class TesteClasseGenerica {

    public static void main(String[] args) {
        
        List<Carro> carrosDisponiveis = new ArrayList<Carro>();
        carrosDisponiveis.add(new Carro("Gol"));
        carrosDisponiveis.add(new Carro("Corsa"));
        ObjetosAlugaveis<Carro> carroAlugavel = new ObjetosAlugaveis(carrosDisponiveis);
        Carro carro = carroAlugavel.alugarObjeto();
        System.out.println("Usando o Carro...");
        carroAlugavel.devolverObjeto(carro);
        
        System.out.println("------------------------");
        
        List<Computador> computadoresDisponiveis = new ArrayList<Computador>();
        computadoresDisponiveis.add(new Computador("DELL"));
        computadoresDisponiveis.add(new Computador("HP"));
        computadoresDisponiveis.add(new Computador("PIXAU"));
        ObjetosAlugaveis<Computador> computadorAlugavel = new ObjetosAlugaveis(computadoresDisponiveis);
        Computador computador = computadorAlugavel.alugarObjeto();
        System.out.println("Usando o Computador...");
        computadorAlugavel.devolverObjeto(computador);
        
    }

}

//Classe Genérica:
//<T> = Type - Define o tipo do objeto
class ObjetosAlugaveis<T> {

    private List<T> disponiveis;

    //No construtor, vamos receber a lista de objetos disponiveis.
    public ObjetosAlugaveis(List<T> objetosDiponiveis) {
        this.disponiveis = objetosDiponiveis;
    }

    //Alugar
    public T alugarObjeto() {
        T t = disponiveis.remove(0);
        System.out.println("Alugando Objeto: " + t);
        System.out.println("Objetos Disponiveis: " + disponiveis);
        return t;
    }

    //Devolver
    public void devolverObjeto(T t) {
        System.out.println("Devolvendo Objeto: " + t);
        disponiveis.add(t);
        System.out.println("Objetos Disponiveis: " + disponiveis);
    }

}

//Podemos ter mais de aum atributo, ex:
class DoisAtributos<T,X,A>{
    T um;
    X dois;
    A tres;
    
    public T getUm() {
        return um;
    }

    public void setUm(T um) {
        this.um = um;
    }

    public X getDois() {
        return dois;
    }

    public void setDois(X dois) {
        this.dois = dois;
    }

    public A getTres() {
        return tres;
    }

    public void setTres(A tres) {
        this.tres = tres;
    }
    
    
}
