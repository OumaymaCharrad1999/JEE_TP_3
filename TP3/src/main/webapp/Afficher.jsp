<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.app.metier.Utilisateur"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <style>
            .user {
                border: 1px solid black;
                border-radius: 10px;
                padding: 10px;
                margin-bottom: 5px;
            }
        </style>
    </head>
    <body>
	<%
            Vector<Utilisateur> users = (Vector<Utilisateur>) request.getAttribute("users");
            for (Utilisateur user : users) {
	%>
	<div class="user">
		<p>Login : <%=user.getLogin()%></p>
		<p>Email : <%=user.getEmail()%></p>
		<p>Ville : <%=user.getVille()%></p>
	</div>
	<%
            }
	%>
	<a href="Bienvenue.jsp"><button>Page d'Acceuil</button></a>
    </body>
</html>