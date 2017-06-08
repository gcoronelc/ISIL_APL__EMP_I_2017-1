<%-- 
    Document   : Cabecera
    Created on : 26-may-2017, 20:33:59
    Author     : HP de Franchesco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <link href="estilo/estilos.css" rel="stylesheet" type="text/css"/>
</head>
    
    <ul class="cabecera">
        <li><a href="#">Usuario: ${sessionScope.usuario.nombre} ${sessionScope.usuario.apellido}</a>
            <ul>
                <li class="li_cerrar"><a href="CerrarSesion">Cerrar Sesion</a></li>
            </ul>
        </li>
    </ul>