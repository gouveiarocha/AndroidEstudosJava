package com.example.curso_maratonajava.Javacore.H_Heranca.Teste;

import com.example.curso_maratonajava.Javacore.H_Heranca.Endereco;
import com.example.curso_maratonajava.Javacore.H_Heranca.Funcionario;
import com.example.curso_maratonajava.Javacore.H_Heranca.Pessoa;

public class HerancaTeste {
    
    public static void main(String[] args) {
        
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua das Flores");
        endereco.setBairro("Vila Flor");
        
        Pessoa pessoa = new Pessoa("Caroline");
        pessoa.setCpf("024.680.000-20");
        pessoa.setEndereco(endereco);
        pessoa.imprimeDados();
        
        //Com herança, temos acesso aos atributos e metodos da classe superclasse, na subclasse, como representado abaixo.
        Funcionario funcionario = new Funcionario("Douglas Gouveia", 900);
        funcionario.setCpf("012.345.789-10");
        funcionario.setEndereco(endereco);
        funcionario.imprimeDados();
        funcionario.imprimeReciboDePagamento();
        
    }
    
}
