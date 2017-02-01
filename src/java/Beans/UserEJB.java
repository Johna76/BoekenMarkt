/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAL.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Johna
 */
@Stateless
public class UserEJB {

    @PersistenceContext(unitName = "Web_BoekenMarktPU")
    private EntityManager em;
         
    
    public User CreateUser(User u){
        em.persist(u);
        return u;
    }
    
    public User FindByStudentennummer(String studentennummer){
        Query query = em.createNamedQuery("User.findByStudentennummer").setParameter("studentennummer", studentennummer);
        User u = (User)query.getSingleResult();
        return u;
    }
}
