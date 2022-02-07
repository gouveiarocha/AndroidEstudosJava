package com.example.curso_maratonajava.Javacore.N_Polimorfismo;

public class RelatorioPagamento {
    
    public void relatorioPagamentoGerente(Gerente gerente){
        System.out.println("Gerando relatorio de pagamento de gerentes...");
        gerente.calcularPagamento();
        gerente.toString();
    }
    
    public void relatorioPagamentoVendedor(Vendedor vendedor){
        System.out.println("Gerando relatorio de pagamento de vendedores...");
        vendedor.calcularPagamento();
        System.out.println("Nome: " + vendedor.getNome());
        System.out.println("Salario: " + vendedor.getSalario());
    }
    
    public void relatorioPagamentoGenerio(Funcionario funcionario){
        System.out.println("Gerando relatorio de pagamento genérico...");
        funcionario.calcularPagamento();
        //Vamos usar o if para verificar qual classe a variavel de ref. funcionario esta instanciando...
        if (funcionario instanceof Gerente) { 
            Gerente g = (Gerente) funcionario; //Usando um cast explicito.
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Participação Lucro: " + g.getPnl());
            System.out.println("Salario: " + funcionario.getSalario());
            System.out.println("------------------------------");
        }else if (funcionario instanceof Vendedor) {
            //Vendedor v = (Vendedor) funcionario; //Usando um cast explicito.
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Comissão: " + (((Vendedor) funcionario).getComissaoFinal())); //Fazendo um cast direto, sem criar variavel de ref.
            System.out.println("Salario: " + funcionario.getSalario());
            System.out.println("------------------------------");
        }
        
    }
    
}
