/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Hieu
 */
public class mainView extends javax.swing.JFrame {

    /**
     * Creates new form mainView
     */
    public mainView() {
        initComponents();
        this.setTitle("Trang Chủ");
        this.setLocationRelativeTo(null);
        displayImage("src/img/paw.png",lbllogo);
        displayImage("src/img/animal.png",lblTrangChu);
    }
    private void displayImage(String imagePath,JLabel label) {
        System.out.println(imagePath);
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        label.setIcon(imageIcon);
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
        jButton6 = new javax.swing.JButton();
        dsdv = new javax.swing.JButton();
        btnWeb = new javax.swing.JButton();
        dmdv = new javax.swing.JButton();
        ls = new javax.swing.JButton();
        lbllogo = new javax.swing.JLabel();
        lblTrangChu = new javax.swing.JLabel();
        bctk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        jButton6.setText("Trang Chủ");

        dsdv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dsdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/list.png"))); // NOI18N
        dsdv.setText("Danh Sách Động Vật");
        dsdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dsdvActionPerformed(evt);
            }
        });

        btnWeb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnWeb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/world-wide-web.png"))); // NOI18N
        btnWeb.setText("Hướng Dẫn Sử Dụng");
        btnWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWebActionPerformed(evt);
            }
        });

        dmdv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dmdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/list.png"))); // NOI18N
        dmdv.setText("Danh mục Động vật");
        dmdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dmdvActionPerformed(evt);
            }
        });

        ls.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/file.png"))); // NOI18N
        ls.setText("Xem lịch sử thú y");
        ls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lsActionPerformed(evt);
            }
        });

        lbllogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllogoMouseClicked(evt);
            }
        });

        bctk.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bctk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bar-chart.png"))); // NOI18N
        bctk.setText("Thống Kê");
        bctk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bctkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnWeb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dsdv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dmdv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bctk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lbllogo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(lblTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbllogo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(btnWeb)
                        .addGap(18, 18, 18)
                        .addComponent(dsdv)
                        .addGap(18, 18, 18)
                        .addComponent(dmdv)
                        .addGap(18, 18, 18)
                        .addComponent(ls)
                        .addGap(18, 18, 18)
                        .addComponent(bctk)
                        .addGap(0, 55, Short.MAX_VALUE)))
                .addContainerGap())
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

    private void dsdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dsdvActionPerformed
        try {
            // TODO add your handling code here:
            new dsdvView(this, true).setVisible(true);
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_dsdvActionPerformed

    private void dmdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dmdvActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            new dmdvView(this, true).setVisible(true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_dmdvActionPerformed

    private void lsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lsActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            new lichsudv(this, true).setVisible(true);
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_lsActionPerformed

    private void btnWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWebActionPerformed
        // TODO add your handling code here:
        try {
            uliti.webService.openWeb();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnWebActionPerformed

    private void lbllogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoMouseClicked
        // TODO add your handling code here:
        try {
            uliti.webService.openWebpage(new URL("https://userdhieu.id.vn/"));// trang web cá nhân nà
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lbllogoMouseClicked

    private void bctkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bctkActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            new tkView(this, true).setVisible(true);
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_bctkActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bctk;
    private javax.swing.JButton btnWeb;
    private javax.swing.JButton dmdv;
    private javax.swing.JButton dsdv;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTrangChu;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JButton ls;
    // End of variables declaration//GEN-END:variables
}
