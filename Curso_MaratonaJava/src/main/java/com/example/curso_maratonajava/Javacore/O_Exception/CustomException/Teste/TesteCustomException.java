package com.example.curso_maratonajava.Javacore.O_Exception.CustomException.Teste;

import com.example.curso_maratonajava.Javacore.O_Exception.CustomException.LoginInvalidoException;

public class TesteCustomException {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }
    }
    
    private static void logar() throws LoginInvalidoException{
        //Dados capturados do banco...
        String usuario = "douglas";
        String senha = "123";
        
        //Dados digitados...
        String usuarioD = "douglas";
        String senhaD = "123";
        
        //Verificação...
        if (usuario.equals(usuarioD) && senha.equals(senhaD)) {
            System.out.println("Login efetuado com sucesso...");
        }else{
            throw new LoginInvalidoException();
        }
    }
            
}
