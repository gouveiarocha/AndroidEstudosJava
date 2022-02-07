package com.example.curso_maratonajava.Javacore.Y_Colecoes;

import java.util.Comparator;

public class Produto_ID_COMPARATOR implements Comparator<Produto>{

    @Override
    public int compare(Produto o1, Produto o2) {
        Integer ID1 = o1.getID();
        Integer ID2 = o2.getID();
        return ID1.compareTo(ID2);
    }
    
    

}
