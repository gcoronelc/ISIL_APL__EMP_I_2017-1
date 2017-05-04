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
        <link rel="stylesheet" href="https://unpkg.com/purecss@0.6.2/build/pure-min.css" integrity="sha384-UQiGfs9ICog+LwheBSRCt1o5cbyKIHbwjWscjemyBMT9YCUMZffs6UqUTd0hObXD" crossorigin="anonymous">
    </head>
    <body>
        <h1>VENTAS POR TIPO</h1>
        <form method="post" action="VentasPorTipo">
          <div>
            Tipo:
            <input type="text" name="tipo"/>
          </div>
          <div>
            <input type="submit" value="Procesar"/>
          </div>
        </form>
        
        <c:if test="${lista != null}">
            <table class="pure-table">
                <thead>
                <tr>
                    <th>EMPLEADO</th>
                    <th>IDVENTA</th>
                    <th>CLIENTE</th>
                    <th>FECHA</th>
                    <th>TITULO</th>
                    <th>PRECIO</th>
                    <th>DCTO</th>
                    <th>CANTIDAD</th>
                    <th>TOTAL</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${lista}" var="item" varStatus="status">
                    <tr>
                        <td>${item.EMPLEADO}</td>
                        <td>${item.IDVENTA}</td>
                        <td>${item.CLIENTE}</td>
                        <td>${item.FECHA}</td>
                        <td>${item.TITULO}</td>
                        <td>${item.PRECIO}</td>
                        <td>${item.DCTO}</td>
                        <td>${item.CANTIDAD}</td>
                        <td>${item.TOTAL}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${error != null}">
          <p style="color:red;">${error}.</p>
        </c:if>
    </body>
</html>
