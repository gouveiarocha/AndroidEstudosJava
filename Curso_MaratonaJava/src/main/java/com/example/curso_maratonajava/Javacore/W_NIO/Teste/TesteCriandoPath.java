package com.example.curso_maratonajava.Javacore.W_NIO.Teste;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteCriandoPath {

    public static void main(String[] args) {

        ResourceBundle rb = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));

        //Utilizando a interface Path com a classe Paths. Observar nos exemplos as formas possivels de caminho
        Path p1 = Paths.get("D:\\Teste\\Arquivo.txt"); //ou
        Path p2 = Paths.get("D:\\Teste", "Arquivo.txt"); //ou
        Path p3 = Paths.get("D:", "Teste", "Arquivo.txt");
        System.out.print(p1.toAbsolutePath() + "\n" + p2.toAbsolutePath() + "\n" + p3.toAbsolutePath()); //Imprime o caminho absoluto

        //Exemplo de conversão de um objeto File para Path e vice-versa
        File file = new File("D:\\Teste\\Teste.txt");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(TesteCriandoPath.class.getName()).log(Level.SEVERE, null, ex);
        }
        Path p4 = file.toPath(); //Cria uma novo Path usando o file.
        System.out.println(p4.toAbsolutePath());

        //Criando um novo diretorio e um novo arquivo com o Path
        Path directory = Paths.get("NovaPasta\\SubPasta");
        Path arquivo = Paths.get("NovaPasta\\NovoArquivo.txt");
        try {

            //IF Para o Diretorio.
            if (Files.notExists(directory)) {
                //Files.createDirectory(p6);            //Para criar um diretorio único, sem subdiretorios.
                Files.createDirectories(directory);     //Cria um novo diretorio e subdiretorios, se houver. //O .getParent elimina o último registro
                System.out.println("Diretorio criado com sucesso!");
            } else {
                System.out.println(rb.getString("directory.exist"));
            }

            //IF Para o arquivo.
            if (Files.notExists(arquivo)) {
                Files.createFile(arquivo);           //Cria um novo arquivo.
                System.out.println("Arquivo criado com sucesso!");
            } else {
                System.out.println(rb.getString("file.exist"));
            }

        } catch (IOException ex) {
            Logger.getLogger(TesteCriandoPath.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Copiando um arquivo.
        Path source = arquivo;                                          //Arquivo fonte a ser copiado(origem).
        Path target = Paths.get("NovaPasta\\NovoArquivoCopiado.txt");   //Arquivo copiado, ou destino.
        try {
            if (Files.notExists(target)) {
                Files.copy(source, target);    //Copia o arquivo, caso não exista.
            }
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);   //Esse exemplo esta fora do IF, mas não vai ocorrer erro pois estamos usando no 3º par. um metodo para re-escrever o arquivo.
        } catch (IOException ex) {
            Logger.getLogger(TesteCriandoPath.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Deletando um arquivo.
        try {
            Files.deleteIfExists(target); //Usamos o mesmo metodo para deletar arquivos e diretorios.
        } catch (IOException ex) {
            Logger.getLogger(TesteCriandoPath.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
