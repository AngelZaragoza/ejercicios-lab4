<%-- 
    Document   : listado
    Created on : 2 oct. 2020, 20:48:17
    Author     : Angel
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Servicio"%>
<%@page import="BaseDeDatos.AccesoBaseDatos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LCIV - Clase 02 Octubre - Listado</title>
    </head>
    <body>
        <h1>Listado de Servicios Registrados</h1>
        
        <div>
            <table border="1">
                <tr>
                    <th>Tipo</th>
                    <th>Descripcion</th>
                    <th>Costo</th>
                </tr>
                <%
                    
                    ArrayList<Servicio> lista = (ArrayList<Servicio>) request.getAttribute("lista");
                    
                    for (Servicio servicio : lista) {
                            out.print("<tr><td>" + servicio.getTipo() + "</td><td>" +
                                    servicio.getDescripcion() + "</td><td>" +
                                    servicio.getCosto() + "</td></tr>");
                        }
                    
                %>
                
            </table>
        </div>
    </body>
</html>
