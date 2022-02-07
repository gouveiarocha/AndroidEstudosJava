package com.example.curso_maratonajava.Javacore.O_Exception.CheckedExceptions.Teste;

import com.example.curso_maratonajava.Javacore.O_Exception.CheckedExceptions.Funcionario;
import com.example.curso_maratonajava.Javacore.O_Exception.CheckedExceptions.Pessoa;
import com.example.curso_maratonajava.Javacore.O_Exception.CustomException.LoginInvalidoException;

import java.io.FileNotFoundException;
import javax.security.auth.login.LoginException;

public class TesteSobescritaComException {
    public static void main(String[] args) {
        
        Funcionario f = new Funcionario();
        Pessoa p = new Pessoa();
        
        //Método sobescrito, sem exceção declarada na criação.
        f.salvar();
        
        //Método sobescrito, com apenas uma exceção.
        try {
            f.salvar2();
        } catch (LoginException e) {
            e.printStackTrace();
        }
        
        //Método da superclasse, com as duas exceções.
        try {
            p.salvar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
