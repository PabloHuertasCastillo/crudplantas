<%-- 
    Document   : update
    Created on : 19 mar. 2021, 13:08:07
    Author     : Pablo
--%>

<%@page import="modelo.Plantas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">La tienda de las plantas</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="servletPlantas?op=listar">Listado de plantas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="servletPlantas?op=insertar">Crear una nueva planta</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container" >
            <h1 class="my-3" >Actualiza producto</h1>
            <%
                Plantas miPlanta = (Plantas) request.getAttribute("miPlanta");
                String mensaje = (String) request.getAttribute("mensaje");
                String cadena = "";
                if (mensaje != null) {
                    cadena = "<h2 id='mensaje' class='alert alert-success'>"+mensaje+"</h2>";
                }
            %>
            <%=cadena%>

            <form action="servletPlantas" method="get">
                <p><label>Nombre: <input  class="form-control" value="<%=miPlanta.getNombre()%>" type="text" name="nombre" required > </label></p>        
                <p><label>Precio: <input  class="form-control"  value="<%=miPlanta.getPrecio()%>" type="text" name="precio" required > </label></p>
                <input type="hidden" name="op" required value="update2"> 
                <input class="btn btn-primary" type="submit" value="Actualizar" >       
            </form>
        </div>



    </body>
</html>
