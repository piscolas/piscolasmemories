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
        lblNombreCompleto = new javax.swing.JLabel();
        lblUsuarioMU = new javax.swing.JLabel();
        lblContrasenaMU = new javax.swing.JLabel();
        lblRepContrasenaMU = new javax.swing.JLabel();
        BoxEstadoMU = new javax.swing.JComboBox<>();
        lblEstadoMU = new javax.swing.JLabel();
        fieldNombreCompleto = new javax.swing.JTextField();
        fieldUsuarioMU = new javax.swing.JTextField();
        fieldContraseñaMU = new javax.swing.JTextField();
        fieldRepContrasenaMU = new javax.swing.JTextField();
        lblMantenedorUsuarios = new javax.swing.JLabel();
        Panel2MantenedorUsuario = new javax.swing.JPanel();
        btnIngresarMU = new javax.swing.JButton();
        btnModificarMU = new javax.swing.JButton();
        btnEliminarMU = new javax.swing.JButton();
        btnCancelarMU = new javax.swing.JButton();
        Panel3MantenedorUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaMantenedorUsuario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

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

        lblNombreCompleto.setText("Nombre Completo:");

        lblUsuarioMU.setText("Usuario:");

        lblContrasenaMU.setText("Contraseña:");

        lblRepContrasenaMU.setText("Repetir Contraseña:");

        BoxEstadoMU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblEstadoMU.setText("Estado:");

        fieldNombreCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNombreCompletoActionPerformed(evt);
            }
        });

        fieldRepContrasenaMU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldRepContrasenaMUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel1MantenedorUsuariosLayout = new javax.swing.GroupLayout(Panel1MantenedorUsuarios);
        Panel1MantenedorUsuarios.setLayout(Panel1MantenedorUsuariosLayout);
        Panel1MantenedorUsuariosLayout.setHorizontalGroup(
            Panel1MantenedorUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1MantenedorUsuariosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(Panel1MantenedorUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Panel1MantenedorUsuariosLayout.createSequentialGroup()
                        .addComponent(lblNombreCompleto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldNombreCompleto))
                    .addGroup(Panel1MantenedorUsuariosLayout.createSequentialGroup()
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
                                .addComponent(lblContrasenaMU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldContraseñaMU, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRepContrasenaMU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldRepContrasenaMU, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel1MantenedorUsuariosLayout.setVerticalGroup(
            Panel1MantenedorUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1MantenedorUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel1MantenedorUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreCompleto)
                    .addComponent(fieldNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(BoxEstadoMU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        lblMantenedorUsuarios.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMantenedorUsuarios.setText("MANTENEDOR DE USUARIOS");

        btnIngresarMU.setIcon(new javax.swing.ImageIcon("C:\\Users\\tomas\\Downloads\\Ingresar\\log-in.png")); // NOI18N
        btnIngresarMU.setText("INGRESAR");

        btnModificarMU.setIcon(new javax.swing.ImageIcon("E:\\U 2021\\DISEÑO APP\\SistemaBiblioteca\\Icons\\Modificar\\editar (3).png")); // NOI18N
        btnModificarMU.setText("MODIFICAR");

        btnEliminarMU.setIcon(new javax.swing.ImageIcon("E:\\U 2021\\DISEÑO APP\\SistemaBiblioteca\\Icons\\Eliminar\\eliminar.png")); // NOI18N
        btnEliminarMU.setText("ELIMINAR");

        btnCancelarMU.setIcon(new javax.swing.ImageIcon("E:\\U 2021\\DISEÑO APP\\SistemaBiblioteca\\Icons\\Cancelar\\cancelar (2).png")); // NOI18N
        btnCancelarMU.setText("CANCELAR");
        btnCancelarMU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMUActionPerformed(evt);
            }
        });

        TablaMantenedorUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaMantenedorUsuario);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("LISTADO DE USUARIOS (26)");

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\tomas\\Downloads\\excel.png")); // NOI18N
        jButton1.setText("Exportar a Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26))))
        );
        Panel3MantenedorUsuarioLayout.setVerticalGroup(
            Panel3MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel3MantenedorUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel3MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout Panel2MantenedorUsuarioLayout = new javax.swing.GroupLayout(Panel2MantenedorUsuario);
        Panel2MantenedorUsuario.setLayout(Panel2MantenedorUsuarioLayout);
        Panel2MantenedorUsuarioLayout.setHorizontalGroup(
            Panel2MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2MantenedorUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel3MantenedorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2MantenedorUsuarioLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnIngresarMU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificarMU)
                .addGap(59, 59, 59)
                .addComponent(btnEliminarMU)
                .addGap(60, 60, 60)
                .addComponent(btnCancelarMU)
                .addGap(50, 50, 50))
        );
        Panel2MantenedorUsuarioLayout.setVerticalGroup(
            Panel2MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2MantenedorUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel2MantenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarMU)
                    .addComponent(btnModificarMU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarMU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarMU))
                .addGap(18, 18, 18)
                .addComponent(Panel3MantenedorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\tomas\\Downloads\\equipo.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblMantenedorUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel1MantenedorUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel2MantenedorUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMantenedorUsuarios)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel1MantenedorUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel2MantenedorUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNombreCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNombreCompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNombreCompletoActionPerformed

    private void btnCancelarMUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMUActionPerformed

    private void fieldRepContrasenaMUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldRepContrasenaMUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldRepContrasenaMUActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_formWindowClosing

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
    
    /**
     *
     */
    public void cerrar()
    {
        int resp=JOptionPane.showConfirmDialog(null,"¿Esta seguro/a que desea salir del sistema?","Confirmación de Cierre",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(resp==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxEstadoMU;
    private javax.swing.JPanel Panel1MantenedorUsuarios;
    private javax.swing.JPanel Panel2MantenedorUsuario;
    private javax.swing.JPanel Panel3MantenedorUsuario;
    private javax.swing.JTable TablaMantenedorUsuario;
    private javax.swing.JButton btnCancelarMU;
    private javax.swing.JButton btnEliminarMU;
    private javax.swing.JButton btnIngresarMU;
    private javax.swing.JButton btnModificarMU;
    private javax.swing.JTextField fieldContraseñaMU;
    private javax.swing.JTextField fieldNombreCompleto;
    private javax.swing.JTextField fieldRepContrasenaMU;
    private javax.swing.JTextField fieldUsuarioMU;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContrasenaMU;
    private javax.swing.JLabel lblEstadoMU;
    private javax.swing.JLabel lblMantenedorUsuarios;
    private javax.swing.JLabel lblNombreCompleto;
    private javax.swing.JLabel lblRepContrasenaMU;
    private javax.swing.JLabel lblUsuarioMU;
    // End of variables declaration//GEN-END:variables
}
