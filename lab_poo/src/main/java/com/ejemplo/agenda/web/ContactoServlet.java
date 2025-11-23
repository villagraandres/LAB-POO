package com.ejemplo.agenda.web;

import com.ejemplo.agenda.dao.ContactoDAO;
import com.ejemplo.agenda.model.Contacto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/contactos")
public class ContactoServlet extends HttpServlet {

    private ContactoDAO dao = new ContactoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "listar";
        }

        switch (action) {

            case "nuevo":
                // Formulario vacío
                request.setAttribute("contacto", new Contacto());
                request.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                Contacto contactoExistente = dao.obtener(idEditar);

                request.setAttribute("contacto", contactoExistente);
                request.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(request, response);  // ← CAMBIADO de lista.jsp a form.jsp
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idEliminar);
                response.sendRedirect("contactos");
                break;

            default:  // listar
                List<Contacto> lista = dao.listar();
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("/WEB-INF/views/lista.jsp").forward(request, response);  // ← AGREGADO /WEB-INF/
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");

        Contacto c = new Contacto();

        if (idStr != null && !idStr.isEmpty()) {
            c.setId(Integer.parseInt(idStr));
        }

        c.setNombre(request.getParameter("nombre"));
        c.setApellidoPaterno(request.getParameter("apellidoPaterno"));
        c.setApellidoMaterno(request.getParameter("apellidoMaterno"));
        c.setSexo(request.getParameter("sexo"));
        c.setTelefono(request.getParameter("telefono"));
        c.setDireccion(request.getParameter("direccion"));
        c.setTipoContacto(request.getParameter("tipoContacto"));

        if (c.getId() == null) {
            dao.agregar(c);       // crear
        } else {
            dao.actualizar(c);    // editar
        }

        response.sendRedirect("contactos");
    }
}