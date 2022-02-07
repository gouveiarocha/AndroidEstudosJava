package com.example.curso_maratonajava.Javacore.U_ResourceBundle.Teste;

import java.util.Locale;
import java.util.ResourceBundle;

public class TesteResourceBundle {

    /**
     * O ResourceBundle serve para criarmos um arquivo de configuração de
     * strings para diferentes linguas, internacionalizando o programa.
     * Ordem de busca do properties pelo java(ex. francês do canada):
     *  messages_fr_CA.properties
     *  messages_fr.properties
     *  messages_pt_BR.properties //default
     *  messages_pt.properties
     *  messages.properties //basename
     *  se não encontrar, vai lançar uma excessão.
     */
    
    public static void main(String[] args) {

        System.out.println(Locale.getDefault()); //Apenas verificando o locale default.

        //Criando uma variavel de ref. para um ResourceBundle.
        ResourceBundle rb = ResourceBundle.getBundle("messages", new Locale("pt", "BR")); //1par = o titulo do arquivo. //2par = o Locale.
        
        //Recuperando e imprimindo os dados através da key.
        System.out.println(rb.getString("hello")); 
        System.out.println(rb.getString("good.morning"));
        
        //Recuperando do basename messages.properties - ou default
        ResourceBundle rb2 = ResourceBundle.getBundle("messages");
        System.out.println(rb2.getString("show"));
    }

}
