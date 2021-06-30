package Controlador;

import Modelo.CrudEditorial;
import Modelo.Editorial;
import Modelo.ExportarExcel;
import Vistas.FormEditorial;
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

public class ControladorEditorial implements ActionListener {

    private Editorial edit;
    private CrudEditorial cons;
    private FormEditorial frm;

    public ControladorEditorial(Editorial edit, CrudEditorial cons, FormEditorial frm) {
        this.edit = edit;
        this.frm = frm;
        this.cons = cons;
        this.frm.btnELIMINAR.addActionListener(this);
        this.frm.btnINGRESAR.addActionListener(this);
        this.frm.btnmodificar.addActionListener(this);
        this.frm.btnExportar.addActionListener(this);
        this.frm.btnVolverME.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Mantenedor de Editoriales");
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        frm.btnmodificar.setEnabled(false);
        frm.btnELIMINAR.setEnabled(false);
        limpiar();

        frm.tableEditorialesME.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent evt) {
                JTable tabla = (JTable) evt.getSource();
                int row = tabla.rowAtPoint(evt.getPoint());
                TableModel model = tabla.getModel();
                frm.frm_id_oculto.setText(String.valueOf(model.getValueAt(row, 0)));
                frm.fieldNombreEditorialME.setText(String.valueOf(model.getValueAt(row, 1)));

                if (model.getValueAt(row, 2).equals("ACTIVO")) {
                    frm.boxEstado.setSelectedItem("ACTIVO");
                } else {
                    frm.boxEstado.setSelectedItem("INACTIVO");
                }

                frm.btnINGRESAR.setVisible(false);
                frm.btnmodificar.setEnabled(true);
                frm.btnELIMINAR.setEnabled(true);
            }
        });
        frm.frmbuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscar(frm.frmbuscar.getText(), frm.tableEditorialesME);
            }
        });
    }

    public void limpiar() {
        frm.fieldNombreEditorialME.setText("");
        frm.frm_id_oculto.setText("");
        frm.frmbuscar.setText("");
        frm.boxEstado.setSelectedIndex(0);
        frm.btnmodificar.setEnabled(false);
        frm.btnELIMINAR.setEnabled(false);
        frm.frm_id_oculto.setVisible(false);
        frm.btnINGRESAR.setVisible(true);
        frm.fieldNombreEditorialME.requestFocus();
        
        cargarTabla(frm.tableEditorialesME);
        frm.lblListadoEditorialesME.setText("Total de Registros ( " + frm.tableEditorialesME.getRowCount() + " )");
    }

    public void buscar(String consulta, JTable jtableBuscar) {
        DefaultTableModel dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + consulta));
    }

    public void cargarTabla(JTable tablaEditorial) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnINGRESAR) {
            edit.setNombreEditorial(frm.fieldNombreEditorialME.getText());

            if (frm.boxEstado.getSelectedItem() != "Seleccionar") {
                if (frm.boxEstado.getSelectedItem() == "ACTIVO") {
                    edit.setEstadoEditorial(1);
                } else {
                    edit.setEstadoEditorial(0);
                }
            }
            if (cons.insertar(edit)) {
                JOptionPane.showMessageDialog(null, "Editorial INGRESADA sin Problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al INGRESAR los Datos de una Editorial");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnmodificar) {
            edit.setNombreEditorial(frm.fieldNombreEditorialME.getText());
            if (frm.boxEstado.getSelectedItem() != "Seleccionar") {
                if (frm.boxEstado.getSelectedItem() == "ACTIVO") {
                    edit.setEstadoEditorial(1);
                } else {
                    edit.setEstadoEditorial(0);
                }
            }
            edit.setIdEditorial(Integer.parseInt(frm.frm_id_oculto.getText()));

            if (cons.modificar(edit)) {
                JOptionPane.showMessageDialog(null, "Los datos de Editorial han sido MODIFICADOS sin problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al MODIFICAR los datos de Editorial");
            }
        }
        
        if (e.getSource() == frm.btnELIMINAR) {
            edit.setIdEditorial(Integer.parseInt(frm.frm_id_oculto.getText()));
            if (cons.eliminar(edit)) {
                JOptionPane.showMessageDialog(null, "La editorial ha sido ELIMINADA sin problemas");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al ELIMINAR los datos de Editorial");
            }
        }
        
        if (e.getSource() == frm.btnExportar) {
            if (frm.tableEditorialesME.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No hay datos en la tabla para exportar.", "Exportación Editoriales", JOptionPane.INFORMATION_MESSAGE);
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
                tb.add(frm.tableEditorialesME);
                nom.add("Detalle de Gastos");
                String file = chooser.getSelectedFile().toString().concat(".xls");
                try {
                    ExportarExcel exporta = new ExportarExcel(new File(file), tb, nom);
                    if (exporta.exportar()) {
                        JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel.", "Exportación Datos Editorial", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Hubo un  error" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        

    }

}
