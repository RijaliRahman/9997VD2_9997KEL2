/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalino.restaurant;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import jalino.restaurant.koneksi;

/**
 *
 * @author Naga
 */
public class admin extends javax.swing.JFrame {

    private Connection con = koneksi.getConnection();
    private Statement stt;
    private ResultSet rss;
    java.util.Date tglsekarang = new java.util.Date();
    private SimpleDateFormat smpdtfmt = new SimpleDateFormat("dd MMMMMMMMM yyyy", Locale.getDefault());
    private String tanggal = smpdtfmt.format(tglsekarang);
    private DefaultTableModel model_admin;
    private DefaultTableModel model_makanan;
    private DefaultTableModel model_minuman;

    /**
     * Creates new form admin
     */
    public admin() {
        initComponents();
        tgl.setText(tanggal);
        setJam();
    }

    private void table_admin() {
        model_admin = new DefaultTableModel();
        model_admin.addColumn("ID");
        model_admin.addColumn("USERNAME");
        model_admin.addColumn("PASSWORD");

        tableadmin.setModel(model_admin);
    }

    private void table_makanan() {
        model_makanan = new DefaultTableModel();
        model_makanan.addColumn("ID");
        model_makanan.addColumn("NAMA MAKANAN");
        model_makanan.addColumn("HARGA MAKANAN");

        tablemakanan.setModel(model_makanan);
    }

    private void table_minuman() {
        model_minuman = new DefaultTableModel();
        model_minuman.addColumn("ID");
        model_minuman.addColumn("NAMA MINUMAN");
        model_minuman.addColumn("HARGA MINUMAN");

        tableminuman.setModel(model_minuman);
    }

    private void tampil_admin() {
        try {
            String sql = "SELECT id,username, password from admin where level='kasir' ";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while (rss.next()) {
                Object[] o = new Object[3];
                o[0] = rss.getString("id");
                o[1] = rss.getString("username");
                o[2] = rss.getString("password");
                model_admin.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void tampil_makanan() {
        try {
            String sql = "SELECT *from makanan";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while (rss.next()) {
                Object[] o = new Object[3];
                o[0] = rss.getString("id_makanan");
                o[1] = rss.getString("nama_makanan");
                o[2] = rss.getString("harga_makanan");
                model_makanan.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void tampil_minuman() {
        try {
            String sql = "SELECT *from minuman";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while (rss.next()) {
                Object[] o = new Object[3];
                o[0] = rss.getString("id_minuman");
                o[1] = rss.getString("nama_minuman");
                o[2] = rss.getString("harga_minuman");
                model_minuman.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public final void setJam() {
        ActionListener taskPerformer = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                String nol_jam = "", nol_menit = "", nol_detik = "";

                java.util.Date dateTime = new java.util.Date();
                int nilai_jam = dateTime.getHours();
                int nilai_menit = dateTime.getMinutes();
                int nilai_detik = dateTime.getSeconds();

                if (nilai_jam <= 9) {
                    nol_jam = "0";
                }
                if (nilai_menit <= 9) {
                    nol_menit = "0";
                }
                if (nilai_detik <= 9) {
                    nol_detik = "0";
                }

                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);

                lblwktu.setText(jam + ":" + menit + ":" + detik + "");
            }
        };
        new Timer(1000, taskPerformer).start();
    }

    public void tambah_kasir(String nama, String password) {
        try {
            String sql = "insert into admin VALUES('" + nama + "','" + password + "','kasir')";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println("ERROR");
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
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        admin = new SetImage("admin.png");
        jScrollPane1 = new javax.swing.JScrollPane();
        tableadmin = new javax.swing.JTable();
        clPanelTransparan1 = new PanelTransparan.ClPanelTransparan();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        user_admin = new javax.swing.JTextField();
        pass_admin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        menu = new SetImage("menu.png");
        makanan = new SetImage("food.png");
        jLabel3 = new javax.swing.JLabel();
        clPanelTransparan2 = new PanelTransparan.ClPanelTransparan();
        txtmakanan = new javax.swing.JTextField();
        txthargamakanan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablemakanan = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        minuman = new SetImage("drink.png");
        jLabel4 = new javax.swing.JLabel();
        clPanelTransparan3 = new PanelTransparan.ClPanelTransparan();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableminuman = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtminuman = new javax.swing.JTextField();
        txthargaminuman = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        tgl = new javax.swing.JLabel();
        lblwktu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("KASIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setText("MENU");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jPanel4.setLayout(new java.awt.CardLayout());

        admin.setBackground(new java.awt.Color(255, 255, 255));

        tableadmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tableadmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableadminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableadmin);

        clPanelTransparan1.setBackground(new java.awt.Color(255, 255, 0));
        clPanelTransparan1.setForeground(new java.awt.Color(255, 204, 51));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel9.setText("NAMA");

        jLabel10.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel10.setText("PASSWORD");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/1494110388_add.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/1494110113_error.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/1494110243_refresh.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        user_admin.setBackground(new Color(0, 0, 0, 0));
        user_admin.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N

        pass_admin.setBackground(new Color(0, 0, 0, 0));
        pass_admin.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        pass_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_adminActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/1494166860_configuration.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout clPanelTransparan1Layout = new javax.swing.GroupLayout(clPanelTransparan1);
        clPanelTransparan1.setLayout(clPanelTransparan1Layout);
        clPanelTransparan1Layout.setHorizontalGroup(
            clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clPanelTransparan1Layout.createSequentialGroup()
                .addGroup(clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clPanelTransparan1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(116, 116, 116)
                        .addComponent(jLabel6))
                    .addGroup(clPanelTransparan1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clPanelTransparan1Layout.createSequentialGroup()
                        .addGroup(clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(user_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pass_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(196, 196, 196))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clPanelTransparan1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(116, 116, 116)
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26))))
        );
        clPanelTransparan1Layout.setVerticalGroup(
            clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user_admin))
                .addGap(170, 170, 170)
                .addGroup(clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pass_admin)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(clPanelTransparan1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );

        javax.swing.GroupLayout adminLayout = new javax.swing.GroupLayout(admin);
        admin.setLayout(adminLayout);
        adminLayout.setHorizontalGroup(
            adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminLayout.createSequentialGroup()
                .addGroup(adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE))
                    .addComponent(clPanelTransparan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        adminLayout.setVerticalGroup(
            adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminLayout.createSequentialGroup()
                .addComponent(clPanelTransparan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel4.add(admin, "card2");

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setLayout(new java.awt.CardLayout());

        makanan.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/1494100977_right.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        txtmakanan.setBackground(new Color(0, 0, 0, 0));
        txtmakanan.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        txtmakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmakananActionPerformed(evt);
            }
        });

        txthargamakanan.setBackground(new Color(0, 0, 0, 0));
        txthargamakanan.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        txthargamakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargamakananActionPerformed(evt);
            }
        });

        tablemakanan.setModel(new javax.swing.table.DefaultTableModel(
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
        tablemakanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablemakananMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablemakanan);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/1494110388_add.png"))); // NOI18N
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/1494110243_refresh.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/1494110113_error.png"))); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/1494166860_configuration.png"))); // NOI18N
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel15.setText("Nama Makanan");

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel16.setText("Harga Makanan");

        javax.swing.GroupLayout clPanelTransparan2Layout = new javax.swing.GroupLayout(clPanelTransparan2);
        clPanelTransparan2.setLayout(clPanelTransparan2Layout);
        clPanelTransparan2Layout.setHorizontalGroup(
            clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clPanelTransparan2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel13)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel14)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clPanelTransparan2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmakanan, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(txthargamakanan))
                        .addGap(124, 124, 124))))
        );
        clPanelTransparan2Layout.setVerticalGroup(
            clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmakanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(44, 44, 44)
                .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txthargamakanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout makananLayout = new javax.swing.GroupLayout(makanan);
        makanan.setLayout(makananLayout);
        makananLayout.setHorizontalGroup(
            makananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, makananLayout.createSequentialGroup()
                .addGap(0, 710, Short.MAX_VALUE)
                .addComponent(jLabel3))
            .addGroup(makananLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clPanelTransparan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        makananLayout.setVerticalGroup(
            makananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, makananLayout.createSequentialGroup()
                .addComponent(clPanelTransparan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menu.add(makanan, "card2");

        minuman.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/1494100970_left.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        tableminuman.setModel(new javax.swing.table.DefaultTableModel(
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
        tableminuman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableminumanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableminuman);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/1494110388_add.png"))); // NOI18N
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/1494110243_refresh.png"))); // NOI18N
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/1494110113_error.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/1494166860_configuration.png"))); // NOI18N
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel21.setText("Nama Minuman");

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel22.setText("Harga Minuman");

        txtminuman.setBackground(new Color(0, 0, 0, 0));
        txtminuman.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N

        txthargaminuman.setBackground(new Color(0, 0, 0, 0));
        txthargaminuman.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        txthargaminuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaminumanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clPanelTransparan3Layout = new javax.swing.GroupLayout(clPanelTransparan3);
        clPanelTransparan3.setLayout(clPanelTransparan3Layout);
        clPanelTransparan3Layout.setHorizontalGroup(
            clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan3Layout.createSequentialGroup()
                .addGroup(clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clPanelTransparan3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(clPanelTransparan3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel20))))
                    .addGroup(clPanelTransparan3Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(44, 44, 44)
                        .addGroup(clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtminuman, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                            .addComponent(txthargaminuman))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        clPanelTransparan3Layout.setVerticalGroup(
            clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clPanelTransparan3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtminuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txthargaminuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout minumanLayout = new javax.swing.GroupLayout(minuman);
        minuman.setLayout(minumanLayout);
        minumanLayout.setHorizontalGroup(
            minumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(minumanLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 710, Short.MAX_VALUE))
            .addGroup(minumanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clPanelTransparan3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        minumanLayout.setVerticalGroup(
            minumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, minumanLayout.createSequentialGroup()
                .addComponent(clPanelTransparan3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menu.add(minuman, "card3");

        jPanel4.add(menu, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tgl.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        tgl.setText("jLabel1");

        lblwktu.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        lblwktu.setText("jLabel2");

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 2, 48)); // NOI18N
        jLabel1.setText("JALINO RESTAURANT");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jalino/restaurant/ono.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tgl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblwktu, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(tgl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblwktu))
            .addComponent(jLabel2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        admin.setVisible(true);
        menu.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        menu.setVisible(true);
        admin.setVisible(false);
        makanan.setVisible(true);
        minuman.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        menu.setVisible(true);
        admin.setVisible(false);
        makanan.setVisible(false);
        minuman.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        menu.setVisible(true);
        admin.setVisible(false);
        makanan.setVisible(true);
        minuman.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        table_admin();
        tampil_admin();
        table_makanan();
        tampil_makanan();
        table_minuman();
        tampil_minuman();
    }//GEN-LAST:event_formComponentShown

    private void pass_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pass_adminActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        String ha = user_admin.getText();
        String za = pass_admin.getText();
        int status = 0;
        try {
            String sql = "insert into admin(username,password,level) VALUES('" + ha + "','" + za + "','kasir')";
            stt = con.createStatement();
            status = stt.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        table_admin();
        tampil_admin();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        int status = 0;
        int baris = tableadmin.getSelectedRow();
        try {
            String sql = "UPDATE admin SET username='" + user_admin.getText() + "',password='" + pass_admin.getText() + "' WHERE ID='" + tableadmin.getValueAt(baris, 0) + "'";
            stt = con.createStatement();
            status = stt.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        table_admin();
        tampil_admin();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void tableadminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableadminMouseClicked
        int baris = tableadmin.getSelectedRow();
        user_admin.setText(tableadmin.getValueAt(baris, 1).toString());
        pass_admin.setText(tableadmin.getValueAt(baris, 2).toString());
    }//GEN-LAST:event_tableadminMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        //wss
        int status = 0;
        int baris = tableadmin.getSelectedRow();
        try {
            String sql = "delete from admin where id ='" + tableadmin.getValueAt(baris, 0) + "'";
            stt = con.createStatement();
            status = stt.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        table_admin();
        tampil_admin();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        user_admin.setText("");
        pass_admin.setText("");
    }//GEN-LAST:event_jLabel8MouseClicked

    private void txtmakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmakananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmakananActionPerformed

    private void txthargamakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargamakananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargamakananActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        String ha = txtmakanan.getText();
        String za = txthargamakanan.getText();
        int status = 0;
        try {
            String sql = "insert into makanan(nama_makanan, harga_makanan) VALUES('" + ha + "','" + za + "')";
            stt = con.createStatement();
            status = stt.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        table_makanan();
        tampil_makanan();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void tablemakananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablemakananMouseClicked
        // TODO add your handling code here:
        int barismakanan = tablemakanan.getSelectedRow();
        txtmakanan.setText(tablemakanan.getValueAt(barismakanan, 1).toString());
        txthargamakanan.setText(tablemakanan.getValueAt(barismakanan, 2).toString());
    }//GEN-LAST:event_tablemakananMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        int status = 0;
        int barismakanan = tablemakanan.getSelectedRow();
        try {
            String sql = "UPDATE makanan SET nama_makanan='" + txtmakanan.getText() + "',harga_makanan='" + txthargamakanan.getText() + "' WHERE id_makanan='" + tablemakanan.getValueAt(barismakanan, 0) + "'";
            stt = con.createStatement();
            status = stt.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        table_makanan();
        tampil_makanan();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        int status = 0;
        int barismakanan = tablemakanan.getSelectedRow();
        try {
            String sql = "delete from makanan where id_makanan ='" + tablemakanan.getValueAt(barismakanan, 0) + "'";
            stt = con.createStatement();
            status = stt.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        table_makanan();
        tampil_makanan();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        txtmakanan.setText("");
        txthargamakanan.setText("");
    }//GEN-LAST:event_jLabel14MouseClicked

    private void txthargaminumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaminumanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaminumanActionPerformed

    private void tableminumanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableminumanMouseClicked
        // TODO add your handling code here:
        int barisminuman = tableminuman.getSelectedRow();
        txtminuman.setText(tableminuman.getValueAt(barisminuman, 1).toString());
        txthargaminuman.setText(tableminuman.getValueAt(barisminuman, 2).toString());
    }//GEN-LAST:event_tableminumanMouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        String ha = txtminuman.getText();
        String za = txthargaminuman.getText();
        int status = 0;
        try {
            String sql = "insert into minuman(nama_minuman, harga_minuman) VALUES('" + ha + "','" + za + "')";
            stt = con.createStatement();
            status = stt.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        table_minuman();
        tampil_minuman();
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
        int status = 0;
        int barisminuman = tableminuman.getSelectedRow();
        try {
            String sql = "delete from minuman where id_minuman ='" + tableminuman.getValueAt(barisminuman, 0) + "'";
            stt = con.createStatement();
            status = stt.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        table_minuman();
        tampil_minuman();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        int status = 0;
        int barisminuman = tableminuman.getSelectedRow();
        try {
            String sql = "UPDATE minuman SET nama_minuman='" + txtminuman.getText() + "',harga_minuman='" + txthargaminuman.getText() + "' WHERE id_minuman='" + tableminuman.getValueAt(barisminuman, 0) + "'";
            stt = con.createStatement();
            status = stt.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        table_minuman();
        tampil_minuman();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
        txtminuman.setText("");
        txthargaminuman.setText("");
    }//GEN-LAST:event_jLabel20MouseClicked

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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel admin;
    private PanelTransparan.ClPanelTransparan clPanelTransparan1;
    private PanelTransparan.ClPanelTransparan clPanelTransparan2;
    private PanelTransparan.ClPanelTransparan clPanelTransparan3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblwktu;
    private javax.swing.JPanel makanan;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel minuman;
    private javax.swing.JTextField pass_admin;
    private javax.swing.JTable tableadmin;
    private javax.swing.JTable tablemakanan;
    private javax.swing.JTable tableminuman;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField txthargamakanan;
    private javax.swing.JTextField txthargaminuman;
    private javax.swing.JTextField txtmakanan;
    private javax.swing.JTextField txtminuman;
    private javax.swing.JTextField user_admin;
    // End of variables declaration//GEN-END:variables
public class SetImage extends JPanel {

        private Image image = null;

        public SetImage(String file) {
            try {
                image = new ImageIcon(getClass().getResource(file)).getImage();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Load Image Gagal");
            }
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            super.paintComponent(grphcs);
            Graphics2D graphic = (Graphics2D) grphcs.create();
            graphic.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            graphic.dispose();
        }
    }

    public class TextFieldTransparan extends JTextField {

        private Color color;

        public TextFieldTransparan() {
            setOpaque(false);
            color = new Color(0, 0, 0, 100);
        }
    }

}
