package com.example.curso_maratonajava.Javacore.R_String.Teste;

public class TesteStringBuilder {

    public static void main(String[] args) {
        //Lembrem-se que, no exemplo acima, a jvm cria uma nova String.
        String s = "Uma frase comum...";
        s.concat(" teste");

        //Já com a StringBuilder, a jvm não cria uma nova String, apenas adiciona - por isso a economia de recursos.
        //Observar que, para o StringBuilder - usamos o metodo append.
        StringBuilder sb = new StringBuilder(10); //O parametro define a capacidade da StringBuilder.
        sb.append("Uma frase comum StringBuilder"); //adicionamos o trecho "Uma frase comum StringBuilder"
        sb.append(" teste"); //adicionamos o trecho " teste"
        System.out.println(sb); //imprimimos o texto completo.

        //Métodos uteis.
        StringBuilder exemplo = new StringBuilder();
        exemplo.append("0123456789");
        System.out.println(exemplo
                .reverse()          //Escreve a StringBuilder de tras para frente.
                .delete(0, 2)       //Deleta um trecho da StringBuilder.
                .insert(2, "##"));  //Insere um trecho de texto.   

    }

}
