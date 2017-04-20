package pe.egcc.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.app.service.SumaService;

@WebServlet(name = "SumaServlet", urlPatterns = {"/SumaServlet"})
public class SumaServlet extends HttpServlet {

  private int n1, n2, suma;
  
  
  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response)
          throws ServletException, IOException {
    
    // Inicio
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>SUMA</title>");      
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>SUMA</h1>");
    
    
    // Datos
    n1 = Integer.parseInt(request.getParameter("num1"));
    n2 = Integer.parseInt(request.getParameter("num2"));
    out.println("<p>Número 1: " + n1 + "</p>");
    out.println("<p>Número 2: " + n2 + "</p>");

    // Proceso
    try {
      Thread.currentThread().sleep(2000);
    } catch (InterruptedException ex) {
      Logger.getLogger(SumaServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    SumaService service = new SumaService();
    suma = service.sumar(n1, n2);
    out.println("<p>Suma: " + suma + "</p>");    
    
    // Fin
    out.println("<a href='index.html'>Retornar</a>");
    out.println("</body>");
    out.println("</html>");
    
  }
  
}
