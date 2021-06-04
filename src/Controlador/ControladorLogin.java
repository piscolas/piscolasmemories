/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultaLogin;
import Modelo.ModeloLogin;
import Vistas.Login;
import Vistas.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author tomas
 */
public class ControladorLogin implements ActionListener{
    
    private ModeloLogin mod;
    private ConsultaLogin cons;
    private Login frm;
    
    
    public ControladorLogin(ModeloLogin mod,ConsultaLogin cons,Login frm)
    {
        this.mod=mod;
        this.cons=cons;
        this.frm=frm;
        this.frm.btningresar.addActionListener(this);
        this.frm.btnsalir.addActionListener(this);
    }
    
    public void iniciar()
    {
        frm.setTitle("LOGIN PENKA");
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }        
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==frm.btningresar)
        {
            if(frm.frmclave.getPassword().equals("") || frm.frmclave.getPassword().equals(""))
            {
                JOptionPane.showMessageDialog(null,"USUARIO/CLAVE EN BLANCO","ERROR AUTENTICACIÓN",JOptionPane.INFORMATION_MESSAGE);
                frm.frmusuario.requestFocus();
            }else{
                mod.setUsuario(frm.frmusuario.getText().trim());
                mod.setClave(frm.frmclave.getText().trim());
                
                if(cons.buscar(mod))
                {
                    JOptionPane.showMessageDialog(null,"USUARIO VÁLIDO","BIENVENIDO",JOptionPane.INFORMATION_MESSAGE);
                    frm.dispose();
                    MenuPrincipal menu=new MenuPrincipal();
                    menu.setVisible(true);
                    menu.setLocationRelativeTo(null);
                }else{
                    JOptionPane.showMessageDialog(null,"USUARIO NO EXISTE","ERROR AUTENTICACIÓN",JOptionPane.INFORMATION_MESSAGE);
                    frm.frmusuario.requestFocus();
                }    
            }    
        }
        
        
        if(e.getSource()==frm.btnsalir)
        {
            cerrar();
        }
    }
    
    public void cerrar()
    {
        int resp=JOptionPane.showConfirmDialog(null,"¿Esta seguro/a que desea salir del sistema?","Confirmación de Cierre",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(resp==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    } 
    
}
