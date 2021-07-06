/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.Hash;
import Modelo.CrudUsuarios;
import Modelo.ExportarExcel;
import Modelo.Usuarios;
import Vistas.FormUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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

        frm.tableListadoUsuariosMU.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent evt) {
                JTable tabla = (JTable) evt.getSource();
                int row = tabla.rowAtPoint(evt.getPoint());
                TableModel model = tabla.getModel();
                frm.frm_idoculto.setText(String.valueOf(model.getValueAt(row, 0)));
                frm.fieldNombreCompletoMU.setText(String.valueOf(model.getValueAt(row, 1)));
                frm.fieldUsuarioMU.setText(String.valueOf(model.getValueAt(row, 2)));

                if (model.getValueAt(row, 3).equals("ACTIVO")) {
                    frm.BoxEstadoMU.setSelectedItem("ACTIVO");
                } else {
                    frm.BoxEstadoMU.setSelectedItem("INACTIVO");
                }

                frm.fieldContraseñaMU.setVisible(false);
                frm.fieldRepContrasenaMU.setVisible(false);
                frm.lblContrasenaMU.setVisible(false);
                frm.lblRepContrasenaMU.setVisible(false);
                frm.btningresar.setVisible(false);
                frm.btnModificarMU.setEnabled(true);
                frm.btneliminar.setEnabled(true);
            }
        });
        frm.frmbuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscar(frm.frmbuscar.getText(), frm.tableListadoUsuariosMU);
            }
        });
    }

    public void limpiar() {
        frm.fieldContraseñaMU.setVisible(true);
        frm.fieldRepContrasenaMU.setVisible(true);
        frm.lblContrasenaMU.setVisible(true);
        frm.lblRepContrasenaMU.setVisible(true);
        frm.fieldNombreCompletoMU.setText("");
        frm.fieldUsuarioMU.setText("");
        frm.fieldContraseñaMU.setText("");
        frm.fieldRepContrasenaMU.setText("");
        frm.fieldNombreCompletoMU.requestFocus();
        frm.btningresar.setVisible(true);
        frm.btnModificarMU.setEnabled(false);
        frm.btneliminar.setEnabled(false);
        frm.frm_idoculto.setVisible(false);
        frm.BoxEstadoMU.setSelectedIndex(0);

        cargarTabla(frm.tableListadoUsuariosMU);
        frm.lblListadoUsuariosMU.setText("LISTADO DE USUARIOS (" + frm.tableListadoUsuariosMU.getRowCount() + ")");
    }

    public void buscar(String consulta, JTable jtableBuscar) {
        DefaultTableModel dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + consulta));
    }

    public void cargarTabla(JTable tablaUsuarios) {
        DefaultTableModel modeloU = new DefaultTableModel();
        tablaUsuarios.setModel(modeloU);
        modeloU.addColumn("ID");
        modeloU.addColumn("NOMBRE");
        modeloU.addColumn("USUARIO");
        modeloU.addColumn("ESTADO");

        Object[] columna = new Object[4];
        int numeroRegistros = cons.ListaUsuario().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = cons.ListaUsuario().get(i).getId();
            columna[1] = cons.ListaUsuario().get(i).getNombre();
            columna[2] = cons.ListaUsuario().get(i).getUsuario();
            columna[3] = cons.ListaUsuario().get(i).getEstado();

            if (columna[3].equals(1)) {
                columna[3] = "ACTIVO";

            } else {
                columna[3] = "INACTIVO";
            }
            modeloU.addRow(columna);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btningresar) {
            if (frm.fieldNombreCompletoMU.getText().equals("") || frm.fieldUsuarioMU.getText().equals("") || frm.fieldContraseñaMU.getPassword().equals("") || frm.fieldRepContrasenaMU.getPassword().equals("") || frm.BoxEstadoMU.getSelectedItem().equals("Seleccionar")) {
                JOptionPane.showMessageDialog(null, "Hay campos en Blanco!");

            } else {
                if (Arrays.equals(frm.fieldContraseñaMU.getPassword(), frm.fieldRepContrasenaMU.getPassword())) {

                    usu.setNombre(frm.fieldNombreCompletoMU.getText());
                    usu.setUsuario(frm.fieldUsuarioMU.getText());
                    usu.setClave(Hash.md5(String.valueOf(frm.fieldRepContrasenaMU)));

                    if (frm.BoxEstadoMU.getSelectedItem() != "Seleccionar") {
                        if (frm.BoxEstadoMU.getSelectedItem() == "ACTIVO") {
                            usu.setEstado(1);
                        } else {
                            usu.setEstado(0);
                        }
                    }

                    if (cons.insertar(usu)) {
                        JOptionPane.showMessageDialog(null, "El Usuario se ha INGRESADO sin problemas");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al INGRESAR Usuario");
                        limpiar();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Contraseñas no coinciden!");
                }
            }

        }

        if (e.getSource() == frm.btnModificarMU) {
            usu.setNombre(frm.fieldNombreCompletoMU.getText());
            usu.setUsuario(frm.fieldUsuarioMU.getText());
            usu.setClave(Hash.md5(String.valueOf(frm.fieldRepContrasenaMU.getPassword())));
            if (frm.BoxEstadoMU.getSelectedItem() != "Seleccionar") {
                if (frm.BoxEstadoMU.getSelectedItem() == "ACTIVO") {
                    usu.setEstado(1);
                } else {
                    usu.setEstado(0);
                }
            }
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
        if (e.getSource() == frm.btnExportarMU) {
            if (frm.tableListadoUsuariosMU.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No hay datos en la tabla para exportar.", "Exportación Autores", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setMultiSelectionEnabled(false);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                List<JTable> tb = new ArrayList<>();
                List<String> nom = new ArrayList<>();
                tb.add(frm.tableListadoUsuariosMU);
                nom.add("Detalle de Gastos");
                String file = chooser.getSelectedFile().toString().concat(".xls");
                try {
                    ExportarExcel exporta = new ExportarExcel(new File(file), tb, nom);
                    if (exporta.exportar()) {
                        JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel.", "Exportación Datos Autores", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Hubo un  error" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}
