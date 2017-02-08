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
    
     public List<Boek> getAllBoeken(){
        Query query = em.createNamedQuery("Boek.findAll");
        List<Boek> resultList = query.getResultList();
        return resultList;        
    }
     
     public Boek getbyId(int id){
        Query query = em.createNamedQuery("Boek.findById").setParameter("id", id);
        Boek b = (Boek)query.getSingleResult();
        return b;        
    }
     
    public ArrayList<String> getAllRichtingen(){
         List<Boek> allBoeken = getAllBoeken();
         ArrayList<String> allRichtingen = new ArrayList<>();
         allRichtingen.add(allBoeken.get(0).getRichting());
         for (Boek boek : allBoeken) {
             if(!allRichtingen.contains(boek.getRichting())){
                 allRichtingen.add(boek.getRichting());
             }
         }
         return allRichtingen;
     }
    
    public List<Boek> findBoekByRichtTitelIsbn(String richting, String titel, String isbn){
        Query query = em.createNativeQuery("SELECT * FROM tbl_boeken b WHERE b.richting = ? AND b.titel = ? AND b.isbn = ?", Boek.class);
        query.setParameter(1, richting);
        query.setParameter(2, titel);
        query.setParameter(3, isbn);
        List<Boek> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Boek> findBoekByRichtTitel(String richting, String titel){
        Query query = em.createNativeQuery("SELECT * FROM tbl_boeken b WHERE b.richting = ? AND b.titel LIKE ?", Boek.class);
        query.setParameter(1, richting);
        query.setParameter(2, "%" + titel + "%");
        List<Boek> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Boek> findBoekByRichtIsbn(String richting, String isbn){
        Query query = em.createNativeQuery("SELECT * FROM tbl_boeken b WHERE b.richting = ? AND b.isbn LIKE ?", Boek.class);
        query.setParameter(1, richting);
        query.setParameter(2, "%" + isbn + "%");
        List<Boek> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Boek> findBoekByTitelIsbn(String titel, String isbn){
        Query query = em.createNativeQuery("SELECT * FROM tbl_boeken b WHERE b.titel LIKE ? AND b.isbn LIKE ?", Boek.class);
        query.setParameter(1, "%" + titel + "%");
        query.setParameter(2,"%" + isbn + "%");
        List<Boek> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Boek> findBoekByTitel(String titel){
        Query query = em.createNativeQuery("SELECT * FROM tbl_boeken b WHERE b.titel LIKE ?", Boek.class);
        query.setParameter(1, "%" + titel + "%");
        List<Boek> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Boek> findBoekByIsbn(String isbn){
        Query query = em.createNativeQuery("SELECT * FROM tbl_boeken b WHERE b.isbn LIKE ?", Boek.class);
        query.setParameter(1, "%" + isbn + "%");
        List<Boek> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Boek> findBoekByRichting(String richting){
        Query query = em.createNamedQuery("Boek.findByRichting").setParameter("richting", richting);
        List<Boek> resultList = query.getResultList();
        return resultList;
    }
    
    
    
    
    
}
