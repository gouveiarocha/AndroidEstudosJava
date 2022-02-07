package com.example.curso_maratonajava.Javacore.N_Polimorfismo.Teste;

import com.example.curso_maratonajava.Javacore.N_Polimorfismo.Funcionario;
import com.example.curso_maratonajava.Javacore.N_Polimorfismo.Gerente;
import com.example.curso_maratonajava.Javacore.N_Polimorfismo.RelatorioPagamento;
import com.example.curso_maratonajava.Javacore.N_Polimorfismo.Vendedor;

public class PolimorfismoTeste {
    
    public static void main(String[] args) {
        
        Gerente g = new Gerente("Douglas", 5000, 3500);
        Vendedor v = new Vendedor("Douglas 2", 1500, 35000);
        
        RelatorioPagamento r = new RelatorioPagamento();
        
        r.relatorioPagamentoGenerio(g);
        r.relatorioPagamentoGenerio(v);
        
        //r.relatorioPagamentoGenerio(new Gerente("Carlos", 10000, 2000)); //É possivel criar o objeto diretamente ao passar o parametro
        
        /***POLIMORFISMO***
        Abaixo iniciamos exemplos onde o polimorfismo pode ser aplicado...*/
        
        //Permite(através da Herança) - criar uma variavel de referencia relacionando-a com um objeto.        
        Funcionario f = g;
        System.out.println(f.getSalario()); 
        System.out.println("--------------"); //OU
        Funcionario ff = new Gerente("Douglas 3", 6000, 2000);
        System.out.println(ff.getSalario());
            
    }
    
}
