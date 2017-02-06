/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAL.User;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Johna
 */
@Stateful
public class LoginEJB {

    @EJB
    UserEJB userService;

    public boolean LoginCheck;
    public final User user;

    @PersistenceContext(unitName = "Web_BoekenMarktPU")
    private EntityManager em;

    public LoginEJB() {
        this.LoginCheck = false;
        this.user = new User();
    }

    public boolean LoginCorrect(String studentnummer, String password) {
        boolean check;

        User u = userService.FindByStudentennummer(studentnummer);

        if (u.getWachtwoord().equals(password)) {
            check = true;
            LoginCheck = true;
            user.setId(u.getId());
            user.setNaam(u.getNaam());
        } else {
            check = false;
        }

        return check;
    }
}
