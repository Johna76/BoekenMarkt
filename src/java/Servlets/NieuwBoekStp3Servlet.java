/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.AangebodenBoekEJB;
import Beans.BoekEJB;
import Beans.LoginEJB;
import Beans.UserEJB;
import DAL.AangebodenBoek;
import DAL.Boek;
import DAL.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Johna
 */
public class NieuwBoekStp3Servlet extends HttpServlet {

    @EJB
    AangebodenBoekEJB AangBoekService;
    
    @EJB
    BoekEJB boekService;
    
    @EJB
    UserEJB userService;
    
    @EJB
    LoginEJB loginService;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int boekId = Integer.parseInt(request.getParameter("BoekId"));
        Boek boek = boekService.getbyId(boekId);
        String conditie = request.getParameter("isConditie");
        double prijs = Double.parseDouble(request.getParameter("prijs"));
        String omschrijving = request.getParameter("omschrijving");
        Date datum = Calendar.getInstance().getTime();
        User user = (User)request.getSession().getAttribute("user");
        
        AangebodenBoek aangBoek = new AangebodenBoek();
        aangBoek.setBoekID(boek);
        aangBoek.setConditie(conditie);
        aangBoek.setDatum(datum);
        aangBoek.setOmschrijving(omschrijving);
        aangBoek.setPrijs(prijs);
        aangBoek.setUserID(user);
        
        AangBoekService.createAangebodenBoek(aangBoek);
        
        RequestDispatcher rd = request.getRequestDispatcher("/OverzichtMijnBoekenServlet");
        rd.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
