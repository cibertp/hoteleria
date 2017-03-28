/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.hotel.victoria.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PSantana
 * Icons By Madebyoliver http://www.flaticon.com/authors/madebyoliver
 * MadebyoliverMadebyoliver http://www.flaticon.com" 
 * www.flaticon.com 
 * http://creativecommons.org/licenses/by/3.0/
 */
public class ViewAdm_Menu extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form ViewAdm_Menu
     */
    MntColaboradores ventana;
    public ViewAdm_Menu() {
        initComponents();
        ventana= new MntColaboradores();
        this.setExtendedState(MAXIMIZED_BOTH);
        btnColaboradores.addActionListener(this);
        btnUsuarios.addActionListener(this);
    } 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnColaboradores){
            if(ventana.isShowing()){
                ventana.jTabbedPane4.setSelectedIndex(0);
            }else{
                pnlEvtMenu.add(ventana);
                ventana.show();
                ventana.jTabbedPane4.setSelectedIndex(0);
            }
        }
        if (e.getSource()==btnUsuarios){
            if(ventana.isShowing()){
                ventana.jTabbedPane4.setSelectedIndex(1);
            }else{
                pnlEvtMenu.add(ventana);
                ventana.show();
                ventana.jTabbedPane4.setSelectedIndex(1);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        btnColaboradores = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        pnlEvtMenu = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMenu.setMaximumSize(new java.awt.Dimension(3276, 3276));
        pnlMenu.setPreferredSize(new java.awt.Dimension(838, 60));

        btnColaboradores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/hotel/victoria/view/resources/manandwoman.jpg"))); // NOI18N
        btnColaboradores.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/code/hotel/victoria/view/resources/manandwoman - copia.jpg"))); // NOI18N

        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/hotel/victoria/view/resources/users.png"))); // NOI18N

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(btnColaboradores, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 228, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnColaboradores, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        getContentPane().add(pnlMenu, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout pnlEvtMenuLayout = new javax.swing.GroupLayout(pnlEvtMenu);
        pnlEvtMenu.setLayout(pnlEvtMenuLayout);
        pnlEvtMenuLayout.setHorizontalGroup(
            pnlEvtMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 838, Short.MAX_VALUE)
        );
        pnlEvtMenuLayout.setVerticalGroup(
            pnlEvtMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );

        getContentPane().add(pnlEvtMenu, java.awt.BorderLayout.CENTER);

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            javax.swing.UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewAdm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAdm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAdm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAdm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAdm_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColaboradores;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel pnlEvtMenu;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables

    
}
