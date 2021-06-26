/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.Hash;
import Modelo.CrudUsuarios;
import Modelo.Usuarios;
import Vistas.FormUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author tomas
 */
public class ControladorUsuarios implements ActionListener {

    private FormUsuario frm;
    private CrudUsuarios cons;
    private Usuarios usu;

    public ControladorUsuarios(FormUsuario frm, CrudUsuarios cons, Usuarios usu) {
        this.frm = frm;
        this.cons = cons;
        this.usu = usu;
        this.frm.btningresar.addActionListener(this);
        this.frm.btnlimpiar.addActionListener(this);
        this.frm.btneliminar.addActionListener(this);
        this.frm.btnExportarMU.addActionListener(this);
        this.frm.btnModificarMU.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("MANTENEDOR DE USUARIOS");
        frm.setLocationRelativeTo(null);
        frm.fieldNombreCompletoMU.requestFocus();
        frm.btnModificarMU.setEnabled(false);
        frm.btneliminar.setEnabled(false);
        limpiar();
    }

    public void limpiar() {
        frm.fieldNombreCompletoMU.setText("");
        frm.fieldUsuarioMU.setText("");
        frm.fieldContraseñaMU.setText("");
        frm.fieldRepContrasenaMU.setText("");
        frm.fieldNombreCompletoMU.requestFocus();
        frm.btningresar.setVisible(true);
        frm.btnModificarMU.setEnabled(false);
        frm.btneliminar.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btningresar) {

            usu.setNombre(frm.fieldNombreCompletoMU.getText());
            usu.setUsuario(frm.fieldUsuarioMU.getText());
            usu.setClave(Hash.md5(String.valueOf(frm.fieldRepContrasenaMU)));
            usu.setEstado(1);

            if (cons.insertar(usu)) {
                JOptionPane.showMessageDialog(null, "El Usuario se ha INGRESADO sin problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al INGRESAR Usuario");
                limpiar();
            }

        }

        if (e.getSource() == frm.btnModificarMU) {
            usu.setNombre(frm.fieldNombreCompletoMU.getText());
            usu.setUsuario(frm.fieldUsuarioMU.getText());
            usu.setClave(Hash.md5(String.valueOf(frm.fieldRepContrasenaMU.getPassword())));
            usu.setEstado(1);
            usu.setId(Integer.parseInt(frm.frm_idoculto.getText()));

            if (cons.modificar(usu)) {
                JOptionPane.showMessageDialog(null, "Los datos del Usuario han sido MODIFICADOS sin problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al MODIFICAR los datos del Usuario");
            }
        }

        if (e.getSource() == frm.btneliminar) {
            usu.setId(Integer.parseInt(frm.frm_idoculto.getText()));
            if (cons.eliminar(usu)) {
                JOptionPane.showMessageDialog(null, "El Usuario ha sido ELIMINADO sin problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al ELIMINAR los datos del Usuario");
            }
        }
        
        if (e.getSource() == frm.btnlimpiar) {
            limpiar();
        }
    }

}
