<%-- 
    Document   : index
    Created on : 9 oct. 2020, 19:56:59
    Author     : Angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>LCIV - JSP Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/estilos.css">
        <script src="js/funciones.js"></script>
    </head>
    <body onload="saludo();">
        
        <h1 id="saludo"></h1>
        <h2>Introduzca su información de logueo</h2>
        <%if(request.getAttribute("mensajeError") != null && 
                !request.getAttribute("mensajeError").equals("")) { %>
                <h4> ${mensajeError} </h4>
        <%
            }
        %>

        
        <div class="contenedor">
            <form id="login" method="post" action="./Login">
                <div>
                    <label for="user">Usuario:</label>                
                    <input type="text" id="user" name="txtUsuario" placeholder="Usuario">
                </div>
                <div>
                    <label for="pass">Password:</label>
                    <input type="password" id="pass" name="txtPassword" placeholder="Password">
                </div>                
                <div>
                    <label></label>
                    <input type="submit" value="Verificar" onclick="validar();">
                </div>
            </form>
        </div>        
    </body>
</html>
