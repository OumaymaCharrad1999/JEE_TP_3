<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
    </head>
    <body>
	<p>Identifiant : ${user.idUser}</p>
	<p>Login : ${user.login}</p>
	<p>Password : ${user.pass}</p>
	<p>Email : ${user.email}</p>
	<p>Ville : ${user.ville}</p>
	<a href="ServletLogout"><button>Logout</button></a>
	<a href="ServletAjout"><button>Ajouter Utilisateur</button></a>
	<a href="ServletAffichage"><button>Lister tous les Utilisateurs</button></a>
	<a href="ServletSuppression"><button>Supprimer Utilisateur</button></a>
	<a href="ServletModification"><button>Modifier Utilisateur</button></a>
    </body>
</html>