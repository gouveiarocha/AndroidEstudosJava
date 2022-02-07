package com.example.curso_maratonajava.Javacore.N_Polimorfismo.Teste;

import com.example.curso_maratonajava.Javacore.N_Polimorfismo.ArquivoDAOImpl;
import com.example.curso_maratonajava.Javacore.N_Polimorfismo.GenericDAO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TesteDAO {
    
    public static void main(String[] args) {
        
        /**No exemplo abaixo, trabalhamos com orientação a interface - observe que é possivel alternar entre objetos
        ArquivosDAOImpl ou DatabaseDAOImpl - usando a Interface GenericDAO.*/
        GenericDAO DAO = new ArquivoDAOImpl();
                    //ou new DatabaseDAOImpl();
        DAO.save();
        
        /**Esse tipo de procedimento é muito usado em coleções, como no exemplo abaixo, onde podemos mudar o objeto de
        ArrayList para LinkedList sem erros de compilação, usando a interface List.*/
        List<String> lista = new ArrayList<>();
                        //ou new LinkedList<>();
        lista.add("nome 1");
        lista.add("nome 2");
        lista.add("nome 3");
        for (String nome:lista) {
            System.out.println(nome);
        }
        
    }

}
