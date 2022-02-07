package com.example.curso_maratonajava.Javacore.Y_Colecoes;

import java.awt.List;
import java.util.Comparator;
import java.util.Objects;

public class Produto implements Comparable<Produto> {

    private int ID;
    private String nome;
    private String serial;
    private double preco;
    private int quantidade;

    public Produto(int ID, String nome, String serial, double preco) {
        this.ID = ID;
        this.nome = nome;
        this.serial = serial;
        this.preco = preco;
    }

    public Produto(int ID, String nome, String serial, double preco, int quantidade) {
        this.ID = ID;
        this.nome = nome;
        this.serial = serial;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.serial);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.serial, other.serial)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "ID=" + ID + ", nome=" + nome + ", serial=" + serial + ", preco=" + preco + ", quantidade=" + quantidade + '}';
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int compareTo(Produto otherObjetc) {
        //negativo se thisObject < otherObjetc
        //zero se thisObject == otherObjetc
        //postivio se thisObject > otherObject
        Integer d = ID;
        return d.compareTo(otherObjetc.getID());
    }

}
