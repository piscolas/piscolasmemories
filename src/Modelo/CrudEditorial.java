/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author some-
 */
public class CrudEditorial extends Conexion {

    public boolean insertar(Editorial edit) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql = "INSERT INTO editorial (nombreEditorial, estadoEditorial) values (?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, edit.getNombreEditorial());
            ps.setInt(2, edit.getEstadoEditorial());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

    public boolean modificar(Editorial edit) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql = "UPDATE editorial SET nombreEditorial=?,estadoEditorial=? WHERE idEditorial=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, edit.getNombreEditorial());
            ps.setInt(2, edit.getEstadoEditorial());
            ps.setInt(3, edit.getIdEditorial());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
                return false;
            }
        }
    }

    public boolean eliminar(Editorial edit) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql = "DELETE from editorial where idEditorial=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, edit.getIdEditorial());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

    public ArrayList<Editorial> ListaEditorial() {

        ArrayList<Editorial> listaeditorial = new ArrayList<Editorial>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) conectar();

        String sql = "select idEditorial,nombreEditorial,estadoEditorial from editorial";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Editorial editorial = new Editorial();
                editorial.setIdEditorial(rs.getInt(1));
                editorial.setNombreEditorial(rs.getString(2));
                editorial.setEstadoEditorial(rs.getInt(3));

                listaeditorial.add(editorial);
            }
            ps.close();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return listaeditorial;
    }
}
