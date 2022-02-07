package com.example.curso_maratonajava.Javacore.Y_Colecoes;

import java.util.Objects;

public class Celular {
    
    private String nome;
    private String IMEI;

    public Celular(String nome, String IMEI) {
        this.nome = nome;
        this.IMEI = IMEI;
    }
    
    //EQUALS
    //Regras para criar um método equals:
    //1- Reflexivo = x.equals(x) tem que ser true para tudo que for diferente de null
    //2- Simetrico = para x e y diferentes de null, se x.equals(y) == true, logo y.equals(x) tem que ser true
    //3- Transitividade = para x, y, z diferentes de null, se x.equals(y) == true, logo y.equals(x) == true e x.equals(z) == true logo y.equals(z) tem que ser true
    //4- Consistente = x.equals(y) deve sempre retornar o mesmo valor.
    //5- para x diferente de null x.equals(null) tem que retornar false
    
    //Criando o equals manualmente...
    public boolean meuEquals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        Celular outroCelular = (Celular) obj;
        return IMEI != null ? IMEI.equals(outroCelular.getIMEI()) : false;
    }
    
    //Criando atraves da IDE...
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
        
        final Celular other = (Celular) obj;
        if (!Objects.equals(this.IMEI, other.IMEI)) {
            return false;
        }
        
        return true;
    }
    
    //HASHCODE
    //Uma regra: Se x.equals(y) == true então y.hashCode() == x.hashCode() ou vice-versa.
    //Outra regra: y.hashCode() == x.hashCode() - não necessáriamente o equals vai retornar true.
    
    //Criando o hashCode manualmente e simplificadamente.
    public int meuHashCode(){
        return IMEI != null ? IMEI.hashCode() : 1;
    }
    
    //Criando através da IDE.
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.IMEI);
        return hash;
    }

    @Override
    public String toString() {
        return "Celular{" + "nome=" + nome + ", IMEI=" + IMEI + '}';
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }
    
}
