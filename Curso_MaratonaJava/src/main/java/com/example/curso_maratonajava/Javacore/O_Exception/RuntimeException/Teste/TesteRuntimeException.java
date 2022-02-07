package com.example.curso_maratonajava.Javacore.O_Exception.RuntimeException.Teste;

public class TesteRuntimeException {
    
    public static void main(String[] args) {
        
        //Primeira parte das aulas(videos 68 a 70)...
        //aulasParte1();
        
        //Segunda parte das aulas(videos...)...
        try{
            divisao(10, 0);
        }catch(RuntimeException e){
            System.out.println(e.getMessage()); //EX PODE SER EXIBIDO PARA O USUARIO.
            e.printStackTrace();                //EX PODE GRAVAR EM LOG PARA O PROGRAMADOR.
        }
        
        
    }
    
    public static void aulasParte1(){
        /***----------EXEMPLO1 (ArithmeticException) ----------***/
        //Devido um erro na logica do programa:
        //int a = 10 / 0;
        //System.out.println(a);
        
        //Para resolver, bastaria usar um if:
        int a = 10;
        int b = 0;
        if (b != 0) {
            int c = a / b;
            System.out.println(c);
        }else{
            System.out.println("Não é possivel dividir por 0...");
        }
        
        /***----------EXEMPLO2 (NullPointerException) ----------***/
        //Estamos tentando chamar um método toString de um objeto que não existe(ou que é null)...
        //Object o = null;
        //System.out.println(o.toString());
        
        /***----------EXEMPLO3 (ArrayIndexOutOfBoundsException) ----------***/
        //Estamos tentando acessar uma posição do array que não existe...
        //int x[] = new int[2];
        //System.out.println(x[2]);
        
        /***----------COLOCANDO EXEMPLO3 EM UM TRY-CATCH (ArrayIndexOutOfBoundsException) ----------***/
        try{
            int x[] = new int[2];
            System.out.println(x[2]);
            System.out.println("Imprimindo depois de possivel excessão...");
        }catch(RuntimeException e){
            e.printStackTrace();
        }
        System.out.println("Imprimindo depois do try-catch...");
    }
    
    private static void divisao(int num1, int num2){
        //Vamos fazer um teste no segundo numero, e se for igual a 0, lançar o throw...
        if (num2 == 0) {
            //O Throw será criado com a Exception correta, neste caso IllegalArgumentException.
            //O Throw interrompe a execução do codigo.
            throw new IllegalArgumentException("Passe um valor diferente de 0 para o num2...");
        }
        int res = num1/num2;
        System.out.println(res);
    }
    
}
