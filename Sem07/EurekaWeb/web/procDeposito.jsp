<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DEPOSITO</title>
  </head>
  <body>
    <h1>DEPOSITO</h1>
    <form method="post" action="CuentaDeposito">
      <div>
        Cuenta:
        <input type="text" name="cuenta"/>
      </div>
      <div>
        Importe:
        <input type="text" name="importe"/>
      </div>
      <div>
        <input type="submit" value="Procesar"/>
      </div>
    </form>
    
    <c:if test="${nroMov != null}">
      <p>Proceso ok. Movimiento nro. ${nroMov}.</p>
    </c:if>
      
    <c:if test="${error != null}">
      <p style="color:red;">${error}.</p>
    </c:if>
      
  </body>
</html>
