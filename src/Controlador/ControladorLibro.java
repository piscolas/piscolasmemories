/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Autor;
import Modelo.Categoria;
import Modelo.CrudAutor;
import Modelo.CrudCategoria;
import Modelo.CrudEditorial;
import Modelo.CrudIdiomas;
import Modelo.CrudLibro;
import Modelo.Editorial;
import Modelo.ExportarExcel;
import Modelo.Idioma;
import Modelo.Libro;
import Vistas.FormAutor;
import Vistas.FormCategoria;
import Vistas.FormEditorial;
import Vistas.FormIdiomas;
import Vistas.FormLibros;
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
public class ControladorLibro implements ActionListener {

    private Libro libro;
    private CrudLibro cons;
    private FormLibros frm;

    public ControladorLibro(Libro libro, CrudLibro cons, FormLibros frm) {
        this.libro = libro;
        this.cons = cons;
        this.frm = frm;

        frm.comboAutor.addActionListener(this);
        frm.btnINGRESARML.addActionListener(this);
        frm.btnELIMINARML.addActionListener(this);
        frm.btnMODIFICAR.addActionListener(this);
        frm.btnEXPORTAR.addActionListener(this);
        frm.btnLIMPIARML.addActionListener(this);
    }

    private void cargarAutores() {
        frm.comboAutor.removeAllItems();
        ArrayList<Autor> cargarAutores = cons.ListaAutor();
        for (int i = 0; i < cargarAutores.size(); i++) {
            frm.comboAutor.addItem(cargarAutores.get(i).getId_autor() + "-" + cargarAutores.get(i).getAlias());
        }
    }

    public void iniciar() {
        frm.setTitle("Mantenedor de Libros");
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        frm.btnMODIFICAR.setEnabled(false);
        frm.btnELIMINARML.setEnabled(false);
        cargarAutores();
        frm.tablaLibros.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent evt) {
                JTable tabla = (JTable) evt.getSource();
                int row = tabla.rowAtPoint(evt.getPoint());
                TableModel model = tabla.getModel();
                frm.field_id_oculto.setText(String.valueOf(model.getValueAt(row, 0)));
                frm.fieldNumeroSerieML.setText(String.valueOf(model.getValueAt(row, 1)));
                frm.fieldISBNML.setText(String.valueOf(model.getValueAt(row, 2)));
                frm.fieldTituloML.setText(String.valueOf(model.getValueAt(row, 3)));
                frm.fieldNroPaginasML.setText(String.valueOf(model.getValueAt(row, 4)));
                frm.fieldPrecioML.setText(String.valueOf(model.getValueAt(row, 5)));
                frm.fieldAñoPubliML.setText(String.valueOf(model.getValueAt(row, 6)));

                if (model.getValueAt(row, 7).equals("ACTIVO")) {
                    frm.comboBoxEstadoML.setSelectedItem("ACTIVO");
                } else {
                    frm.comboBoxEstadoML.setSelectedItem("INACTIVO");
                }

                frm.btnINGRESARML.setVisible(false);
                frm.btnMODIFICAR.setEnabled(true);
                frm.btnELIMINARML.setEnabled(true);
            }
        });
        frm.fieldBUSCAR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscar(frm.fieldBUSCAR.getText(), frm.tablaLibros);
            }
        });
    }

    public void limpiar() {
        frm.fieldNumeroSerieML.setText("");
        frm.field_id_oculto.setText("");
        frm.fieldBUSCAR.setText("");
        frm.fieldISBNML.setText("");
        frm.fieldTituloML.setText("");
        frm.fieldNroPaginasML.setText("");
        frm.fieldPrecioML.setText("");
        frm.fieldAñoPubliML.setText("");
        frm.comboBoxEstadoML.setSelectedIndex(0);
        frm.comboEditorial.setSelectedIndex(0);
        frm.comboAutor.setSelectedIndex(0);
        frm.comboIdioma.setSelectedIndex(0);
        frm.comboCategoria.setSelectedIndex(0);
        frm.btnMODIFICAR.setEnabled(false);
        frm.btnELIMINARML.setEnabled(false);
        frm.field_id_oculto.setVisible(false);
        frm.btnINGRESARML.setVisible(true);
        frm.fieldNumeroSerieML.requestFocus();

        cargarTabla(frm.tablaLibros);
        frm.lbl_listado.setText("Total de Registros ( " + frm.tablaLibros.getRowCount() + " )");
    }

    public void buscar(String consulta, JTable jtableBuscar) {
        DefaultTableModel dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + consulta));
    }

    public void cargarTabla(JTable tablaLibro) {
        DefaultTableModel modeloE = new DefaultTableModel();

        tablaLibro.setModel(modeloE);
        modeloE.addColumn("ID");
        modeloE.addColumn("NUM. SERIE");
        modeloE.addColumn("ISBN");
        modeloE.addColumn("TITULO");
        modeloE.addColumn("NUM. PAG");
        modeloE.addColumn("PRECIO");
        modeloE.addColumn("AÑO PUBLICACION");
        modeloE.addColumn("ESTADO");
        modeloE.addColumn("EDITORIAL");
        modeloE.addColumn("AUTOR");
        modeloE.addColumn("IDIOMA");
        modeloE.addColumn("CATEGORIA");

        Object[] columna = new Object[12];

        int numregistros = cons.ListaLibros().size();
        for (int i = 0; i <= numregistros - 1; i++) {
            columna[0] = cons.ListaLibros().get(i).getID_Libro();
            columna[1] = cons.ListaLibros().get(i).getNumSerie();
            columna[2] = cons.ListaLibros().get(i).getISBNLibro();
            columna[3] = cons.ListaLibros().get(i).getTitulo();
            columna[4] = cons.ListaLibros().get(i).getNumPag();
            columna[5] = cons.ListaLibros().get(i).getPrecio();
            columna[6] = cons.ListaLibros().get(i).getAñoPub();
            columna[7] = cons.ListaLibros().get(i).getEstadoLibro();
            columna[8] = cons.ListaLibros().get(i).getIdEditorial();
            columna[9] = cons.ListaLibros().get(i).getIdAutor();
            columna[10] = cons.ListaLibros().get(i).getIdIdioma();
            columna[11] = cons.ListaLibros().get(i).getIdCategoria();

            if (columna[7].equals(1)) {
                columna[7] = "ACTIVO";
            } else {
                columna[7] = "INACTIVO";
            }
            modeloE.addRow(columna);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnINGRESARML) {
            if (frm.fieldNumeroSerieML.getText().equals("") || frm.fieldISBNML.getText().equals("") || frm.fieldTituloML.getText().equals("") || frm.fieldNroPaginasML.getText().equals("") || frm.fieldPrecioML.getText().equals("") || frm.fieldAñoPubliML.getText().equals("") || frm.comboBoxEstadoML.getSelectedItem().equals("Seleccionar")) {
                JOptionPane.showMessageDialog(null, "Hay campos en Blanco!");
            } else {

                libro.setNumSerie(Integer.parseInt(frm.fieldNumeroSerieML.getText()));
                libro.setISBNLibro(frm.fieldISBNML.getText());
                libro.setTitulo(frm.fieldTituloML.getText());
                libro.setNumPag(Integer.parseInt(frm.fieldNroPaginasML.getText()));
                libro.setAñoPub(Integer.parseInt(frm.fieldAñoPubliML.getText()));

                if (frm.comboBoxEstadoML.getSelectedItem() != "Seleccionar") {
                    if (frm.comboBoxEstadoML.getSelectedItem() == "ACTIVO") {
                        libro.setEstadoLibro(1);
                    } else {
                        libro.setEstadoLibro(0);
                    }
                }
                if (cons.insertar(libro)) {
                    JOptionPane.showMessageDialog(null, "Libro INGRESADO sin Problemas");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al INGRESAR los Datos de una Libro");
                    limpiar();
                }
            }
        }

        if (e.getSource() == frm.btnMODIFICAR) {
            libro.setNumSerie(Integer.parseInt(frm.fieldNumeroSerieML.getText()));
            libro.setISBNLibro(frm.fieldISBNML.getText());
            libro.setTitulo(frm.fieldTituloML.getText());
            libro.setNumPag(Integer.parseInt(frm.fieldNroPaginasML.getText()));
            libro.setAñoPub(Integer.parseInt(frm.fieldAñoPubliML.getText()));

            if (frm.comboBoxEstadoML.getSelectedItem() != "Seleccionar") {
                if (frm.comboBoxEstadoML.getSelectedItem() == "ACTIVO") {
                    libro.setEstadoLibro(1);
                } else {
                    libro.setEstadoLibro(0);
                }
            }
            libro.setID_Libro(Integer.parseInt(frm.field_id_oculto.getText()));

            if (cons.modificar(libro)) {
                JOptionPane.showMessageDialog(null, "Los datos del Libro han sido MODIFICADOS sin problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al MODIFICAR los datos del Libro");
            }
        }
        
         if (e.getSource() == frm.btnELIMINARML) {
            libro.setID_Libro(Integer.parseInt(frm.field_id_oculto.getText()));
            if (cons.eliminar(libro)) {
                JOptionPane.showMessageDialog(null, "El Libro ha sido ELIMINADO sin problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al ELIMINAR los datos del Libro");
            }
        }
         
         if (e.getSource() == frm.btnEXPORTAR) {
            if (frm.tablaLibros.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No hay datos en la tabla para exportar.", "Exportación Libros", JOptionPane.INFORMATION_MESSAGE);
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
                tb.add(frm.tablaLibros);
                nom.add("Detalle de Gastos");
                String file = chooser.getSelectedFile().toString().concat(".xls");
                try {
                    ExportarExcel exporta = new ExportarExcel(new File(file), tb, nom);
                    if (exporta.exportar()) {
                        JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel.", "Exportación Datos de Libros", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Hubo un  error" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}
