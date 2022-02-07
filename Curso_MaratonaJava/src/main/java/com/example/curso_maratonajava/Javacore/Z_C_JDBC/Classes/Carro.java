package com.example.curso_maratonajava.Javacore.Z_C_JDBC.Classes;

import java.util.Objects;

public class Carro {
    
    private Integer id;
    private String placa;
    private String nome;
    private Comprador Comprador;

    public Carro() {
    }
    
    public Carro(String placa, String nome) {
        this.placa = placa;
        this.nome = nome;
    }
    
    public Carro(String placa, String nome, Comprador Comprador) {
        this.placa = placa;
        this.nome = nome;
        this.Comprador = Comprador;
    }

    public Carro(Integer id, String placa, String nome, Comprador Comprador) {
        this.id = id;
        this.placa = placa;
        this.nome = nome;
        this.Comprador = Comprador;
    }

    @Override
    public String toString() {
        return "Carro{" + "id=" + id + ", placa=" + placa + ", nome=" + nome + ", Comprador=" + Comprador + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.placa);
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.Comprador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.Comprador, other.Comprador)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Comprador getComprador() {
        return Comprador;
    }

    public void setComprador(Comprador Comprador) {
        this.Comprador = Comprador;
    }
    
    
    
}
