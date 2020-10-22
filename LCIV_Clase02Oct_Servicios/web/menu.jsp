<%-- 
    Document   : menuprincipal
    Created on : 16 oct. 2020, 9:33:16
    Author     : Angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LCIV - JSP Menú Principal</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/estilos.css">
        <script src="js/funciones.js"></script>
    </head>
    <body>
        <h1>Bienvenido</h1>
        <h2>Elija una opción</h2>
        <section>
            <aside>
                <a href="#">Alta de Servicio</a>
                <a href="./ListadoEL">Listado de Servicios registrados</a>
            </aside>
            <article>
                <p>
                    El proyecto web, en la carpeta Source Package, debe respetar la siguiente estructura:

                    · Paquete Base de Datos- AccesoBaseDatos.java: contiene la lógica para poder acceder a la BD Gestoría y los métodos necesarios para la registración y procesamiento de los servicios registrados.

                    · Paquete Modelo- Servicio.java: contiene los siguientes atributos: número (int), tipo (), descripción (String)y costo (double).

                    · Paquete Servlets- ServicioServlet.java: contiene la lógica necesaria que permite identificar de que página se originó la petición y permite su procesamiento.

                </p>
            </article>
        </section>
    </body>
</html>
