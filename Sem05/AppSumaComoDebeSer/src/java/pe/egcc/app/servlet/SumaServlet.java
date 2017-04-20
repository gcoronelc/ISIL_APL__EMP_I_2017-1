package pe.egcc.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.app.service.SumaService;

@WebServlet(name = "SumaServlet", urlPatterns = {"/SumaServlet"})
public class SumaServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response)
          throws ServletException, IOException {
    
    // Datos
    int n1 = Integer.parseInt(request.getParameter("num1"));
    int n2 = Integer.parseInt(request.getParameter("num2"));
    
    // Proceso
    try {
      Thread.currentThread().sleep(2000);
    } catch (InterruptedException ex) {
      Logger.getLogger(SumaServlet.class.getName()).log(Level.SEVERE, null, ex);
    }    
    SumaService service = new SumaService();
    int suma = service.sumar(n1, n2);
    
    // Forward
    request.setAttribute("n1", n1);
    request.setAttribute("n2", n2);
    request.setAttribute("suma", suma);
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("suma.jsp");
    rd.forward(request, response);
  }
  
}
