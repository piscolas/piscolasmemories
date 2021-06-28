/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;

/**
 *
 * @author tomas
 */
public class CrudUsuarios extends Conexion{
    
    public boolean insertar(Usuarios usu)
    {
        PreparedStatement ps=null;
        Connection con=(Connection) conectar();
        String sql="INSERT INTO usuarios (Nombre,usuario,clave,estado,Biblioteca_idBiblioteca) VALUES (?,?,?,?,100)";
        try
        {
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getUsuario());
            ps.setString(3, usu.getClave());
            ps.setInt(4, usu.getEstado());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch (SQLException e)
            {
                System.err.println(e);
                return false;
            }                        
        }    
    }
    
    public boolean modificar(Usuarios usu)
    {
        PreparedStatement ps=null;
        Connection con=(Connection) conectar();
        String sql="UPDATE usuarios SET Nombre=?,usuario=?,clave=?,estado=? WHERE Id=?";
        try
        {
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getUsuario());
            ps.setString(3, usu.getClave()); //PASAR LA CLAVE CIFRADA CON EL HASH
            ps.setInt(4, usu.getEstado());
            ps.setInt(5, usu.getId());            
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch (SQLException e)
            {
                System.err.println(e);
                return false;
            }                        
        }    
    }
    
    public boolean eliminar(Usuarios usu)
    {
        PreparedStatement ps=null;
        Connection con=(Connection) conectar();
        String sql="DELETE FROM usuarios WHERE Id=?";
        try
        {
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, usu.getId());            
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch (SQLException e)
            {
                System.err.println(e);
                return false;
            }                        
        }    
    }
    
    public ArrayList<Usuarios> ListaUsuario(){
       
        ArrayList<Usuarios> listaUsuarios=new ArrayList<Usuarios>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=(Connection) conectar();
        
        String sql="Select Id,Nombre,usuario,estado from usuarios";
        
        try
        {
            ps=(PreparedStatement) con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                Usuarios usu=new Usuarios();
                usu.setId(rs.getInt(1));
                usu.setNombre(rs.getString(2));
                usu.setUsuario(rs.getString(3));
                usu.setEstado(rs.getInt(4));
                listaUsuarios.add(usu);
            }    
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                con.close();
            }catch (SQLException e)
            {
                System.err.println(e);
            }                        
        }
        return listaUsuarios;     
    }    
}
