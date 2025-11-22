package com.ejemplo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Muestra el formulario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Formulario</title></head><body>");
        out.println("<h2>Formulario de Datos</h2>");
        out.println("<form method='POST' action='FormServlet'>");
        out.println("Nombre: <input type='text' name='nombre'><br><br>");
        out.println("Apellido: <input type='text' name='apellido'><br><br>");
        out.println("Email: <input type='email' name='mail'><br><br>");
        out.println("Teléfono: <input type='text' name='telefono'><br><br>");
        out.println("<input type='submit' value='Enviar'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    // Procesa el formulario
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // para recibir acentos correctamente
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String mail = request.getParameter("mail");
        String telefono = request.getParameter("telefono");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Datos Recibidos</title></head><body>");
        out.println("<h2>Datos recibidos:</h2>");
        out.println("<p>Nombre: " + nombre + "</p>");
        out.println("<p>Apellido: " + apellido + "</p>");
        out.println("<p>Email: " + mail + "</p>");
        out.println("<p>Teléfono: " + telefono + "</p>");
        out.println("</body></html>");
    }
}
