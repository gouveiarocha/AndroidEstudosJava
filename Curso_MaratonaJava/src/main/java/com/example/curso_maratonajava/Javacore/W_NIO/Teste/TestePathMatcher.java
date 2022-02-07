package com.example.curso_maratonajava.Javacore.W_NIO.Teste;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class FindAllTest extends SimpleFileVisitor<Path>{
    
    PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*{Test*}.{java,class}");
    
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(matcher.matches(file)){
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
    
}

public class TestePathMatcher {

    public static void main(String[] args) throws IOException {
        
        Path path1 = Paths.get("NovaPasta/DirectoryStream/doc1.bkp");
        Path path2 = Paths.get("doc1.bkp");
        Path path3 = Paths.get("Douglas-Gouveia");
        
        matches(path2, "glob:*.bkp");   //ret. true pois existe o arquivo e não há diretorios no glob
        System.out.println("-------------");
        
        //Outros exemplos
        matches(path1, "glob:*.bkp");   //ret. false - pois esse glob não inclui diretorios
        matches(path1, "glob:**.bkp");  //dois asteristicos (**) ou (**/*) incluem os diretorios - mesmo exemplo acima, mas agora ret. true
        matches(path1, "glob:**");      //busca qualquer tipo de arquivo em qualquer diretorio. ret. true
        System.out.println("-------------");
        
        //Exemplos acima, mas aqui vamos testar se a extensão possui 3 caracteres
        matches(path1, "glob:*.???");
        matches(path1, "glob:**/*.???");
        matches(path1, "glob:**.???");
        System.out.println("-------------");
        
        matches(path3, "glob:{Douglas*,Gouveia*,Rocha*}");   //Procura Douglas ou Gouveia ou Rocha.
        matches(path3, "glob:{Douglas,Gouveia,Rocha}*");     //Mesmo que acima.         
        matches(path3, "glob:{Douglas,Gouveia}");     //Ou um, ou outro.  
        System.out.println("-------------");
        
        Files.walkFileTree(Paths.get("./"), new FindAllTest());
        
    }
    
    private static void matches(Path path, String glob){
        
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
        
    }
    
}
