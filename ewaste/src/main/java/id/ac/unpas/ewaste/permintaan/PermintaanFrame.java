/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package id.ac.unpas.ewaste.permintaan;

import id.ac.unpas.ewaste.permintaan.*;
import java.util.List;
import id.ac.unpas.ewaste.dao.PermintaanDao;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author ghifarullah19
 */
public class PermintaanFrame
        extends javax.swing.JFrame {
    
    // jenisMemberList adalah variabel yang digunakan untuk menyimpan data jenis member
    private List<Permintaan> permintaanList;
    
    // jenisMemberDao adalah variabel yang digunakan untuk menyimpan data jenis member yang didapat dari database
    private PermintaanDao permintaanDao;

    /**
     * Creates new form PermintaanFrame2
     */
    public PermintaanFrame(PermintaanDao permintaanDao) {
        // this.jenisMemberDao diberikan nilai dari parameter jenisMemberDao
        this.permintaanDao = permintaanDao;
        // this.jenisMemberList diberikan nilai dari data jenis member yang didapat dari database
        this.permintaanList = this.permintaanDao.findAll();
        
        initComponents();
        
//        showPermintaanPane.setLayout(new BoxLayout(showPermintaanPane, BoxLayout.PAGE_AXIS));
        showPermintaanPane.setLayout(new GridLayout(permintaanList.size(), 1, 0, 10));
        
        for (int i = 0; i < permintaanList.size(); i++) {
            JPanel panel = new JPanel();
            PermintaanCard permintaan = new PermintaanCard();
            permintaan.setPanelData(permintaanList.get(i));
            panel.setBackground(new Color(0,0,0,0));
            panel.add(permintaan.getFrame());
            showPermintaanPane.add(panel);
        }
        showPermintaanScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPermintaan = new javax.swing.JPanel();
        panelTitlePermintaan = new javax.swing.JPanel();
        labelTitlePermintaan = new javax.swing.JLabel();
        showPermintaanScrollPane = new javax.swing.JScrollPane();
        showPermintaanPane = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelPermintaan.setBackground(new java.awt.Color(155, 190, 200));

        panelTitlePermintaan.setBackground(new java.awt.Color(22, 72, 99));

        labelTitlePermintaan.setFont(new java.awt.Font("Kaushan Script", 0, 12)); // NOI18N
        labelTitlePermintaan.setForeground(new java.awt.Color(255, 255, 255));
        labelTitlePermintaan.setText("Permintaan Penjemputan");

        javax.swing.GroupLayout panelTitlePermintaanLayout = new javax.swing.GroupLayout(panelTitlePermintaan);
        panelTitlePermintaan.setLayout(panelTitlePermintaanLayout);
        panelTitlePermintaanLayout.setHorizontalGroup(
            panelTitlePermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitlePermintaanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitlePermintaan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTitlePermintaanLayout.setVerticalGroup(
            panelTitlePermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitlePermintaanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitlePermintaan)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        showPermintaanPane.setBackground(new java.awt.Color(155, 190, 200));

        javax.swing.GroupLayout showPermintaanPaneLayout = new javax.swing.GroupLayout(showPermintaanPane);
        showPermintaanPane.setLayout(showPermintaanPaneLayout);
        showPermintaanPaneLayout.setHorizontalGroup(
            showPermintaanPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        showPermintaanPaneLayout.setVerticalGroup(
            showPermintaanPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        showPermintaanScrollPane.setViewportView(showPermintaanPane);

        javax.swing.GroupLayout panelPermintaanLayout = new javax.swing.GroupLayout(panelPermintaan);
        panelPermintaan.setLayout(panelPermintaanLayout);
        panelPermintaanLayout.setHorizontalGroup(
            panelPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitlePermintaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(showPermintaanScrollPane)
        );
        panelPermintaanLayout.setVerticalGroup(
            panelPermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPermintaanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panelTitlePermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(showPermintaanScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPermintaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPermintaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelTitlePermintaan;
    private javax.swing.JPanel panelPermintaan;
    private javax.swing.JPanel panelTitlePermintaan;
    private javax.swing.JPanel showPermintaanPane;
    private javax.swing.JScrollPane showPermintaanScrollPane;
    // End of variables declaration//GEN-END:variables
}
