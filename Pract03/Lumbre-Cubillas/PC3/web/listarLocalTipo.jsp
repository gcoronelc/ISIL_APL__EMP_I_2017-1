<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listar por Local y Tipo</title>
    <link rel="stylesheet" href="https://unpkg.com/purecss@0.6.2/build/pure-min.css" integrity="sha384-UQiGfs9ICog+LwheBSRCt1o5cbyKIHbwjWscjemyBMT9YCUMZffs6UqUTd0hObXD" crossorigin="anonymous">
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
    <h1>Listar por Local y Tipo</h1>
    <form method="post" action="ListarLocalTipo">
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
        <input type="submit" value="Procesar"/>
      </div>

      <c:if test="${lista != null}">
        <table class="pure-table">
          <thead>
            <tr>
              <th>LOCAL</th>
              <th>TIPO GRAVEDAD</th>
              <th>GRAVEDAD</th>
              <th>DESCRIPCION</th>
              <th>FECHA</th>
              <th>HORA</th>
              <th>RECOMENDACION</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${lista}" var="item" varStatus="status">
              <tr>
                <td>${item.getLocal()}</td>
                <td>${item.getTipo()}</td>
                <td>${item.getGravedad()}</td>
                <td>${item.getDescripcion()}</td>
                <td>${item.getFecha()}</td>
                <td>${item.getHora()}</td>
                <td>${item.getRecomendacion()}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </c:if>
  </body>
</html>
