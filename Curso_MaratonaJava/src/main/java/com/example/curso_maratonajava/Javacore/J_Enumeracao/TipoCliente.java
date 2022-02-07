package com.example.curso_maratonajava.Javacore.J_Enumeracao;

public enum TipoCliente {
    
    //-Nas Enumerações, tudo é considerado uma constante.
    //-É possivel trabalhar com atributos, construtores e métodos.
    //-No caso de Construtores, a própria classe chama o construtor. Assim sendo, não é possivel mudar o modificador do construtor para public.
    //-As constantes deve, obrigatoriamente, estaram no topo do codigo(primeira linha válida.)
    
    //CONSTANTES E ATRIBUTOS...
    PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica"){ //Os valores entre os parenteses identificam a constante escolhida, é possivel busca-los com o metodo .getTipo, criado abaixo.
        //Constant Specific Class Body
        public String getId(){ 
            return "B";
        }
    };
    private int tipo;
    private String nome;
    
    //CONSTRUTORES
    private TipoCliente(int tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }
    
    public String getId(){
        return "A";
    }
    
    //GETS
    public int getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }
    
}
