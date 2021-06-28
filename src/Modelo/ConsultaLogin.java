/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.jdbc.PreparedStatement;
import java.sql.*;

/**
 *
 * @author tomas
 */
public class ConsultaLogin extends Conexion{
    
    
   public boolean buscar(ModeloLogin log)
   {
       PreparedStatement ps=null;
       ResultSet rs=null;
       Connection con=(Connection) conectar();
       
       String sql="select count(*) as val from usuarios where usuario=? and clave=? and estado=1";
       
       try{
           
           ps=(PreparedStatement) con.prepareStatement(sql); //PASAMOS LA SQL DE LA QUERY 
           ps.setString(1, log.getUsuario().trim()); //PASAMOS EL USUARIO A LA QUERY
           ps.setString(2, log.getClave().trim()); //PASAMOS LA CLAVE A LA QUERY
           
           rs=ps.executeQuery(); //Ejecutamos la QUERY
           
           if(rs.next())
           {
               if(rs.getInt("val")!=0)
               {
                   return true;
               }    
           }
           
           return false;
       }catch(SQLException e){
           System.err.println(e);
           return false;
       }finally{   
           try{
               con.close();
           }catch(SQLException e)
           { 
               System.err.println(e);
               return false;    
           }  
        }    
    }  
}
