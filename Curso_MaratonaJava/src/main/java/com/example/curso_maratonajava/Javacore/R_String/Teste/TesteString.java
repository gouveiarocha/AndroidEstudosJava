package com.example.curso_maratonajava.Javacore.R_String.Teste;

/**
 * Regras e informações gerais sobre strings..
 * 1- São imutaveis.
 * 2- A jvm possui um local especifico para armazenar as strings, chamado String constant pool(piscinas de strings)
 * 2.1- Possui o nome constant, justamente por serem imutaveis.
 * 3- Ao tentarmos criar duas Strings iguais, o jvm associa a ref. existente a nova String, economizando recursos.
 */

public class TesteString {

    public static void main(String[] args) {
        //Criando Strings de duas formas e explicando as diferenças:
        String nome = "Douglas"; //apenas cria a string no String constant pool
        String sobrenome = new String("Gouveia"); //1- cria a variavel de ref. 2- cria um objeto do tipo string. 3- cria a variavel no String constant pool
        //Portanto, para economizar recursos, é aconselahvel criarmos apenas da primeira forma, o proprio java informa a redundancia e sugere a mudança.
        
        //O metodo concat contatena a variavel com o texto do parametro. Mas, cria uma nova variavel.
        sobrenome.concat(" Rocha"); //Apenas criou-se uma nova String, observar que o proprio java sugere criar uma ref. para essa variavel.
        
        //Nesta impressão, vamos mostrar apenas o nome e o sobrenome - o texto concatenado não vai aparecer pois trata-se de outra String
        System.out.println(nome + " " + sobrenome);
        
        //Agora sim, estamos trocando a referencia do sobrenome para a nova String - quando imprimirmos, vai motrar o nome completo
        sobrenome = sobrenome.concat(" Rocha");
        System.out.println(nome + " " + sobrenome);
        
        //Exemplo onde a jvm economiza recursos, dentro da String constant pool, a String nome2 esta sendo referenciada na nome1, evitando-se criar uma nova referencia.
        String nome1 = "Heitor";
        String nome2 = "Heitor";
        
        //Alguns exemplos de métodos uteis da classe String.
        String exemplo1 = "Exemplos";
        String exemplo2 = "EXEMPLOS";
        String exemplo3 = "0123456789";
        String exemplo4 = "   0123456789   ";
        System.out.println(exemplo1.charAt(3)); //ret. o char em uma posição na String - no par. é passado o indice.
        System.out.println(exemplo1.equals(exemplo2)); //compara se as Strings são iguais e retorna um boolean (não ignora o case sensitive)
        System.out.println(exemplo1.equalsIgnoreCase(exemplo2)); //compara se as Strings são iguais(ignora o case sensitive) e retorna um boolean
        System.out.println(exemplo1.length()); //ret. o tamanho da String
        System.out.println(exemplo1.replace("os", "OS")); //substitui um valor ou sequenciade valores.
        System.out.println(exemplo1.toUpperCase()); //transforma o texto em caixa alta
        System.out.println(exemplo1.toLowerCase()); //transforma o texto em caixa baixa
        System.out.println(exemplo3.substring(0,2)); //quebra a string, ret. um determinado intervalo
        System.out.println(exemplo4.trim()); //retira os espaços em do começo e fim da string
        
    }
    
}
