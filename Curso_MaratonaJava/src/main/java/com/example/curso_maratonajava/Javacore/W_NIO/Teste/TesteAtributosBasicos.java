package com.example.curso_maratonajava.Javacore.W_NIO.Teste;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TesteAtributosBasicos {

    public static void main(String[] args) throws IOException {

        Date primeiroDeDezembro = new GregorianCalendar(2015, Calendar.DECEMBER, 1).getTime();

        //Alterando data modificação usando File.
        File file = new File("ArquivoNovo2.txt");
        file.createNewFile();
        file.setLastModified(primeiroDeDezembro.getTime()); //Altera a data de modificação.
        System.out.println(file.lastModified());
        file.delete();
        System.out.println("-----------------------------");

        //Alterando data modificação usando Path
        System.out.println("Testes Classe Path");
        Path path = Paths.get("NovaPasta\\ArquivoNovo3.txt");
        Files.createFile(path);
        FileTime fileTime = FileTime.fromMillis(primeiroDeDezembro.getTime());  //Cria um fileTime
        Files.setLastModifiedTime(path, fileTime);  //Altera a data de modificação.
        System.out.println(Files.getLastModifiedTime(path));
        Files.deleteIfExists(path);

        //Atributos basicos classe Path
        Path path2 = Paths.get("NovaPasta\\NovoArquivo.txt");
        System.out.println(Files.isReadable(path2));    //leitura...
        System.out.println(Files.isWritable(path2));    //escrita...
        System.out.println(Files.isExecutable(path2));  //executavel...
        System.out.println(Files.exists(path2));        //existe...
        System.out.println("-----------------------------");

        /**
         * Atributos usando as interfaces: Basic(baseado em todos SO) -
         * Posix(Linux) - Dos(Windows/PromptCommand). Essas Classes são usadas
         * apenas para leitura, para alterar os atributos, adiciona-se o View
         * após o nome de cada classe. Para alterar os atributos, temos ainda
         * duas classes além das citadas acima: FileOwnerAttributesView e
         * AclFileAttributesView. Exemplos abaixo.
         */
        
        //BasicFileAttributes - Apenas leitura.
        System.out.println("Testes Interface BasicFileAttributes");
        Path path3 = Paths.get("NovaPasta\\NovoArquivo.txt");
        BasicFileAttributes basicAttrs = Files.readAttributes(path3, BasicFileAttributes.class);
        System.out.println(basicAttrs.creationTime());       //data criação
        System.out.println(basicAttrs.lastAccessTime());     //ultimo acesso...
        System.out.println(basicAttrs.lastModifiedTime());   //data modificação...
        System.out.println(basicAttrs.isDirectory());        //é diretorio?
        System.out.println(basicAttrs.isSymbolicLink());     //é link?
        System.out.println(basicAttrs.isRegularFile());      //é um arquivo?
        System.out.println(basicAttrs.size());               //tamanho...
        //Modificando...
        BasicFileAttributeView basicAttrsView = Files.getFileAttributeView(path2, BasicFileAttributeView.class);
        FileTime fileTime2 = FileTime.fromMillis(System.currentTimeMillis());
        basicAttrsView.setTimes(fileTime2, fileTime2, fileTime2); //Altera na sequencia dos parametros: modificação, acesso e criação.
        basicAttrs = Files.readAttributes(path3, BasicFileAttributes.class); //Após as alterações, é preciso ler novamente o arquivo.
        System.out.println("Apos mudanças das datas:\n" + 
                           "Criação: " + basicAttrs.creationTime() + 
                           " Ultimo Acesso: " + basicAttrs.lastAccessTime() + 
                           " Ultima Alteração: " + basicAttrs.lastModifiedTime());
        System.out.println("-----------------------------");

    }

}
