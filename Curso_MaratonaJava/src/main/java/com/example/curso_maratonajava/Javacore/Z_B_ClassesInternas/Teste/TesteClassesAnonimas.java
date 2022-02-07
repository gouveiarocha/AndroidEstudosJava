package com.example.curso_maratonajava.Javacore.Z_B_ClassesInternas.Teste;

//Classe anonima é executada em determinado ponto do codigo e deixara de existir quando for executada, serve para ex:
import com.example.curso_maratonajava.Javacore.Z_A_Generics.Carro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//- Alterar o comportamento de um método.
class Animal {

    public void andar() {
        System.out.println("Andando...");
    }
}

public class TesteClassesAnonimas {

    public static void main(String[] args) {
        //Normal...
        Animal a = new Animal();
        a.andar();

        //Anonima... Observar abertura e fechamento de chave após instanciar a classe.
        Animal b = new Animal() { //Cria uma nova classe anonima(sem nome)
            @Override
            public void andar() { //Sobescreve o método andar...
                System.out.println("Andando diferente...");
            }
        };
        b.andar(); //Vai chamar o metodo sobescrito da classe anonima.
        
        //---USANDO COM INTERFACE...
        List<Carro> listaCarros = new ArrayList<>();
        listaCarros.add(new Carro("GOL"));
        listaCarros.add(new Carro("CORSA"));
        listaCarros.add(new Carro("CIVIC"));
        listaCarros.add(new Carro("ASTRA"));
        
        //Normal...
        //Collections.sort(listaCarros, new CarroComparator());
        //System.out.println("Normal: " + listaCarros);
        
        //Anonima... Observar que vamos instanciar a classe Comparator dentro do metodo sort...
        Collections.sort(listaCarros, new Comparator<Carro>() {
            @Override
            public int compare(Carro o1, Carro o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        //System.out.println("Anonima: " + listaCarros);
        
        //Anonima com lambda - a lambda reduz o codigo.
        //Collections.sort(listaCarros, (Carro o1, Carro o2) -> o1.getNome().compareTo(o2.getNome()));
        System.out.println("Anonima com Lambda: " + listaCarros);
    }
}

class CarroComparator implements Comparator<Carro> {

    @Override
    public int compare(Carro o1, Carro o2) {
        return o1.getNome().compareTo(o2.getNome());
    }

}
