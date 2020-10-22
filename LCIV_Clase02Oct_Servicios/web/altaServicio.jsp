<%-- 
    Document   : altaservicio
    Created on : 16 oct. 2020, 9:32:56
    Author     : Angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LCIV - JSP Alta de Servicio</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/estilos.css">
        <script src="js/funciones.js"></script>
    </head>
    <body>
        <h1>Alta de Servicio</h1>
        <h2>Complete los datos</h2>
        
        <div class="contenedor">
            <form id="alta" method="post" action="">
                <div>
                    <label for="tipo">Tipo:</label>                
                    <input type="text" id="tipo" name="txtTipo" placeholder="Tipo">
                </div>
                <div>
                    <label for="desc">Descripción:</label>
                    <textarea id="desc" rows="3" name="txtDescripcion" placeholder="Descripción del Servicio"></textarea>

                </div>
                <div>
                    <label for="costo">Costo:</label>
                    <input type="text" id="costo" name="txtCosto" placeholder="Costo">
                </div>                
                <div>
                    <label></label>
                    <input type="submit" value="Guardar" onclick="">
                </div>
            </form>
        </div>
    </body>
</html>
