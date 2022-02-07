package com.example.curso_maratonajava.Javacore.S_Datas.Teste;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

public class Douglas {

    public static void main(String[] args) {
        
        gerarCarnePagamento(23, 150, "D:\\CarnePagamentoCorsa.txt");
        
        gerarCarnePagamento(60, 440, "D:\\CarnePagamentoPalio.txt");
        
    }
    
    public static void gerarCarnePagamento(int qtdPar, int valorPar, String path){
        
        Locale locale = new Locale("pt", "BR");
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        
        Calendar vencimento = Calendar.getInstance();
        vencimento.set(2019, Calendar.JUNE, 25);
        
        int idParc = 0;
        int valorTot = 0;
        for (int i = 0; i < qtdPar; i++) {
            idParc++;
            valorTot = valorTot + valorPar;
            String parcela = "Parcela: " + idParc + " - Data: " + df.format(vencimento.getTime()) + " - Valor Pago: R$ " + valorTot;
            vencimento.add(Calendar.MONTH, 1);
            salvarArquivo(path, parcela);
        }
        
    }
    
    public static void salvarArquivo(String caminho, String texto){
        
        File file = new File(caminho);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Douglas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
            bw.write(texto);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Douglas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
