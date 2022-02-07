package com.example.curso_maratonajava.Javacore.X_Serializacao.Teste;

import com.example.curso_maratonajava.Javacore.X_Serializacao.Aluno;
import com.example.curso_maratonajava.Javacore.X_Serializacao.Turma;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacao {
    
    public static void main(String[] args) {
        
        gravadorObjeto();
        leitorObjeto();
    
    }
    
    private static void gravadorObjeto(){
        Turma turma = new Turma("Maratona Java");
        Aluno aluno = new Aluno(1L, "Douglas", "12345678");
        aluno.setTurma(turma);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aluno.ser"))) {
            oos.writeObject(aluno);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void leitorObjeto(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aluno.ser"))) {
            Aluno aluno = (Aluno) ois.readObject();
            System.out.println(aluno);
            System.out.println("O password veio como null pois foi definido como transient na classe...");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
