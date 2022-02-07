package com.example.curso_maratonajava.Javacore.A_IntroducaoClasses.Teste;

import com.example.curso_maratonajava.Javacore.A_IntroducaoClasses.Professor;

public class ProfessorTeste {

    public static void main(String[] args) {
        
        //Objeto professor sem inivcialização de atributos para testar metodo com referencia.
        Professor prof = new Professor();

        //Cria um objeto professor e inicializa manualmente seus atributos.
        Professor professor = new Professor();
        professor.nome = "Carlos";
        professor.RG = "56.633.584-5";
        professor.CPF = "347.252.798-95";
        professor.salario = 2500.90;

        //Cria um objeto professor, usando o construtor para inicializar seus atributos.
        Professor professor2 = new Professor("Douglas", "46.611.631-7", "111.111.111-11", 2900.55);
        
        //Imprime usando o metodo com retorno String.
        System.out.println(professor.imprimeDados());

        //Imprime usando um metodo void, com parametro de referencia.
        prof.imprimeDadosReference(professor);
        prof.imprimeDadosReference(professor2);
        
        //Imprime usando um metodo void, que trabalha com o this.
        prof.imprimeDadosThis();
        professor.imprimeDadosThis();
        professor2.imprimeDadosThis();

    }

}
