/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;

/**
 *
 * @author tomas
 */
public class Conexion {

    private final String bd = "Sistema_de_Biblioteca";
    private final String usuario = "root";
    private final String clave = "12345678";
    private final String url = "jdbc:mysql://localhost:3306/Sistema_de_Biblioteca";

    private Connection con = null;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.usuario, this.clave);
            System.out.println("* HA INGRESADO CORRECTAMENTE A LA BASE DE DATOS *");

        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
        return con;
    }

}
