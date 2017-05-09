package pe.egcc.app.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AppController",
        urlPatterns = {"/Agregar", "/Listar", "/Limpiar","/Eliminar"})
public class AppController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    switch (path) {
      case "/Agregar":
        agregar(request, response);
        break;
      case "/Eliminar":
        eliminar(request, response);
        break;
      case "/Limpiar":
        limpiar(request, response);
        break;
    }
  }

  private void limpiar(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    request.getSession().invalidate();
    request.setAttribute("mensaje", "Sesion eliminada.");
    forward(request, response, "index.jsp");
  }
  
  private void eliminar(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    // Dato
    String nombre = request.getParameter("nombre");
    // Obtener lista
    List<String> lista = getLista(request);
    // Agregar nueva ciudad
    lista.remove(nombre);
    request.setAttribute("mensaje", "Ciudad eliminada.");
    // Forward
    forward(request, response, "index.jsp");
  }

  private void agregar(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    // Dato
    String nombre = request.getParameter("nombre");
    // Obtener lista
    List<String> lista = getLista(request);
    // Agregar nueva ciudad
    lista.add(nombre);
    request.setAttribute("mensaje", "Nueva ciudad agregada.");
    // Forward
    forward(request, response, "index.jsp");
  }

  private List<String> getLista(HttpServletRequest request) {
    // Obtener la sesion
    HttpSession session = request.getSession();
    // Obtener la lista
    List<String> lista = (List<String>) session.getAttribute("lista");
    return lista;
  }

  private void forward(HttpServletRequest request, 
          HttpServletResponse response, String destino) 
          throws ServletException, IOException {
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }

  
  
  
  
}
