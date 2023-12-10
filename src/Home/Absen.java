package Home;

import java.awt.CardLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeListener;
import java.util.Calendar;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;


public class Absen extends javax.swing.JFrame {

private void autoid(){
    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmahasiswa","root","");
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM absen_pagi ORDER BY id_absen DESC");
        if (rs.next()){
            String id = rs.getString("id_absen").substring(1);
            String AN = ""+(Integer.parseInt(id) + 1);
            String nol = "";
            
            if (AN.length()==1){
                nol = "00";
            }else if (AN.length()==2){
                nol = "0";
            }else if (AN.length()==3){
                nol = "";
            }
            txid.setText(nol + AN);
            
        } else {
            txid.setText("001");
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "S");
    }
}   

private void autoid1(){
    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmahasiswa","root","");
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM absen_malam ORDER BY id_absen_malam DESC");
        if (rs.next()){
            String id = rs.getString("id_absen_malam").substring(1);
            String AN = ""+(Integer.parseInt(id) + 1);
            String nol = "";
            
            if (AN.length()==1){
                nol = "00";
            }else if (AN.length()==2){
                nol = "0";
            }else if (AN.length()==3){
                nol = "0";
            }
            txid1.setText(nol + AN);
            
        } else {
            txid1.setText("001");
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "S");
    }
}   

private void autoid2(){
   try {
            String sql = "SELECT * FROM sesi";
            java.sql.Connection con= (java.sql.Connection) Home.Koneksi.getKoneksi();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
            txid2.setText(rs.getString("id_sesi"));
                
            }
            rs.last();
            int data = rs.getRow();
            rs.first();
            
        }catch(Exception e){
            
        } 
}

private void autoid3() {
   try {
        String sql = "SELECT id_sesi FROM sesi ORDER BY id_sesi DESC LIMIT 1 OFFSET 1";
        java.sql.Connection con = (java.sql.Connection) Home.Koneksi.getKoneksi();
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String previousID = rs.getString("id_sesi");
            txid3.setText(previousID);
        } else {
            // Tidak ada sesi sebelumnya
            txid3.setText(""); // Atur ke nilai default jika tidak ada sesi sebelumnya
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    CardLayout cardLayout;
    public Absen() {
        initComponents();
        show_combo();
        show_combo1();
        show_combo2();
        show_combo3();
        show_combo4();
        show_combo5();
        autoid();
        autoid1();
        autoid2();
        autoid3();
        show_data();
        show_data4();
        show_data3();
        getUserData();
        startDate1.setDate(new Date());
        endDate1.setDate(new Date());
        cardLayout = (CardLayout)(jPanel2.getLayout());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        card1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        card2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        penghuni = new javax.swing.JComboBox<>();
        lantai = new javax.swing.JComboBox<>();
        sbmt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txid = new javax.swing.JTextField();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        txid2 = new javax.swing.JTextField();
        card4 = new javax.swing.JPanel();
        cb_nama = new javax.swing.JComboBox<>();
        cb_sesi = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        startDate1 = new com.toedter.calendar.JDateChooser();
        endDate1 = new com.toedter.calendar.JDateChooser();
        jScrollPane7 = new javax.swing.JScrollPane();
        hadir = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        izin = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        alfa = new javax.swing.JTable();
        card5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        lantai3 = new javax.swing.JComboBox<>();
        penghuni3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rb4 = new javax.swing.JRadioButton();
        rb5 = new javax.swing.JRadioButton();
        rb6 = new javax.swing.JRadioButton();
        sbmt1 = new javax.swing.JButton();
        txid1 = new javax.swing.JTextField();
        txid3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 233, 204));
        jPanel1.setForeground(new java.awt.Color(254, 233, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 288));

        jPanel3.setBackground(new java.awt.Color(254, 233, 204));

        jLabel2.setBackground(new java.awt.Color(254, 233, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/Group 4(1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel2)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(13, 45, 32));

        jButton6.setBackground(new java.awt.Color(254, 233, 204));
        jButton6.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(254, 233, 204));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/Vector.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setContentAreaFilled(false);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(13, 45, 32));

        jButton7.setBackground(new java.awt.Color(254, 233, 204));
        jButton7.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(254, 233, 204));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/Vector(1).png"))); // NOI18N
        jButton7.setText("Presensi Pagi");
        jButton7.setBorder(null);
        jButton7.setContentAreaFilled(false);
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(13, 45, 32));

        jButton8.setBackground(new java.awt.Color(254, 233, 204));
        jButton8.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(254, 233, 204));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/Vector(1).png"))); // NOI18N
        jButton8.setText("Presensi Malam");
        jButton8.setBorder(null);
        jButton8.setContentAreaFilled(false);
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(13, 45, 32));

        jButton9.setBackground(new java.awt.Color(254, 233, 204));
        jButton9.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(254, 233, 204));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/Vector(1).png"))); // NOI18N
        jButton9.setText("Rekap Presensi");
        jButton9.setBorder(null);
        jButton9.setContentAreaFilled(false);
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(13, 45, 32));

        jButton10.setBackground(new java.awt.Color(254, 233, 204));
        jButton10.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(254, 233, 204));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/Vector(1).png"))); // NOI18N
        jButton10.setText("Admin");
        jButton10.setBorder(null);
        jButton10.setContentAreaFilled(false);
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(58, 71, 80));
        jPanel2.setLayout(new java.awt.CardLayout());

        card1.setBackground(new java.awt.Color(13, 45, 32));
        card1.setPreferredSize(new java.awt.Dimension(780, 700));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/Untitled(3) 1(4).png"))); // NOI18N

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap())
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(5, 5, 5))
        );

        jPanel2.add(card1, "card1");
        card1.getAccessibleContext().setAccessibleName("card1");

        card2.setBackground(new java.awt.Color(13, 45, 32));

        jTable1.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        penghuni.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        penghuni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-" }));
        penghuni.setMinimumSize(new java.awt.Dimension(86, 22));
        penghuni.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                penghuniItemStateChanged(evt);
            }
        });
        penghuni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penghuniActionPerformed(evt);
            }
        });

        lantai.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        lantai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-", "1", "2" }));
        lantai.setPreferredSize(new java.awt.Dimension(86, 22));
        lantai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lantaiActionPerformed(evt);
            }
        });

        sbmt.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        sbmt.setText("SUBMIT");
        sbmt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sbmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbmtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Floor");

        jLabel4.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Name");

        txid.setBackground(new java.awt.Color(13, 45, 32));
        txid.setEnabled(false);
        txid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txidActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb1);
        rb1.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        rb1.setForeground(new java.awt.Color(242, 242, 242));
        rb1.setText("Available");
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb2);
        rb2.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        rb2.setForeground(new java.awt.Color(242, 242, 242));
        rb2.setText("Not Available");
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb3);
        rb3.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        rb3.setForeground(new java.awt.Color(242, 242, 242));
        rb3.setText("Urgent Only");
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });

        txid2.setBackground(new java.awt.Color(13, 45, 32));
        txid2.setEnabled(false);
        txid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txid2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(rb1)
                .addGap(88, 88, 88)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sbmt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb2))
                .addGap(66, 66, 66)
                .addComponent(rb3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(card2Layout.createSequentialGroup()
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(670, 670, 670)
                        .addComponent(txid, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txid2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(card2Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lantai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(236, 236, 236)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(penghuni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lantai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(penghuni, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb2)
                    .addComponent(rb3)
                    .addComponent(rb1))
                .addGap(35, 35, 35)
                .addComponent(sbmt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        txid.getAccessibleContext().setAccessibleName("txid");

        jPanel2.add(card2, "card2");
        card2.getAccessibleContext().setAccessibleName("card2");

        card4.setBackground(new java.awt.Color(13, 45, 32));

        cb_nama.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        cb_nama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-" }));
        cb_nama.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_namaItemStateChanged(evt);
            }
        });
        cb_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_namaActionPerformed(evt);
            }
        });

        cb_sesi.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        cb_sesi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-", "Pagi", "Malam" }));
        cb_sesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sesiActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton4.setText("Submit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable5.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable5);

        jLabel12.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Nama");

        jLabel13.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Sesi");

        jLabel14.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Waktu");

        hadir.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        hadir.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(hadir);

        izin.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        izin.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(izin);

        alfa.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        alfa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(alfa);

        javax.swing.GroupLayout card4Layout = new javax.swing.GroupLayout(card4);
        card4.setLayout(card4Layout);
        card4Layout.setHorizontalGroup(
            card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card4Layout.createSequentialGroup()
                .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card4Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(card4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(card4Layout.createSequentialGroup()
                                .addComponent(cb_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124)
                                .addComponent(cb_sesi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card4Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(startDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(endDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
            .addGroup(card4Layout.createSequentialGroup()
                .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(card4Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        card4Layout.setVerticalGroup(
            card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(card4Layout.createSequentialGroup()
                        .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_sesi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(card4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startDate1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(endDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(28, 28, 28)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel2.add(card4, "card4");
        card4.getAccessibleContext().setAccessibleName("card4");

        card5.setBackground(new java.awt.Color(13, 45, 32));

        jScrollPane6.setPreferredSize(new java.awt.Dimension(300, 80));

        jTable6.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable6);

        lantai3.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        lantai3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-", "1", "2" }));
        lantai3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lantai3ActionPerformed(evt);
            }
        });

        penghuni3.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        penghuni3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-" }));
        penghuni3.setPreferredSize(new java.awt.Dimension(86, 22));
        penghuni3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penghuni3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Floor");

        jLabel5.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Name");

        buttonGroup2.add(rb4);
        rb4.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        rb4.setForeground(new java.awt.Color(242, 242, 242));
        rb4.setText("Available");
        rb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb4ActionPerformed(evt);
            }
        });

        buttonGroup2.add(rb5);
        rb5.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        rb5.setForeground(new java.awt.Color(242, 242, 242));
        rb5.setText("Not Available");
        rb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb5ActionPerformed(evt);
            }
        });

        buttonGroup2.add(rb6);
        rb6.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        rb6.setForeground(new java.awt.Color(242, 242, 242));
        rb6.setText("Urgent Only");
        rb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb6ActionPerformed(evt);
            }
        });

        sbmt1.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        sbmt1.setText("SUBMIT");
        sbmt1.setPreferredSize(new java.awt.Dimension(83, 22));
        sbmt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbmt1ActionPerformed(evt);
            }
        });

        txid1.setBackground(new java.awt.Color(13, 45, 32));
        txid1.setEnabled(false);
        txid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txid1ActionPerformed(evt);
            }
        });

        txid3.setBackground(new java.awt.Color(13, 45, 32));
        txid3.setEnabled(false);

        javax.swing.GroupLayout card5Layout = new javax.swing.GroupLayout(card5);
        card5.setLayout(card5Layout);
        card5Layout.setHorizontalGroup(
            card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card5Layout.createSequentialGroup()
                        .addComponent(txid1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txid3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card5Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
            .addGroup(card5Layout.createSequentialGroup()
                .addGroup(card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(card5Layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addComponent(sbmt1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(card5Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lantai3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card5Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(rb4)
                        .addGap(88, 88, 88)
                        .addComponent(rb5)))
                .addGap(66, 66, 66)
                .addGroup(card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(penghuni3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(93, Short.MAX_VALUE))
                    .addGroup(card5Layout.createSequentialGroup()
                        .addComponent(rb6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        card5Layout.setVerticalGroup(
            card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txid3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addGroup(card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lantai3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(penghuni3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(33, 33, 33)
                .addGroup(card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb5)
                    .addComponent(rb4)
                    .addComponent(rb6))
                .addGap(35, 35, 35)
                .addComponent(sbmt1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel2.add(card5, "card3");

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void show_combo(){
        try {
            penghuni.removeAllItems();
            String preSql = "";
            switch (lantai.getSelectedIndex()) {
                case 0:
                    preSql = "WHERE kode_kamar IS NOT NULL";
                    break;
                case 1:
                    preSql = "WHERE kode_kamar LIKE 'A%'";
                    break;
                default:
                    preSql = "WHERE kode_kamar LIKE 'B%'";
                    break;
            }
            String sql = "SELECT * FROM penghuni " + preSql;
            java.sql.Connection con= (java.sql.Connection) Home.Koneksi.getKoneksi();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            penghuni.addItem("-SELECT-");
            while (rs.next()){
                penghuni.addItem(rs.getString("nama"));
                
            }
            rs.last();
            int data = rs.getRow();
            rs.first();
            
        }catch(Exception e){
            
        }
    }

    private void show_combo1(){
        try {
            String sql = "SELECT * FROM";
            java.sql.Connection con= (java.sql.Connection) Home.Koneksi.getKoneksi();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
               lantai.addItem(rs.getString("lantai"));
                
            }
            rs.last();
            int data = rs.getRow();
            rs.first();
            
        }catch(Exception e){
            
        }
    }    

    private void show_combo2(){
        try {
            String sql = "SELECT * FROM penghuni";
            java.sql.Connection con= (java.sql.Connection) Home.Koneksi.getKoneksi();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
                cb_nama.addItem(rs.getString("nama"));
                
            }
            rs.last();
            int data = rs.getRow();
            rs.first();
            
        }catch(Exception e){
            
        }
    }    
    
    private void show_combo3(){
        try {
            String sql = "SELECT * FROM";
            java.sql.Connection con= (java.sql.Connection) Home.Koneksi.getKoneksi();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
                
               cb_sesi.addItem(rs.getString("lantai"));
                
            }
            rs.last();
            int data = rs.getRow();
            rs.first();
            
        }catch(Exception e){
            
        }
    }
    
    private void show_combo4(){
        try {
            penghuni3.removeAllItems();
            String preSql = "";
            switch (lantai3.getSelectedIndex()) {
                case 0:
                    preSql = "WHERE kode_kamar IS NOT NULL";
                    break;
                case 1:
                    preSql = "WHERE kode_kamar LIKE 'A%'";
                    break;
                default:
                    preSql = "WHERE kode_kamar LIKE 'B%'";
                    break;
            }
            String sql = "SELECT * FROM penghuni " + preSql;
            java.sql.Connection con= (java.sql.Connection) Home.Koneksi.getKoneksi();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            penghuni3.addItem("-SELECT-");
            while (rs.next()){
                penghuni3.addItem(rs.getString("nama"));
                
            }
            rs.last();
            int data = rs.getRow();
            rs.first();
            
        }catch(Exception e){
            
        }
    }    
    
    private void show_combo5(){
        try {
            String sql = "SELECT * FROM";
            java.sql.Connection con= (java.sql.Connection) Home.Koneksi.getKoneksi();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
                
               lantai3.addItem(rs.getString("lantai"));
                
            }
            
            rs.last();
            int data = rs.getRow();
            rs.first();
            
        }catch(Exception e){
            
        }
    }
    
        
    
    public String chooseid(JComboBox a){
        String hsl = "";
        try {
            
            String sql = "SELECT * FROM penghuni WHERE nama='"+a.getSelectedItem()+"'";
            java.sql.Connection con= (java.sql.Connection) Home.Koneksi.getKoneksi();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
                String result = rs.getString(2);
                hsl = result;
                
            }
            rs.last();
            int data = rs.getRow();
            rs.first();
            
        }catch(Exception e){
            
        } 
        return hsl;
    }
    
    public String chooseid1(JComboBox a){
        String hsl = "";
        try {
            String sql = "SELECT * FROM lantai WHERE lantai='"+a.getSelectedItem()+"'";
            java.sql.Connection con= (java.sql.Connection) Home.Koneksi.getKoneksi();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
                String result = rs.getString(1);
                hsl = result;
                
            }
            rs.last();
            int data = rs.getRow();
            rs.first();
            
        }catch(Exception e){
            
        } 
    return hsl;
    }
    

    

 
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        cardLayout.show(jPanel2, "card2");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        setColorLeft(jPanel5);
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        resetColorLeft(jPanel5);
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        setColorLeft(jPanel4);
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        resetColorLeft(jPanel4);
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        setColorLeft(jPanel8);
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        resetColorLeft(jPanel8);
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        cardLayout.show(jPanel2, "card1");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        cardLayout.show(jPanel2, "card4");
    }//GEN-LAST:event_jButton9ActionPerformed
   
    
    public void show_data(){
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("Kode Kamar");
        tabel.addColumn("Nama");
        tabel.addColumn("Lantai");
        tabel.addColumn("Keterangan");
        tabel.addColumn("Tanggal Presensi");
        tabel.addColumn("Jam Presensi");
        try {
            java.sql.Connection con = (java.sql.Connection)Home.Koneksi.getKoneksi();
            String sql = "SELECT penghuni.kode_kamar, penghuni.nama, lantai.lantai, absen_pagi.keterangan, absen_pagi.Waktu, absen_pagi.jam FROM absen_pagi LEFT JOIN penghuni ON absen_pagi.kode_penghuni = penghuni.kode_penghuni LEFT JOIN lantai ON absen_pagi.id_lantai = lantai.id_lantai";
            java.sql.PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs =stm.executeQuery(sql);
            while (rs.next()) {
                tabel.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)});
                }
            jTable1.setModel(tabel);
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error");
                System.out.println(e.getMessage());
            }
    }
    
    
    public void show_data4(){
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("Kode Kamar");
        tabel.addColumn("Nama");
        tabel.addColumn("Lantai");
        tabel.addColumn("Keterangan");
        tabel.addColumn("Tanggal Presensi");
        tabel.addColumn("Jam Presensi");
        try {
            java.sql.Connection con = (java.sql.Connection)Home.Koneksi.getKoneksi();
            String sql = "SELECT penghuni.kode_kamar, penghuni.nama, lantai.lantai, absen_malam.keterangan, absen_malam.Waktu, absen_malam.jam FROM absen_malam LEFT JOIN penghuni ON absen_malam.kode_penghuni = penghuni.kode_penghuni LEFT JOIN lantai ON absen_malam.id_lantai = lantai.id_lantai";
            java.sql.PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs =stm.executeQuery(sql);
            while (rs.next()) {
                tabel.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)});
                }
            jTable6.setModel(tabel);
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error");
                System.out.println(e.getMessage());
            }
    }
    

    
public String tgl_between(JDateChooser startDateChooser, JDateChooser endDateChooser) {
    Date startDate1 = startDateChooser.getDate();
    Date endDate1 = endDateChooser.getDate();

    if (startDate1 == null || endDate1 == null) {
        // Tangani situasi ketika tanggal tidak tersedia
        // Misalnya, tampilkan pesan kesalahan atau berikan nilai default
        return null;
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String startDateStr = dateFormat.format(startDate1);
    String endDateStr = dateFormat.format(endDate1);

    String hsl = "'" + startDateStr + "' AND '" + endDateStr + "'";
    return hsl;
}



    
    
    
    public void scndtable1(){
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("Kode Kamar");
        tabel.addColumn("Nama");
        tabel.addColumn("Available");
        tabel.addColumn("Not Available");
        tabel.addColumn("Urgent Only");
        try {
            java.sql.Connection con = (java.sql.Connection)Home.Koneksi.getKoneksi();
            String sql = "SELECT penghuni.kode_kamar, penghuni.nama, SUM(absen_pagi.keterangan = 'Available' AND absen_pagi.id_absen = '"+chooseid1(cb_sesi)+"'), SUM(absen_pagi.keterangan = 'Not Availalbe' AND absen_pagi.id_absen = '"+chooseid1(cb_sesi)+"'), SUM(absen_pagi.keterangan = 'Urgent Only' AND absen_pagi.id_absen = '"+chooseid1(cb_sesi)+"') FROM penghuni JOIN absen_pagi ON penghuni.kode_penghuni = absen_pagi.kode_penghuni WHERE absen_pagi.id_absen = '"+chooseid1(cb_sesi)+"' GROUP BY penghuni.kode_kamar;";
            System.out.println(sql);
            java.sql.PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs =stm.executeQuery(sql);
            while (rs.next()) {
                tabel.addRow(new Object[]{
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)});
            }
            jTable5.setModel(tabel);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error bro" + e);
            e.printStackTrace();
        }
    }
    
   

    
    public void show_data2(){
        DefaultTableModel tabel = new DefaultTableModel();
        jTable5.setModel(tabel);
        tabel.addColumn("Kode Kamar");
        tabel.addColumn("Nama");
        tabel.addColumn("Available");
        tabel.addColumn("Not Available");
        tabel.addColumn("Urgent Only");
        
        
        String query = null;
       
        if(cb_sesi.getSelectedItem().toString().equals("Pagi") && !(cb_nama.getSelectedIndex()==0)){
            try {
                query = "SELECT kode_kamar, nama, SUM(keterangan = 'Available'), SUM(Keterangan = 'Not Available'), SUM(Keterangan = 'Urgent Only')"
                        + " FROM penghuni"
                        + " JOIN absen_pagi ON penghuni.kode_penghuni = absen_pagi.kode_penghuni "
                        + " WHERE penghuni.kode_penghuni = '" + cb_nama.getSelectedItem().toString().substring(0, 6)+"'"
                        + " AND absen_pagi.waktu BETWEEN " + tgl_between(startDate1, endDate1)
                        + " GROUP BY kode_kamar, nama";
                Connection c = Koneksi.getKoneksi();
                Statement s = c.createStatement();
                ResultSet rs = s.executeQuery(query);
                while(rs.next()){
                    Object[] dataRekap = {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)
                    };
                    tabel.addRow(dataRekap);
                }
                s.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Absen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (cb_sesi.getSelectedItem().toString().equals("Malam") && !(cb_nama.getSelectedIndex()==0)){
            try {
                query = "SELECT kode_kamar, nama, SUM(keterangan = 'Available'), SUM(Keterangan = 'Not Available'), SUM(Keterangan = 'Urgent Only')"
                        + " FROM penghuni"
                        + " JOIN absen_malam ON penghuni.kode_penghuni = absen_malam.kode_penghuni "
                        + " WHERE penghuni.kode_penghuni = '" + cb_nama.getSelectedItem().toString().substring(0, 6) + "'"
                        + " AND absen_malam.waktu BETWEEN " + tgl_between(startDate1, endDate1)
                        + " GROUP BY kode_kamar, nama";
                
                Connection c = Koneksi.getKoneksi();
                Statement s = c.createStatement();
                ResultSet rs = s.executeQuery(query);
                while(rs.next()){
                    Object[] dataRekap = {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)
                    };
                    tabel.addRow(dataRekap);
                }
                s.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Absen.class.getName()).log(Level.SEVERE, null, ex);
            }            
        } else if (!(cb_nama.getSelectedItem()==null) && !(cb_nama.getSelectedIndex()==0)){
            try {
                Object[] dataRekap = new Object[5];
                query = "SELECT kode_kamar, nama, SUM(keterangan = 'Available'), SUM(Keterangan = 'Not Available'), SUM(Keterangan = 'Urgent Only')"
                        + " FROM penghuni"
                        + " JOIN absen_pagi ON penghuni.kode_penghuni = absen_pagi.kode_penghuni "
                        + " WHERE penghuni.kode_penghuni = '" + cb_nama.getSelectedItem().toString().substring(0, 6) + "'"
                        + " AND absen_pagi.waktu BETWEEN " + tgl_between(startDate1, endDate1)
                        + " GROUP BY kode_kamar, nama";
                Connection c = Koneksi.getKoneksi();
                Statement s = c.createStatement();
                ResultSet rs = s.executeQuery(query);
                while(rs.next()){
                    dataRekap[0] = rs.getString(1);
                    dataRekap[1] = rs.getString(2);
                    dataRekap[2] = rs.getInt(3);
                    dataRekap[3] = rs.getInt(4);
                    dataRekap[4] = rs.getInt(5);
                } 
                s.close();
                rs.close();                
                
                query = "SELECT kode_kamar, nama, SUM(keterangan = 'Available'), SUM(Keterangan = 'Not Available'), SUM(Keterangan = 'Urgent Only')"
                        + " FROM penghuni"
                        + " JOIN absen_malam ON penghuni.kode_penghuni = absen_malam.kode_penghuni "
                        + " WHERE penghuni.kode_penghuni = '" + cb_nama.getSelectedItem().toString().substring(0, 6) + "'"
                        + " AND absen_malam.waktu BETWEEN " + tgl_between(startDate1, endDate1)
                        + " GROUP BY kode_kamar, nama";
                
                s = c.createStatement();
                rs = s.executeQuery(query);
                while(rs.next()){
                    dataRekap[0] = rs.getString(1);
                    dataRekap[1] = rs.getString(2);
                    dataRekap[2] = Integer.parseInt(dataRekap[2].toString()) + rs.getInt(3);
                    dataRekap[3] = Integer.parseInt(dataRekap[3].toString()) + rs.getInt(4);
                    dataRekap[4] = Integer.parseInt(dataRekap[4].toString()) + rs.getInt(5);
                    tabel.addRow(dataRekap);
                }
                s.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Absen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if(cb_sesi.getSelectedItem().toString().equals("Pagi") && (cb_nama.getSelectedIndex()==0)){
                try {
                    query = "SELECT kode_kamar, nama, SUM(keterangan = 'Available'), SUM(Keterangan = 'Not Available'), SUM(Keterangan = 'Urgent Only')"
                            + " FROM penghuni"
                            + " JOIN absen_pagi ON penghuni.kode_penghuni = absen_pagi.kode_penghuni "
                            + " WHERE absen_pagi.waktu BETWEEN " + tgl_between(startDate1, endDate1)
                            + " GROUP BY kode_kamar, nama";
                            
                    Connection c = Koneksi.getKoneksi();
                    Statement s = c.createStatement();
                    ResultSet rs = s.executeQuery(query);
                    while(rs.next()){
                        Object[] dataRekap = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5)
                        };
                        tabel.addRow(dataRekap);
                    }
                    s.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Absen.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (cb_sesi.getSelectedItem().toString().equals("Malam") && (cb_nama.getSelectedIndex()==0)){
                try {
                    query = "SELECT kode_kamar, nama, SUM(keterangan = 'Available'), SUM(Keterangan = 'Not Available'), SUM(Keterangan = 'Urgent Only')"
                            + " FROM penghuni"
                            + " JOIN absen_malam ON penghuni.kode_penghuni = absen_malam.kode_penghuni "
                            + " WHERE absen_malam.waktu BETWEEN " + tgl_between(startDate1, endDate1)
                            + " GROUP BY kode_kamar, nama";

                    Connection c = Koneksi.getKoneksi();
                    Statement s = c.createStatement();
                    ResultSet rs = s.executeQuery(query);
                    while(rs.next()){
                        Object[] dataRekap = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5)
                        };
                        tabel.addRow(dataRekap);
                    }
                    s.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Absen.class.getName()).log(Level.SEVERE, null, ex);
                }            
            } else if (!(cb_nama.getSelectedItem()==null) && !(cb_nama.getSelectedIndex()==0)){
                try {
                    Object[] dataRekap = new Object[5];
                    query = "SELECT kode_kamar, nama, SUM(keterangan = 'Available'), SUM(Keterangan = 'Not Available'), SUM(Keterangan = 'Urgent Only')"
                            + " FROM penghuni"
                            + " JOIN absen_pagi ON penghuni.kode_penghuni = absen_pagi.kode_penghuni "
                            + " WHERE absen_pagi.waktu BETWEEN " + tgl_between(startDate1, endDate1)
                            + " GROUP BY kode_kamar, nama";
                    Connection c = Koneksi.getKoneksi();
                    Statement s = c.createStatement();
                    ResultSet rs = s.executeQuery(query);
                    while(rs.next()){
                        dataRekap[0] = rs.getString(1);
                        dataRekap[1] = rs.getString(2);
                        dataRekap[2] = rs.getInt(3);
                        dataRekap[3] = rs.getInt(4);
                        dataRekap[4] = rs.getInt(5);
                    }
                    s.close();
                    rs.close();                

                    query = "SELECT kode_kamar, nama, SUM(keterangan = 'Available'), SUM(Keterangan = 'Not Available'), SUM(Keterangan = 'Urgent Only')"
                            + " FROM penghuni"
                            + " JOIN absen_malam ON penghuni.kode_penghuni = absen_malam.kode_penghuni"
                            + " WHERE absen_malam.waktu BETWEEN " + tgl_between(startDate1, endDate1)
                            + " GROUP BY kode_kamar, nama";
                    s = c.createStatement();
                    rs = s.executeQuery(query);
                    while(rs.next()){
                        dataRekap[0] = rs.getString(1);
                        dataRekap[1] = rs.getString(2);
                        dataRekap[2] = Integer.parseInt(dataRekap[2].toString()) + rs.getInt(3);
                        dataRekap[3] = Integer.parseInt(dataRekap[3].toString()) + rs.getInt(4);
                        dataRekap[4] = Integer.parseInt(dataRekap[4].toString()) + rs.getInt(5);
                        tabel.addRow(dataRekap);
                    }
                    s.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Absen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }        
        
        System.err.println("a " + query);


    }
    
    
    
    public void getUserData(){
        cb_nama.removeAllItems();
        cb_nama.addItem("-SELECT-");
        try {
            String query = "SELECT kode_penghuni, nama FROM penghuni";
            Connection con = Koneksi.getKoneksi();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while(rs.next()){
                cb_nama.addItem(rs.getString(1) + " - " + rs.getString(2));
            }
            s.close();
            rs.close();
        } catch (SQLException ex) {
            
            Logger.getLogger(Absen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showRecapData(){
        
    }
    
     public void show_data3(){
        DefaultTableModel mhadir = new DefaultTableModel();
        DefaultTableModel mizin = new DefaultTableModel();
        DefaultTableModel malfa = new DefaultTableModel();
        
        hadir.setModel(mhadir);
        mhadir.addColumn("Available");
        
        izin.setModel(mizin);
        mizin.addColumn("Not Available");
        
        alfa.setModel(malfa);
        malfa.addColumn("Urgent Only");
        String query = null;
       
        if(cb_sesi.getSelectedItem().toString().equals("Pagi") && !(cb_nama.getSelectedIndex()==0)){
            try {
                Connection c = Koneksi.getKoneksi();
                query = "SELECT waktu"
                        + " FROM absen_pagi"
                        + " WHERE keterangan = 'Available'"
                        + " AND kode_penghuni = '" + cb_nama.getSelectedItem().toString().substring(0, 6) + "' "
                        + " AND waktu BETWEEN " + tgl_between(startDate1, endDate1);               
                Statement s = c.createStatement();
                ResultSet rs = s.executeQuery(query);
                
                while(rs.next()){
                    Object[] dataRekap = {
                        rs.getString(1)
                    };
                    mhadir.addRow(dataRekap);
                }
                s.close();
                rs.close();
    
                query = "SELECT waktu"
                        + " FROM absen_pagi"
                        + " WHERE keterangan = 'Not Available'"
                        + " AND kode_penghuni = '" + cb_nama.getSelectedItem().toString().substring(0, 6) + "' "
                        + " AND waktu BETWEEN " + tgl_between(startDate1, endDate1);               
                s = c.createStatement();
                rs = s.executeQuery(query);
                
                while(rs.next()){
                    Object[] dataRekap = {
                        rs.getString(1)
                    };
                    mizin.addRow(dataRekap);
                }
                s.close();
                rs.close();

                query = "SELECT waktu"
                        + " FROM absen_pagi"
                        + " WHERE keterangan = 'Urgent Only'"
                        + " AND kode_penghuni = '" + cb_nama.getSelectedItem().toString().substring(0, 6) + "' "
                        + " AND waktu BETWEEN " + tgl_between(startDate1, endDate1);               
                s = c.createStatement();
                rs = s.executeQuery(query);
                
                while(rs.next()){
                    Object[] dataRekap = {
                        rs.getString(1)
                    };
                    malfa.addRow(dataRekap);
                }
                s.close();
                rs.close();                
            } catch (SQLException ex) {
                Logger.getLogger(Absen.class.getName()).log(Level.SEVERE, null, ex);
            }    
    }else if(cb_sesi.getSelectedItem().toString().equals("Malam") && !(cb_nama.getSelectedIndex()==0)){
            try {
                Connection c = Koneksi.getKoneksi();
                query = "SELECT waktu"
                        + " FROM absen_malam"
                        + " WHERE keterangan = 'Available'"
                        + " AND kode_penghuni = '" + cb_nama.getSelectedItem().toString().substring(0, 6) + "' "
                        + " AND waktu BETWEEN " + tgl_between(startDate1, endDate1);               
                Statement s = c.createStatement();
                ResultSet rs = s.executeQuery(query);
                
                while(rs.next()){
                    Object[] dataRekap = {
                        rs.getString(1)
                    };
                    mhadir.addRow(dataRekap);
                }
                s.close();
                rs.close();
    
                query = "SELECT waktu"
                        + " FROM absen_malam"
                        + " WHERE keterangan = 'Not Available'"
                        + " AND kode_penghuni = '" + cb_nama.getSelectedItem().toString().substring(0, 6) + "' "
                        + " AND waktu BETWEEN " + tgl_between(startDate1, endDate1);               
                s = c.createStatement();
                rs = s.executeQuery(query);
                
                while(rs.next()){
                    Object[] dataRekap = {
                        rs.getString(1)
                    };
                    mizin.addRow(dataRekap);
                }
                s.close();
                rs.close();

                query = "SELECT waktu"
                        + " FROM absen_malam"
                        + " WHERE keterangan = 'Urgent Only'"
                        + " AND kode_penghuni = '" + cb_nama.getSelectedItem().toString().substring(0, 6) + "' "
                        + " AND waktu BETWEEN " + tgl_between(startDate1, endDate1);               
                s = c.createStatement();
                rs = s.executeQuery(query);
                
                while(rs.next()){
                    Object[] dataRekap = {
                        rs.getString(1)
                    };
                    malfa.addRow(dataRekap);
                }
                s.close();
                rs.close();                
            } catch (SQLException ex) {
                Logger.getLogger(Absen.class.getName()).log(Level.SEVERE, null, ex);
            }
     }}
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        show_data2();
        show_data3();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cb_namaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_namaItemStateChanged
        show_data2();
        show_data3();
    }//GEN-LAST:event_cb_namaItemStateChanged

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        setColorLeft(jPanel9);
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
        resetColorLeft(jPanel9);
    }//GEN-LAST:event_jButton10MouseExited

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.dispose();
        Admin a = new Admin();
        a.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
        keterangan = "Urgent Only";
    }//GEN-LAST:event_rb3ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        keterangan = "Not Available";
    }//GEN-LAST:event_rb2ActionPerformed

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed
        keterangan = "Available";
    }//GEN-LAST:event_rb1ActionPerformed

    private void txidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txidActionPerformed

    private void sbmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbmtActionPerformed
        String keterangan = null;
        SimpleDateFormat formatWaktu = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (rb1.isSelected()){
            keterangan = "Available";
        }
        else if (rb2.isSelected()){
            keterangan = "Not Available";
        }
        else if (rb3.isSelected()){
            keterangan = "Urgent Only";
        }
        try {
            String sql = "INSERT INTO absen_pagi VALUES ('"
            +txid.getText()+"','"
            +txid2.getText()+"','" 
            +chooseid(penghuni)+"','"
            +chooseid1(lantai)+"','"
            +keterangan+"','"
            +(java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")))+"','"
            +(java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))+ "');";
            java.sql.Connection con = (java.sql.Connection) Home.Koneksi.getKoneksi();
            java.sql.PreparedStatement stmnt = con.prepareStatement(sql);
            stmnt.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Disimpan");
            autoid();
            autoid2();
            show_data();

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Disimpan");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_sbmtActionPerformed

    private void lantaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lantaiActionPerformed
        show_combo();
    }//GEN-LAST:event_lantaiActionPerformed

    private void penghuniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penghuniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_penghuniActionPerformed

    private void penghuniItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_penghuniItemStateChanged
        show_data();
        show_combo1();
    }//GEN-LAST:event_penghuniItemStateChanged

    private void cb_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_namaActionPerformed

    private void txid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txid2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txid2ActionPerformed

    private void cb_sesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sesiActionPerformed
        // TODO add your handling code here:
        show_data2();
    }//GEN-LAST:event_cb_sesiActionPerformed

    private void txid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txid1ActionPerformed

    private void sbmt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbmt1ActionPerformed
        String keterangan = null;
        SimpleDateFormat formatWaktu = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (rb4.isSelected()){
            keterangan = "Available";
        }
        else if (rb5.isSelected()){
            keterangan = "Not Available";
        }
        else if (rb6.isSelected()){
            keterangan = "Urgent Only";
        }
        try {
            String sql = "INSERT INTO absen_malam VALUES ('"
            +txid1.getText()+"','"
            +txid3.getText()+"','"
            +chooseid(penghuni3)+"','"
            +chooseid1(lantai3)+"','"
            +keterangan+"','"
            +(java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")))+"','"
            +(java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))) + "');";
            java.sql.Connection con = (java.sql.Connection) Home.Koneksi.getKoneksi();
            java.sql.PreparedStatement stmnt = con.prepareStatement(sql);
            stmnt.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Disimpan");
            autoid1();
            autoid3();
            show_data4();

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Disimpan");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_sbmt1ActionPerformed

    private void rb6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb6ActionPerformed

    private void rb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb5ActionPerformed

    private void rb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb4ActionPerformed

    private void lantai3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lantai3ActionPerformed
        // TODO add your handling code here:
        show_combo4();
    }//GEN-LAST:event_lantai3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        cardLayout.show(jPanel2, "card3");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        resetColorLeft(jPanel7);
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        setColorLeft(jPanel7);
    }//GEN-LAST:event_jButton8MouseEntered

    private void penghuni3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penghuni3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_penghuni3ActionPerformed
    public void setColor(JPanel p) {
        p.setBackground(new Color(254,233,204));
    }
    public void setColorLeft(JPanel p) {
        p.setBackground(new Color(230, 230, 230));
    }
    public void setColorRed(JPanel p) {
        p.setBackground(new Color(254,233,204));
    }
    public void resetColor(JPanel p1) {
        p1.setBackground(new Color(254,233,204));
    }
    public void resetColorLeft(JPanel p1) {
        p1.setBackground(new Color(13,45,32));
    }
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
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Absen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable alfa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card4;
    private javax.swing.JPanel card5;
    private javax.swing.JComboBox<String> cb_nama;
    private javax.swing.JComboBox<String> cb_sesi;
    private com.toedter.calendar.JDateChooser endDate1;
    private javax.swing.JTable hadir;
    private javax.swing.JTable izin;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JComboBox<String> lantai;
    private javax.swing.JComboBox<String> lantai3;
    private javax.swing.JComboBox<String> penghuni;
    private javax.swing.JComboBox<String> penghuni3;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rb4;
    private javax.swing.JRadioButton rb5;
    private javax.swing.JRadioButton rb6;
    private javax.swing.JButton sbmt;
    private javax.swing.JButton sbmt1;
    private com.toedter.calendar.JDateChooser startDate1;
    private javax.swing.JTextField txid;
    private javax.swing.JTextField txid1;
    private javax.swing.JTextField txid2;
    private javax.swing.JTextField txid3;
    // End of variables declaration//GEN-END:variables
private String keterangan;
}
