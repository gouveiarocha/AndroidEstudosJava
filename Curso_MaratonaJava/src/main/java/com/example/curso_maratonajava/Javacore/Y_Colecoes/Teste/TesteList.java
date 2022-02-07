package com.example.curso_maratonajava.Javacore.Y_Colecoes.Teste;

import java.util.ArrayList;
import java.util.List;

public class TesteList {

    public static void main(String[] args) {

        List<String> nomes = new ArrayList();
        nomes.add("Douglas");
        nomes.add("Caroline");
        nomes.add("OutroNome");
        System.out.println(nomes); //Imprime todos os dados de forma agrupada.

        List<String> nomes2 = new ArrayList<>();
        nomes2.add("Gouveia");

        nomes.set(2, "Alterado...");    //Altera um dado.
        nomes.remove(0);                //Remove pelo indice.
        nomes.remove("Caroline");       //Remove pelo dado.
        //nomes.clear();                //Remove todos.
        nomes.addAll(nomes2);           //Adiciona todos os elementos de uma lista a lista atual.

        System.out.println("Deletou? " + nomes.remove("Nome que não existe"));      //O metodo .remove ret. um boolean...
        System.out.println("Size: " + nomes.size());                             //Tamanho da lista...

        if (!nomes.isEmpty()) {

            for (int i = 0; i < nomes.size(); i++) {    //Imprimindo de forma individual, usando um for...
                //System.out.println(nomes.get(i));
            }

            for (String nome : nomes) {                 //... com foreach
                //System.out.println(nome);
            }

            //nomes.forEach(System.out::println);         //... outra forma de usar o foreach a partir do java 8...

        } else {
            System.out.println("Nenhum dado encontrado...");
        }

    }

}
