<%-- 
    Document   : insert
    Created on : 19 mar. 2021, 13:31:24
    Author     : Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
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
        
        <div class="container">
               <h1>Crea una nueva planta</h1>
        <form action="servletPlantas?op=insert2" method="get">
        <p><label>Nombre: <input class="form-control" type="text" name="nombre" required > </label></p>
        <p><label>Precio: <input class="form-control" type="text" name="precio" required > </label></p>
        <input type="hidden" name="op" required value="insert2"> 
        <input class="btn btn-primary" type="submit" value="insertar" >       
        </form>
        </div>
        
    </body>
</html>
