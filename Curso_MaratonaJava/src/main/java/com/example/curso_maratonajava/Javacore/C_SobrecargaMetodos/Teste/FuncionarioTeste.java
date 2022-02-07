package com.example.curso_maratonajava.Javacore.C_SobrecargaMetodos.Teste;

import com.example.curso_maratonajava.Javacore.C_SobrecargaMetodos.Funcionario;

public class FuncionarioTeste {

    public static void main(String[] args) {
        
        //Criando um funcionario e imprimindo os dados.
        Funcionario f = new Funcionario();
        f.init("Eternal Oblivion", "310.310.310-10", "15.151.151-5");
        f.imprimeDados();
        
        //Criando um funcionario sobrecarregado e imprimindo os dados.
        Funcionario ff = new Funcionario();
        ff.init("Coiso", "320.320.320-20", "20.200.200.2", 3600.00);
        ff.imprimeDados();
        
    }

}
