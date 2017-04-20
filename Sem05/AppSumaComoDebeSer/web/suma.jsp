<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SUMA</title>
    <style>
      body{
        background-color: antiquewhite;
        font-family: sans-serif;
        font-size: 14px;
        padding: 20px;
      }
      p{
        margin: 10px;
        padding: 10px;
      }
    </style>
  </head>
  <body>
    <h1>SUMA</h1>
    
    <p>Número 1: <%= request.getAttribute("n1") %></p>
    <p>Número 2: <%= request.getAttribute("n2") %></p>
    <p>Suma: <%= request.getAttribute("suma") %></p>
    
    <p><a href="index.html">Retornar</a></p>
    
  </body>
</html>
