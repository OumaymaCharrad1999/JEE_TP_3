<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
    </head>
    <body>
	<form method="post" action="ServletModification">
            <input type="text" name="login" placeholder="login"> 
            <input type="password" name="password" placeholder="password"> 
            <input type="email" name="email" placeholder="email"> 
            <input type="text" name="ville" placeholder="ville"> 
            <input type="text" name="newLogin" placeholder="newLogin"> 
            <input type="password" name="newPassword" placeholder="newPassword">
            <input type="submit">
	</form>
    </body>
</html>