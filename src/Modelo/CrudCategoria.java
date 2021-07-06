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
public class CrudCategoria extends Conexion{
    
    public boolean insertar(Categoria cat) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql = "INSERT INTO categoria (nombreCategoria, estadoCategoria) values (?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, cat.getNombreCAT());
            ps.setInt(2, cat.getEstadoCAT());
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
    
    public boolean modificar(Categoria cat) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql = "UPDATE categoria SET nombreCategoria=?,estadoCategoria=? WHERE idCategoria=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, cat.getNombreCAT());
            ps.setInt(2, cat.getEstadoCAT());
            ps.setInt(3, cat.getID_CAT());
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
    
    public boolean eliminar(Categoria cat) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql = "DELETE from categoria where idCategoria=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, cat.getID_CAT());
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
    
    public ArrayList<Categoria> ListaCategoria() {

        ArrayList<Categoria> listacategoria = new ArrayList<Categoria>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) conectar();

        String sql = "select idCategoria,nombreCategoria,estadoCategoria from categoria";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setID_CAT(rs.getInt(1));
                cat.setNombreCAT(rs.getString(2));
                cat.setEstadoCAT(rs.getInt(3));

                listacategoria.add(cat);
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
        return listacategoria;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
