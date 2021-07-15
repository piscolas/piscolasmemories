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
public class CrudLibro extends Conexion {

    public boolean insertar(Libro libro) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql = "INSERT INTO libro (numeroSerie,isbn,titulo,numpagina,precio,anhopublicacion,estado,Biblioteca_idBiblioteca) VALUES(?,?,?,?,?,?,?,100)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, libro.getNumSerie());
            ps.setString(2, libro.getISBNLibro());
            ps.setString(3, libro.getTitulo());
            ps.setInt(4, libro.getNumPag());
            ps.setInt(5, libro.getPrecio());
            ps.setInt(6, libro.getAñoPub());
            ps.setInt(7, libro.getEstadoLibro());
            ps.setInt(8, libro.getIdEditorial());
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

    public boolean modificar(Libro libro) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql = "UPDATE libro SET numeroSerie=?,isbn=?,titulo=?,numpagina=?,precio=?,anhopublicacion=?,estado=?,editorial_idEditorial=? WHERE idLibro=?";
        try {
            ps.setInt(1, libro.getNumSerie());
            ps.setString(2, libro.getISBNLibro());
            ps.setString(3, libro.getTitulo());
            ps.setInt(4, libro.getNumPag());
            ps.setInt(5, libro.getPrecio());
            ps.setInt(6, libro.getAñoPub());
            ps.setInt(7, libro.getEstadoLibro());
            ps.setInt(8, libro.getIdEditorial());
            ps.setInt(9, libro.getID_Libro());
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

    public boolean eliminar(Libro libro) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql = "DELETE FROM libro WHERE idLibro=?";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, libro.getID_Libro());
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

    public ArrayList<Libro> ListaLibros() {

        ArrayList<Libro> listaLibros = new ArrayList<Libro>();
        com.mysql.jdbc.PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) conectar();

        String sql = "Select idLibro,numeroSerie,isbn,titulo,numpagina,precio,anhopublicacion,estado,editorial_idEditorial from libro";

        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setID_Libro(rs.getInt(1));
                libro.setNumSerie(rs.getInt(2));
                libro.setISBNLibro(rs.getString(3));
                libro.setTitulo(rs.getString(4));
                libro.setNumPag(rs.getInt(5));
                libro.setPrecio(rs.getInt(6));
                libro.setAñoPub(rs.getInt(7));
                libro.setEstadoLibro(rs.getInt(8));
                libro.setIdEditorial(rs.getInt(9));

                listaLibros.add(libro);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return listaLibros;
    }



        public ArrayList<Autor> ListaAutor() {

            ArrayList<Autor> listaautores = new ArrayList<Autor>();
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = (Connection) conectar();

            String sql = "select * from autor where estado=1";

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
                    auto.setEstado(rs.getInt(6));
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


