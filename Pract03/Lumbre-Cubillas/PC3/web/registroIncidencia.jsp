<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registrar Incidencia</title>
  </head>
  <style>
    ul {
      list-style-type: none;
      margin: 0;
      padding: 0;
      overflow: hidden;
      background-color: #333333;
    }

    li {
      float: left;
    }

    li a {
      display: block;
      color: white;
      text-align: center;
      padding: 16px;
      text-decoration: none;
    }

    li a:hover {
      background-color: #111111;
    }
  </style>
  <body>
    <ul>
      <li><a href="registroIncidencia.jsp">Registrar Incidencia</a></li>
      <li><a href="listarLocalGravedad.jsp">Listar por Local y Gravedad</a></li>
      <li><a href="listarLocalTipo.jsp">Listar por Local y Tipo</a></li>
    </ul>
    <h1>Registrar Incidencia</h1>
    <form method="post" action="RegistrarIncidencia">
      <div>
        Local:
        <select name="local">
          <option value="Miraflores">Miraflores</option>
          <option value="La Molina">La Molina</option>
          <option value="San Isidro">San Isidro</option>
          <option value="Jesús María">Jesús María</option>
        </select>
      </div>
      <div>
        Tipo de Incidencia:
        <select name="tipo">
          <option value="Académica">Académica</option>
          <option value="Administrativa">Administrativa</option>
          <option value="Estudiantil">Estudiantil</option>
        </select>
      </div>
      <div>
        Gravedad de Incidencia:
        <select name="gravedad">
          <option value="Normal">Normal</option>
          <option value="Grave">Grave</option>
          <option value="Muy Grave">Muy Grave</option>
        </select>
      </div>
      <div>
        Descripción:
        <input type="text" name="descripcion" required/>
      </div>
      <div>
        Recomendación:
        <input type="text" name="recomendacion"/>
      </div>
      <div>
        <input type="submit" value="Procesar"/>
      </div>

      <c:if test="${not empty ok}">
        <p>${ok}</p>
      </c:if>

      <c:if test="${error != null}">
        <p style="color:red;">${error}.</p>
      </c:if>
    </form>
  </body>
</html>
