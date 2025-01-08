/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package id.ac.unpas.ewaste.lacak;

import id.ac.unpas.ewaste.lacak.*;
import id.ac.unpas.ewaste.dao.LacakDao;
import id.ac.unpas.ewaste.lacak.LacakModelTable;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ghifarullah19
 */
public class LacakCRUD
        extends javax.swing.JFrame {

    private List<Lacak> lacakList;
    private Lacak lacakUbah;
    private LacakDao lacakDao;
    private LacakModelTable lacakModelTable;

    /**
     * Creates new form LacakCRUD
     */
    public LacakCRUD(LacakDao lacakDao) {
        this.lacakDao = lacakDao;
        this.lacakList = this.lacakDao.findAll();
        this.lacakModelTable = new LacakModelTable(lacakList);

        initComponents();

        buttonGroup1.add(radioTrue);
        buttonGroup1.add(radioFalse);

        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        frameCRUDPermintaan = new javax.swing.JPanel();
        panelCRUDPermintaan = new javax.swing.JPanel();
        labelNamaPelanggan = new javax.swing.JLabel();
        textfieldNamaPelanggan = new javax.swing.JTextField();
        labelAlamatPelanggan = new javax.swing.JLabel();
        textfieldAlamatPelanggan = new javax.swing.JTextField();
        labelStatus = new javax.swing.JLabel();
        radioTrue = new javax.swing.JRadioButton();
        radioFalse = new javax.swing.JRadioButton();
        titleCRUDPermintaan = new javax.swing.JLabel();
        buttonUbah = new javax.swing.JButton();
        buttonKirim = new javax.swing.JButton();
        buttonSimpanUbah = new javax.swing.JButton();
        labelNamaKurir = new javax.swing.JLabel();
        textfieldNamaKurir = new javax.swing.JTextField();
        labelAlamatTujuan = new javax.swing.JLabel();
        textfieldAlamatTujuan = new javax.swing.JTextField();
        scrollableTable = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLacak = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        frameCRUDPermintaan.setBackground(new java.awt.Color(102, 153, 255));

        panelCRUDPermintaan.setBackground(new java.awt.Color(255, 255, 255));

        labelNamaPelanggan.setText("Nama Pelanggan");

        labelAlamatPelanggan.setText("Almat Penjemputan");

        labelStatus.setText("Status");

        radioTrue.setText("Sudah Diantar");

        radioFalse.setText("Sedang Diantar");

        titleCRUDPermintaan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleCRUDPermintaan.setText("Form Permintaan");

        buttonUbah.setText("Ubah");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });

        buttonKirim.setText("Kirim");
        buttonKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKirimActionPerformed(evt);
            }
        });

        buttonSimpanUbah.setText("Simpan Ubah");
        buttonSimpanUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanUbahActionPerformed(evt);
            }
        });

        labelNamaKurir.setText("Nama Kurir");

        labelAlamatTujuan.setText("Alamat Tujuan");

        javax.swing.GroupLayout panelCRUDPermintaanLayout = new javax.swing.GroupLayout(panelCRUDPermintaan);
        panelCRUDPermintaan.setLayout(panelCRUDPermintaanLayout);
        panelCRUDPermintaanLayout.setHorizontalGroup(
            panelCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCRUDPermintaanLayout.createSequentialGroup()
                .addGroup(panelCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCRUDPermintaanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelStatus)
                            .addGroup(panelCRUDPermintaanLayout.createSequentialGroup()
                                .addGroup(panelCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelNamaPelanggan)
                                    .addComponent(labelAlamatPelanggan)
                                    .addComponent(textfieldAlamatPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                    .addComponent(textfieldNamaPelanggan))
                                .addGap(42, 42, 42)
                                .addGroup(panelCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelNamaKurir)
                                    .addComponent(labelAlamatTujuan)
                                    .addComponent(textfieldNamaKurir, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(textfieldAlamatTujuan)))
                            .addGroup(panelCRUDPermintaanLayout.createSequentialGroup()
                                .addComponent(radioTrue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioFalse))))
                    .addGroup(panelCRUDPermintaanLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(titleCRUDPermintaan))
                    .addGroup(panelCRUDPermintaanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSimpanUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonKirim)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCRUDPermintaanLayout.setVerticalGroup(
            panelCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCRUDPermintaanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleCRUDPermintaan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNamaPelanggan)
                    .addComponent(labelNamaKurir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textfieldNamaKurir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAlamatPelanggan)
                    .addComponent(labelAlamatTujuan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldAlamatPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textfieldAlamatTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioTrue)
                    .addComponent(radioFalse))
                .addGap(18, 18, 18)
                .addGroup(panelCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUbah)
                    .addComponent(buttonKirim)
                    .addComponent(buttonSimpanUbah))
                .addGap(46, 46, 46))
        );

        tableLacak.setModel(lacakModelTable);
        jScrollPane1.setViewportView(tableLacak);

        scrollableTable.setViewportView(jScrollPane1);

        javax.swing.GroupLayout frameCRUDPermintaanLayout = new javax.swing.GroupLayout(frameCRUDPermintaan);
        frameCRUDPermintaan.setLayout(frameCRUDPermintaanLayout);
        frameCRUDPermintaanLayout.setHorizontalGroup(
            frameCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameCRUDPermintaanLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(frameCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCRUDPermintaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollableTable, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        frameCRUDPermintaanLayout.setVerticalGroup(
            frameCRUDPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameCRUDPermintaanLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(panelCRUDPermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollableTable, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frameCRUDPermintaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frameCRUDPermintaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonKirimActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonKirimActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        lacakDao = new LacakDao();
        lacakList = lacakDao.findAll();
        for (int i = 0; i < lacakList.size(); i++) {
            lacakDao.insert(lacakList.get(i));
            Lacak lacak = new Lacak();
            lacak.setNamaPelanggan(lacakList.get(i).getNamaPelanggan());
            lacak.setAlamatPenjemputan(lacakList.get(i).getAlamatPenjemputan());
            lacak.setNamaKurir(lacakList.get(i).getNamaKurir());
            lacak.setAlamatTujuan(lacakList.get(i).getAlamatTujuan());
            lacak.setStatus(true);

            int confirmation = JOptionPane.showConfirmDialog(LacakCRUD.this,"Apakah yakin ingin menyimpan data?", 
                       "Peringatan!", JOptionPane.YES_NO_OPTION);
        
            if (confirmation == JOptionPane.YES_OPTION) { //Jika Confirmation Option bernilai "Yes"
                this.addData(lacak);
              } else { //Jika tidak,
                JOptionPane.showMessageDialog(LacakCRUD.this, "Data tidak disimpan"); 
              }
        }
    }// GEN-LAST:event_buttonKirimActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonUbahActionPerformed
        // TODO add your handling code here:
        int row = tableLacak.getSelectedRow();
        int column = tableLacak.getSelectedColumn();

        if (row == -1 || column == -1) {
            return;
        }

        String dataUbah = (String) tableLacak.getModel().getValueAt(row, column);

        int id = -1;
        String col = "";

        switch (column) {
            case 0:
                col = "namaPelanggan";
                break;
            case 1:
                col = "namaKurir";
                break;
            case 2:
                col = "alamatPenjemputan";
                break;
            case 3:
                col = "alamatTujuan";
                break;
            case 4:
                col = "status";
                break;
            default:
                System.out.println("Kolom tidak ditemukan");
                break;
        }
        id = this.lacakDao.select(col, dataUbah).getId();

        this.textfieldNamaPelanggan.setText(this.lacakDao.select(col, dataUbah).getNamaPelanggan());
        this.textfieldNamaKurir.setText(this.lacakDao.select(col, dataUbah).getNamaKurir());
        this.textfieldAlamatPelanggan.setText(this.lacakDao.select(col, dataUbah).getAlamatPenjemputan());
        this.textfieldAlamatTujuan.setText(this.lacakDao.select(col, dataUbah).getAlamatTujuan());

        if (this.lacakDao.select(col, dataUbah).getStatus() == true) {
            this.radioTrue.setSelected(true);
        } else {
            this.radioFalse.setSelected(true);
        }

        lacakUbah = new Lacak();
        lacakUbah.setId(id);
    }// GEN-LAST:event_buttonUbahActionPerformed

    private void buttonSimpanUbahActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonSimpanUbahActionPerformed
        // TODO add your handling code here:
        boolean status = false;

        if (radioTrue.isSelected()) {
            status = true;
        }

        if (radioFalse.isSelected()) {
            status = false;
        }

        String namaPelanggan = this.textfieldNamaPelanggan.getText();
        String namaKurir = this.textfieldNamaKurir.getText();
        String alamatPenjemputan = this.textfieldAlamatPelanggan.getText();
        String alamatTujuan = this.textfieldAlamatTujuan.getText();

        Lacak lacak = new Lacak();
        lacak.setId(lacakUbah.getId());
        lacak.setNamaPelanggan(namaPelanggan);
        lacak.setNamaKurir(namaKurir);
        lacak.setAlamatPenjemputan(alamatPenjemputan);
        lacak.setAlamatTujuan(alamatTujuan);
        lacak.setStatus(status);

        
        
        int confirmation = JOptionPane.showConfirmDialog(LacakCRUD.this,"Apakah yakin ingin mengubah data?", 
                       "Peringatan!", JOptionPane.YES_NO_OPTION);
        
        if (confirmation == JOptionPane.YES_OPTION) { //Jika Confirmation Option bernilai "Yes"
            this.lacakDao.update(lacak);
            this.update(lacak);
        } else { //Jika tidak,
            JOptionPane.showMessageDialog(LacakCRUD.this, "Data tidak diubah"); 
        }
    }// GEN-LAST:event_buttonSimpanUbahActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonHapusActionPerformed
        // TODO add your handling code here:
        int row = this.tableLacak.getSelectedRow();
        int column = this.tableLacak.getSelectedColumn();

        if (row == -1 || column == -1) {
            return;
        } else {
            String newValue = (String) this.tableLacak.getModel().getValueAt(row, column);

            Lacak id = new Lacak();

            String col = "";

            switch (column) {
                case 0:
                    col = "namaPelanggan";
                    break;
                case 1:
                    col = "namaKurir";
                    break;
                case 2:
                    col = "alamatPenjemputan";
                    break;
                case 3:
                    col = "alamatTujuan";
                    break;
                case 4:
                    col = "status";
                    break;
                default:
                    System.out.println("Kolom tidak ditemukan");
                    break;
            }
            id = this.lacakDao.select(col, newValue);

            int confirmation = JOptionPane.showConfirmDialog(LacakCRUD.this,"Apakah yakin ingin menghapus data?", 
                       "Peringatan!", JOptionPane.YES_NO_OPTION);
        
            if (confirmation == JOptionPane.YES_OPTION) { //Jika Confirmation Option bernilai "Yes"
                this.delete(id);
                // this.lacakDao.delete(id);
                JOptionPane.showMessageDialog(LacakCRUD.this, "Data sudah dihapus", "Peringatan!", JOptionPane.WARNING_MESSAGE);
              } else { //Jika tidak,
                JOptionPane.showMessageDialog(LacakCRUD.this, "Data tidak dihapus"); 
              }
        }
    }// GEN-LAST:event_buttonHapusActionPerformed

    // Method untuk menambahkan lacak ke tableModel
    public void addData(Lacak lacak) {
        lacakModelTable.add(lacak);
        textfieldNamaPelanggan.setText("");
        textfieldNamaKurir.setText("");
        textfieldAlamatPelanggan.setText("");
        textfieldAlamatTujuan.setText("");
        radioFalse.setSelected(true);
    }

    // Method untuk mengubah lacak ke tableModel
    public void update(Lacak lacak) {
        lacakModelTable.update(lacak);
        textfieldNamaPelanggan.setText("");
        textfieldNamaKurir.setText("");
        textfieldAlamatPelanggan.setText("");
        textfieldAlamatTujuan.setText("");
    }

    // Method untuk menghapus lacak ke tableModel
    public void delete(Lacak lacak) {
        // Tambahkan lacak ke tableModel
        lacakModelTable.delete(lacak);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JButton buttonKirim;
    private javax.swing.JButton buttonSimpanUbah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JPanel frameCRUDPermintaan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAlamatPelanggan;
    private javax.swing.JLabel labelAlamatTujuan;
    private javax.swing.JLabel labelNamaKurir;
    private javax.swing.JLabel labelNamaPelanggan;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JPanel panelCRUDPermintaan;
    private javax.swing.JRadioButton radioFalse;
    private javax.swing.JRadioButton radioTrue;
    private javax.swing.JScrollPane scrollableTable;
    private javax.swing.JTable tableLacak;
    private javax.swing.JTextField textfieldAlamatPelanggan;
    private javax.swing.JTextField textfieldAlamatTujuan;
    private javax.swing.JTextField textfieldNamaKurir;
    private javax.swing.JTextField textfieldNamaPelanggan;
    private javax.swing.JLabel titleCRUDPermintaan;
    // End of variables declaration//GEN-END:variables
}
