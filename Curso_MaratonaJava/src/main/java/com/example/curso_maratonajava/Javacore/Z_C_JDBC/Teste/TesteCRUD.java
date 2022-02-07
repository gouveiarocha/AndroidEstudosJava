package com.example.curso_maratonajava.Javacore.Z_C_JDBC.Teste;

import java.util.Scanner;

public class TesteCRUD {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int op;
        while (true) {
            menuPrincipal();
            op = Integer.parseInt(teclado.nextLine());
            if (op == 0) {
                System.out.println("Saindo...");
                break;
            }
            if (op == 1) {
                menuComprador();
                op = Integer.parseInt(teclado.nextLine());
                CompradorCRUD.executar(op);
            }
            if (op == 2) {
                menuCarro();
                        
                op = Integer.parseInt(teclado.nextLine());
                CarroCRUD.executar(op);
            }
        }
    }
    
    private static void menuPrincipal(){
        System.out.println("Digite uma opção: ");
        System.out.println("1. Menu Comprador: ");
        System.out.println("2. Menu Carro: ");
        System.out.println("0. Sair: ");
    }

    private static void menuComprador() {
        System.out.println("Digite uma opção: ");
        System.out.println("1. Inserir Comprador");
        System.out.println("2. Atualizar Comprador");
        System.out.println("3. Listar todos os Compradores");
        System.out.println("4. Buscar Comprador por nome");
        System.out.println("5. Deletar Comprador");
        System.out.println("9. Voltar");
    }
    
    private static void menuCarro() {
        System.out.println("Digite uma opção: ");
        System.out.println("1. Inserir Carro");
        System.out.println("2. Atualizar Carro");
        System.out.println("3. Listar todos os Carros");
        System.out.println("4. Buscar Carro por nome");
        System.out.println("5. Deletar Carro");
        System.out.println("9. Voltar");
    }

}
