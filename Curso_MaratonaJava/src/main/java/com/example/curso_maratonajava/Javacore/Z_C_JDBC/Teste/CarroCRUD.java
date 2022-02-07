package com.example.curso_maratonajava.Javacore.Z_C_JDBC.Teste;

import com.example.curso_maratonajava.Javacore.Z_C_JDBC.Classes.Carro;
import com.example.curso_maratonajava.Javacore.Z_C_JDBC.Classes.Comprador;
import com.example.curso_maratonajava.Javacore.Z_C_JDBC.DB.CarroDAO;

import java.util.List;
import java.util.Scanner;

public class CarroCRUD {
    
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
        Carro c = new Carro();
        System.out.println("Placa: ");
        c.setPlaca(teclado.nextLine());
        System.out.println("Nome: ");
        c.setNome(teclado.nextLine());
        System.out.println("Selecione um dos compradores abaixo: ");
        List<Comprador> compradorList = CompradorCRUD.listar();
        c.setComprador(compradorList.get(Integer.parseInt(teclado.nextLine())));
        CarroDAO.salvar(c);
    }

    private static void atualizar() {
        System.out.println("Selecione o carro que deseja atualizar: ");
        List<Carro> carroList = listar();
        Carro c = carroList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("Novo NOME ou ENTER para manter");
        String nome = teclado.nextLine();
        System.out.println("Nova PLACA ou ENTER para manter");
        String placa = teclado.nextLine();
        if (!nome.isEmpty()) {
            c.setNome(nome);
        }
        if (!placa.isEmpty()) {
            c.setPlaca(placa); 
        }
        CarroDAO.atualizar(c);
    }

    private static void deletar() {
        System.out.println("Selecione o carro que deseja deletar: ");
        List<Carro> carroList = listar();
        Carro c = carroList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("Deletar: " + c.toString());
        System.out.println("Tem Certeza? [S/N]");
        String op = teclado.nextLine();
        if (op.startsWith("s") || op.startsWith("S")) {
            CarroDAO.deletar(c);
        }

    }

    private static List<Carro> listar() {
        List<Carro> carroList = CarroDAO.selecionarTodos();
        for (int i = 0; i < carroList.size(); i++) {
            Carro c = carroList.get(i);
            System.out.println("[" + i + "]= " + carroList.get(i));
        }
        return carroList;
    }

    private static void buscarPorNome(String nome) {
        List<Carro> carroList = CarroDAO.selecionarPorNomeContem(nome);
        for (int i = 0; i < carroList.size(); i++) {
            System.out.println("[" + i + "]= " + carroList.get(i));
        }
    }

}
