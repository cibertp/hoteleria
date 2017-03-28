/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.hotel.victoria.view;

import code.hotel.victoria.model.dao.DAOUsuario;
import code.hotel.victoria.model.interfaces.IUsuario;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author PSantana
 */
public class Login extends javax.swing.JFrame implements ActionListener{
    private int x=0,y=0;
    public Login() {
        this.setUndecorated(true);        
        initComponents();
        this.setResizable(false);  
        this.setLocationRelativeTo(this);
        btnIngresar.setToolTipText("Ingresar");        
        btnSalir.setToolTipText("Salir");
        btnIngresar.addActionListener(this);
        btnSalir.addActionListener(this); 
//        pressEnter();
        moveFrame();
        
    }
    private void moveFrame(){
        panelLogin1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Point point = MouseInfo.getPointerInfo().getLocation()   ;
                setLocation(point.x - x, point.y - y)   ;
            }
        });
        panelLogin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                x = evt.getX   ()  ;
                y = evt.getY   ()  ;
            }
        });
    }
//    private void pressEnter(){
//        addKeyListener(new java.awt.event.KeyAdapter() {
//            public void keyPressed(java.awt.event.KeyEvent evt) {
//                System.out.println("dsdsd");
//                if(evt.getKeyCode()==KeyEvent.VK_ENTER ||evt.getKeyCode()==KeyEvent.VK_1){
//                    System.out.println("dfdsfgd");
//                }
//            }
//        });
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnSalir) 
            System.exit(0);
        if (e.getSource()==btnIngresar){
            getPass();
        }
    }
    private void getPass(){
        String u="",p = "";
        u=txtUsuario.getText();
            char[] input = txtPassword.getPassword();
            for (int i = 0; i < input.length; i++) {
                p+=input[i];
            }
            System.out.println(p);
            accessUser(u,p);
    }
    private void accessUser(String user,String password){
        IUsuario oUser= new DAOUsuario();
        boolean isUser=oUser.isUserExist(user, password);        
        if(isUser){
            switch(oUser.existUser(user, password)){
                case "ADMINISTRADOR": new ViewAdm_Menu().setVisible(true);
                        this.dispose();break;
//                case "SISTEMAS": new Sistemas().setVisible(true);
//                        this.dispose();break;
//                case "OPERARIO": new Operario().setVisible(true);
//                        this.dispose();break;                    
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Acceso denegado");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin1 = new code.hotel.victoria.view.components.PanelLogin();
        txtUsuario = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIngresar.setBackground(new java.awt.Color(153, 255, 255));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/hotel/victoria/view/resources/enter-pin.png"))); // NOI18N
        btnIngresar.setFocusable(false);
        btnIngresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/code/hotel/victoria/view/resources/enter-pin(1).png"))); // NOI18N

        btnSalir.setBackground(new java.awt.Color(153, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/code/hotel/victoria/view/resources/computing-cloud.png"))); // NOI18N
        btnSalir.setFocusable(false);
        btnSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/code/hotel/victoria/view/resources/computing-cloud_1.png"))); // NOI18N

        javax.swing.GroupLayout panelLogin1Layout = new javax.swing.GroupLayout(panelLogin1);
        panelLogin1.setLayout(panelLogin1Layout);
        panelLogin1Layout.setHorizontalGroup(
            panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogin1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(panelLogin1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(txtPassword))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        panelLogin1Layout.setVerticalGroup(
            panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogin1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private code.hotel.victoria.view.components.PanelLogin panelLogin1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
   
}
