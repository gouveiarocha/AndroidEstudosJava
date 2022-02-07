package com.example.curso_maratonajava.Javacore.F_ModificadorEstatico;

/**
 * BLOCO DE INICIALIZAÇÃO - O Bloco de inicialização é util quando é necessário
 * inicializar atributos. É recomendavel utiliza-lo aos construtores, que devem
 * ser o mais limpo possivel, apenas com objetivo de 'construir' de fato cada
 * objeto, e não inicializar seus atributos. Para criar, basta abrir e fechar as
 * chaves. Boas praticas recomenda cria-lo antes dos construtores.
 */

public class Cliente {
    
    // 0º- Bloco de inicialização estatico é executado
    // 1º- Alocado espaço na memória para objeto criado.
    // 2º- Cada atributo da classe é criado e inicializado com seus valores default ou valores explicitos.
    // 3º- Bloco de inicialização é executado.
    // 4º- O Construtor é executado.
    
    private static int[] parcelas;

    //BLOCO DE INICIALIZAÇÃO ESTATICO. Vira um membro da classe e é executado apenas uma vez.
    static {
        int qtdParcelasMaxima = 50;
        parcelas = new int[qtdParcelasMaxima];
        System.out.println("Dentro do bloco de inicialização...");
        for (int i = 1; i <= qtdParcelasMaxima; i++) {
            parcelas[i - 1] = i;
        }
    }

    //CONSTRUTORES
    public Cliente() {
        System.out.println("Dentro do construtor...");
    }

    //GETTERS AND SETTERS
    public static int[] getParcelas() {
        return parcelas;
    }

    public static void setParcelas(int[] parcelas) {
        Cliente.parcelas = parcelas;
    }

}
