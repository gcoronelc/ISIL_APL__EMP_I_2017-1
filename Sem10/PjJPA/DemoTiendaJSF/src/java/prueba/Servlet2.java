package prueba;

import ejb.beans.VentaBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet2", urlPatterns = {"/Servlet2"})
public class Servlet2 extends HttpServlet {
	@EJB
	private VentaBeanLocal dao;

	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Demo01</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet Demo01 at " + req.getContextPath() + "</h1>");

			List lista = dao.consultarVentas();
			for (Object o: lista) {
				Object[] rec = (Object[]) o;
				out.println("<p>" + rec[0].toString() + " - " + rec[1].toString() + "</p>");
			}

			out.println("<p style='color:blue'>" + "Hola todos." + "</p>");
		} catch (Exception e) {
			out.println("<p style='color:red'>Error: " + e.getMessage() + "</p>");
		} finally {
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
	}
}
