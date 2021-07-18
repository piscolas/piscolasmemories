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
public class CrudAutor extends Conexion {

    public boolean insertar(Autor autor) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql = "INSERT INTO autor (nombreAutor,apPaternoAutor,apMaternoAutor,alias,Nacionalidad,Sexo,estado) VALUES(?,?,?,?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getApPaterno());
            ps.setString(3, autor.getApMaterno());
            ps.setString(4, autor.getAlias());
            ps.setString(5, autor.getNacionalidad());
            ps.setInt(6, autor.getSexo());
            ps.setInt(7, autor.getEstado());
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

    public boolean modificar(Autor autor) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql
                = "UPDATE autor SET nombreAutor =  ?,apPaternoAutor =  ?,apMaternoAutor =  ?,alias =  ?, Nacionalidad=?, Sexo=?, estado=? where  idAutor =  ? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getApPaterno());
            ps.setString(3, autor.getApMaterno());
            ps.setString(4, autor.getAlias());
            ps.setString(5, autor.getNacionalidad());
            ps.setInt(6, autor.getSexo());
            ps.setInt(7, autor.getEstado());
            ps.setInt(8, autor.getId_autor());
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

    public boolean eliminar(Autor autor) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql = "DELETE from autor where idAutor=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, autor.getId_autor());
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

    public ArrayList<Autor> ListaAutor() {

        ArrayList<Autor> listaautores = new ArrayList<Autor>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) conectar();

        String sql = "select * from autor";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Autor auto = new Autor();
                auto.setId_autor(rs.getInt(1));
                auto.setNombre(rs.getString(2));
                auto.setApPaterno(rs.getString(3));
                auto.setApMaterno(rs.getString(4));
                auto.setAlias(rs.getString(5));
                auto.setNacionalidad(rs.getString(6));
                auto.setSexo(rs.getInt(7));
                auto.setEstado(rs.getInt(8));

                listaautores.add(auto);
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
        return listaautores;
    }

}
