/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package id.ac.unpas.ewaste.riwayat;

import id.ac.unpas.ewaste.dao.PermintaanDao;
import id.ac.unpas.ewaste.dao.RiwayatDao;
import id.ac.unpas.ewaste.permintaan.Permintaan;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ghifarullah19
 */
public class RiwayatCard
        extends javax.swing.JFrame {

    /**
     * Creates new form PermintaanFrame
     */
    public RiwayatCard() {
        initComponents();
        
    }
    
    public JPanel getFrame() {
        return this.riwayatPanel;
    }
    
    public void setPanelData(Riwayat riwayat) {
        namaPelanggan.setText(riwayat.getNamaPelanggan());
        alamatRiwayat.setText(riwayat.getAlamatPenjemputan());
        
        iconBox.setText("");
        iconBox.setIcon(imageIcon("C:\\Users\\ghifarullah19\\Documents\\NetBeansProjects\\tech-in\\src\\main\\java\\id\\ac\\unpas\\techIn\\img\\box.png",
                65,
                65));
        
        PermintaanDao permintaanDao = new PermintaanDao();
        Permintaan permintaan = permintaanDao.select("namaPelanggan", namaPelanggan.getText());
        
        if (permintaan.getStatus()) {
            status.setText("Sampah sudah dijemput");
        } else {
            status.setText("Sampah sedang dijemput");
        }
    }
    
    public ImageIcon imageIcon(String imageURL, int height, int width) {
        ImageIcon icon = new ImageIcon(imageURL);
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width,
                        height,
                        Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new java.awt.Canvas();
        jPanel2 = new javax.swing.JPanel();
        jOptionPane1 = new javax.swing.JOptionPane();
        riwayatPanel = new javax.swing.JPanel();
        buttonDetail = new javax.swing.JButton();
        namaPelanggan = new javax.swing.JLabel();
        alamatRiwayat = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        iconBox = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        riwayatPanel.setBackground(new java.awt.Color(255, 255, 255));
        riwayatPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        riwayatPanel.setForeground(new java.awt.Color(0, 102, 204));
        riwayatPanel.setMaximumSize(new java.awt.Dimension(556, 131));

        buttonDetail.setBackground(new java.awt.Color(204, 204, 204));
        buttonDetail.setForeground(new java.awt.Color(0, 0, 0));
        buttonDetail.setText("Detail");
        buttonDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetailActionPerformed(evt);
            }
        });

        namaPelanggan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        namaPelanggan.setForeground(new java.awt.Color(0, 102, 204));
        namaPelanggan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namaPelanggan.setText("namaPelanggan");

        alamatRiwayat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        alamatRiwayat.setForeground(new java.awt.Color(0, 102, 204));
        alamatRiwayat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alamatRiwayat.setText("alamatPenjemputan");

        iconBox.setText("iconBox");

        status.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        status.setForeground(new java.awt.Color(0, 102, 204));
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText("Sampah Sudah Dijemput");

        javax.swing.GroupLayout riwayatPanelLayout = new javax.swing.GroupLayout(riwayatPanel);
        riwayatPanel.setLayout(riwayatPanelLayout);
        riwayatPanelLayout.setHorizontalGroup(
            riwayatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, riwayatPanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(riwayatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, riwayatPanelLayout.createSequentialGroup()
                        .addComponent(iconBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(riwayatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(alamatRiwayat, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                            .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(buttonDetail)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, riwayatPanelLayout.createSequentialGroup()
                        .addComponent(namaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(281, 281, 281))))
        );
        riwayatPanelLayout.setVerticalGroup(
            riwayatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(riwayatPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(namaPelanggan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(riwayatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(riwayatPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(buttonDetail))
                    .addGroup(riwayatPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(riwayatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(iconBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(riwayatPanelLayout.createSequentialGroup()
                                .addComponent(alamatRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(riwayatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(riwayatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetailActionPerformed
        // TODO add your handling code here:
        Riwayat riwayat = new Riwayat();
        RiwayatDao riwayatDao = new RiwayatDao();
        riwayat = riwayatDao.select("namaPelanggan", namaPelanggan.getText());
        RiwayatDetailFrame riwayatDetailFrame = new RiwayatDetailFrame(riwayat);
        riwayatDetailFrame.setVisible(true);
    }//GEN-LAST:event_buttonDetailActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamatRiwayat;
    private javax.swing.JButton buttonDetail;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel iconBox;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel namaPelanggan;
    private javax.swing.JPanel riwayatPanel;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}