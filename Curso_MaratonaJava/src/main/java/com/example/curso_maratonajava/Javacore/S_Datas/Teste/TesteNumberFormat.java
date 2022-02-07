package com.example.curso_maratonajava.Javacore.S_Datas.Teste;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class TesteNumberFormat {

    public static void main(String[] args) {
        
        float valor = 123.4567f; //valor para formatar.
        
        Locale locale = new Locale("jp"); //localização para usar na formatação.
        
        NumberFormat[] nfa = new NumberFormat[4]; 
        //Abaixo 2 tipos de formatação mostrando a dif. pela localização.
        nfa[0] = NumberFormat.getInstance();
        nfa[1] = NumberFormat.getInstance(locale);
        nfa[2] = NumberFormat.getCurrencyInstance();
        nfa[3] = NumberFormat.getCurrencyInstance(locale);
        
        for(NumberFormat nf : nfa){
            System.out.println(nf.format(valor));
        }
        
        //Convertendo uma String em NumberFormat...
        NumberFormat nf = NumberFormat.getInstance();
        String valorString = "123.4567";
        
        try {
            System.out.println(nf.parse(valorString));
            nf.setParseIntegerOnly(true); //Desconsidera os numeros decimais.
            System.out.println(valorString); //Vai imprimir sem os numeros decimais
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }
    
}
