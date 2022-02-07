package com.example.curso_maratonajava.Javacore.L_ClassesAbstratas;

/** Classe Abstract **
Uma classe abtract não pode ser instanciada, ela servirá apenas como modelo para as subclasses, 
isso se aplica no mundo real, onde este exemplo(Funcionario) é de fato um termo abstrato, o 'Funcionario' 
de fato, não existe - é apenas uma classificação.
-Não pode ser instanciada */

public abstract class Pessoa {
    protected String nome;
    
    /** OBSERVAR **:
    Observar o metodo abstract abaixo, criado apenas para esse exemplo, esse método, por ser abstract, não precisa ser
    implementado nas demais subclasses que forem igualmente abstract(como a classe Funcionario) - mas obrigatoriamente
    deve ser implamentado nas classes concretas(como Gerente e Funcionario). */
    public abstract void imprime();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
