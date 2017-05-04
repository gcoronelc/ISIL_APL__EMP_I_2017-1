<%-- 
    Document   : registroPublicacion
    Created on : May 4, 2017, 12:15:54 AM
    Author     : benjamin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>REGISTRO PUBLICACION</h1>
        <form method="post" action="RegistroPublicacion">
          <div>
            Titulo:
            <input type="text" name="titulo"/>
          </div>
          <div>
            Autor:
            <input type="text" name="autor"/>
          </div>
          <div>
            Num. Edicion:
            <input type="number" name="nroedicion"/>
          </div>
          <div>
            Precio:
            <input type="number" step="any" name="precio"/>
          </div>
          <div>
            Stock:
            <input type="number" name="stock"/>
          </div>
          <div>
            Id Tipo:
            <input type="text" name="idtipo"/>
          </div>
          <div>
            <input type="submit" value="Procesar"/>
          </div>
        </form>
        
        <c:if test="${not empty idpublicacion}">
          <p>Proceso ok. ID Publicacion: ${idpublicacion}</p>
        </c:if>

        <c:if test="${error != null}">
          <p style="color:red;">${error}.</p>
        </c:if>
    </body>
</html>
