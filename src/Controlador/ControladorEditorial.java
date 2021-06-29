package Controlador;

import Modelo.CrudEditorial;
import Modelo.Editorial;
import Vistas.FormEditorial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
        limpiar();
    }

    public void limpiar() {
        frm.fieldNombreEditorialME.setText("");
        frm.frm_id_oculto.setText("");
        frm.frmbuscar.setText("");
        frm.boxEstado.setSelectedIndex(0);
        frm.btnmodificar.setEnabled(false);
        frm.btnELIMINAR.setEnabled(false);
        frm.frm_id_oculto.setVisible(false);
        frm.btnINGRESAR.setEnabled(true);
        frm.fieldNombreEditorialME.requestFocus();
        cargarTabla(frm.tableEditorialesME);
        frm.lblListadoEditorialesME.setText("Total de Registros ( " + frm.tableEditorialesME.getRowCount() + " )");
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

            if (columna[3].equals(1)) {
                columna[5] = "ACTIVO";
            } else {
                columna[5] = "INACTIVO";
            }
            modeloE.addRow(columna);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnINGRESAR) {
            edit.setNombreEditorial(frm.fieldNombreEditorialME.getText());

            if (frm.boxEstado.getSelectedItem() != "Seleccione") {
                if (frm.boxEstado.getSelectedItem() == "ACTIVO") {
                    edit.setEstadoEditorial(1);
                } else {
                    edit.setEstadoEditorial(0);
                }
            }
            if (cons.insertar(edit)) {
                JOptionPane.showMessageDialog(null, "Editorial INGRESADA sin Problemas", "Ingreso Editorial Exitosa", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al INGRESAR los Datos de una Editorial", "Error de Ingreso de Editorial", JOptionPane.ERROR_MESSAGE);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hay Campos en Blancos, no se puede Ingresar Editorial", "Campos en Blanco", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }

}
