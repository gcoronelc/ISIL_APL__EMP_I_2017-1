<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <div><jsp:include page="cabecera.jsp" /></div>
    <h2>AGREGAR NUEVA CIUDAD</h2>
    <fieldset>
      <legend>Nueva Ciudad</legend>
      <form method="post" action="Agregar"c>
        <div>
          <label>Nombre:</label>
          <input type="text" name="nombre" />
        </div>
        <div>
          <input type="submit" value="Procesar" />
        </div>
      </form>
    </fieldset>
  </body>
</html>
