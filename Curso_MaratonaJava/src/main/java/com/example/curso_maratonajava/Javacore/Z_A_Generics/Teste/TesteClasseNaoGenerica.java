package com.example.curso_maratonajava.Javacore.Z_A_Generics.Teste;

import com.example.curso_maratonajava.Javacore.Z_A_Generics.Carro;
import com.example.curso_maratonajava.Javacore.Z_A_Generics.Computador;

import java.util.ArrayList;
import java.util.List;

public class TesteClasseNaoGenerica {

    public static void main(String[] args) {

        CarroAlugavel carro = new CarroAlugavel();
        Carro carroAlugado = carro.alugarCarro();
        System.out.println("Usando o carro: " + carroAlugado);
        carro.devolverCarro(carroAlugado);

        System.out.println("-------------------------------------------------");

        ComputadorAlugavel computador = new ComputadorAlugavel();
        Computador computadorAlugado = computador.alugarComputador();
        System.out.println("Usando o computador: " + computadorAlugado);
        computador.devolverComputador(computadorAlugado);

    }

}

class CarroAlugavel {

    private List<Carro> carrosDisponiveis = new ArrayList<>();

    {
        carrosDisponiveis.add(new Carro("Gol"));
        carrosDisponiveis.add(new Carro("Corsa"));
    }

    //Alugar
    public Carro alugarCarro() {
        Carro c = carrosDisponiveis.remove(0);
        System.out.println("Alugando Carro: " + c);
        System.out.println("Carros Disponiveis: " + carrosDisponiveis);
        return c;
    }

    //Devolver
    public void devolverCarro(Carro c) {
        System.out.println("Devolvendo Carro: " + c);
        carrosDisponiveis.add(c);
        System.out.println("Carros Disponiveis: " + carrosDisponiveis);
    }

}

class ComputadorAlugavel {

    private List<Computador> computadoresDisponiveis = new ArrayList<>();

    {
        computadoresDisponiveis.add(new Computador("DELL"));
        computadoresDisponiveis.add(new Computador("HP"));
        computadoresDisponiveis.add(new Computador("PIXAU"));
    }

    //Alugar
    public Computador alugarComputador() {
        Computador c = computadoresDisponiveis.remove(0);
        System.out.println("Alugando Computador: " + c);
        System.out.println("Computadores Disponiveis: " + computadoresDisponiveis);
        return c;
    }

    //Devolver
    public void devolverComputador(Computador c) {
        System.out.println("Devolvendo Computador: " + c);
        computadoresDisponiveis.add(c);
        System.out.println("Computadores Disponiveis: " + computadoresDisponiveis);
    }

}
