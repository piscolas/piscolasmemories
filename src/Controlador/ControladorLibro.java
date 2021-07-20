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
import javax.swing.table.TableColumn;
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

        this.frm.btnINGRESARML.addActionListener(this);
        this.frm.btnELIMINARML.addActionListener(this);
        this.frm.btnMODIFICAR.addActionListener(this);
        this.frm.btnEXPORTAR.addActionListener(this);
        this.frm.btnLIMPIARML.addActionListener(this);
        this.frm.btnagregarAutor.addActionListener(this);
        this.frm.comboAutores.addActionListener(this);
        this.frm.btnCat.addActionListener(this);
        this.frm.comboCateg.addActionListener(this);
        this.frm.btnEditorial.addActionListener(this);
        this.frm.comboEditorial.addActionListener(this);
        this.frm.btnIdioma.addActionListener(this);
        this.frm.comboIdiomas.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Mantenedor de Libros");
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        frm.fieldNumeroSerieML.requestFocus();
        frm.btnMODIFICAR.setEnabled(false);
        frm.btnELIMINARML.setEnabled(false);
        cargarAutores();
        cargarCategorias();
        cargarEditoriales();
        cargarIdiomas();
        cargarTablaAutores(frm.GrillaAutores);
        cargarTablaCategorias(frm.GrillaCateg);
        cargarTablaEditoriales(frm.GrillaEditorial);
        cargarTablaIdiomas(frm.GrillaIdioma);
        cargarTablaAutoresCheckBox(frm.GrillaAutoresCheck);
        cargarTablaCategoriasCheck(frm.GrillaCategCheck);
        cargarTablaEditorialesCheck(frm.GrillaEditorialCheck);
        cargarTablaIdiomasCheck(frm.GrillaIdiomaCheck);
        limpiar();
        

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

                if (model.getValueAt(row, 6).equals("ACTIVO")) {
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
        frm.btnMODIFICAR.setEnabled(true);
        frm.btnELIMINARML.setEnabled(true);
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

    public void cargarTabla(JTable tablaLibros) {
        DefaultTableModel modeloL = new DefaultTableModel();

        tablaLibros.setModel(modeloL);
        modeloL.addColumn("ID");
        modeloL.addColumn("NUM. SERIE");
        modeloL.addColumn("ISBN");
        modeloL.addColumn("TITULO");
        modeloL.addColumn("NUM. PAG");
        modeloL.addColumn("PRECIO");
        modeloL.addColumn("ESTADO");

        Object[] columna = new Object[7];

        int numregistros = cons.ListaLibros().size();
        for (int i = 0; i <= numregistros; i++) {
            columna[0] = cons.ListaLibros().get(i).getID_Libro();
            columna[1] = cons.ListaLibros().get(i).getNumSerie();
            columna[2] = cons.ListaLibros().get(i).getISBNLibro();
            columna[3] = cons.ListaLibros().get(i).getTitulo();
            columna[4] = cons.ListaLibros().get(i).getNumPag();
            columna[5] = cons.ListaLibros().get(i).getPrecio();
            columna[6] = cons.ListaLibros().get(i).getEstadoLibro();

            if (columna[6].equals(1)) {
                columna[6] = "ACTIVO";
            } else {
                columna[6] = "INACTIVO";
            }
            modeloL.addRow(columna);
        }
    }

    private void cargarAutores() {
        frm.comboAutores.removeAllItems();

        ArrayList<Autor> cargarAutores = cons.ListaAutor();
        for (int i = 0; i < cargarAutores.size(); i++) {
            frm.comboAutores.addItem(cargarAutores.get(i).getId_autor() + "-" + cargarAutores.get(i).getAlias());
        }

    }

    private void cargarCategorias() {
        frm.comboCateg.removeAllItems();
        ArrayList<Categoria> cargarCategoria = cons.ListaCategoria();
        for (int i = 0; i < cargarCategoria.size(); i++) {
            frm.comboCateg.addItem(cargarCategoria.get(i).getID_CAT() + "-" + cargarCategoria.get(i).getNombreCAT());
        }
    }

    private void cargarEditoriales() {
        frm.comboEditorial.removeAllItems();
        ArrayList<Editorial> cargarEditoriales = cons.ListaEditorial();
        for (int i = 0; i < cargarEditoriales.size(); i++) {
            frm.comboEditorial.addItem(cargarEditoriales.get(i).getIdEditorial() + "-" + cargarEditoriales.get(i).getNombreEditorial());
        }
    }

    private void cargarIdiomas() {
        frm.comboIdiomas.removeAllItems();
        ArrayList<Idioma> cargarIdiomas = cons.ListaIdiomas();
        for (int i = 0; i < cargarIdiomas.size(); i++) {
            frm.comboIdiomas.addItem(cargarIdiomas.get(i).getIdIdioma() + "-" + cargarIdiomas.get(i).getNombreIdioma());
        }
    }

    public void cargarTablaAutores(JTable tablaAutor) {
        DefaultTableModel modeloA = new DefaultTableModel();
        tablaAutor.setModel(modeloA);
        modeloA.addColumn("ID");
        modeloA.addColumn("NOMBRE");
        modeloA.addColumn("APELLIDO P");
        modeloA.addColumn("APELLIDO M");
        modeloA.addColumn("ALIAS");
        modeloA.addColumn("NACIONALIDAD");
        modeloA.addColumn("SEXO");
        modeloA.addColumn("ESTADO");

        Object[] columna = new Object[8];
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
            columna[7] = cons.ListaAutor().get(i).getEstado();
            if (columna[7].equals(1)) {
                columna[7] = "ACTIVO";
            } else {
                columna[7] = "INACTIVO";
            }
            modeloA.addRow(columna);
        }
    }

    public void cargarTablaCategorias(JTable tablaCategoria) {
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

    public void cargarTablaEditoriales(JTable tablaEditorial) {
        DefaultTableModel modeloE = new DefaultTableModel();

        tablaEditorial.setModel(modeloE);
        modeloE.addColumn("ID");
        modeloE.addColumn("NOMBRE");
        modeloE.addColumn("ESTADO");

        Object[] columna = new Object[3];

        int numregistros = cons.ListaEditorial().size();
        for (int i = 0; i <= numregistros - 1; i++) {
            columna[0] = cons.ListaEditorial().get(i).getIdEditorial();
            columna[1] = cons.ListaEditorial().get(i).getNombreEditorial();
            columna[2] = cons.ListaEditorial().get(i).getEstadoEditorial();

            if (columna[2].equals(1)) {
                columna[2] = "ACTIVO";
            } else {
                columna[2] = "INACTIVO";
            }
            modeloE.addRow(columna);
        }
    }

    public void cargarTablaIdiomas(JTable tablaIdioma) {
        DefaultTableModel modeloI = new DefaultTableModel();
        tablaIdioma.setModel(modeloI);
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

    public void addCheckbox(int columna, JTable tabla) {
        TableColumn tc = tabla.getColumnModel().getColumn(columna);
        tc.setCellEditor(tabla.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
    }

    public void cargarTablaAutoresCheckBox(JTable tablaAutor) {
        DefaultTableModel modeloA = new DefaultTableModel();
        tablaAutor.setModel(modeloA);
        modeloA.addColumn("ID");
        modeloA.addColumn("NOMBRE");
        modeloA.addColumn("AP. PATERNO");
        modeloA.addColumn("AP. MATERNO");
        modeloA.addColumn("ALIAS");
        modeloA.addColumn("ESTADO");
        modeloA.addColumn("SELECCIÓN");
        Object[] columna = new Object[7];
        int numregistros = cons.ListaAutor().size();
        for (int i = 0; i <= numregistros - 1; i++) {
            columna[0] = cons.ListaAutor().get(i).getId_autor();
            columna[1] = cons.ListaAutor().get(i).getNombre();
            columna[2] = cons.ListaAutor().get(i).getApPaterno();
            columna[3] = cons.ListaAutor().get(i).getApMaterno();
            columna[4] = cons.ListaAutor().get(i).getAlias();
            columna[5] = cons.ListaAutor().get(i).getEstado();
            if (columna[5].equals(1)) {
                columna[5] = "ACTIVO";
            } else {
                columna[5] = "INACTIVO";
            }
            modeloA.addRow(columna);
        }
        addCheckbox(6, frm.GrillaAutoresCheck);
    }

    public void cargarTablaCategoriasCheck(JTable tablaCategoria) {
        DefaultTableModel modeloC = new DefaultTableModel();

        tablaCategoria.setModel(modeloC);
        modeloC.addColumn("ID");
        modeloC.addColumn("NOMBRE");
        modeloC.addColumn("ESTADO");
        modeloC.addColumn("SELECCION");

        Object[] columna = new Object[4];

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
        addCheckbox(3, frm.GrillaCategCheck);
    }

    public void cargarTablaEditorialesCheck(JTable tablaEditorial) {
        DefaultTableModel modeloE = new DefaultTableModel();

        tablaEditorial.setModel(modeloE);
        modeloE.addColumn("ID");
        modeloE.addColumn("NOMBRE");
        modeloE.addColumn("ESTADO");
        modeloE.addColumn("SELECCIONAR");

        Object[] columna = new Object[4];

        int numregistros = cons.ListaEditorial().size();
        for (int i = 0; i <= numregistros - 1; i++) {
            columna[0] = cons.ListaEditorial().get(i).getIdEditorial();
            columna[1] = cons.ListaEditorial().get(i).getNombreEditorial();
            columna[2] = cons.ListaEditorial().get(i).getEstadoEditorial();

            if (columna[2].equals(1)) {
                columna[2] = "ACTIVO";
            } else {
                columna[2] = "INACTIVO";
            }
            modeloE.addRow(columna);
        }
        addCheckbox(3, frm.GrillaEditorialCheck);
    }

    public void cargarTablaIdiomasCheck(JTable tablaIdioma) {
        DefaultTableModel modeloI = new DefaultTableModel();
        tablaIdioma.setModel(modeloI);
        modeloI.addColumn("ID");
        modeloI.addColumn("IDIOMA");
        modeloI.addColumn("SELECCIONAR");

        Object[] columna = new Object[3];
        int numeroRegistros = cons.ListaIdiomas().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = cons.ListaIdiomas().get(i).getIdIdioma();
            columna[1] = cons.ListaIdiomas().get(i).getNombreIdioma();

            modeloI.addRow(columna);
        }
        addCheckbox(2, frm.GrillaIdiomaCheck);
    }

    public boolean Seleccionado(int fila, int columna, JTable tabla) {
        return tabla.getValueAt(fila, columna) != null;
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
                libro.setPrecio(Integer.parseInt(frm.fieldPrecioML.getText()));

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
            libro.setPrecio(Integer.parseInt(frm.fieldPrecioML.getText()));

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
        if (e.getSource() == frm.btnLIMPIARML) {
            limpiar();
        }
        if (e.getSource() == frm.comboAutores) {
            if (frm.comboAutores.getSelectedIndex() >= 0) {
                String id = frm.comboAutores.getSelectedItem().toString();
                int largo = id.length();
                int posicion = id.indexOf("-");
                frm.id_Autor.setText("ID:" + id.substring(0, posicion));
                frm.nombre_autor.setText("Nombre:" + id.substring(posicion + 1, largo));
            }
        }

        if (e.getSource() == frm.comboCateg) {
            if (frm.comboCateg.getSelectedIndex() >= 0) {
                String id = frm.comboCateg.getSelectedItem().toString();
                int largo = id.length();
                int posicion = id.indexOf("-");
                frm.id_cat.setText("ID:" + id.substring(0, posicion));
                frm.nombre_cat.setText("Nombre:" + id.substring(posicion + 1, largo));
            }
        }

        if (e.getSource() == frm.comboEditorial) {
            if (frm.comboEditorial.getSelectedIndex() >= 0) {
                String id = frm.comboEditorial.getSelectedItem().toString();
                int largo = id.length();
                int posicion = id.indexOf("-");
                frm.id_editoriales.setText("ID:" + id.substring(0, posicion));
                frm.nombre_editoriales.setText("Nombre:" + id.substring(posicion + 1, largo));
            }
        }

        if (e.getSource() == frm.comboIdiomas) {
            if (frm.comboIdiomas.getSelectedIndex() >= 0) {
                String id = frm.comboIdiomas.getSelectedItem().toString();
                int largo = id.length();
                int posicion = id.indexOf("-");
                frm.id_idiomas.setText("ID:" + id.substring(0, posicion));
                frm.nombre_idiomas.setText("Nombre:" + id.substring(posicion + 1, largo));
            }
        }

        if (e.getSource() == frm.btnagregarAutor) {
            for (int i = 0; i < frm.GrillaAutoresCheck.getRowCount(); i++) {
                if (Seleccionado(i, 6, frm.GrillaAutoresCheck)) {
                    String id = frm.GrillaAutoresCheck.getValueAt(i, 0).toString();
                    JOptionPane.showMessageDialog(null, id, "Mostrar Autores Seleccionados", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        if (e.getSource() == frm.btnCat) {
            for (int i = 0; i < frm.GrillaCategCheck.getRowCount(); i++) {
                if (Seleccionado(i, 6, frm.GrillaCategCheck)) {
                    String id = frm.GrillaCategCheck.getValueAt(i, 0).toString();
                    JOptionPane.showMessageDialog(null, id, "Mostrar Categorias Seleccionadas", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        if (e.getSource() == frm.btnEditorial) {
            for (int i = 0; i < frm.GrillaEditorialCheck.getRowCount(); i++) {
                if (Seleccionado(i, 6, frm.GrillaEditorialCheck)) {
                    String id = frm.GrillaEditorialCheck.getValueAt(i, 0).toString();
                    JOptionPane.showMessageDialog(null, id, "Mostrar Editoriales Seleccionadas", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        if (e.getSource() == frm.btnIdioma) {
            for (int i = 0; i < frm.GrillaIdiomaCheck.getRowCount(); i++) {
                if (Seleccionado(i, 6, frm.GrillaIdiomaCheck)) {
                    String id = frm.GrillaIdiomaCheck.getValueAt(i, 0).toString();
                    JOptionPane.showMessageDialog(null, id, "Mostrar Idiomas Seleccionados", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

}
