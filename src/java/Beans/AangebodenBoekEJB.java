/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAL.AangebodenBoek;
import DAL.User;
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
public class AangebodenBoekEJB {

    @PersistenceContext(unitName = "Web_BoekenMarktPU")
    private EntityManager em;
    
    
    public AangebodenBoek createAangebodenBoek(AangebodenBoek b){
        em.persist(b);
        return b;
    }
    
    
    public List<AangebodenBoek> getAllAangebodenBoeken(){
        Query query = em.createNamedQuery("AangebodenBoek.findAll");
        List<AangebodenBoek> resultList = query.getResultList();
        return resultList;        
    }
          
    
    public AangebodenBoek getBoekById(int id){
        Query query = em.createNamedQuery("AangebodenBoek.findById").setParameter("id", id);
        AangebodenBoek b = (AangebodenBoek)query.getSingleResult();
        return b;
    }
    
    public void deleteAangBoek(int id){
        Query query = em.createNativeQuery("DELETE b FROM tbl_aangebodenboeken b WHERE b.id = ?");
        query.setParameter(1, id);
        int resultList = query.executeUpdate();
    }
       
    
}
