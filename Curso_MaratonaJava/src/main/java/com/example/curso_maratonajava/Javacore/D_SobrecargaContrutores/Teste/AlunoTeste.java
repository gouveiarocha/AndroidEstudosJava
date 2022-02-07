package com.example.curso_maratonajava.Javacore.D_SobrecargaContrutores.Teste;

import com.example.curso_maratonajava.Javacore.D_SobrecargaContrutores.Aluno;

public class AlunoTeste {
    
    public static void main(String[] args) {
        
        Aluno a = new Aluno("Douglas", "347.202.728-27");
        a.imprimeDados();
        
        Aluno a2 = new Aluno("Carol", "000.000.000-00", "001");
        a2.imprimeDados();
        
    }
    
}
