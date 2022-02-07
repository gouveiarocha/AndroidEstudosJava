package com.example.curso_maratonajava.Javacore.Q_Wrappers.Teste;

public class TesteWrapper {

    public static void main(String[] args) {
        //Tipos primitivos...
        byte bytePrimitivo = 1;
        short shortPrimitivo = 10;
        int intPrimitivo = 100;
        long longPrimitivo = 1000l;
        float floatPrimitivo = 10000.0f;
        double doublePrimitivo = 10000.0d;
        char charPrimtivo = 'a';
        boolean booleanPrimitivo = true;
        
        //Wrappers dos tipos primitivos...
        Byte byteWrapper = 1;
        Short shortWrapper = 1;
        Integer intWrapper = 10;
        Long longWrapper = 1000l;
        Float floatWrapper = 10000.0f;
        Double doubleWrapper = 10000.0d;
        Character charWrapper = 'a';
        Boolean booleanWrapper = true;
        
        //Autoboxing - pegar um tipo primitivo e colocar em um wrapper - como fizemos acima, e no exemplo abaixo
        Integer colocandoUmTipoPrimitivoEmUmWrapper = 100;
        
        //Unboxing - associar uma wrapper a um tipo primitivo, como no exemplo abaixo:
        int i = intWrapper;
        
        //As classes wrappers possibilitaram outras formas de trabalhar com o codigo, como os exemplos abaixo:
        Integer novoInt = new Integer(5);
        Integer novoInt2 = new Integer("10"); //A Wrapper vai tentar converter automaticamente o String em Inteiro.
        System.out.println(novoInt2);
        //Integer novoInt3 = new Integer("a10"); //Aqui, ocorrerá erro em tempo de execução.
        Boolean novoBoolean = new Boolean("OLD"); //Aqui, caso esteja true ou TRUE - ficara TRUE - caso esteja escrito qualquer outra coisa, dara FALSE.
        System.out.println(novoBoolean);
        
        //parse - Usando wrapper para converter valores, exemplo:
        String stringParaConverter = "1000";
        Integer integerConvertido = Integer.parseInt(stringParaConverter); //Convertemos a String stringParaConverte para a Integer integerConvertido
        System.out.println(integerConvertido);
        
        //valueOff - Usado para recuperar o wrapper, exemplo:
        String stringValueOff = "1000";
        Long long1 = Long.valueOf(stringValueOff); //Quero pegar o valor da wrapper 'stringValueOff'
        System.out.println(long1);
        
        //Métodos da classe Character - exemplos
        System.out.println(Character.isDigit('9')); //ret. true se for digito.
        System.out.println(Character.isLetter('1')); //ret. true se for letra.
        System.out.println(Character.isLetterOrDigit('1')); //ret. true se for letra ou digito.
        System.out.println(Character.isUpperCase('a')); //ret. true se for caixa alta.
        System.out.println(Character.isLowerCase('a')); //ret. true se for caixa baixa.
        System.out.println(Character.toUpperCase('a')); //transforma o char em caixa alta.
        System.out.println(Character.toLowerCase('A')); //transforma o char em caixa baixa.
        
    }
}
