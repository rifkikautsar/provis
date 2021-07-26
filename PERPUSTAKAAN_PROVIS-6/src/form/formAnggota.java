/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import anggota.anggota;
import anggota.anggotaTableModel;
//import form.formTambahAnggota;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import main.database;

/**
 *
 * @author ASUS
 */
public class formAnggota extends javax.swing.JInternalFrame {
    database db = new database();
    anggotaTableModel tabelAnggota = new anggotaTableModel();
    
    /**
     * Creates new form form_anggota2
     */
    public formAnggota() {
        initComponents();
        tampilData();
    }
    public void tampilData(){
        
        tabelAnggota.setData(db.tampilAnggota());
        tbAnggota.setModel(tabelAnggota);
    }
    public void refreshData(){
       
        tabelAnggota.setData(db.tampilAnggota());
        tabelAnggota.fireTableDataChanged();
        
        tbAnggota.changeSelection(0, 0, false, false);
    }
    
    /*
    public void dataAnggota(){
        DefaultTableModel tabAnggota = (DefaultTableModel) tbAnggota.getModel();
        tabAnggota.setRowCount(0);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db10119240perpustakaan", "root", "");
            
            //query
            Statement st = conn.createStatement();
            
            //sql
            String sql = "SELECT * from siswa ORDER BY nis ASC";
            
            //eksekusi
            ResultSet rs = st.executeQuery(sql);
            
            
            while (rs.next()){
                Object[] obj = new Object[5];
                obj[0]=rs.getString("nis");
                obj[1]=rs.getString("nama_siswa");
                obj[2]=rs.getString("kelas");
                obj[3]=rs.getString("jurusan");
                obj[4]=rs.getString("tingkat");
                tabAnggota.addRow(obj);
            }
            tbAnggota.setModel(tabAnggota);
            rs.close();
            st.close();
            tabAnggota.fireTableDataChanged();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : "+e, "Error Koneksi",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void updateTabel(){
       
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db10119240perpustakaan", "root", "");
            
            //query
            Statement st = conn.createStatement();
            
            //sql
            String sql = "SELECT * from buku ORDER BY kode_buku ASC";
            
            //eksekusi
            ResultSet rs = st.executeQuery(sql);
            
            DefaultTableModel tabBuku = (DefaultTableModel) tbAnggota.getModel();
            
            rs.close();
            st.close();
        }catch(Exception e){
            
        }
    } */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTambah = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAnggota = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tblUpdate = new javax.swing.JButton();
        tblHapus = new javax.swing.JButton();
        tblRefresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        tbAnggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIS", "Nama", "Kelas", "Jurusan", "Tingkat"
            }
        ));
        jScrollPane2.setViewportView(tbAnggota);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Tabel Anggota");

        tblUpdate.setText("Update");
        tblUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblUpdateActionPerformed(evt);
            }
        });

        tblHapus.setText("Hapus");
        tblHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblHapusActionPerformed(evt);
            }
        });

        tblRefresh.setText("Refresh");
        tblRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblRefreshActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Cari Anggota");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(btnTambah)
                                .addGap(32, 32, 32)
                                .addComponent(tblUpdate)
                                .addGap(32, 32, 32)
                                .addComponent(tblHapus)
                                .addGap(32, 32, 32)
                                .addComponent(tblRefresh))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(tblUpdate)
                    .addComponent(tblHapus)
                    .addComponent(tblRefresh))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        boolean validasi = false;
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        formTambahAnggota formTambah;
        formTambah = new formTambahAnggota(frame,true);
        formTambah.setLocationRelativeTo(null);
        formTambah.setVisible(true);
        formTambah.txtNis.setText("");
        formTambah.txtNama.setText("");
        formTambah.txtKelas.setText("");
        formTambah.txtJurusan.setText("");
        formTambah.txtTingkat.setText("");
        refreshData();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void tblHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblHapusActionPerformed
        // TODO add your handling code here:
        try{
            int baris = tbAnggota.getSelectedRow();
            String nis = (String) tabelAnggota.getValueAt(baris, 0);
            String nama = (String) tabelAnggota.getValueAt(baris, 1);
            Object[] pilihan = {"Ya","Tidak"};
            int jawaban = JOptionPane.showOptionDialog(rootPane,
                    "Apakah yakin menghapus data anggota yang bernama "+nama+"?", 
                    "Konfirmasi",JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,null,pilihan,pilihan[0]);
            if(jawaban==0){
                db.hapusAnggota(nis);
                refreshData();
            }
        }
        catch (IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus!",
                    "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_tblHapusActionPerformed

    private void tblUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblUpdateActionPerformed
        // TODO add your handling code here:
        try{
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            formUpdateAnggota formUpdate = new formUpdateAnggota(frame,true);

            int baris = tbAnggota.getSelectedRow();
            String nis = (String) tabelAnggota.getValueAt(baris, 0);
            anggota ag = db.pilihAnggota(nis);
            if(ag!=null){
            formUpdate.setForm(ag);
            formUpdate.setVisible(true);
            refreshData();
            }
        else{
            JOptionPane.showMessageDialog(rootPane, "Anggota dengan nis "+nis+""
                    + " tidak ditemukan");
            }
        }catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus!",
                    "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_tblUpdateActionPerformed

    private void tblRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblRefreshActionPerformed
        // TODO add your handling code here:
        refreshData();
    }//GEN-LAST:event_tblRefreshActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        String keyword = txtCari.getText();
        tbAnggota.setModel(tabelAnggota);
        tabelAnggota.setData(db.cariAnggota(keyword));
        tabelAnggota.fireTableDataChanged();
        tbAnggota.changeSelection(0, 0, false, false);
    }//GEN-LAST:event_txtCariKeyReleased
/**/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbAnggota;
    private javax.swing.JButton tblHapus;
    private javax.swing.JButton tblRefresh;
    private javax.swing.JButton tblUpdate;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
