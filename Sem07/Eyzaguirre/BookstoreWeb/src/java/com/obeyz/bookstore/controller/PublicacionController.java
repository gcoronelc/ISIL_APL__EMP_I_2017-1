package com.obeyz.bookstore.controller;

import com.obeyz.bookstore.model.Publicacion;
import com.obeyz.bookstore.model.Venta;
import com.obeyz.bookstore.service.VentaService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author benjamin
 */
@WebServlet(name="PublicacionController", 
        urlPatterns = {"/RegistroPublicacion", "/RegistroVenta", "/VentasPorTipo"})
public class PublicacionController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/RegistroPublicacion":
                registroPublicacion(request, response);
                break;
            case "/RegistroVenta":
                registroVenta(request, response);
                break;
            case "/VentasPorTipo":
                ventasPorTipo(request, response);
            default:
                break;
        }

    }
    
    private void registroPublicacion(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        try {
            // Datos           
            String titulo = request.getParameter("titulo");
            String autor = request.getParameter("autor");
            Integer nroedicion = Integer.parseInt(request.getParameter("nroedicion"));   
            Double precio = Double.parseDouble(request.getParameter("precio"));   
            Integer stock = Integer.parseInt(request.getParameter("stock"));   
            String idtipo = request.getParameter("idtipo");
            Publicacion publicacion = new Publicacion("", titulo, autor, nroedicion, precio, stock, idtipo);
            // Proceso
            VentaService service = new VentaService();
            String idpublicacion = service.registrarNuevaPublicacion(publicacion);
            // Reporte
            request.setAttribute("idpublicacion", idpublicacion);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        // Forward
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("registroPublicacion.jsp");
        rd.forward(request, response);
    }
    
    private void registroVenta(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        try {
            // Datos            
            String cliente = request.getParameter("cliente");
            Integer idempleado = Integer.parseInt(request.getParameter("idempleado")); 
            String idpublicacion = request.getParameter("idpublicacion");
            Integer cantidad = Integer.parseInt(request.getParameter("cantidad")); 
            Venta venta = new Venta(null, cliente, null, idempleado, idpublicacion, cantidad, null, null, null, null, null);
            // Proceso
            VentaService service = new VentaService();
            Integer idventa = service.efectuarVenta(venta);
            // Reporte
            request.setAttribute("idventa", idventa);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        // Forward
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("registroVenta.jsp");
        rd.forward(request, response);
    }
    
    private void ventasPorTipo(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        try {
            // Datos            
            String tipo = request.getParameter("tipo");
            // Proceso
            VentaService service = new VentaService();
            List < Map < String, ? >> lista = service.ventasPorTipoPublicacion(tipo);
            // Reporte
            request.setAttribute("lista", lista);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        // Forward
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("ventasPorTipo.jsp");
        rd.forward(request, response);
    }
}
