/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.Hash;
import Modelo.CrudIdiomas;
import Modelo.ExportarExcel;
import Modelo.Idioma;
import Vistas.FormIdiomas;
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
public class ControladorIdioma implements ActionListener {

    private Idioma idi;
    private CrudIdiomas cons;
    private FormIdiomas frm;

    public ControladorIdioma(Idioma idi, CrudIdiomas cons, FormIdiomas frm) {
        this.idi = idi;
        this.frm = frm;
        this.cons = cons;
        this.frm.btnINGRESARMI.addActionListener(this);
        this.frm.btnELIMINARMI.addActionListener(this);
        this.frm.btnVolverMI.addActionListener(this);
        this.frm.btnExportar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Mantenedor de Idiomas");
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        frm.btnELIMINARMI.setEnabled(false);
        limpiar();

        frm.tablaIdiomasMI.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent evt) {
                JTable tabla = (JTable) evt.getSource();
                int row = tabla.rowAtPoint(evt.getPoint());
                TableModel model = tabla.getModel();
                frm.field_id_oculto.setText(String.valueOf(model.getValueAt(row, 0)));
                frm.fieldNombreIdiomaMI.setText(String.valueOf(model.getValueAt(row, 1)));

                frm.btnINGRESARMI.setVisible(false);
                frm.btnELIMINARMI.setEnabled(true);
            }
        });
        frm.fieldBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscar(frm.fieldBuscar.getText(), frm.tablaIdiomasMI);
            }
        });
    }

    public void limpiar() {
        frm.fieldNombreIdiomaMI.setText("");
        frm.field_id_oculto.setText("");
        frm.fieldBuscar.setText("");
        frm.btnELIMINARMI.setEnabled(false);
        frm.field_id_oculto.setVisible(false);
        frm.btnINGRESARMI.setVisible(true);
        frm.fieldNombreIdiomaMI.requestFocus();

        cargarTabla(frm.tablaIdiomasMI);
        frm.lblListadoIdiomasMI.setText("Total de Registros ( " + frm.tablaIdiomasMI.getRowCount() + " )");
    }

    public void buscar(String consulta, JTable jtableBuscar) {
        DefaultTableModel dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + consulta));
    }

    public void cargarTabla(JTable tablaUsuarios) {
        DefaultTableModel modeloI = new DefaultTableModel();
        tablaUsuarios.setModel(modeloI);
        modeloI.addColumn("ID");
        modeloI.addColumn("IDIOMA");

        Object[] columna = new Object[2];
        int numeroRegistros = cons.ListaIdiomas().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = cons.ListaIdiomas().get(i).getIdIdioma();
            columna[1] = cons.ListaIdiomas().get(i).getNombreIdioma();

            modeloI.addRow(columna);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frm.btnINGRESARMI) {

            idi.setNombreIdioma(frm.fieldNombreIdiomaMI.getText());

            if (cons.insertar(idi)) {
                JOptionPane.showMessageDialog(null, "El Idioma se ha INGRESADO sin problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al INGRESAR Idioma");
                limpiar();
            }

        }

        if (e.getSource() == frm.btnELIMINARMI) {
            idi.setIdIdioma(Integer.parseInt(frm.field_id_oculto.getText()));
            if (cons.eliminar(idi)) {
                JOptionPane.showMessageDialog(null, "El Idioma ha sido ELIMINADO sin problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al ELIMINAR el Idioma");
            }
        }

        if (e.getSource() == frm.btnExportar) {
            if (frm.tablaIdiomasMI.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No hay datos en la tabla para exportar.", "Exportación Idioma", JOptionPane.INFORMATION_MESSAGE);
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
                tb.add(frm.tablaIdiomasMI);
                nom.add("Detalle de Gastos");
                String file = chooser.getSelectedFile().toString().concat(".xls");
                try {
                    ExportarExcel exporta = new ExportarExcel(new File(file), tb, nom);
                    if (exporta.exportar()) {
                        JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel.", "Exportación de Datos de Idiomas", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Hubo un  error" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

}
