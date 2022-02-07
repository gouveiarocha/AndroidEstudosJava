package com.example.curso_maratonajava.Javacore.Y_Colecoes;

import java.util.Comparator;

public class Produto_NOME_Comparator implements Comparator<Produto>{

    @Override
    public int compare(Produto o1, Produto o2) {
        return o1.getNome().compareTo(o2.getNome());
    }

}
