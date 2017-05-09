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

    <c:if test="${mensaje != null}" >
      <p style="color:blue; margin: 20px;">${mensaje}</p>
    </c:if>

  </body>
</html>
