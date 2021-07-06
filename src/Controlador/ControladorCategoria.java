/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.CrudCategoria;
import Modelo.ExportarExcel;
import Vistas.FormCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
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
 * @author some-
 */
public class ControladorCategoria implements ActionListener {

    private Categoria cat;
    private CrudCategoria cons;
    private FormCategoria frm;

    public ControladorCategoria(Categoria cat, CrudCategoria cons, FormCategoria frm) {
        this.cat = cat;
        this.cons = cons;
        this.frm = frm;
        this.frm.boxEstado.addActionListener(this);
        this.frm.btnELIMINAR.addActionListener(this);
        this.frm.btnEXPORTAR.addActionListener(this);
        this.frm.btnINGRESAR.addActionListener(this);
        this.frm.btnMODIFICAR.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Mantenedor de Categorias");
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        frm.btnMODIFICAR.setEnabled(false);
        frm.btnELIMINAR.setEnabled(false);
        limpiar();

        frm.tablaCATEGORIAS.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent evt) {
                JTable tabla = (JTable) evt.getSource();
                int row = tabla.rowAtPoint(evt.getPoint());
                TableModel model = tabla.getModel();
                frm.field_idOculto.setText(String.valueOf(model.getValueAt(row, 0)));
                frm.fieldCategoria.setText(String.valueOf(model.getValueAt(row, 1)));

                if (model.getValueAt(row, 2).equals("ACTIVO")) {
                    frm.boxEstado.setSelectedItem("ACTIVO");
                } else {
                    frm.boxEstado.setSelectedItem("INACTIVO");
                }

                frm.btnINGRESAR.setVisible(false);
                frm.btnMODIFICAR.setEnabled(true);
                frm.btnELIMINAR.setEnabled(true);
            }
        });
        frm.fieldBUSCAR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscar(frm.fieldBUSCAR.getText(), frm.tablaCATEGORIAS);
            }
        });
    }

    public void limpiar() {
        frm.fieldCategoria.setText("");
        frm.field_idOculto.setText("");
        frm.fieldBUSCAR.setText("");
        frm.boxEstado.setSelectedIndex(0);
        frm.btnMODIFICAR.setEnabled(false);
        frm.btnELIMINAR.setEnabled(false);
        frm.field_idOculto.setVisible(false);
        frm.btnINGRESAR.setVisible(true);
        frm.fieldCategoria.requestFocus();

        cargarTabla(frm.tablaCATEGORIAS);
        frm.lbl_LISTADO.setText("Total de Registros ( " + frm.tablaCATEGORIAS.getRowCount() + " )");
    }

    public void buscar(String consulta, JTable jtableBuscar) {
        DefaultTableModel dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + consulta));
    }

    public void cargarTabla(JTable tablaCategoria) {
        DefaultTableModel modeloC = new DefaultTableModel();

        tablaCategoria.setModel(modeloC);
        modeloC.addColumn("ID");
        modeloC.addColumn("NOMBRE");
        modeloC.addColumn("ESTADO");

        Object[] columna = new Object[3];

        int numregistros = cons.ListaCategoria().size();
        for (int i = 0; i <= numregistros - 1; i++) {
            columna[0] = cons.ListaCategoria().get(i).getID_CAT();
            columna[1] = cons.ListaCategoria().get(i).getNombreCAT();
            columna[2] = cons.ListaCategoria().get(i).getEstadoCAT();

            if (columna[2].equals(1)) {
                columna[2] = "ACTIVO";
            } else {
                columna[2] = "INACTIVO";
            }
            modeloC.addRow(columna);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frm.btnINGRESAR) {
            if (frm.fieldCategoria.getText().equals("") || frm.boxEstado.getSelectedItem().equals("Seleccionar")) {
                JOptionPane.showMessageDialog(null, "Hay campos en Blanco!");
            } else {

                cat.setNombreCAT(frm.fieldCategoria.getText());

                if (frm.boxEstado.getSelectedItem() != "Seleccionar") {
                    if (frm.boxEstado.getSelectedItem() == "ACTIVO") {
                        cat.setEstadoCAT(1);
                    } else {
                        cat.setEstadoCAT(0);
                    }
                }
                if (cons.insertar(cat)) {
                    JOptionPane.showMessageDialog(null, "Categoria INGRESADA sin Problemas");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al INGRESAR la Categoria");
                    limpiar();
                }
            }
        }

        if (e.getSource() == frm.btnMODIFICAR) {
            cat.setNombreCAT(frm.fieldCategoria.getText());
            if (frm.boxEstado.getSelectedItem() != "Seleccionar") {
                if (frm.boxEstado.getSelectedItem() == "ACTIVO") {
                    cat.setEstadoCAT(1);
                } else {
                    cat.setEstadoCAT(0);
                }
            }
            cat.setID_CAT(Integer.parseInt(frm.field_idOculto.getText()));

            if (cons.modificar(cat)) {
                JOptionPane.showMessageDialog(null, "Los datos de Categoria han sido MODIFICADOS sin problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al MODIFICAR una Categoria");
            }
        }

        if (e.getSource() == frm.btnELIMINAR) {
            cat.setID_CAT(Integer.parseInt(frm.field_idOculto.getText()));
            if (cons.eliminar(cat)) {
                JOptionPane.showMessageDialog(null, "La categoria ha sido ELIMINADA sin problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al ELIMINAR la Categoria");
            }
        }

        if (e.getSource() == frm.btnEXPORTAR) {
            if (frm.tablaCATEGORIAS.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No hay datos en la tabla para exportar.", "Exportación Categorias", JOptionPane.INFORMATION_MESSAGE);
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
                tb.add(frm.tablaCATEGORIAS);
                nom.add("Detalle de Gastos");
                String file = chooser.getSelectedFile().toString().concat(".xls");
                try {
                    ExportarExcel exporta = new ExportarExcel(new File(file), tb, nom);
                    if (exporta.exportar()) {
                        JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel.", "Exportación Datos Categorias", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Hubo un  error" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

}
