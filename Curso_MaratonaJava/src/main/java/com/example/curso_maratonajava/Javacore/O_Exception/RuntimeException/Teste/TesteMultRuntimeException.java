package com.example.curso_maratonajava.Javacore.O_Exception.RuntimeException.Teste;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class TesteMultRuntimeException {
    
    public static void main(String[] args) {
        
        try{
            
            int a = 10/0;
            System.out.println(a);
            
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("dentro do ArrayIndexOutOfBoundsException");
        }catch(IllegalArgumentException e){
            System.out.println("dentro do IllegalArgumentException");
        }catch(ArithmeticException e){
            System.out.println("dentro do ArithmeticException");
        }finally{
            System.out.println("dentro do finally");
        }
        
        System.out.println("Fim do programa...");
        
        //Exemplo como acima, mas na versão 7 do java é possivel colocar todas as exceções juntas separadas com o pipe
        try{
            throw new IndexOutOfBoundsException();
        }catch(IllegalArgumentException | IndexOutOfBoundsException | ArithmeticException e){
            System.out.println("Dentro da exceção 2...");
        }
        System.out.println("Fim do programa 2...");
        
        //Neste caso é preciso colocar a chamada do metodo em um try-catch e tratar as possiveis excessoes.
        try{
            talvezLanceExcessao();
        }catch(SQLException e){
            
        }catch(FileNotFoundException e){
            
        }
        
        //Mesmo exemplo que acima, mas na versão 7 do java é possivel colocar todas as exceções juntas separadas com o pipe
        try{
            talvezLanceExcessao();
        }catch(SQLException | FileNotFoundException e){
            
        }
        
    }
    
    //O método abaixo esta determinado possivel excessão dos tipos SQLException e FileNotFoundExceptio
    public static void talvezLanceExcessao() throws SQLException, FileNotFoundException{
        
    }

}
