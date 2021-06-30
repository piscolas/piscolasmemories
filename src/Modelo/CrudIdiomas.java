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
public class CrudIdiomas extends Conexion {

    public boolean insertar(Idioma idi) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql = "INSERT INTO idioma (nombreIdioma) values (?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, idi.getNombreIdioma());
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

    public boolean modificar(Idioma idi) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql = "UPDATE idioma SET nombreIdioma=? WHERE ididioma=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, idi.getNombreIdioma());
            ps.setInt(2, idi.getIdIdioma());
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

    public boolean eliminar(Idioma idi) {
        PreparedStatement ps = null;
        Connection con = (Connection) conectar();
        String sql = "DELETE from idioma where ididioma=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, idi.getIdIdioma());
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

    public ArrayList<Idioma> ListaIdiomas() {

        ArrayList<Idioma> listaIdiomas = new ArrayList<Idioma>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) conectar();

        String sql = "Select ididioma,nombreIdioma from idioma";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Idioma idi = new Idioma();
                idi.setIdIdioma(rs.getInt(1));
                idi.setNombreIdioma(rs.getString(2));
                listaIdiomas.add(idi);
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
        return listaIdiomas;
    }
}
