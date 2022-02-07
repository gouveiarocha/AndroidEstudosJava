package com.example.curso_maratonajava.Javacore.Y_Colecoes.Teste;

import com.example.curso_maratonajava.Javacore.Y_Colecoes.Produto;
import com.example.curso_maratonajava.Javacore.Y_Colecoes.Produto_ID_COMPARATOR;
import com.example.curso_maratonajava.Javacore.Y_Colecoes.Produto_NOME_Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TesteSortProduto {
    
    public static void main(String[] args) {
        
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1, "Mouse",        "45681",    20.50));
        produtos.add(new Produto(2, "Teclado",      "25846",    35.90));
        produtos.add(new Produto(3, "Grampeador",   "15846",    10.35));
        
        //Collections.sort(produtos);                               //Vai ordenar usando o padrao da classe Produto, no metodo compareTo 
        Collections.sort(produtos, new Produto_NOME_Comparator());  //Para usar o Comparator, basta instanciar a classe criada e já configurada para ordenar pelo nome.
        
        for(Produto p : produtos){
            System.out.println(p);
        }
        
        System.out.println("\n----------Divisor de Exemplo----------\n" );
        
        //Exemplo sort com Array
        Produto[] produtosArray = new Produto[3];
        produtosArray[0] = produtos.get(0);
        produtosArray[1] = produtos.get(1);
        produtosArray[2] = produtos.get(2);
        
        //System.out.println(Arrays.toString(produtosArray)); //Vai imprimir os dados do Array.
        
        //Arrays.sort(produtosArray);                               //Vai ordenar usando o padrao da classe Produto, no metodo compareTo 
        Arrays.sort(produtosArray, new Produto_ID_COMPARATOR());    //Para usar o Comparator, basta instanciar a classe criada e já configurada para ordenar pelo nome.
        
        for (Produto p : produtosArray) {
            System.out.println(p);
        }
        
    }
    
}

//Usando o Comparator Nome - Como ensinado no curso(Criar a classe aqui...)
class ProdutoNomeComparator implements Comparator<Produto>{

    @Override
    public int compare(Produto o1, Produto o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
    
}


