/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public final class formLogin extends javax.swing.JFrame {
    database db = new database();
    /**
     * Creates new form formLogin
     */
    public formLogin() {
        if(koneksi()==0){
            System.exit(0);
        }else{
            initComponents();
        }
    }
    public int koneksi(){
        
        int pilihan = 0;
        try{
            Class.forName(db.driver);
            Connection conn = DriverManager.getConnection(
                    db.url, db.user, db.pwd);
            JOptionPane.showMessageDialog(rootPane, "Koneksi Berhasil","Koneksi",JOptionPane.INFORMATION_MESSAGE);
            pilihan = 1;
        }catch(Exception e){
            JOptionPane.showConfirmDialog(rootPane, "Koneksi GAGAL : "+e,
                    "Koneksi",JOptionPane.CLOSED_OPTION);
        }
        return pilihan;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * insert into petugas values ('19900817201502001','ujang','ujang','ujang'),
     * ('19920705201502002','oneng','oneng','oneng');
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        tblLogin = new javax.swing.JButton();
        tblExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password");

        tblLogin.setText("Login");
        tblLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblLoginActionPerformed(evt);
            }
        });

        tblExit.setText("Exit");
        tblExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblExitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Silahkan login terlebih dahulu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(tblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(tblExit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tblLogin)
                    .addComponent(tblExit))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblLoginActionPerformed
        // TODO add your handling code here:
        Connection conn=null;
        Statement st = null;
       
        //jika username kosong
            if (txtUsername.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Username tidak boleh kosong");
            txtUsername.requestFocus();
        }
        //kondisi jika password kosong
        else if (txtPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Password tidak boleh kosong");
        }else{      
            if(db.loginUser(txtUsername.getText(),txtPassword.getText()).equals("OK")){
            this.dispose();
            new formUtama().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Username / Password tidak sama!",
                    "ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        
        }
    }//GEN-LAST:event_tblLoginActionPerformed

    private void tblExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_tblExitActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton tblExit;
    private javax.swing.JButton tblLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}