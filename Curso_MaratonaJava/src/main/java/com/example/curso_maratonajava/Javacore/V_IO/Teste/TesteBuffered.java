package com.example.curso_maratonajava.Javacore.V_IO.Teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteBuffered {

    public static void main(String[] args) {

        File file = new File("Arquivo.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));
             BufferedReader br = new BufferedReader(new FileReader(file))) {

            //Escrevendo...
            bw.write("Escrevendo no arquivo 3...");
            bw.newLine(); //método se encarrega de pular a linha de acordo com o S.O
            bw.write("Pulando linha 3...");
            bw.flush();
            bw.close();

            //Lendo...
            String s = null;
            while ((s = br.readLine()) != null) { //O método readLine ret. null quando acabar o arquivo - ou seja, enquanto o ret. for diferente de nulo, vamos escrever a String dentro do while.
                System.out.println(s);
            }
            br.close();

        } catch (IOException ex) {
            Logger.getLogger(TesteBuffered.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
