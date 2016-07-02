/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.alfa.jogo.entidades;

import br.com.munif.alfa.jogo.services.Transportavel;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 * Esta é a classe Personagem que serve para
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personagem implements Transportavel {

    @Id
    @GeneratedValue
    private Long codigo;

    private static int contador = 0;

    public static int getContador() {
        return contador;
    }

    protected String nome;
    /**
     * Se chegar a zero morreu
     */
    private int energia;

    @ManyToOne
    private Lugar lugar;

    public Personagem() { //Seria melhor colocar lugar aqui também
        System.out.println("Executando o construtor sem parâmetros de Personagem");
        nome = "Sem nome";
        energia = 100;
        contador++;
    }

    public Personagem(String nome) {
        System.out.println("Executando o construtor com parâmetros de Personagem");
        this.nome = nome;
        energia = 100;
        contador++;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugarAtual) {
        if (lugar != null) {
            lugar.getPernsonagens().remove(this);
        }

        this.lugar = lugarAtual;
        lugarAtual.getPernsonagens().add(this);

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEnergia(int energia) {
        if (energia >= 0 && energia <= 1000) {
            this.energia = energia;
        } else {
            throw new RuntimeException("Valor da energia inválido(" + energia + ")");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    abstract public String getDescricao();

    @Override
    public String toString() {
        String aRetornar;
        aRetornar = this.nome + " " + this.energia;
        return aRetornar;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object outro) {
        if (this == outro) {
            return true;
        }
        if (outro == null) {
            return false;
        }
        if (getClass() != outro.getClass()) {
            return false;
        }
        final Personagem other = (Personagem) outro;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

}
