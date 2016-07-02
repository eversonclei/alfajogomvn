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
public class Bandido extends Personagem {

    private String crime;

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    @Override
    public String getDescricao() {
        return nome + "(" + crime + ")";
    }

}
