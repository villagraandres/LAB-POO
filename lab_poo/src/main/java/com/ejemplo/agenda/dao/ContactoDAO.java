package com.ejemplo.agenda.dao;

import com.ejemplo.agenda.model.Contacto;
import com.ejemplo.agenda.util.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {

    // LISTAR TODOS
    public List<Contacto> listar() {
        List<Contacto> lista = new ArrayList<>();

        String sql = "SELECT * FROM contactos";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Contacto c = new Contacto();

                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellidoPaterno(rs.getString("apellido_paterno"));
                c.setApellidoMaterno(rs.getString("apellido_materno"));
                c.setSexo(rs.getString("sexo"));
                c.setTelefono(rs.getString("telefono"));
                c.setDireccion(rs.getString("direccion"));
                c.setTipoContacto(rs.getString("tipo_contacto"));

                lista.add(c);
            }

        } catch (Exception e) {
            System.out.println("Error listando: " + e.getMessage());
        }

        return lista;
    }

    // OBTENER POR ID
    public Contacto obtener(int id) {
        Contacto c = null;
        String sql = "SELECT * FROM contactos WHERE id = ?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Contacto();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellidoPaterno(rs.getString("apellido_paterno"));
                c.setApellidoMaterno(rs.getString("apellido_materno"));
                c.setSexo(rs.getString("sexo"));
                c.setTelefono(rs.getString("telefono"));
                c.setDireccion(rs.getString("direccion"));
                c.setTipoContacto(rs.getString("tipo_contacto"));
            }

        } catch (Exception e) {
            System.out.println("Error obteniendo contacto: " + e.getMessage());
        }

        return c;
    }

    // AGREGAR
    public boolean agregar(Contacto c) {
        String sql = "INSERT INTO contactos (nombre, apellido_paterno, apellido_materno, sexo, telefono, direccion, tipo_contacto) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellidoPaterno());
            ps.setString(3, c.getApellidoMaterno());
            ps.setString(4, c.getSexo());
            ps.setString(5, c.getTelefono());
            ps.setString(6, c.getDireccion());
            ps.setString(7, c.getTipoContacto());

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            System.out.println("Error agregando: " + e.getMessage());
        }

        return false;
    }

    // ACTUALIZAR
    public boolean actualizar(Contacto c) {
        String sql = "UPDATE contactos SET nombre=?, apellido_paterno=?, apellido_materno=?, sexo=?, telefono=?, direccion=?, tipo_contacto=? "
                   + "WHERE id=?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellidoPaterno());
            ps.setString(3, c.getApellidoMaterno());
            ps.setString(4, c.getSexo());
            ps.setString(5, c.getTelefono());
            ps.setString(6, c.getDireccion());
            ps.setString(7, c.getTipoContacto());
            ps.setInt(8, c.getId());

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            System.out.println("Error actualizando: " + e.getMessage());
        }

        return false;
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM contactos WHERE id = ?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            System.out.println("Error eliminando: " + e.getMessage());
        }

        return false;
    }
}
