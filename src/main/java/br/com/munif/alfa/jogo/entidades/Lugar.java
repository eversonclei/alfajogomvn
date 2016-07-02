/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.alfa.jogo.entidades;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Lugar {
    
    @Id @GeneratedValue
    private Long codigo;

    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "lugar")
    private List<Personagem> pernsonagens;

    public Lugar() {
        init();
    }

    public Lugar(String nome, String descricao) {
        init();
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    

    public List<Personagem> getPernsonagens() {
        return pernsonagens;
    }

    public void setPernsonagens(List<Personagem> pernsonagens) {
        this.pernsonagens = pernsonagens;
    }

    public String getNome() {
        return nome;
    }

    private void init() {
        pernsonagens = new LinkedList<>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Lugar{" + "nome=" + nome + ", descricao=" + descricao + '}';
    }

}
