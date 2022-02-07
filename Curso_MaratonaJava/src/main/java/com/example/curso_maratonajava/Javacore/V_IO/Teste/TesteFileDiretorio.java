package com.example.curso_maratonajava.Javacore.V_IO.Teste;

import java.io.File;
import java.io.IOException;

public class TesteFileDiretorio {

    public static void main(String[] args) throws IOException {

        //Cria diretorio...
        File diretorio = new File("D:\\Folder");
        System.out.println("Criou Diretorio: " + diretorio.mkdir());

        //Cria arquivo dentro do diretorio...
        File arquivo = new File(diretorio, "arquivo.txt"); //É possivel passar o diretorio criado anteriormente.
        System.out.println("Criou Arquivo: " + arquivo.createNewFile());

        //Renomear arquivo...
        File arquivoRenomeado = new File(diretorio, "arquivo renomeado.txt");
        System.out.println("Renomeou arquivo: " + arquivo.renameTo(arquivoRenomeado));

        //Renomear diretrio...
        File diretorioRenomeado = new File("D:\\Folder2");
        System.out.println("Renomeou diretorio: " + diretorio.renameTo(diretorioRenomeado));

        buscarArquivo();

    }

    //Buscando arquivos, método mais básico e simples.
    public static void buscarArquivo() {
        File file = new File("D:\\Folder2"); //A pasta na qual queremos buscar.
        String[] list = file.list(); //O método list ret. um array de Strings
        for (String s : list) {
            System.out.println(s);
        }
    }

}
