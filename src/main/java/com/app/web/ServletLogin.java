package com.app.web;

import java.io.IOException;
import java.sql.*;
import com.app.metier.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    public ServletLogin() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String login = request.getParameter("login");
	String password = request.getParameter("password");
	HttpSession s = request.getSession(false);
	if (s.getAttribute("user") != null) {
            request.getRequestDispatcher("Bienvenue.jsp").forward(request, response);
            return;
	}
	if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            request.setAttribute("errorMessage", "Please provide a login and a password!");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
	} 
        else {
            try {
                GestUsers gest = new GestUsers();
		Utilisateur user = gest.Chercher(login, password);
		if (user != null) {
                    HttpSession maSession = request.getSession(true);
                    maSession.setAttribute("user", user);
                    request.getRequestDispatcher("Bienvenue.jsp").forward(request, response);
                    response.sendRedirect("Bienvenue.jsp");
		} 
                else {
                    request.setAttribute("errorMessage", "Invalid login credentials!");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
            } 
            catch (SQLException e) {
		response.sendRedirect("Erreur.html");
            }
	}
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
    }
    
}