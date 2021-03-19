/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Plantas;
import modelo.Plantascrud;

/**
 *
 * @author Pablo
 */
public class servletPlantas extends HttpServlet {

    private int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String op = request.getParameter("op");

        if (op.equals("listar")) {
            List<Plantas> misPlantas = Plantascrud.getPlantas();
            request.setAttribute("misPlantas", misPlantas);
            request.getRequestDispatcher("listar.jsp").forward(request, response);
        }

        if (op.equals("borrar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (Plantascrud.destroyPlanta(id) > 0) {
                out.println("<h1>Registro Borrado " + "<a href='index.jsp'>Volver a home</a>" + "</h1>");
            }

        }

        if (op.equals("update1")) {
            id = Integer.parseInt(request.getParameter("id"));
            Plantas miPlanta = Plantascrud.getPlanta(id);
            request.setAttribute("miPlanta", miPlanta);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }

        if (op.equals("update2")) {
            String nombre = request.getParameter("nombre");
            float precio = Float.parseFloat(request.getParameter("precio"));
            Plantas miPlanta = new Plantas(id, nombre, precio);
            Plantascrud.actualizaPlanta(miPlanta);
            String mensaje = nombre + " ha sido actualizado";
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("miPlanta", miPlanta);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }

        if (op.equals("insertar")) {
            request.getRequestDispatcher("insert.jsp").forward(request, response);
        }

        if (op.equals("insert2")) { 

            Plantas miPlanta = new Plantas();
            miPlanta.setNombre(request.getParameter("nombre"));
            String precio = request.getParameter("precio");
            miPlanta.setPrecio(Float.parseFloat(precio));
            Plantascrud.insertaPlanta(miPlanta);
            out.println("<h1>"+miPlanta.getNombre()+" se ha insertado " + "<a href='index.jsp'>Volver</a>" + "</h1>");

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
