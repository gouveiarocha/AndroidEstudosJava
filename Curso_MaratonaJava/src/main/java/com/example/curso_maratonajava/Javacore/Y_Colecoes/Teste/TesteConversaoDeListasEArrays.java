package com.example.curso_maratonajava.Javacore.Y_Colecoes.Teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesteConversaoDeListasEArrays {
    
    public static void main(String[] args) {
        
        //Lista em Array
        List<String> nomesLista = new ArrayList<>();
        nomesLista.add("Douglas");
        nomesLista.add("Caroline");
        nomesLista.add("Heitor");
        nomesLista.add("Davi");
        
        String[] nomesArray = new String[nomesLista.size()];
        nomesLista.toArray(nomesArray); //convertendo...
        
        System.out.println(nomesLista);
        System.out.println(Arrays.toString(nomesArray));
        
        //Array e Lista.
        Integer[] numerosArray = new Integer[4];
        numerosArray[0] = 1;
        numerosArray[1] = 2;
        numerosArray[2] = 3;
        numerosArray[3] = 4;
        
        //Importane: o método asList mantem ambos(Lista e Array) unidos, ou seja o que for alterado em um, será também no outro.
        List<Integer> numerosLista = Arrays.asList(numerosArray);   //convertendo...
        numerosLista.set(0, 10); //Observar que vai mudar tanto no numerosLista como no numerosArray
        //numerosLista.add(5); //esse vai dar erro pois, como avaliado acima, estão unidos e a lista não consegue alterar o tamnho do array;
        
        //Para de fato criamos uma nova lista e ter liberdade, devemos usar o comando addAll, como o exemplo abaixo...
        List<Integer> numerosLista2 = new ArrayList<>();
        numerosLista2.addAll(Arrays.asList(numerosArray));
        numerosLista2.add(30);
        
        System.out.println("Array:" + Arrays.toString(numerosArray));
        System.out.println("Lista1 com asList" + numerosLista);
        System.out.println("Lista2 com addAll" + numerosLista2);
        
    }
    
}
