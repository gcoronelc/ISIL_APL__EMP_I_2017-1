<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <div><jsp:include page="cabecera.jsp"/></div>
    <h2>LISTADO DE CIUDADES</h2>
    
    <c:if test="${empty sessionScope.lista}">
      <p style="color:red;">Lista vacia</p>
    </c:if>
    
    <c:if test="${sessionScope.lista != null}">
    <ol>
      <c:forEach items="${sessionScope.lista}" var="ciudad"> 
        <li>
          ${ciudad}
          <a href="#">Eliminar</a>
        </li>
      </c:forEach>
    </ol>
    </c:if>
    
  </body>
</html>
