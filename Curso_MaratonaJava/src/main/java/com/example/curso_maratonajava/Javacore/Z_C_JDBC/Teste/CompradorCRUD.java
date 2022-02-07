package com.example.curso_maratonajava.Javacore.Z_C_JDBC.Teste;

import com.example.curso_maratonajava.Javacore.Z_C_JDBC.Classes.Comprador;
import com.example.curso_maratonajava.Javacore.Z_C_JDBC.DB.CompradorDAO;

import java.util.List;
import java.util.Scanner;

public class CompradorCRUD {
    
    private static Scanner teclado = new Scanner(System.in);
    
    public static void executar(int op) {
        switch (op) {
            case 1:
                inserir();
                break;
            case 2:
                atualizar();
                break;
            case 3:
                listar();
                break;
            case 4:
                System.out.println("Digite o nome: ");
                buscarPorNome(teclado.nextLine());
                break;
            case 5:
                deletar();
                break;
        }
    }

    private static void inserir() {
        Comprador c = new Comprador();
        System.out.println("Nome: ");
        c.setNome(teclado.nextLine());
        System.out.println("CPF: ");
        c.setCpf(teclado.nextLine());
        CompradorDAO.salvar(c);
    }

    private static void atualizar() {
        System.out.println("Selecione o comprador que deseja atualizar: ");
        List<Comprador> compradorList = listar();
        Comprador c = compradorList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("Novo NOME ou ENTER para manter");
        String nome = teclado.nextLine();
        System.out.println("Novo CPF ou ENTER para manter");
        String cpf = teclado.nextLine();
        if (!nome.isEmpty()) {
            c.setNome(nome);
        }
        if (!cpf.isEmpty()) {
            c.setCpf(cpf);
        }
        CompradorDAO.atualizar(c);
    }

    private static void deletar() {
        System.out.println("Selecione o comprador que deseja deletar: ");
        List<Comprador> compradorList = listar();
        Comprador c = compradorList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("Deletar: " + c.toString());
        System.out.println("Tem Certeza? [S/N]");
        String op = teclado.nextLine();
        if (op.startsWith("s") || op.startsWith("S")) {
            CompradorDAO.deletar(c);
        }

    }

    public static List<Comprador> listar() {
        List<Comprador> compradorList = CompradorDAO.selecionarTodos();
        for (int i = 0; i < compradorList.size(); i++) {
            System.out.println("[" + i + "]= " + compradorList.get(i));
        }
        return compradorList;
    }

    private static void buscarPorNome(String nome) {
        List<Comprador> compradorList = CompradorDAO.selecionarPorNomeContem(nome);
        for (int i = 0; i < compradorList.size(); i++) {
            System.out.println("[" + i + "]= " + compradorList.get(i));
        }
    }

}
