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
public class FormUsuario extends javax.swing.JFrame {

    /**
     * Creates new form FormUsuario
     */
    public FormUsuario() {
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

        Panel1MantenedorUsuarios = new javax.swing.JPanel();
        lblNombreCompletoMU = new javax.swing.JLabel();
        lblUsuarioMU = new javax.swing.JLabel();
        lblContrasenaMU = new javax.swing.JLabel();
        lblRepContrasenaMU = new javax.swing.JLabel();
        BoxEstadoMU = new javax.swing.JComboBox<>();
        lblEstadoMU = new javax.swing.JLabel();
        fieldNombreCompletoMU = new javax.swing.JTextField();
        fieldUsuarioMU = new javax.swing.JTextField();
        fieldContraseñaMU = new javax.swing.JPasswordField();
        fieldRepContrasenaMU = new javax.swing.JPasswordField();
        lblTituloMantenedorUsuarios = new javax.swing.JLabel();
        Panel2MantenedorUsuario = new javax.swing.JPanel();
        btningresar = new javax.swing.JButton();
        btnModificarMU = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        Panel3MantenedorUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListadoUsuariosMU = new javax.swing.JTable();
        lblListadoUsuariosMU = new javax.swing.JLabel();
        btnExportarMU = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fieldBuscar = new javax.swing.JTextField();
        frm_idoculto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnVolverMU = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MANTENEDOR DE USUARIOS");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblNombreCompletoMU.setText("Nombre Completo:");

        lblUsuarioMU.setText("Usuario:");

        lblContrasenaMU.setText("Contraseña:");

        lblRepContrasenaMU.setText("Repetir Contraseña:");

        BoxEstadoMU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));

        lblEstadoMU.setText("Estado:");

        fieldNombreCompletoMU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNombreCompletoMUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel1MantenedorUsuariosLayout = new javax.swing.GroupLayout(Panel1MantenedorUsuarios);
        Panel1MantenedorUsuarios.setLayout(Panel1MantenedorUsuariosLayout);
        Panel1MantenedorUsuariosLayout.setHorizontalGroup(
            Panel1MantenedorUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1MantenedorUsuariosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(Panel1MantenedorUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel1MantenedorUsuariosLayout.createSequentialGroup()
                        .addComponent(lblNombreCompletoMU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldNombreCompletoMU, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1MantenedorUsuariosLayout.createSequentialGroup()
                        .addGroup(Panel1MantenedorUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel1MantenedorUsuariosLayout.createSequentialGroup()
                                .addComponent(lblEstadoMU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BoxEstadoMU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel1MantenedorUsuariosLayout.createSequentialGroup()
                                .addComponent(lblUsuarioMU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldUsuarioMU, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblContrasenaMU)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldContraseñaMU, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblRepContrasenaMU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldRepContrasenaMU, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        Panel1MantenedorUsuariosLayout.setVerticalGroup(
            Panel1MantenedorUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1MantenedorUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel1MantenedorUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreCompletoMU)
                    .addComponent(fieldNombreCompletoMU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(Panel1MantenedorUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuarioMU)
                    .addComponent(lblContrasenaMU)
                    .addComponent(lblRepContrasenaMU)
                    .addComponent(fieldUsuarioMU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldContraseñaMU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldRepContrasenaMU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel1MantenedorUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoMU)
                    .addComponent(BoxEstadoMU, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        lblTituloMantenedorUsuarios.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTituloMantenedorUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/equipo.png"))); // NOI18N
        lblTituloMantenedorUsuarios.setText("MANTENEDOR DE USUARIOS");

        btningresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/log-in ESTE OCUPÉ.png"))); // NOI18N
        btningresar.setText("INGRESAR");
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });

        btnModificarMU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/editar (3).png"))); // NOI18N
        btnModificarMU.setText("MODIFICAR");

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eliminar.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");

        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/limpiar.png"))); // NOI18N
        btnlimpiar.setText("LIMPIAR");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        tableListadoUsuariosMU.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableListadoUsuariosMU);

        lblListadoUsuariosMU.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblListadoUsuariosMU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/lista-de-quehaceres.png"))); // NOI18N
        lblListadoUsuariosMU.setText("LISTADO DE USUARIOS");

        btnExportarMU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/excel.png"))); // NOI18N
        btnExportarMU.setText("Exportar a Excel");
        btnExportarMU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarMUActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar: ");

        fieldBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel3MantenedorUsuarioLayout = new javax.swing.GroupLayout(Panel3MantenedorUsuario);
        Panel3MantenedorUsuario.setLayout(Panel3MantenedorUsuarioLayout);
        Panel3MantenedorUsuarioLayout.setHorizontalGroup(
            Panel3MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel3MantenedorUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel3MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel3MantenedorUsuarioLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(Panel3MantenedorUsuarioLayout.createSequentialGroup()
                        .addGroup(Panel3MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblListadoUsuariosMU)
                            .addGroup(Panel3MantenedorUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldBuscar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExportarMU, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        Panel3MantenedorUsuarioLayout.setVerticalGroup(
            Panel3MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel3MantenedorUsuarioLayout.createSequentialGroup()
                .addGroup(Panel3MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel3MantenedorUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnExportarMU))
                    .addGroup(Panel3MantenedorUsuarioLayout.createSequentialGroup()
                        .addComponent(lblListadoUsuariosMU)
                        .addGap(18, 18, 18)
                        .addGroup(Panel3MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout Panel2MantenedorUsuarioLayout = new javax.swing.GroupLayout(Panel2MantenedorUsuario);
        Panel2MantenedorUsuario.setLayout(Panel2MantenedorUsuarioLayout);
        Panel2MantenedorUsuarioLayout.setHorizontalGroup(
            Panel2MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2MantenedorUsuarioLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(Panel2MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Panel2MantenedorUsuarioLayout.createSequentialGroup()
                        .addComponent(frm_idoculto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificarMU, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnlimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btningresar))
                    .addComponent(Panel3MantenedorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        Panel2MantenedorUsuarioLayout.setVerticalGroup(
            Panel2MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2MantenedorUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel2MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btningresar)
                    .addComponent(btnModificarMU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnlimpiar)
                    .addComponent(frm_idoculto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(Panel3MantenedorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnVolverMU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/regreso.png"))); // NOI18N
        btnVolverMU.setText("VOLVER AL MENÚ PRINCIPAL");
        btnVolverMU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverMUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Panel1MantenedorUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(133, 133, 133))
                    .addComponent(Panel2MantenedorUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(lblTituloMantenedorUsuarios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolverMU)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTituloMantenedorUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel1MantenedorUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel2MantenedorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolverMU)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNombreCompletoMUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNombreCompletoMUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNombreCompletoMUActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnExportarMUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarMUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportarMUActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void btnVolverMUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMUActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVolverMUActionPerformed

    private void fieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBuscarActionPerformed

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btningresarActionPerformed

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
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUsuario().setVisible(true);
            }
        });
    }
   
    
    
    public void cerrar()
    {
        int resp=JOptionPane.showConfirmDialog(null,"¿Esta seguro/a que desea cerrar la ventana Usuarios?","Confirmación de Cierre",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(resp==JOptionPane.YES_OPTION)
        {
            this.dispose();
        }
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxEstadoMU;
    private javax.swing.JPanel Panel1MantenedorUsuarios;
    private javax.swing.JPanel Panel2MantenedorUsuario;
    private javax.swing.JPanel Panel3MantenedorUsuario;
    public javax.swing.JButton btnExportarMU;
    public javax.swing.JButton btnModificarMU;
    public javax.swing.JButton btnVolverMU;
    public javax.swing.JButton btneliminar;
    public javax.swing.JButton btningresar;
    public javax.swing.JButton btnlimpiar;
    public javax.swing.JTextField fieldBuscar;
    public javax.swing.JPasswordField fieldContraseñaMU;
    public javax.swing.JTextField fieldNombreCompletoMU;
    public javax.swing.JPasswordField fieldRepContrasenaMU;
    public javax.swing.JTextField fieldUsuarioMU;
    public javax.swing.JTextField frm_idoculto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContrasenaMU;
    private javax.swing.JLabel lblEstadoMU;
    private javax.swing.JLabel lblListadoUsuariosMU;
    private javax.swing.JLabel lblNombreCompletoMU;
    private javax.swing.JLabel lblRepContrasenaMU;
    private javax.swing.JLabel lblTituloMantenedorUsuarios;
    private javax.swing.JLabel lblUsuarioMU;
    public javax.swing.JTable tableListadoUsuariosMU;
    // End of variables declaration//GEN-END:variables
}
