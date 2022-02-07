package com.example.curso_maratonajava.Javacore.Y_Colecoes.Teste;

import com.example.curso_maratonajava.Javacore.Y_Colecoes.Produto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TesteIterator {

    public static void main(String[] args) {
        
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1, "Mouse",        "45681",    20.50,  10));
        produtos.add(new Produto(2, "Teclado",      "25846",    35.90,  0));
        produtos.add(new Produto(3, "Grampeador",   "15846",    10.35,  30));
        produtos.add(new Produto(4, "Monitor",      "58879",    150.00, 0));
        System.out.println(produtos);
        
        //Usando o Iterator | //hasNext();(verifica se existe proximo elemento na lista) //next();(pega o elemento da lista)
        Iterator<Produto> produtoIterator = produtos.iterator();
        while(produtoIterator.hasNext()){           //ret. um boolean
            Produto p = produtoIterator.next();     //criamos uma var. de ref e usamos o .next para associar ao produto.
            if(p.getQuantidade() == 0){             //usamos o if com a var. de ref. p - para verificar se o produto possui saldo 0
                produtoIterator.remove();           //se retornar true - removemos o item.
            }
            if(produtoIterator.next().getNome().equals("Mouse")){     //outra forma menor de pegar o produto.
                System.out.println("Outro exemplo de pegar o produto...");
            }
        }
        System.out.println(produtos);
        
        
        //Não devemos usar o metodo abaixo para interagir e retirar produtos da lista, não teremos certeza do resultado e erros devem ocorrer.
//        System.out.println(produtos);
//        for (Produto p : produtos) {
//            if (p.getQuantidade() == 0) {
//                produtos.remove(p);
//            }
//        }
//        System.out.println(produtos);
        
    }
    
}
