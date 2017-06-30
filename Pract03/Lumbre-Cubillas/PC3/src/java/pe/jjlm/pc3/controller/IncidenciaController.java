package pe.jjlm.pc3.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.jjlm.pc3.domain.Incidencia;
import pe.jjlm.pc3.model.IncidenciaModel;
import pe.jjlm.pc3.service.IncidenciaService;

@WebServlet(name = "IncidenciaController",
        urlPatterns = {"/RegistrarIncidencia", "/ListarLocalTipo", "/ListarLocalGravedad"})
public class IncidenciaController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    switch (path) {
      case "/RegistrarIncidencia":
        registrarIncidencia(request, response);
        break;
      case "/ListarLocalTipo":
        listarLocalTipo(request, response);
        break;
      case "/ListarLocalGravedad":
        listarLocalGravedad(request, response);
        break;
      default:
        break;
    }
  }

  private void registrarIncidencia(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      IncidenciaService service = new IncidenciaService();

      IncidenciaModel inc = new IncidenciaModel();

      inc.setLocal(request.getParameter("local"));
      inc.setTipo(request.getParameter("tipo"));
      inc.setGravedad(request.getParameter("gravedad"));
      inc.setDescripcion(request.getParameter("descripcion"));
      inc.setRecomendacion(request.getParameter("recomendacion"));

      service.registrarIncidencia(1L, inc);

      request.setAttribute("ok", "Proceso Ok.");

    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("registroIncidencia.jsp");
    rd.forward(request, response);
  }

  private void listarLocalTipo(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
       IncidenciaService service = new IncidenciaService();
      String local = request.getParameter("local");
      String tipo = request.getParameter("tipo");
      System.out.println(local);
      List<Incidencia> inc = service.getListaLocalTipo(local, tipo);
      
      request.setAttribute("lista", inc);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("listarLocalTipo.jsp");
    rd.forward(request, response);
  }

  private void listarLocalGravedad(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
        IncidenciaService service = new IncidenciaService();
      String local = request.getParameter("local");
      String gravedad = request.getParameter("gravedad");
      System.out.println(local);
      List<Incidencia> inc = service.getListaLocalGravedad(local, gravedad);
      
      request.setAttribute("lista", inc);
      
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("listarLocalGravedad.jsp");
    rd.forward(request, response);
  }
}
