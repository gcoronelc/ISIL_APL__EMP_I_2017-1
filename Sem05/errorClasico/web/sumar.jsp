<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
  private int n1;
  private int n2;
  private int suma;
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SUMAR</title>
  </head>
  <body>
    <h1>SUMAR</h1>
    
    <!-- DATOS -->
    <%
      n1 = Integer.parseInt(request.getParameter("num1"));
      n2 = Integer.parseInt(request.getParameter("num2"));
    %>
    <p>Número 1: <%= n1 %></p>
    <p>Número 2: <%= n2 %></p>
    
    <!-- PROCESO -->
    <% 
      Thread.currentThread().sleep(2000);
      suma = n1 + n2;
    %>
    
    <!-- REPORTE -->
    <p>Suma: <%= suma %></p>
    
    <!-- FIN -->
    <a href="index.html">Retornar</a>
    
  </body>
</html>
