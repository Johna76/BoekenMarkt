/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAL.AangebodenBoek;
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
    
    
    public AangebodenBoek CreateAangebodenBOek(AangebodenBoek b){
        em.persist(b);
        return b;
    }
    
    
    public List<AangebodenBoek> GetAllAangebodenBoeken(){
        Query query = em.createNamedQuery("AangebodenBoek.findAll");
        List<AangebodenBoek> resultList = query.getResultList();
        return resultList;        
    }
    
    
}
