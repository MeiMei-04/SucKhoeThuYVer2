/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views;

import dao.danhmucdongvatDao;
import dao.danhsachdongvatDao;
import entity.danhmucdongvat;
import entity.danhsachdongvat;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hieu
 */
public class dsdvView extends javax.swing.JDialog {

    danhsachdongvatDao dsDao;
    danhmucdongvatDao dmDao;
    private List<danhsachdongvat> Listdsdv = new ArrayList<>();
    private List<danhmucdongvat> Listdmdv = new ArrayList<>();
    String pathimg = "src/img/";
    String nameimg = null;

    /**
     * Creates new form dsdvView
     */
    public dsdvView(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Danh Sách Động Vật");
        dsDao = new danhsachdongvatDao();
        dmDao = new danhmucdongvatDao();
        fillTableDsdv();
        fillcbbDanhMuc();
    }

    private void fillcbbDanhMuc() {
        Listdmdv = dmDao.getAllData();
        cbDanhMuc.removeAllItems();
        for (danhmucdongvat object : Listdmdv) {
            cbDanhMuc.addItem(object.getTendm());
        }
        cbDanhMuc.setSelectedIndex(0);
    }

    private int getIdDanhMuc() {
        int id = -1;
        int index = cbDanhMuc.getSelectedIndex();
        Listdmdv = dmDao.getAllData();
        return Listdmdv.get(index).getId();
    }

    private void setForm(int row) {
        if (row > -1) {
            txtID.setText(tbldsdv.getValueAt(row, 0).toString());
            txtTenDv.setText(tbldsdv.getValueAt(row, 2).toString());
            txtCanNang.setText(tbldsdv.getValueAt(row, 3).toString());
            cbDanhMuc.setSelectedItem(tbldsdv.getValueAt(row, 1).toString());
            displayImage(pathimg + tbldsdv.getValueAt(row, 4).toString());
            nameimg = tbldsdv.getValueAt(row, 4).toString();
        }
    }

    private danhsachdongvat getForm() {
        String idstr = txtID.getText();
        int id = -1;//thêm không cần id lên để -1
        if (!idstr.equals("")) {
            id = Integer.parseInt(idstr);
        }
        int iddm = getIdDanhMuc();
        String tendv = txtTenDv.getText();
        if (tendv.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên Động Vật Không Được Để Trống", "Thông Báo", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        String cannangstr = txtCanNang.getText();
        if (cannangstr.equals("")) {
            JOptionPane.showMessageDialog(this, "Cân Nặng Động Vật Không Được Để Trống", "Thông Báo", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        float cannnag = Float.parseFloat(txtCanNang.getText());
        if (nameimg == null) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Ảnh", "Thông Báo", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        danhsachdongvat dsdv = new danhsachdongvat(id, iddm, tendv, cannnag, nameimg);
        return dsdv;
    }

    private void fillTableDsdv() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tbldsdv.getModel();
        defaultTableModel.setRowCount(0);
        Listdsdv = dsDao.getAllData();
        if (Listdsdv.isEmpty()) {
            System.out.println("Danh Sách Trống");
            return;
        }
        for (danhsachdongvat object : Listdsdv) {
            Object[] row = {
                object.getId(),
                object.getTendm(),
                object.getTendv(),
                object.getCannang(),
                object.getAnh()
            };
            defaultTableModel.addRow(row);
        }
    }

    // hàm lấy đường dẫn của ảnh
    private String chooseImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            displayImage(selectedFile.getAbsolutePath());
            saveImage(selectedFile.getAbsolutePath(), pathimg);
            return selectedFile.getName();
        }
        return null;
    }

    // hàm set ảnh theo kích thước của label
    private void displayImage(String imagePath) {
        System.out.println(imagePath);
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lblAnh.setIcon(imageIcon);
    }

    //hàm lưu ảnh
    public void saveImage(String sourceImage, String targetFolder) {
        // Tạo đường dẫn đến thư mục đích
        Path targetFolderPath = Paths.get(targetFolder);

        // Chuyển đổi đường dẫn ảnh từ String sang File
        File imageFile = new File(sourceImage);

        // Tạo đường dẫn tới tệp ảnh trong thư mục đích
        Path targetImagePath = targetFolderPath.resolve(imageFile.getName());

        try {
            // Kiểm tra xem thư mục đích có tồn tại không, nếu không thì tạo mới
            if (!Files.exists(targetFolderPath)) {
                Files.createDirectories(targetFolderPath);
            }

            // Copy tệp ảnh từ nguồn đến thư mục đích
            Files.copy(imageFile.toPath(), targetImagePath);
            System.out.println("Đã lưu tệp ảnh vào: " + targetImagePath);
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu tệp ảnh: " + e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbldsdv = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbDanhMuc = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtTenDv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCanNang = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        btnChonAnh = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnTimKiem4 = new javax.swing.JButton();
        btnqrcode = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbldsdv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbldsdv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên Danh Mục", "Tên Động Vật", "Cân Nặng", "Ảnh"
            }
        ));
        tbldsdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldsdvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldsdv);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ID:");

        txtID.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Danh Mục:");

        cbDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tên Động Vật:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Cân Nặng:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ảnh"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
        );

        btnChonAnh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnChonAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/picture.png"))); // NOI18N
        btnChonAnh.setText("Chọn Ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnTimKiem4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnTimKiem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnTimKiem4.setText("Tìm Kiếm");
        btnTimKiem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem4ActionPerformed(evt);
            }
        });

        btnqrcode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnqrcode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/qrcode.png"))); // NOI18N
        btnqrcode.setText("QR Quét");
        btnqrcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnqrcodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDanhMuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenDv)
                            .addComponent(txtCanNang)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChonAnh)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua))
                            .addComponent(btnTimKiem4))
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMoi))
                    .addComponent(btnqrcode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenDv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCanNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChonAnh)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)
                            .addComponent(btnMoi))
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnqrcode)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        // TODO add your handling code here:
        String pathimg = chooseImage();
        if (pathimg != null) {
            nameimg = pathimg;
            System.out.println(pathimg);
        }
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        lblAnh.setIcon(null);
        txtID.setText("");
        txtCanNang.setText("");
        txtTenDv.setText("");
        cbDanhMuc.setSelectedIndex(0);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void tbldsdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldsdvMouseClicked
        // TODO add your handling code here:
        int row = tbldsdv.getSelectedRow();
        setForm(row);
    }//GEN-LAST:event_tbldsdvMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        danhsachdongvat dsdv = getForm();
        if (dsdv == null) {
            return;
        }
        dsDao.create(dsdv);
        fillTableDsdv();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        danhsachdongvat dsdv = getForm();
        if (dsdv == null) {
            return;
        }
        dsDao.update(dsdv);
        fillTableDsdv();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        danhsachdongvat dsdv = getForm();
        if (dsdv == null) {
            return;
        }
        dsDao.delete(dsdv);
        fillTableDsdv();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem4ActionPerformed
        // TODO add your handling code here:
        String tenDv = txtTenDv.getText();
        String tenDm = cbDanhMuc.getSelectedItem().toString();
        if (!txtTenDv.equals("")) {
            DefaultTableModel defaultTableModel = (DefaultTableModel) tbldsdv.getModel();
            defaultTableModel.setRowCount(0);
            Listdsdv = dsDao.getAllDataByTenDv(tenDv, tenDm);
            if (Listdsdv.isEmpty()) {
                System.out.println("Danh Sách Trống");
                return;
            }
            for (danhsachdongvat object : Listdsdv) {
                Object[] row = {
                    object.getId(),
                    object.getTendm(),
                    object.getTendv(),
                    object.getCannang(),
                    object.getAnh()
                };
                defaultTableModel.addRow(row);
            }
        }
    }//GEN-LAST:event_btnTimKiem4ActionPerformed

    private void btnqrcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnqrcodeActionPerformed
        // TODO add your handling code here:
        String str = null;
        readQr qr = new readQr(null, true);
        qr.setVisible(true);
        if (!qr.isVisible()) {
            str = qr.getStr();
        }
        if (str != null) {
            DefaultTableModel defaultTableModel = (DefaultTableModel) tbldsdv.getModel();
            defaultTableModel.setRowCount(0);
            try {
                Listdsdv = dsDao.getAllDataByIDDv(Integer.parseInt(str));
                if (Listdsdv.isEmpty()) {
                    uliti.Dialog.fail("Tìm");
                    System.out.println("Danh Sách Trống");
                    return;
                }
                for (danhsachdongvat object : Listdsdv) {
                    Object[] row = {
                        object.getId(),
                        object.getTendm(),
                        object.getTendv(),
                        object.getCannang(),
                        object.getAnh()
                    };
                    defaultTableModel.addRow(row);
                }
                setForm(0);
            } catch (Exception e) {
//                e.printStackTrace();
                uliti.Dialog.fail("Tìm");
            }

        } else {
            uliti.Dialog.fail("Tìm");
        }
    }//GEN-LAST:event_btnqrcodeActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(dsdvView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(dsdvView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(dsdvView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(dsdvView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                dsdvView dialog = null;
//                try {
//                    dialog = new dsdvView(new javax.swing.JFrame(), true);
//                } catch (Exception ex) {
//                    Logger.getLogger(dsdvView.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem4;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnqrcode;
    private javax.swing.JComboBox<String> cbDanhMuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JTable tbldsdv;
    private javax.swing.JTextField txtCanNang;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTenDv;
    // End of variables declaration//GEN-END:variables
}
