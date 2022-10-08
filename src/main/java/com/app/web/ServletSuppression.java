package com.app.web;

import java.io.IOException;
import java.sql.*;
import com.app.metier.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletSuppression")
public class ServletSuppression extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    public ServletSuppression() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if (!Authentification.isAuthenticated(request)) {
            response.sendRedirect("Login.jsp");
            return;
	}
	request.getRequestDispatcher("Supprimer.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if (!Authentification.isAuthenticated(request)) {
            response.sendRedirect("Login.jsp");
            return;
	}
	String login = request.getParameter("login");
	String pass = request.getParameter("password");
	try {
            GestUsers gest = new GestUsers();
            gest.supprimer(login, pass);
            response.sendRedirect("ServletAffichage");
	} 
        catch (SQLException e) {
            response.sendRedirect("Erreur.html");
	}
    }

}