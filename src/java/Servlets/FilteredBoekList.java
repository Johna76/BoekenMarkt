/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.BoekEJB;
import DAL.Boek;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Johna
 */
public class FilteredBoekList extends HttpServlet {
    @EJB
    BoekEJB boekService;

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
        
        String richting = request.getParameter("isRichting");
        String titel = request.getParameter("titel");
        String isbn = request.getParameter("isbn");
        List<Boek> filteredList;
        
        if(!richting.equals("empty") && !titel.equals("") && !isbn.equals("") ){
            filteredList = boekService.FindBoekByRichtTitelIsbn(richting, titel, isbn);
        }
        else if(!richting.equals("empty") && !titel.equals("") && isbn.equals("")){
            filteredList = boekService.FindBoekByRichtTitel(richting, titel);
        }
        else if(!richting.equals("empty") && titel.equals("") && !isbn.equals("")){
            filteredList = boekService.FindBoekByRichtIsbn(richting, isbn);
        }
        else if(richting.equals("empty") && !titel.equals("") && !isbn.equals("")){
            filteredList = boekService.FindBoekByTitelIsbn(titel, isbn);
        }
        else if(richting.equals("empty") && titel.equals("") && !isbn.equals("")){
            filteredList = boekService.FindBoekByIsbn(isbn);
        }
        else if(richting.equals("empty") && !titel.equals("") && isbn.equals("")){
            filteredList = boekService.FindBoekByTitel(titel);
        }
        else if(!richting.equals("empty") && titel.equals("") && isbn.equals("")){
            filteredList = boekService.FindBoekByRichting(richting);
        }
        else{
            filteredList = boekService.GetAllAangebodenBoeken();
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("filteredList", filteredList);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("OverviewFiltered.jsp");
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
