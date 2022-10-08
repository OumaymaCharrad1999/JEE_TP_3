package com.app.web;

import java.io.IOException;
import java.sql.*;
import com.app.metier.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletModification")
public class ServletModification extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    public ServletModification() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if (!Authentification.isAuthenticated(request)) {
            response.sendRedirect("Login.jsp");
            return;
	}
	request.getRequestDispatcher("Modifier.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if (!Authentification.isAuthenticated(request)) {
            response.sendRedirect("Login.jsp");
            return;
	}
	String login = request.getParameter("login");
	String pass = request.getParameter("password");
	String email = request.getParameter("email");
	String ville = request.getParameter("ville");
	String newLogin = request.getParameter("newLogin");
	String newPass = request.getParameter("newPassword");
	Utilisateur u = new Utilisateur();
	u.setEmail(email);
	u.setLogin(newLogin);
	u.setPass(newPass);
	u.setVille(ville);
	GestUsers gest = new GestUsers();
	try {
            gest.modifier(u, login, pass);
            response.sendRedirect("ServletAffichage");
	} 
        catch (SQLException e) {
            response.sendRedirect("Erreur.html");
	}
    }

}