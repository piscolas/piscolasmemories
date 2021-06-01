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
public class FormCategoria extends javax.swing.JFrame {

    /**
     * Creates new form FormCategoria
     */
    public FormCategoria() {
        initComponents();
        ocultar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLibrosInteractivos = new javax.swing.JButton();
        btnGeneroLirico = new javax.swing.JButton();
        btnGeneroEpico = new javax.swing.JButton();
        btnGeneroDramatico = new javax.swing.JButton();
        btnLecturaProlongada = new javax.swing.JButton();
        btnLibrosConsulta = new javax.swing.JButton();
        btnManuales = new javax.swing.JButton();
        btnLiteraturaIlustrada = new javax.swing.JButton();
        btnBiografias = new javax.swing.JButton();
        btnLibrosSagrados = new javax.swing.JButton();
        btnLibrosBolsillo = new javax.swing.JButton();
        btnComics = new javax.swing.JButton();
        btnSagas = new javax.swing.JButton();
        btnLibroPartituras = new javax.swing.JButton();
        btnNovelas = new javax.swing.JButton();
        btnLibrosCocina = new javax.swing.JButton();
        btnLibrosFantasia = new javax.swing.JButton();
        btnLibrosReligion = new javax.swing.JButton();
        btnCienciaFiccion = new javax.swing.JButton();
        btnLibrosdeArte = new javax.swing.JButton();
        btnRevistas = new javax.swing.JButton();
        btnLibrosEspiritualidad = new javax.swing.JButton();
        btnLibrosEroticos = new javax.swing.JButton();
        btnCuentos = new javax.swing.JButton();
        btnCienciasExactas = new javax.swing.JButton();
        btnCine = new javax.swing.JButton();
        btnLibrosCostumbristas = new javax.swing.JButton();
        btnCronicas = new javax.swing.JButton();
        btnLibrosCultura = new javax.swing.JButton();
        btnDiccionarios = new javax.swing.JButton();
        btnEnciclopedia = new javax.swing.JButton();
        btnLibrosEconomia = new javax.swing.JButton();
        btnLibrosEsoterismo = new javax.swing.JButton();
        btnLibrosFilosofia = new javax.swing.JButton();
        btnLibrosAstrologia = new javax.swing.JButton();
        btnLibrosCriticas = new javax.swing.JButton();
        btnLibrosDeportes = new javax.swing.JButton();
        btnEnsayos = new javax.swing.JButton();
        btnCienciasSociales = new javax.swing.JButton();
        btnLibrosComunicacion = new javax.swing.JButton();
        btnCatVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CATEGORIAS DE LIBROS");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnLibrosInteractivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/visualizacion-interactiva.png"))); // NOI18N
        btnLibrosInteractivos.setText("Libros interactivos");

        btnGeneroLirico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/letra.png"))); // NOI18N
        btnGeneroLirico.setText("Género Lírico");

        btnGeneroEpico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/caballero.png"))); // NOI18N
        btnGeneroEpico.setText("Género Épico");

        btnGeneroDramatico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/drama.png"))); // NOI18N
        btnGeneroDramatico.setText("Género Dramático");

        btnLecturaProlongada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/libross (1).png"))); // NOI18N
        btnLecturaProlongada.setText("Lectura prolongada");
        btnLecturaProlongada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLecturaProlongadaActionPerformed(evt);
            }
        });

        btnLibrosConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/consulta.png"))); // NOI18N
        btnLibrosConsulta.setText("Libros de Consulta");

        btnManuales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/guia.png"))); // NOI18N
        btnManuales.setText("Manuales");
        btnManuales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManualesActionPerformed(evt);
            }
        });

        btnLiteraturaIlustrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/hombre.png"))); // NOI18N
        btnLiteraturaIlustrada.setText("Literatura Ilustrada");
        btnLiteraturaIlustrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiteraturaIlustradaActionPerformed(evt);
            }
        });

        btnBiografias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/biografia.png"))); // NOI18N
        btnBiografias.setText("Biografías");

        btnLibrosSagrados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/escrituras-sagradas.png"))); // NOI18N
        btnLibrosSagrados.setText("Libros sagrados");

        btnLibrosBolsillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bolsillo.png"))); // NOI18N
        btnLibrosBolsillo.setText("Libros de Bolsillo");

        btnComics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/comic.png"))); // NOI18N
        btnComics.setText("Cómics");

        btnSagas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/libros-serializados.png"))); // NOI18N
        btnSagas.setText("Sagas");

        btnLibroPartituras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/partitura.png"))); // NOI18N
        btnLibroPartituras.setText("Libro de Partituras");

        btnNovelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/escribir.png"))); // NOI18N
        btnNovelas.setText("Novelas");

        btnLibrosCocina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cocinando.png"))); // NOI18N
        btnLibrosCocina.setText("Libros de Cocina");

        btnLibrosFantasia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fantasia.png"))); // NOI18N
        btnLibrosFantasia.setText("Libros de Fantasía");

        btnLibrosReligion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/religion.png"))); // NOI18N
        btnLibrosReligion.setText("Libros de Religión");

        btnCienciaFiccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ciencia-ficcion.png"))); // NOI18N
        btnCienciaFiccion.setText("Ciencia Ficción");

        btnLibrosdeArte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/imagen.png"))); // NOI18N
        btnLibrosdeArte.setText("Libros de Arte");

        btnRevistas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/revista.png"))); // NOI18N
        btnRevistas.setText("Revistas");

        btnLibrosEspiritualidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bienestar-espiritual.png"))); // NOI18N
        btnLibrosEspiritualidad.setText("Libros de Espiritualidad");

        btnLibrosEroticos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/erotico.png"))); // NOI18N
        btnLibrosEroticos.setText("Libros Eróticos");

        btnCuentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bebe.png"))); // NOI18N
        btnCuentos.setText("Cuentos");

        btnCienciasExactas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exactitud.png"))); // NOI18N
        btnCienciasExactas.setText("Ciencias Exactas");

        btnCine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cine.png"))); // NOI18N
        btnCine.setText("Cine");

        btnLibrosCostumbristas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/nativo.png"))); // NOI18N
        btnLibrosCostumbristas.setText("Libros Costumbristas");

        btnCronicas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/periodico.png"))); // NOI18N
        btnCronicas.setText("Crónicas");

        btnLibrosCultura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/personas.png"))); // NOI18N
        btnLibrosCultura.setText("Libros de Cultura");

        btnDiccionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/diccionario.png"))); // NOI18N
        btnDiccionarios.setText("Diccionarios");

        btnEnciclopedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/libro.png"))); // NOI18N
        btnEnciclopedia.setText("Enciclopedias");

        btnLibrosEconomia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/analitica.png"))); // NOI18N
        btnLibrosEconomia.setText("Libros de Economía");
        btnLibrosEconomia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibrosEconomiaActionPerformed(evt);
            }
        });

        btnLibrosEsoterismo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/luna.png"))); // NOI18N
        btnLibrosEsoterismo.setText("Libros de Esoterismo");

        btnLibrosFilosofia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/aristoteles.png"))); // NOI18N
        btnLibrosFilosofia.setText("Libros de Filosofía");

        btnLibrosAstrologia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/astrologia.png"))); // NOI18N
        btnLibrosAstrologia.setText("Libros de Astrología");

        btnLibrosCriticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cliente.png"))); // NOI18N
        btnLibrosCriticas.setText("Libros de Críticas");

        btnLibrosDeportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/deportes.png"))); // NOI18N
        btnLibrosDeportes.setText("Libros de Deportes");

        btnEnsayos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/nota.png"))); // NOI18N
        btnEnsayos.setText("Ensayos");

        btnCienciasSociales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ciencias-sociales.png"))); // NOI18N
        btnCienciasSociales.setText("Ciencias Sociales");

        btnLibrosComunicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/comunicacion-bidireccional.png"))); // NOI18N
        btnLibrosComunicacion.setText("Libros de Comunicación");

        btnCatVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/regreso.png"))); // NOI18N
        btnCatVolver.setText("VOLVER AL MENÚ PRINCIPAL");
        btnCatVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCienciasSociales, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCine, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnComics, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCronicas, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCuentos, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCatVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLibrosCostumbristas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnManuales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGeneroLirico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGeneroEpico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGeneroDramatico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEnsayos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEnciclopedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDiccionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCienciasExactas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCienciaFiccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBiografias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosBolsillo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLibrosCocina, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLibrosAstrologia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosdeArte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnRevistas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosComunicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosCriticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosCultura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosDeportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosEconomia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLiteraturaIlustrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNovelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosEspiritualidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosEsoterismo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosFantasia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosFilosofia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibroPartituras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosReligion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosEroticos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosInteractivos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLecturaProlongada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLibrosSagrados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSagas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBiografias)
                    .addComponent(btnLibrosComunicacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCienciaFiccion)
                    .addComponent(btnLibrosConsulta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCienciasExactas)
                    .addComponent(btnLibrosCriticas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCienciasSociales)
                    .addComponent(btnLibrosCultura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCine)
                    .addComponent(btnLibrosDeportes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComics)
                    .addComponent(btnLibrosEconomia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCronicas)
                    .addComponent(btnLibrosEspiritualidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCuentos)
                    .addComponent(btnLibrosEsoterismo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDiccionarios)
                    .addComponent(btnLibrosFantasia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnciclopedia)
                    .addComponent(btnLibrosFilosofia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnsayos)
                    .addComponent(btnLibroPartituras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGeneroDramatico)
                    .addComponent(btnLibrosReligion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGeneroEpico)
                    .addComponent(btnLibrosEroticos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGeneroLirico)
                    .addComponent(btnLibrosInteractivos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManuales)
                    .addComponent(btnLecturaProlongada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLibrosCostumbristas)
                    .addComponent(btnLibrosSagrados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLibrosdeArte)
                    .addComponent(btnLiteraturaIlustrada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLibrosAstrologia)
                    .addComponent(btnNovelas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLibrosBolsillo)
                    .addComponent(btnRevistas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLibrosCocina)
                    .addComponent(btnSagas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCatVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void btnLecturaProlongadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLecturaProlongadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLecturaProlongadaActionPerformed

    private void btnLiteraturaIlustradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiteraturaIlustradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLiteraturaIlustradaActionPerformed

    private void btnManualesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManualesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManualesActionPerformed

    private void btnLibrosEconomiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibrosEconomiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLibrosEconomiaActionPerformed

    private void btnCatVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatVolverActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCatVolverActionPerformed

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
            java.util.logging.Logger.getLogger(FormCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCategoria().setVisible(true);
            }
        });
    }
    
    public void ocultar(){
    
        
        btnBiografias.setEnabled(false);
        btnCienciaFiccion.setEnabled(false);
        btnCienciasExactas.setEnabled(false);
        btnCienciasSociales.setEnabled(false);
        btnCine.setEnabled(false);
        btnComics.setEnabled(false);
        btnCronicas.setEnabled(false);
        btnCuentos.setEnabled(false);
        btnDiccionarios.setEnabled(false);
        btnEnciclopedia.setEnabled(false);
        btnEnsayos.setEnabled(false);
        btnGeneroDramatico.setEnabled(false);
        btnGeneroEpico.setEnabled(false);
        btnGeneroLirico.setEnabled(false);
        btnLecturaProlongada.setEnabled(false);
        btnLibroPartituras.setEnabled(false);
        btnLibrosAstrologia.setEnabled(false);
        btnLibrosBolsillo.setEnabled(false);
        btnLibrosCocina.setEnabled(false);
        btnLibrosComunicacion.setEnabled(false);
        btnLibrosConsulta.setEnabled(false);
        btnLibrosCostumbristas.setEnabled(false);
        btnLibrosCriticas.setEnabled(false);
        btnLibrosCultura.setEnabled(false);
        btnLibrosDeportes.setEnabled(false);
        btnLibrosEconomia.setEnabled(false);
        btnLibrosEroticos.setEnabled(false);
        btnLibrosEsoterismo.setEnabled(false);
        btnLibrosEspiritualidad.setEnabled(false);
        btnLibrosFantasia.setEnabled(false);
        btnLibrosFilosofia.setEnabled(false);
        btnLibrosInteractivos.setEnabled(false);
        btnLibrosReligion.setEnabled(false);
        btnLibrosSagrados.setEnabled(false);
        btnLibrosdeArte.setEnabled(false);
        btnLiteraturaIlustrada.setEnabled(false);
        btnManuales.setEnabled(false);
        btnNovelas.setEnabled(false);
        btnRevistas.setEnabled(false);
        btnSagas.setEnabled(false);
        
    }
    
        public void cerrar()
    {
        int resp=JOptionPane.showConfirmDialog(null,"¿Esta seguro/a que desea cerrar la ventana de Categoria?","Confirmación de Cierre",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(resp==JOptionPane.YES_OPTION)
        {
            this.dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBiografias;
    private javax.swing.JButton btnCatVolver;
    private javax.swing.JButton btnCienciaFiccion;
    private javax.swing.JButton btnCienciasExactas;
    private javax.swing.JButton btnCienciasSociales;
    private javax.swing.JButton btnCine;
    private javax.swing.JButton btnComics;
    private javax.swing.JButton btnCronicas;
    private javax.swing.JButton btnCuentos;
    private javax.swing.JButton btnDiccionarios;
    private javax.swing.JButton btnEnciclopedia;
    private javax.swing.JButton btnEnsayos;
    private javax.swing.JButton btnGeneroDramatico;
    private javax.swing.JButton btnGeneroEpico;
    private javax.swing.JButton btnGeneroLirico;
    private javax.swing.JButton btnLecturaProlongada;
    private javax.swing.JButton btnLibroPartituras;
    private javax.swing.JButton btnLibrosAstrologia;
    private javax.swing.JButton btnLibrosBolsillo;
    private javax.swing.JButton btnLibrosCocina;
    private javax.swing.JButton btnLibrosComunicacion;
    private javax.swing.JButton btnLibrosConsulta;
    private javax.swing.JButton btnLibrosCostumbristas;
    private javax.swing.JButton btnLibrosCriticas;
    private javax.swing.JButton btnLibrosCultura;
    private javax.swing.JButton btnLibrosDeportes;
    private javax.swing.JButton btnLibrosEconomia;
    private javax.swing.JButton btnLibrosEroticos;
    private javax.swing.JButton btnLibrosEsoterismo;
    private javax.swing.JButton btnLibrosEspiritualidad;
    private javax.swing.JButton btnLibrosFantasia;
    private javax.swing.JButton btnLibrosFilosofia;
    private javax.swing.JButton btnLibrosInteractivos;
    private javax.swing.JButton btnLibrosReligion;
    private javax.swing.JButton btnLibrosSagrados;
    private javax.swing.JButton btnLibrosdeArte;
    private javax.swing.JButton btnLiteraturaIlustrada;
    private javax.swing.JButton btnManuales;
    private javax.swing.JButton btnNovelas;
    private javax.swing.JButton btnRevistas;
    private javax.swing.JButton btnSagas;
    // End of variables declaration//GEN-END:variables
}
