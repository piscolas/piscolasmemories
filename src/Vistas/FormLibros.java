package Vistas;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomas
 */
public class FormLibros extends javax.swing.JFrame {

    /**
     * Creates new form FormLibros
     */
    public FormLibros() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloMantenedorLibros = new javax.swing.JLabel();
        panelMantenedorLibros = new javax.swing.JPanel();
        lblNdeSerieML = new javax.swing.JLabel();
        lblISBNML = new javax.swing.JLabel();
        lblTituloML = new javax.swing.JLabel();
        lblNdePaginasML = new javax.swing.JLabel();
        lblPrecioML = new javax.swing.JLabel();
        lblAñoPubliML = new javax.swing.JLabel();
        lblEstadoML = new javax.swing.JLabel();
        fieldNumeroSerieML = new javax.swing.JTextField();
        fieldISBNML = new javax.swing.JTextField();
        fieldTituloML = new javax.swing.JTextField();
        fieldNroPaginasML = new javax.swing.JTextField();
        fieldPrecioML = new javax.swing.JTextField();
        fieldAñoPubliML = new javax.swing.JTextField();
        comboBoxEstadoML = new javax.swing.JComboBox<>();
        btnINGRESARML = new javax.swing.JButton();
        btnMODIFICAR = new javax.swing.JButton();
        btnELIMINARML = new javax.swing.JButton();
        btnLIMPIARML = new javax.swing.JButton();
        btnVolverML = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        fieldBUSCAR = new javax.swing.JTextField();
        lbl_listado = new javax.swing.JLabel();
        btnEXPORTAR = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        GrillaAutores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        comboAutores = new javax.swing.JComboBox<>();
        id_Autor = new javax.swing.JLabel();
        nombre_autor = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        GrillaAutoresCheck = new javax.swing.JTable();
        btnagregarAutor = new javax.swing.JButton();
        field_id_oculto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MANTENEDOR DE LIBROS");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblTituloMantenedorLibros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTituloMantenedorLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/libros.png"))); // NOI18N
        lblTituloMantenedorLibros.setText("MANTENEDOR DE LIBROS");

        lblNdeSerieML.setText("Número de serie :");

        lblISBNML.setText("ISBN :");

        lblTituloML.setText("Nombre :");

        lblNdePaginasML.setText("Nro. Páginas :");

        lblPrecioML.setText("Precio :");

        lblAñoPubliML.setText("Año publicación :");

        lblEstadoML.setText("Estado :");

        fieldNumeroSerieML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNumeroSerieMLActionPerformed(evt);
            }
        });

        comboBoxEstadoML.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "ACTIVO", "INACTIVO" }));
        comboBoxEstadoML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEstadoMLActionPerformed(evt);
            }
        });

        btnINGRESARML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/log-in ESTE OCUPÉ.png"))); // NOI18N
        btnINGRESARML.setText("INGRESAR");

        btnMODIFICAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/editar (3).png"))); // NOI18N
        btnMODIFICAR.setText("MODIFICAR");

        btnELIMINARML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eliminar.png"))); // NOI18N
        btnELIMINARML.setText("ELIMINAR");

        btnLIMPIARML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/limpiar.png"))); // NOI18N
        btnLIMPIARML.setText("LIMPIAR");
        btnLIMPIARML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLIMPIARMLActionPerformed(evt);
            }
        });

        btnVolverML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/regreso.png"))); // NOI18N
        btnVolverML.setText("VOLVER AL MENÚ PRINCIPAL");
        btnVolverML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverMLActionPerformed(evt);
            }
        });

        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaLibros = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int col)
            {
                return false;
            }
        };
        jScrollPane1.setViewportView(tablaLibros);

        jLabel3.setText("Buscar:");

        lbl_listado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_listado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/lista-de-quehaceres.png"))); // NOI18N
        lbl_listado.setText("LISTADO");

        btnEXPORTAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/excel.png"))); // NOI18N
        btnEXPORTAR.setText("Exportar");

        GrillaAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(GrillaAutores);

        jLabel1.setText("AUTORES");

        comboAutores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        id_Autor.setText("ID=");

        nombre_autor.setText("NOMBRE=");

        GrillaAutoresCheck.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(GrillaAutoresCheck);

        btnagregarAutor.setText("AGREGAR AUTOR");

        javax.swing.GroupLayout panelMantenedorLibrosLayout = new javax.swing.GroupLayout(panelMantenedorLibros);
        panelMantenedorLibros.setLayout(panelMantenedorLibrosLayout);
        panelMantenedorLibrosLayout.setHorizontalGroup(
            panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMantenedorLibrosLayout.createSequentialGroup()
                .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMantenedorLibrosLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnVolverML, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelMantenedorLibrosLayout.createSequentialGroup()
                                .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPrecioML)
                                    .addComponent(lblTituloML)
                                    .addComponent(lblNdeSerieML)
                                    .addComponent(lblISBNML)
                                    .addComponent(lblNdePaginasML)
                                    .addComponent(lblEstadoML)
                                    .addComponent(lblAñoPubliML))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldISBNML, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(fieldTituloML)
                                    .addComponent(fieldNroPaginasML)
                                    .addComponent(fieldPrecioML)
                                    .addComponent(fieldAñoPubliML)
                                    .addComponent(fieldNumeroSerieML)
                                    .addComponent(comboBoxEstadoML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelMantenedorLibrosLayout.createSequentialGroup()
                                .addComponent(btnELIMINARML, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(btnLIMPIARML, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMantenedorLibrosLayout.createSequentialGroup()
                                .addComponent(btnINGRESARML, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMODIFICAR, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(94, 94, 94)
                        .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMantenedorLibrosLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldBUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(158, 158, 158)
                                .addComponent(lbl_listado)
                                .addGap(96, 96, 96)
                                .addComponent(btnEXPORTAR))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelMantenedorLibrosLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(comboAutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(id_Autor)
                                .addGap(86, 86, 86)
                                .addComponent(nombre_autor))
                            .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(panelMantenedorLibrosLayout.createSequentialGroup()
                        .addGap(590, 590, 590)
                        .addComponent(btnagregarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(471, Short.MAX_VALUE))
        );
        panelMantenedorLibrosLayout.setVerticalGroup(
            panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMantenedorLibrosLayout.createSequentialGroup()
                .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelMantenedorLibrosLayout.createSequentialGroup()
                        .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMantenedorLibrosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNdeSerieML)
                                    .addComponent(fieldNumeroSerieML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(fieldBUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_listado)
                                .addComponent(btnEXPORTAR)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblISBNML)
                            .addComponent(fieldISBNML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTituloML)
                            .addComponent(fieldTituloML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNdePaginasML)
                            .addComponent(fieldNroPaginasML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecioML)
                            .addComponent(fieldPrecioML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAñoPubliML)
                    .addComponent(fieldAñoPubliML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMantenedorLibrosLayout.createSequentialGroup()
                        .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxEstadoML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstadoML))
                        .addGap(18, 18, 18)
                        .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnINGRESARML)
                            .addComponent(btnMODIFICAR))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnELIMINARML)
                            .addComponent(btnLIMPIARML, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnVolverML)
                        .addGap(376, 376, 376))
                    .addGroup(panelMantenedorLibrosLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(panelMantenedorLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboAutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(id_Autor)
                                .addComponent(nombre_autor)))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnagregarAutor)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(lblTituloMantenedorLibros)
                .addGap(37, 37, 37)
                .addComponent(field_id_oculto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMantenedorLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblTituloMantenedorLibros))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(field_id_oculto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelMantenedorLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void btnVolverMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMLActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVolverMLActionPerformed

    private void btnLIMPIARMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLIMPIARMLActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnLIMPIARMLActionPerformed

    private void comboBoxEstadoMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEstadoMLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxEstadoMLActionPerformed

    private void fieldNumeroSerieMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNumeroSerieMLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNumeroSerieMLActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLibros().setVisible(true);
            }
        });
    }
    
        public void cerrar()
    {
        int resp=JOptionPane.showConfirmDialog(null,"¿Esta seguro/a que desea cerrar la ventana de Libros?","Confirmación de Cierre",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(resp==JOptionPane.YES_OPTION)
        {
            this.dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable GrillaAutores;
    public javax.swing.JTable GrillaAutoresCheck;
    public javax.swing.JButton btnELIMINARML;
    public javax.swing.JButton btnEXPORTAR;
    public javax.swing.JButton btnINGRESARML;
    public javax.swing.JButton btnLIMPIARML;
    public javax.swing.JButton btnMODIFICAR;
    public javax.swing.JButton btnVolverML;
    public javax.swing.JButton btnagregarAutor;
    public javax.swing.JComboBox<String> comboAutores;
    public javax.swing.JComboBox<String> comboBoxEstadoML;
    public javax.swing.JTextField fieldAñoPubliML;
    public javax.swing.JTextField fieldBUSCAR;
    public javax.swing.JTextField fieldISBNML;
    public javax.swing.JTextField fieldNroPaginasML;
    public javax.swing.JTextField fieldNumeroSerieML;
    public javax.swing.JTextField fieldPrecioML;
    public javax.swing.JTextField fieldTituloML;
    public javax.swing.JTextField field_id_oculto;
    public javax.swing.JLabel id_Autor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAñoPubliML;
    private javax.swing.JLabel lblEstadoML;
    private javax.swing.JLabel lblISBNML;
    private javax.swing.JLabel lblNdePaginasML;
    private javax.swing.JLabel lblNdeSerieML;
    private javax.swing.JLabel lblPrecioML;
    private javax.swing.JLabel lblTituloML;
    private javax.swing.JLabel lblTituloMantenedorLibros;
    public javax.swing.JLabel lbl_listado;
    public javax.swing.JLabel nombre_autor;
    public javax.swing.JPanel panelMantenedorLibros;
    public javax.swing.JTable tablaLibros;
    // End of variables declaration//GEN-END:variables
}
