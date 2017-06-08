<%-- 
    Document   : Login
    Created on : 26-may-2017, 20:19:34
    Author     : HP de Franchesco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilo/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Inicia Sesión</title>
    </head>
    
    <body class="body_login">
        
        <div class="div_login">
            
            <p class="titulo_login">INICIAR SESIÓN</p>
            
            <c:if test="${requestScope.error != null}">
              <p class="egcc_error">${requestScope.error}</p>
            </c:if>
            
            <form method="post" action="IniciarSesion">
                <table align="center">
                    <tr>
                        <td style="font-weight: bold;">USUARIO</td>
                    </tr>
                    <tr>
                        <td><input class="txt_login_user" type="text" name="usuario" /><br><br></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold;">CONTRASEÑA</td>
                    </tr>
                    <tr>
                        <td><input class="txt_login_pass" type="password" name="clave" /><br><br><br></td>
                    </tr>
                    <tr>
                        <td><input class="btn_login" type="submit" value="INGRESAR"/></td>
                    </tr>
                </table>
            </form>
        </div>
            
            <footer class="pie_login">
                &copy; 2017 Matrículas
            </footer>
            
    </body>
</html>
