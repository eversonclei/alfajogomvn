/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.alfa.jogo;

import br.com.munif.alfa.jogo.entidades.Bandido;
import br.com.munif.alfa.jogo.entidades.Heroi;
import br.com.munif.alfa.jogo.entidades.Lugar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author munif
 */
public class Programa {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadePersistencia");
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
//        Lugar l=new Lugar("Casa", "Minha Casa");
//        Heroi h=new Heroi("Java");
//        Bandido b=new Bandido();
//        b.setNome("JavaScript");
//        b.setCrime("bobo");
//        b.setEnergia(10);
//        b.setLugar(l);
//        h.setLugar(l);
//
//        
//        em.persist(b);
//        em.persist(h);
//        em.persist(l);
//        Heroi h=em.find(Heroi.class, 2l);
//        h.setEnergia(200);
        Query q = em.createQuery("from Heroi h where h.lugar.nome like 'Ca%'");
        List<Heroi> herois=q.getResultList();
        
        Heroi um=null;
        for (Heroi h:herois){
            System.out.println("--->"+h);
            um=h;
        }
        
        q = em.createQuery("from Lugar l where :parametro in elements(l.pernsonagens)");
        q.setParameter("parametro", um);
        System.out.println("---->"+q.getSingleResult());


        em.getTransaction().commit();
        emf.close();
        
        
    }
    
}
