package com.example.curso_maratonajava.Javacore.D_SobrecargaContrutores;

public class Aluno {

    private String nome, CPF, matricula;
    
    /**
     * REGRAS SOBRE CONSTRUTOR DENTRO DE OUTRO CONSTRUTOR:
     *      Apenas um construtor pode chamar outro construtor, ocorrerá erro de compilação caso tentemos chamar um construtor dentro de um metodo.
     *      Ao chamar um construtor dentro de outro, obrigatoriamente deve estar na primeira linha.
     */

    //Construtor default, possibilita criar um objeto sem passar nenhum parametro...
    public Aluno() {
        System.out.println("Construtor Default...");
    }

    //Construtor com sobrecarga, passando nome e CPF...
    public Aluno(String nome, String CPF) {
        this(); //Aqui estamos chamando o construtor default...
        this.nome = nome;
        this.CPF = CPF;
    }

    //Construtor com sobrecarga, observar que aqui é adicionado o atributo matricula em comparação com o construtor acima...
    public Aluno(String nome, String CPF, String matricula) {
        this(nome, CPF); //Aqui estamos chamando o construtor que possui somente o nome e o CPF, que por sua vez tbm chama o construtor default...
        this.matricula = matricula;
    }

    public void imprimeDados() {
        System.out.println("Aluno{" + "nome=" + this.nome + ", CPF=" + this.CPF + ", matricula=" + this.matricula + '}');
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
