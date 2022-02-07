package com.example.curso_maratonajava.Javacore.M_Interfaces;

/***SOBRE INTERFACE***
-Serve como um contrato que vai informar o que deve fazer, mas não como deve fazer
-Para interface, usamos a palavra chave implments, e não extends
-Todos os atirbutos são considerados constantes (public static final)
-Todos os metodos são abstracts e public*/

public interface Tributavel {
    
    public static final double IMPOSTO = 0.2;
    double IMPOSTO2 = 0.2; //O 'public static final' é desnecessario.
    
    public abstract void calcularImposto();
    void calcularImposto2(); //O 'public abstract' é desnecessario.
    
}
