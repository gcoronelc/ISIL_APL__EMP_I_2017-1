<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<head>
    <link href="estilo/estilos.css" rel="stylesheet" type="text/css"/>
</head>
    
    <ul class="menu">
    
    <li><a href="#" >Home</a></li>
    
    <c:if test="${Ventas == 1}">
        <li><a href="#">Ventas</a>
        <ul>
            <li><a href="#">Estudiantes</a></li>
            <li><a href="#">Cuota Ingreso</a></li>
            <li><a href="#">Matricula</a></li>
            <li><a href="#">Pago de Cuota</a></li>
      </ul>
    </li>
    </c:if>
    
    <c:if test="${Planificación == 1}">
    <li><a href="#">Planificación</a>
      <ul>
        <li><a href="#">Aulas</a></li>
        <li><a href="#">Periodos</a></li>
        <li><a href="#">Sección</a></li>
      </ul>
    </li>
    </c:if>

     <c:if test="${Consultas == 1}">
    <li><a href="#">Consultas</a>
      <ul>
        <li><a href="#">Consulta de Alumnos</a></li>
      </ul>
    </li>
     </c:if>

    <c:if test="${Reportes == 1}">
    <li><a href="#">Reportes</a>
      <ul>
        <li><a href="#">Reporte Mensual</a></li>
        <li><a href="#">Reporte x Alumnos</a></li>
      </ul>
    </li>
    </c:if>
    
    <c:if test="${Seguridad == 1}">
    <li><a href="#">Seguridad</a>
      <ul>
        <li><a href="#">Agregar Nuevo Usuario</a></li>
      </ul>
    </li>
    </c:if>
    
  </ul>