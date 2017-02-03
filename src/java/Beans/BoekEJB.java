/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAL.Boek;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Johna
 */
@Stateless
public class BoekEJB {

    @PersistenceContext(unitName = "Web_BoekenMarktPU")
    private EntityManager em;
    
     public List<Boek> GetAllAangebodenBoeken(){
        Query query = em.createNamedQuery("Boek.findAll");
        List<Boek> resultList = query.getResultList();
        return resultList;        
    }
     
    public ArrayList<String> GetAllRichtingen(){
         List<Boek> allBoeken = GetAllAangebodenBoeken();
         ArrayList<String> allRichtingen = new ArrayList<>();
         allRichtingen.add(allBoeken.get(0).getRichting());
         for (Boek boek : allBoeken) {
             if(!allRichtingen.contains(boek.getRichting())){
                 allRichtingen.add(boek.getRichting());
             }
         }
         return allRichtingen;
     }
    
    public List<Boek> FindBoekByRichtTitelIsbn(String richting, String titel, String isbn){
        Query query = em.createNativeQuery("SELECT b FROM Boek b WHERE b.richting = ?, b.titel = ?, b.isbn = ?");
        query.setParameter(1, richting);
        query.setParameter(2, titel);
        query.setParameter(3, isbn);
        List<Boek> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Boek> FindBoekByRichtTitel(String richting, String titel){
        Query query = em.createNativeQuery("SELECT b FROM Boek b WHERE b.richting = ?, b.titel = ?");
        query.setParameter(1, richting);
        query.setParameter(2, titel);
        List<Boek> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Boek> FindBoekByRichtIsbn(String richting, String isbn){
        Query query = em.createNativeQuery("SELECT b FROM Boek b WHERE b.richting = ?, b.isbn = ?");
        query.setParameter(1, richting);
        query.setParameter(2, isbn);
        List<Boek> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Boek> FindBoekByTitelIsbn(String titel, String isbn){
        Query query = em.createNativeQuery("SELECT b FROM Boek b WHERE b.titel = ?, b.isbn = ?");
        query.setParameter(1, titel);
        query.setParameter(2, isbn);
        List<Boek> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Boek> FindBoekByTitel(String titel){
        Query query = em.createNativeQuery("SELECT b FROM Boek b WHERE b.titel = ?");
        query.setParameter(1,titel);
        List<Boek> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Boek> FindBoekByIsbn(String isbn){
        Query query = em.createNamedQuery("Boek.findByIsbn").setParameter("isbn", isbn);
        List<Boek> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Boek> FindBoekByRichting(String richting){
        Query query = em.createNamedQuery("Boek.findByRichting").setParameter("richting", richting);
        List<Boek> resultList = query.getResultList();
        return resultList;
    }
    
    
    
    
    
}
