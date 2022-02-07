package com.example.curso_maratonajava.Javacore.S_Datas.Teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Para trabalhar com datas, moedas e localizações, usaremos as classes
 * NumberFormat, Locale, Calendar, Date, DateFormat e SimpleDateFormat
 */
public class TesteManipulacaoDatas {

    public static void main(String[] args) {
        //Classe DATE. Foi a primeira desenvolvida e esta mais de 90% depreciada.
        Date date = new Date(); //A Classe DATE trabalha com milisegundos. Observe isso no segundo exemplo sout.
        System.out.println(date);
        System.out.println(date.getTime()); //Aqui vai imprimir o tempo em ms(desde 01/jan/1970)

        //Classe CALENDAR.
        Calendar calendar = Calendar.getInstance(); //Por ser uma classe abstrata, não podemos criar um objeto - temos que usar o metogo getInstance
        calendar.setTime(date); //É possivel passar um Date para o Calendar.
        System.out.println(calendar); //Todos os dados da classe.
        System.out.println(calendar.getTime()); //Data e hora atual.
        //O Método .get pede uma constant, na classe Calendar, temos varias constantes para trabalhar - exemplo abaixo
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); //Dia do mês.
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); //Dia da semana.
        System.out.println(calendar.get(Calendar.YEAR)); //Ano atual
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR)); //Dia do ano
        
        //Manipulando...
        calendar.add(Calendar.HOUR, 24); //Adiciona 24 horas e muda o dia.
        calendar.add(Calendar.YEAR, 1); //Adiciona 1 ano.
        calendar.roll(Calendar.HOUR, 20); //Adiciona 24 horas, mas (o roll) não muda o dia.
        System.out.println(calendar.getTime());
        
        //Formatando... - Usando formatos predefinidos da classe DateFormat.
        DateFormat[] datas = new DateFormat[6];
        datas[0] = DateFormat.getInstance();
        datas[1] = DateFormat.getDateInstance();
        datas[2] = DateFormat.getDateInstance(DateFormat.SHORT);
        datas[3] = DateFormat.getDateInstance(DateFormat.MEDIUM); 
        datas[4] = DateFormat.getDateInstance(DateFormat.LONG);
        datas[5] = DateFormat.getDateInstance(DateFormat.FULL);
        
        for(DateFormat df : datas){
            System.out.println(df.format(calendar.getTime()));
        }
        
        //Internacionalização com classe Locale...
        calendar.set(2020, Calendar.FEBRUARY, 20); //Setando uma data.
        
        Locale loc = new Locale("it", "IT"); //Vamos usar para alterar o idioma de exibição no nome do pais no sout(linha de codigo 64)
        
        Locale[] locales = new Locale[5];
        locales[0] = new Locale("it", "CH"); //No construtor, passar lingua e/ou pais - de acordo com a ISO 639
        locales[1] = new Locale("hi", "IN");
        locales[2] = new Locale("en");
        locales[3] = new Locale("pt", "PT");
        locales[4] = new Locale("ja");
        
        for (Locale locale : locales) {
            DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL,locale); //Criando um objeto DateFormat e indicando o locale no 2 par. do construtor.
            System.out.println("Local: " + locale.getDisplayCountry(loc) + //ret. país
                               " - Linguagem: " + locale.getDisplayLanguage() + //ret. a linguagem
                               " - Formato de Data: " + df2.format(calendar.getTime())); //ret. a data.
        }
        
        //Datas personalizadas com SimpleDateFormat
        //O SimpleDateFormat usa letras no para criar as datas personalizadas, ver na documentação cada letra correnspondente a cada dado da data.
        Date date2 = new Date();
        String mascara1 = "yyyy.MM.dd G 'as' MM:mm:ss z"; //Criando uma mascara String para faciliar. Tudo entre as aspas simples é desconsiderado no format e entra como texto na visulização.
        String mascara2 = "dd/MM/yy";
        String mascara3 = "dd-MM-yyyy 'as' MM:mm:ss";
        String mascara4 = "'Brasil,' dd 'de' MMMM 'de' yyyy";
        SimpleDateFormat formatador = new SimpleDateFormat(mascara4);
        System.out.println(formatador.format(date2.getTime()));
        
    }
    
}
