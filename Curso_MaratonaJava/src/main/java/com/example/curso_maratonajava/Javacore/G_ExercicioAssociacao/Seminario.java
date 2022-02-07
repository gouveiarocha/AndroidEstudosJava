package com.example.curso_maratonajava.Javacore.G_ExercicioAssociacao;

public class Seminario {
    
    private String titulo;
    
    private Aluno[] alunos;
    private Professor professor;
    private Local local;

    public Seminario(String titulo) {
        this.titulo = titulo;
    }

    public Seminario() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
    
}
