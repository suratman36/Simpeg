/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simpeg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.koneksi;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.HashMap;

/**
 *
 * @author PROXIS PROCUREMENT
 */
public class Kehadiran extends javax.swing.JFrame {
    private final Connection con = new koneksi ().open();
    koneksi kon = new koneksi();
    private DefaultTableModel tabmode;

    /**
     * Creates new form Kehadiran
     */
    public Kehadiran() {
        initComponents();
        setTitle("Form Kehadiran");
        setLocationRelativeTo(this);
        datatable();
        comboid();
        tampilnama();
    }
    protected void aktif(){
        cbox.setEnabled(true);
        a.setEnabled(true);
        b.setEnabled(true);
        cbox.requestFocus();
    }
    protected void kosong (){
        cbox.setSelectedItem("");
        a.setText("");
        b.setText("");
    }
    protected void datatable(){
        Object[] Baris = {"ID","NAMA","KEHADIRAN"};
        tabmode = new DefaultTableModel (null, Baris);
        tblhadir.setModel(tabmode);
        String sql = "select * from kehadiran";
        try {
            java.sql.Statement stat = con.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String a = hasil.getString("id");
                String b = hasil.getString("nama");
                String c = hasil.getString("hadir");
                String[] data={a,b,c};
                tabmode.addRow (data);
            }            
        } catch (Exception e){
    }
    }
        public void comboid(){
            try {
               String sql = "select * from pegawai";
               java.sql.Statement stat = con.createStatement();
               ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    cbox.addItem(hasil.getString("id"));
                } 
                hasil.last();
                int jumlahdata = hasil.getRow();
                hasil.first();
            } catch (SQLException e){
       }
        }     
                         
        public void tampilnama(){
            try {
                String sql = "select * from pegawai where id ='"+cbox.getSelectedItem()+"'";
                try (java.sql.Statement stat = con.createStatement();
                        ResultSet hasil = stat.executeQuery(sql))
                {
                    while (hasil.next()){
                        Object[] ob = new Object[1];
                        ob[0]= hasil.getString(2);
                        a.setText ((String) ob[0]);
                    }
                }
                } catch (SQLException e){
                }
                
            }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        selesai = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        b = new javax.swing.JTextField();
        a = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhadir = new javax.swing.JTable();
        cbox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(69, 98, 128));

        jPanel2.setBackground(new java.awt.Color(239, 177, 12));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("INPUT DATA KEHADIRAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(109, 109, 109))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jumlah Kehadiran");

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        selesai.setText("Selesai");
        selesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selesaiActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        b.setBackground(new java.awt.Color(204, 204, 204));

        a.setBackground(new java.awt.Color(204, 204, 204));

        tblhadir.setModel(new javax.swing.table.DefaultTableModel(
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
        tblhadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhadirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblhadir);

        cbox.setBackground(new java.awt.Color(204, 204, 204));
        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih ID Pegawai" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(simpan)
                        .addGap(26, 26, 26)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(selesai))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(a, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(b, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(cbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selesai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try{
            String sql ="update kehadiran set hadir=? where nama='"+a.getText()+"'";
            PreparedStatement stat = con.prepareStatement (sql);
            stat.setString(1, b.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
            kosong();
            cbox.requestFocus();
            datatable();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal di Update"+e);
        }
    }//GEN-LAST:event_editActionPerformed

    private void selesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selesaiActionPerformed
        int keluar = JOptionPane.showConfirmDialog(this, "Yakin ingin keluar?","Konfirmasi",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (keluar == JOptionPane.YES_OPTION){
            dispose();
            new Menu_utama().setVisible(true);
        }
    }//GEN-LAST:event_selesaiActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
         int ok = JOptionPane.showConfirmDialog(null, "Hapus", "Konfirmasi Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
            if (ok==0){
            String sql ="delete from kehadiran where id ='"+cbox.getSelectedItem()+"'";
            try{
                PreparedStatement stat = con.prepareStatement (sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
                kosong();
                cbox.requestFocus();
                datatable();
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus" +e);
            }
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        String sql = "insert into kehadiran values (?,?,?)";
        try {
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, (String) cbox.getSelectedItem());
            stat.setString(2, a.getText());
            stat.setString(3, b.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog (null, "Data Berhasil Disimppan");
            kosong ();
            cbox.requestFocus();
            datatable();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan" +e);
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void tblhadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhadirMouseClicked
        int bar = tblhadir.getSelectedRow();
        cbox.setSelectedItem (tabmode.getValueAt (bar, 0).toString());
        a.setText (tabmode.getValueAt(bar, 1).toString());
        b.setText (tabmode.getValueAt(bar, 2).toString());
    }//GEN-LAST:event_tblhadirMouseClicked

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
            java.util.logging.Logger.getLogger(Kehadiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kehadiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kehadiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kehadiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kehadiran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JTextField b;
    private javax.swing.JComboBox<String> cbox;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton selesai;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tblhadir;
    // End of variables declaration//GEN-END:variables
}
