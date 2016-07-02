/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.alfa.jogo.entidades;

import javax.persistence.Entity;

/**
 *
 * @author munif
 */
@Entity
public class Heroi extends Personagem {
    
    private String identidadeSecreta;

    public Heroi() {
        System.out.println("Executando o construtor de Heroi sem parâmetros");
        identidadeSecreta = nome;
    }

    public Heroi(String identidadeSecreta) {
        super("Ultra " + identidadeSecreta);
        System.out.println("Executando o construtor de Heroi com parâmetros");
        this.identidadeSecreta = identidadeSecreta;
    }

    public String getIdentidadeSecreta() {
        return identidadeSecreta;
    }

    public void setIdentidadeSecreta(String identidadeSecreta) {
        this.identidadeSecreta = identidadeSecreta;
    }

    @Override
    public String toString() {
        return super.toString() + " " + identidadeSecreta;
    }

    @Override
    public String getDescricao() {
        return nome + "(" + identidadeSecreta + ")";
    }
    
    

}
