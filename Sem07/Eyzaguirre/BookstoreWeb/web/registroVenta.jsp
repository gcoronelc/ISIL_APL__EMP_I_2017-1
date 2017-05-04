<%-- 
    Document   : registroVenta
    Created on : May 4, 2017, 12:54:13 AM
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
        <h1>REGISTRO VENTA</h1>
        <form method="post" action="RegistroVenta">
          <div>
            Cliente:
            <input type="text" name="cliente"/>
          </div>
          <div>
            Id Empleado:
            <input type="number" name="idempleado"/>
          </div>
          <div>
            Id Publicacion:
            <input type="text" name="idpublicacion"/>
          </div>
          <div>
            Cantidad:
            <input type="number" name="cantidad"/>
          </div>
          <div>
            <input type="submit" value="Procesar"/>
          </div>
        </form>
        
        <c:if test="${not empty idventa}">
          <p>Proceso ok. ID Venta: ${idventa}</p>
        </c:if>

        <c:if test="${error != null}">
          <p style="color:red;">${error}.</p>
        </c:if>
    </body>
</html>
