package com.example.curso_maratonajava.Javacore.J_Enumeracao;

public class Cliente {
    
    //Também é possivel integrar a Enumeração na propria classe, como abaixo.
    public enum TipoFormaPagamento {
    DINHEIRO, DEBITO, CREDITO, CHEQUE;
    }
    
    private String nome;
    private TipoCliente tipoCliente; //Cria um tipoCliente de relacionamento com a classe Enum TipoCliente.
    private TipoFormaPagamento tipoPagamento; //Cria um tipoCliente de relacionamento com a mesma classe, integrando o enum TipoFormaPagamento
    
    /** //ATRIBUTOS ANTIGOS, SEM ENUMERAÇÃO.
    //public static final int PESSOA_FISICA = 1;
    //public static final int PESSOA_JURIDICA = 2;
    //public int tipoCliente;*/
    
    //COSNTRUTOR USANDO ENUMERAÇÃO.
    public Cliente(String nome, TipoCliente tipoCliente, TipoFormaPagamento tipoPagamento) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.tipoPagamento = tipoPagamento;
    }
    
    /** //CONSTRUTOR SEM ENUMERAÇÃO.
    public Cliente(String nome, int tipoCliente) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
    }*/
    
    //TOSTRING COM ENUMERAÇÃO
    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", tipo=" + tipoCliente.getNome() + ", numeroTipoCliente="+ tipoCliente.getTipo() + ", pagamento=" + tipoPagamento + '}';
    }
    
    /** //TOSTRING SEM ENUMERAÇÃO
    @Override
    public String toString() {
        String tipo;
        if (this.tipo == 1) {
            tipo = "Pessoa física...";
        } else {
            tipo = "Pessoa jurídica...";
        }
        return "Cliente{" + "nome=" + nome + ", tipo=" + tipo + '}';
    }*/
    
    //GETS AND SETS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
}
