package com.example.gouveiarocha.appsaulas.Classes.Estudos.Testers;

import com.example.gouveiarocha.appsaulas.Classes.Estudos.Cao;
import com.example.gouveiarocha.appsaulas.Classes.Estudos.Conta;
import com.example.gouveiarocha.appsaulas.Classes.Estudos.Funcionario;
import com.example.gouveiarocha.appsaulas.Classes.Estudos.Passaro;

public class TestaClasses {

    public static void main(String[] args) {

        //SEÇÃO 7 AULAS 45 E 46 (MODIFICADORES DE ACESSO)
        Conta conta = new Conta();
        conta.depositar(100);
        conta.depositar(20);
        conta.sacar(12.50);
        System.out.println(conta.recuperarSaldo());

        //SEÇÃO 7, AULAS 42, 43 E 44 (HERANÇA)
        Cao cao = new Cao();
        //cao.nome = "Mel";     //ATRIBUTO DA SUPERCLASSE ANIMAL
        cao.setNome("Mel");     //USANDO UM SET PARA SETAR O NOME DO CAO
        cao.cor = "Parda";      //ATRIBUTO DA SUPERCLASSE ANIMAL
        cao.peso = 1.90;        //ATRIBUTO DA SUPERCLASSE ANIMAL
        cao.raça = "Poodle";    //ATRIBUTO DA SUBCLASSE CAO
        System.out.println("TESTANTO CÃO");
        System.out.println(cao.getNome() + " " + cao.cor + " " + cao.peso + " " + cao.raça);
        cao.correr();           //METODO DA SUPERCLASSE ANIMAL
        cao.latir();            //METODO DA SUBCLASSE CAO

        Passaro passaro = new Passaro();
        passaro.nome = "Loro";          //ATRIBUTO DA SUPERCLASSE ANIMAL
        passaro.cor = "Jumbo";          //ATRIBUTO DA SUPERCLASSE ANIMAL
        passaro.peso = 0.55;            //ATRIBUTO DA SUPERCLASSE ANIMAL
        passaro.tipo = "Ave terrestre"; //ATRIBUTO DA SUBCLASSE PASSARO
        System.out.println("TESTANTO PASSARO");
        System.out.println(passaro.nome + " " + passaro.cor + " " + passaro.peso + " " + passaro.tipo);
        passaro.correr();               //METODO DA SUPERCLASSE ANIMAL
        passaro.voar();                 //METODO DA SUBCLASSE PASSARO

        //SEÇÃO 7, AULA 41
        Funcionario funcionario = new Funcionario();
        funcionario.nome = "Douglas Gouveia";
        funcionario.salario = 1250.50;
        double salarioRecuperado = funcionario.recuperarSalario(100, 10);
        System.out.println("Salário: " + salarioRecuperado);

    }

}
