package Controller;

import Model.Empleado;
import Service.LogeoService;
import Service.PermisoService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP de Franchesco
 */
@WebServlet(name = "LogoeController", urlPatterns = {"/IniciarSesion", "/CerrarSesion"})
public class LoginController  extends HttpServlet{
    
    @Override
    protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if(path.equals("/IniciarSesion"))
        {
            IniciarSesion(request,response);
        } else if(path.equals("/CerrarSesion"))
        {
            CerrarSesion(request,response);
        }
    }

    private void IniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String destino = "";
        
        try
        {
            // Datos
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            // Proceso
            LogeoService service = new LogeoService();
            Empleado empleado = service.validar(usuario, clave);
            // Guardando datos en session
            HttpSession session = request.getSession();
            session.setAttribute("usuario", empleado);
            
             // Roles
            PermisoService permisoService = new PermisoService();
            session.setAttribute("Ventas", permisoService.getPermiso(empleado.getIdemp(), PermisoService.P_VENTAS));
            session.setAttribute("Planificacion", permisoService.getPermiso(empleado.getIdemp(), PermisoService.P_PLANIFICACION));
            session.setAttribute("Consultas", 1);
            session.setAttribute("Reportes", permisoService.getPermiso(empleado.getIdemp(), PermisoService.P_REPORTES));
            session.setAttribute("Seguridad", permisoService.getPermiso(empleado.getIdemp(), PermisoService.P_SEGURIDAD));
      
            destino = "Principal.jsp";
        }
        catch (Exception e)
        {
            request.setAttribute("error", e.getMessage());
            destino = "Index.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    private void CerrarSesion(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        // Cerrar session
        HttpSession session = request.getSession();
        session.invalidate();
        // Forward
        RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
        rd.forward(request, response);
    }
    
}
