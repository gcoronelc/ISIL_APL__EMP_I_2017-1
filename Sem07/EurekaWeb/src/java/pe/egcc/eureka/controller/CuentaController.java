package pe.egcc.eureka.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.eureka.service.CuentaService;

@WebServlet(name = "CuentaController",
        urlPatterns = {"/CuentaDeposito", "/CuentaRetiro"})
public class CuentaController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    switch (path) {
      case "/CuentaDeposito":
        cuentaDeposito(request, response);
        break;
      case "/CuentaRetiro":
        cuentaRetiro(request, response);
        break;
    }

  }

  private void cuentaDeposito(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    try {
      // Datos
      String cuenta = request.getParameter("cuenta");
      double importe = Double.parseDouble(request.getParameter("importe"));
      // Otros datos
      String codEmp = "0003";
      // Proceso
      CuentaService service = new CuentaService();
      int nroMov = service.procDeposito(cuenta, importe, codEmp);
      // Reporte
      request.setAttribute("nroMov", nroMov);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("procDeposito.jsp");
    rd.forward(request, response);
  }

  private void cuentaRetiro(HttpServletRequest request, HttpServletResponse response) {

  }

}
