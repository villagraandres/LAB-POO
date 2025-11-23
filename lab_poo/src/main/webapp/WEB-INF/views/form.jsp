<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ejemplo.agenda.model.Contacto" %>

<%
    Contacto c = (Contacto) request.getAttribute("contacto");
%>

<html>
<head>
    <title>Formulario</title>
</head>
<body>

<h2><%= (c.getId() == null ? "Nuevo Contacto" : "Editar Contacto") %></h2>

<form action="contactos" method="post">

    <input type="hidden" name="id" value="<%= c.getId() == null ? "" : c.getId() %>">

    Nombre:<br>
    <input type="text" name="nombre" value="<%= c.getNombre() %>" required><br><br>

    Apellido Paterno:<br>
    <input type="text" name="apellidoPaterno" value="<%= c.getApellidoPaterno() %>" required><br><br>

    Apellido Materno:<br>
    <input type="text" name="apellidoMaterno" value="<%= c.getApellidoMaterno() %>" required><br><br>

    Sexo:<br>
    <select name="sexo">
        <option value="M" <%= "M".equals(c.getSexo()) ? "selected" : "" %>>M</option>
        <option value="F" <%= "F".equals(c.getSexo()) ? "selected" : "" %>>F</option>
        <option value="O" <%= "O".equals(c.getSexo()) ? "selected" : "" %>>O</option>
    </select>
    <br><br>

    Teléfono:<br>
    <input type="text" name="telefono" value="<%= c.getTelefono() %>"><br><br>

    Dirección:<br>
    <input type="text" name="direccion" value="<%= c.getDireccion() %>"><br><br>

    Tipo de Contacto:<br>
    <select name="tipoContacto">
        <option value="CASA" <%= "CASA".equals(c.getTipoContacto()) ? "selected" : "" %>>CASA</option>
        <option value="TRABAJO" <%= "TRABAJO".equals(c.getTipoContacto()) ? "selected" : "" %>>TRABAJO</option>
    </select>
    <br><br>

    <button type="submit">Guardar</button>
</form>

<br>
<a href="contactos">Volver</a>

</body>
</html>
