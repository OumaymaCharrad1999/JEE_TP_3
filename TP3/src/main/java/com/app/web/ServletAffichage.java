package com.app.web;

import java.io.IOException;
import java.sql.*;
import com.app.metier.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletAffichage")
public class ServletAffichage extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
        
    public ServletAffichage() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Authentification.isAuthenticated(request)) {
            response.sendRedirect("Login.jsp");
            return;
        }
        GestUsers gest = new GestUsers();
        try {
	request.setAttribute("users", gest.lister());
	request.getRequestDispatcher("Afficher.jsp").forward(request, response);
        } 
        catch (SQLException e) {
            response.sendRedirect("Erreur.html");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
}