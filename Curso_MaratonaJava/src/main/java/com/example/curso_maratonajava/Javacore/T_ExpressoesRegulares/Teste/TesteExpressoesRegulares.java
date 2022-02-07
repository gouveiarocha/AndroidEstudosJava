package com.example.curso_maratonajava.Javacore.T_ExpressoesRegulares.Teste;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TesteExpressoesRegulares {
    
    /**
     * Metacaracteres:
     *      \\d = busca todos os digitos.
     *      \\D = tudo o que não for digito.
     *      \\s - espaços em branco - também \t \n \f \r
     *      \\S - caractere que não é branco.
     *      \\w - caracteres de palavras a-z A-Z, digitos e _
     *      \\W - tudo o que não de caracter de palavra.
     *      []  - procura apenas os caracteres especificados dentro dos []
     *             se quiser procurar uma sequencia, basta usar o hifen entre 
     *             as letras, exemplo: [a-cA-D] - vai procurar abc e ABCD - 
     *             o mesmo serve para números, como: [a-cA-D0-9]
     *      0[xX][0-9a-fA-F]  - procura números hexadecimais(java) usando a 
     *             regra dos []. - o 0 a frente é obrigatorio.
     *      ^   - negação
     * 
     * Quantificadores:
     *      ? - zero ou uma ocorrência
     *      * - zero ou mais ocorrências.
     *      + - uma ou mais ocorrências.
     *      {n,m} - custom - ex: de n ate m ocorrências.
     *      () - agrupar ocorrências
     *      | - colocar ou
     *      $ - fim de linha
     *      . - coringa 
     */
    
    public static void main(String[] args) {
        
        int numeroHex = 0x100; //Número hexadecimal no java - faz ref. ao número inteiro 256.
        
        //Exemplos gerais.
        String regex1 = "0[xX]([0-9a-fA-F])+(\\s|$)"; //quero procurar essa expressão...
        String textoExemploGeral = "1 a A X 2"; //...nesse texto.
        String textoExemploGeral2 = "12 0x 0X 0xFFABC 0x10G 0x1"; //...ou nesse, exemplo para hexadecimais.
        
        //Exemplo Regex para busca de e-mails.
        String regex2 = "([\\w\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        String textoExemploEmail = "fulano@hotmail.com, 102Abc@gmail.com, #@!abrao@mail, teste@gmail.com.br, teste@mail";
        
        //Validar um e-mail usando o regex.
        System.out.println("Email válido: " + "#@!abrao@mail.br".matches(regex2)); //ret. true ou false.
        
        //Exemplo Regex para busca de datas.
        String regex3 = "\\d{2}/\\d{2}/\\d{2,4}"; 
        String textoExemploDatas = "05/10/2010 05/5/2015 1/1/01 01/05/95"; // dd/MM/yyyy
        
        //Exemplo usando o ^ (negação)
        String regex4 = "proj([^,])*";
        String textoExemploNegacao = "proj1.bkp, proj1.java, proj1.class, proj1final.java, proj2.bkp, proj2.java, diagrama, texto";
        
        //Códigos do Pattern e Matcher.
        Pattern pattern = Pattern.compile(regex4); //compilando a expressão regular...
        Matcher matcher = pattern.matcher(textoExemploNegacao); //definindo o matcher no texto...
        
        System.out.println("Texto:  " + textoExemploNegacao);
        System.out.println("Indice: 0123456789");
        System.out.println("Expressão: " + matcher.pattern());
        System.out.println("Posições Encontradas: ");
        
        while(matcher.find()){ //Enquanto o while encontrar esse padrão no texto.
            //.start - mostra a posição da expressão encontrada
            //.group - mostra a expressão encontrada
            System.out.println(matcher.start() + " " + matcher.group());
        }
        
    }    
    
}
