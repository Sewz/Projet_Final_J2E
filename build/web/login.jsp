<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
        <form action="LoginController" method="post">
            <table>
                <tr>
                    <td><label for="login">Nom d'utilisateur : </label></td>
                    <td>
                        <input type="text" name="username" id="login">
                    </td>
                <tr>
                    <td><label for="password">Mot de passe : </label></td>
                    <td>
                        <input type="password" name="password" id="password">
                    </td>
                </tr>    
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" name="submit" value="Connectez-vous">
                    </td>
                </tr> 
            </table>
        </form>
    </body>
</html>