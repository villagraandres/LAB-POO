<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Contactos</title>
</head>
<body>

<h2>Contactos</h2>

<a href="contactos?action=nuevo">Agregar Contacto</a>
<br><br>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Nombre Completo</th>
        <th>Sexo</th>
        <th>Telefono</th>
        <th>Direccion</th>
        <th>Tipo</th>
        <th>Acciones</th>
    </tr>

    <%
        java.util.List<com.ejemplo.agenda.model.Contacto> lista =
                (java.util.List<com.ejemplo.agenda.model.Contacto>) request.getAttribute("lista");

        if (lista != null) {
            for (com.ejemplo.agenda.model.Contacto c : lista) {
    %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getNombre() %> <%= c.getApellidoPaterno() %> <%= c.getApellidoMaterno() %></td>
            <td><%= c.getSexo() %></td>
            <td><%= c.getTelefono() %></td>
            <td><%= c.getDireccion() %></td>
            <td><%= c.getTipoContacto() %></td>
            <td>
                <a href="contactos?action=editar&id=<%= c.getId() %>">Editar</a>
                |
                <a href="contactos?action=eliminar&id=<%= c.getId() %>">Eliminar</a>
            </td>
        </tr>
    <%
            }
        }
    %>

</table>

</body>
</html>
