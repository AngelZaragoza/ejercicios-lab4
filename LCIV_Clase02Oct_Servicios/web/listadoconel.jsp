<%-- 
    Document   : listadoconel
    Created on : 9 oct. 2020, 18:52:40
    Author     : Angel
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Servicio"%>
<%@page import="BaseDeDatos.AccesoBaseDatos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>LCIV - Clase 02 Octubre - Listado</title>
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <h1>Listado de Servicios Registrados</h1>
        <h2>con Servlet y EL</h2>

        <div class="contenedor">
            <table border="1">
                <tr>
                    <th>Tipo</th>
                    <th>Descripcion</th>
                    <th>Costo</th>
                </tr>

                <c:forEach items="${lista}" var="servicio">
                    
                    <tr>
                        <td> ${servicio.tipo} </td>
                        <td> ${servicio.descripcion} </td>
                        <td> ${servicio.costo} </td>
                    </tr>
                    
                </c:forEach>

            </table>            
        </div>
        <hr>
        <div class="contenedor">            
            <a href="./menuprincipal.jsp">Volver al Menú Principal</a>
        </div>            
    </body>
</html>
