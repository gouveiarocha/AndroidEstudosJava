package com.example.curso_maratonajava.Javacore.E_BlocoDeInicializacao.Teste;

import com.example.curso_maratonajava.Javacore.E_BlocoDeInicializacao.Cliente;

public class ClienteTeste {
    
    public static void main(String[] args) {
        
        Cliente c = new Cliente();
        System.out.println("Exibindo a quantidade de parcelas possiveis: ");
        for(int parcela:c.getParcelas()){
            System.out.print(parcela + " ");
        }
            
    }
    
}
