<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
    </head>
    <body>
        <span style="color: red;">${errorMessage}</span>
        <P>Please fill out this form with your name. Thanks!
        <FORM METHOD="GET" action="ServletLogin">
            <P>Please enter your login and password.
            <P>Login <INPUT NAME="login" TYPE=" TEXT" SIZE=" 12" MAXLENGTH=" 20">
            <P>Password <INPUT NAME="password" TYPE="password" SIZE=" 12" MAXLENGTH=" 20">
            <P>Thank you! 
            <INPUT TYPE="SUBMIT">
        </FORM>
    </body>
</html>