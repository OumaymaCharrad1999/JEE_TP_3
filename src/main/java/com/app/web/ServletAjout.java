package com.app.web;

import java.io.IOException;
import java.sql.*;
import com.app.metier.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletAjout")
public class ServletAjout extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    public ServletAjout() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getRequestDispatcher("Ajouter.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if (!Authentification.isAuthenticated(request)) {
            response.sendRedirect("Login.jsp");
            return;
        }
	String login = request.getParameter("login");
	String pass = request.getParameter("password");
	String ville = request.getParameter("ville");
	String email = request.getParameter("email");
	GestUsers gest = new GestUsers();
	Utilisateur user = new Utilisateur();
	user.setEmail(email);
	user.setLogin(login);
	user.setPass(pass);
	user.setVille(ville);
	try {
            gest.ajouter(user);
            request.getRequestDispatcher("ServletAffichage").forward(request, response);
	} 
        catch (SQLException e) {
            response.sendRedirect("Erreur.html");
	}
    }

}