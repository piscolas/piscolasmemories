/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.Hash;
import Modelo.Autor;
import Modelo.CrudAutor;
import Modelo.ExportarExcel;
import Vistas.FormAutor;
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
public class ControladorAutor implements ActionListener {

    private Autor auto;
    private CrudAutor cons;
    private FormAutor frm;

    public ControladorAutor(Autor auto, CrudAutor cons, FormAutor frm) {
        this.auto = auto;
        this.frm = frm;
        this.cons = cons;
        this.frm.btnINGRESARMA.addActionListener(this);
        this.frm.btnMODIFICAR.addActionListener(this);
        this.frm.btnELIMINAR.addActionListener(this);
        this.frm.btnLIMPIARMA.addActionListener(this);
        this.frm.btnEXPORTAR.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Mantenedor de Autores");
        frm.setLocationRelativeTo(null);
        frm.fieldNombreMA.requestFocus();
        frm.btnMODIFICAR.setEnabled(false);
        frm.btnELIMINAR.setEnabled(false);
        limpiar();

        frm.tablaAutores.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent evt) {
                JTable tabla = (JTable) evt.getSource();
                int row = tabla.rowAtPoint(evt.getPoint());
                TableModel model = tabla.getModel();
                frm.field_idoculto.setText(String.valueOf(model.getValueAt(row, 0)));
                frm.fieldNombreMA.setText(String.valueOf(model.getValueAt(row, 1)));
                frm.fieldApellidoPaternoMA.setText(String.valueOf(model.getValueAt(row, 2)));
                frm.fieldApellidoMA.setText(String.valueOf(model.getValueAt(row, 3)));
                frm.fieldNacionalidadMA.setText(String.valueOf(model.getValueAt(row, 4)));
                frm.fieldAlias.setText(String.valueOf(model.getValueAt(row, 5)));

                if (model.getValueAt(row, 6).equals("Masculino")) {
                    frm.comboBoxSexoMA.setSelectedItem("Masculino");
                } else {
                    frm.comboBoxSexoMA.setSelectedItem("Femenino");
                }

                frm.btnINGRESARMA.setVisible(false);
                frm.btnMODIFICAR.setEnabled(true);
                frm.btnELIMINAR.setEnabled(true);
            }
        });
        frm.fieldBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscar(frm.fieldBuscar.getText(), frm.tablaAutores);
            }
        });
    }

    public void limpiar() {
        frm.fieldNombreMA.setText("");
        frm.fieldApellidoPaternoMA.setText("");
        frm.fieldApellidoMA.setText("");
        frm.fieldAlias.setText("");
        frm.field_idoculto.setText("");
        frm.fieldBuscar.setText("");
        frm.fieldNacionalidadMA.setText("");
        frm.comboBoxSexoMA.setSelectedIndex(0);
        frm.btnMODIFICAR.setEnabled(false);
        frm.btnELIMINAR.setEnabled(false);
        frm.field_idoculto.setVisible(false);
        frm.btnINGRESARMA.setEnabled(true);
        frm.fieldNombreMA.requestFocus();
        cargarTabla(frm.tablaAutores);
        frm.lblLISTADOAUTORES.setText("Total de Registros ( " + frm.tablaAutores.getRowCount() + " )");
    }
    
    public void buscar(String consulta, JTable jtableBuscar) {
        DefaultTableModel dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + consulta));
    }
    
    public void cargarTabla(JTable tablaAutor) {
        DefaultTableModel modeloA = new DefaultTableModel();
        tablaAutor.setModel(modeloA);
        modeloA.addColumn("ID");
        modeloA.addColumn("NOMBRE");
        modeloA.addColumn("APELLIDO P");
        modeloA.addColumn("APELLIDO M");
        modeloA.addColumn("ALIAS");
        modeloA.addColumn("NACIONALIDAD");
        modeloA.addColumn("SEXO");

        Object[] columna = new Object[7];
        int numeroRegistros = cons.ListaAutor().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = cons.ListaAutor().get(i).getId_autor();
            columna[1] = cons.ListaAutor().get(i).getNombre();
            columna[2] = cons.ListaAutor().get(i).getApPaterno();
            columna[3] = cons.ListaAutor().get(i).getApMaterno();
            columna[4] = cons.ListaAutor().get(i).getAlias();
            columna[5] = cons.ListaAutor().get(i).getNacionalidad();
            columna[6] = cons.ListaAutor().get(i).getSexo();

            if (columna[6].equals(1)) {
                columna[6] = "Masculino";

            } else {
                columna[6] = "Femenino";
            }
            modeloA.addRow(columna);
        }
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frm.btnINGRESARMA) {

            auto.setNombre(frm.fieldNombreMA.getText());
            auto.setApPaterno(frm.fieldApellidoPaternoMA.getText());
            auto.setApMaterno(frm.fieldApellidoMA.getText());
            auto.setNacionalidad(frm.fieldNacionalidadMA.getText());
            auto.setAlias(frm.fieldAlias.getText());
            
            if (frm.comboBoxSexoMA.getSelectedItem() != "Seleccionar") {
                if (frm.comboBoxSexoMA.getSelectedItem() == "Masculino") {
                    auto.setSexo(1);
                } else {
                    auto.setSexo(0);
                }
            }

            if (cons.insertar(auto)) {
                JOptionPane.showMessageDialog(null, "El Autor se ha INGRESADO sin problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al INGRESAR Autor");
                limpiar();
            }

        }
        
        if (e.getSource() == frm.btnMODIFICAR) {
            auto.setNombre(frm.fieldNombreMA.getText());
            auto.setApPaterno(frm.fieldApellidoPaternoMA.getText());
            auto.setApMaterno(frm.fieldApellidoMA.getText());
            auto.setNacionalidad(frm.fieldNacionalidadMA.getText());
            auto.setAlias(frm.fieldAlias.getText());
            if (frm.comboBoxSexoMA.getSelectedItem() != "Seleccionar") {
                if (frm.comboBoxSexoMA.getSelectedItem() == "Masculino") {
                    auto.setSexo(1);
                } else {
                    auto.setSexo(0);
                }
            }
            auto.setId_autor(Integer.parseInt(frm.field_idoculto.getText()));

            if (cons.modificar(auto)) {
                JOptionPane.showMessageDialog(null, "Los datos del Autor han sido MODIFICADOS sin problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al MODIFICAR los datos del Autor");
            }
        }
        
        if (e.getSource() == frm.btnELIMINAR) {
            auto.setId_autor(Integer.parseInt(frm.field_idoculto.getText()));
            if (cons.eliminar(auto)) {
                JOptionPane.showMessageDialog(null, "El Autor ha sido ELIMINADO sin problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al ELIMINAR los datos del Autor");
            }
        }
        
        if (e.getSource() == frm.btnLIMPIARMA) {
            limpiar();
        }
        if (e.getSource() == frm.btnEXPORTAR) {
            if (frm.tablaAutores.getRowCount() == 0) {
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
                tb.add(frm.tablaAutores);
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
