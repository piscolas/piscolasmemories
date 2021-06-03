/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabiblioteca;

import Controlador.ControladorLogin;
import Modelo.ConsultaLogin;
import Modelo.ModeloLogin;
import Vistas.Login;

/**
 *
 * @author tomas
 */
public class SistemaBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    ModeloLogin mod=new ModeloLogin();
    ConsultaLogin cons=new ConsultaLogin();
    Login frm=new Login();
    
    ControladorLogin ctrl=new ControladorLogin(mod,cons,frm);
    ctrl.iniciar();
        
    }
    
}
