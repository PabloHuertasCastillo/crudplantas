<%-- 
    Document   : listar
    Created on : 19 mar. 2021, 12:50:14
    Author     : Pablo
--%>

<%@page import="java.util.List"%>
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

        <div class="container" id="lista">
            <h1 class="my-3" >Listado de productos</h1>
            <% List<Plantas> misPlantas = (List<Plantas>) request.getAttribute("misPlantas");
            %>
            <table class="table table-hover">
                <tr>
                    <th>id</th>
                    <th>Nombre</th>
                    <td>Precio</td>
                    <td>Borrar</td>
                    <td>Actualizar</td>
                </tr>

                <% for (Plantas p : misPlantas) {
                        String cadenaBorrar = "<a onclick='return Confirmation()' href='servletPlantas?op=borrar&id=" + p.getId() + "'><i class='far fa-trash-alt'></i></a>";
                        String cadenaActualizar = "<a href='servletPlantas?op=update1&id=" + p.getId() + "'><i class='far fa-edit'></i></a>";
                %>
                <tr>
                    <td><%=p.getId()%></td>
                    <td><%=p.getNombre()%></td>
                    <td><%=p.getPrecio()%></td>
                    <td><%=cadenaBorrar%></td>
                    <td><%=cadenaActualizar%></td>

                </tr>    

                <% }%>
            </table>
        </div>

    </body>
</html>
