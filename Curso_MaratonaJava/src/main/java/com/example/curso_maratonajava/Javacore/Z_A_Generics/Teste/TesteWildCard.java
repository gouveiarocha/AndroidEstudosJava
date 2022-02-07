package com.example.curso_maratonajava.Javacore.Z_A_Generics.Teste;

import java.util.ArrayList;
import java.util.List;

abstract class Animal {

    public abstract void consulta();
}

class Cachorro extends Animal {

    @Override
    public void consulta() {
        System.out.println("Consultando Cachorro...");
    }

}

class Gato extends Animal {

    @Override
    public void consulta() {
        System.out.println("Consultando Gato...");
    }

}

public class TesteWildCard {

    public static void main(String[] args) {

        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(), new Gato()};
        consultarAnimais(cachorros);
        consultarAnimais(gatos);

        List<Cachorro> listaCachorros = new ArrayList<>();
        listaCachorros.add(new Cachorro());
        List<Gato> listaGatos = new ArrayList<>();
        listaGatos.add(new Gato());
        
        //Erro de compilação abaixo, nas coleções, somos obrigados a passar uma lista do mesmo tipo.
        //consultarAnimaisList(listaCachorros);
        //consultarAnimaisList(listaGatos); 
        
        //Agora vai funcionar devido ao caracter coringa no metodo.
        consultarAnimaisList(listaCachorros);   
        consultarAnimaisList(listaGatos);
        
        //Aqui vai funcionar sempre, pois é o mesmo tipo de lista que esta no método.
        List<Animal> listaAnimais = new ArrayList<>();
        consultarAnimaisList(listaAnimais);
    }

    public static void consultarAnimais(Animal[] animais) {
        for (Animal animal : animais) {
            animal.consulta();
        }
        //animais[1] = new Gato();  //Erro de compilação, pois estamos tentando alterar a posição de um array CACHORRO com um GATO.
    }
    
    //Caracter coringa: ? - Usando o caracter coringa, podemos passar listas de animais ou de subclasses de animais, mas fazemos um acordo com o java, onde não podemos adicionar nada na lista dentro do metodo.
    
    public static void consultarAnimaisList(List<? extends Animal> animais) { //com caracter coringa...
        for (Animal animal : animais) {
            animal.consulta();
        }
        //animais.add(new Cachorro()); //Erro devido o caracter coringa, prometemos para o java que não fariamos isso.
    }
    
    public static void consultarCachorroList(List<? super Cachorro> cachorroList){
        Cachorro c1 = new Cachorro();
        Animal c2 = new Cachorro();
        cachorroList.add(new Cachorro());
    }
    
}
