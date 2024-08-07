/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import dao.danhsachdongvatDao;
import dao.lichsutiemphongDao;
import entity.danhsachdongvat;
import entity.lichsutiemphong;
import java.awt.Image;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uliti.DateUliti;

/**
 *
 * @author Hieu
 */
public class pnllstiemphong extends javax.swing.JPanel {

    danhsachdongvatDao dsdao;
    lichsutiemphongDao lstdao;
    private List<danhsachdongvat> Listdsdv = new ArrayList<>();
    /**
     * Creates new form pnllstiemphong
     */
    String tendm = null;
    int idDv = -1;
    private List<lichsutiemphong> listls = new ArrayList<>();

    public pnllstiemphong(String tendm, int iddv) throws Exception {
        initComponents();
        this.tendm = tendm;
        this.idDv = iddv;
        dsdao = new danhsachdongvatDao();
        lstdao = new lichsutiemphongDao();
        fillTable();
        cbbTenDv();
    }

    private void cbbTenDv() {
        cbbTenDv.removeAllItems();
        if(tendm == null){
            tendm = dsdao.getDmById(idDv);
        }
        Listdsdv = dsdao.getAllDataByTenDm(tendm);
        for (danhsachdongvat object : Listdsdv) {
            cbbTenDv.addItem(object.getTendv());
        }
        cbbTenDv.setSelectedIndex(0);
    }

    private int getIdDv() {
        int id = -1;
        int index = cbbTenDv.getSelectedIndex();
        Listdsdv = dsdao.getAllDataByTenDm(tendm);
        return Listdsdv.get(index).getId();
    }

    private void displayImage(String imagePath) {
        System.out.println(imagePath);
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(lblanh.getWidth(), lblanh.getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        lblanh.setIcon(imageIcon);
    }

    private void setForm() throws ParseException {
        int row = -1;
        row = tblLstiem.getSelectedRow();
        if (row > -1) {
            txtID.setText(tblLstiem.getValueAt(row, 0).toString());
            txtNgayTiem.setDate(DateUliti.stringToDate(tblLstiem.getValueAt(row, 3).toString(), "yyyy-MM-dd"));
            txtThuocsd.setText(tblLstiem.getValueAt(row, 2).toString());
            txtTinhTrang.setText(tblLstiem.getValueAt(row, 4).toString());
            String imgname = tblLstiem.getValueAt(row, 5).toString();
            displayImage("src/img/" + imgname);
            cbbTenDv.setSelectedItem(tblLstiem.getValueAt(row, 1).toString());
        }
    }

    private lichsutiemphong getForm() {
        String idstr = txtID.getText();
        int id = -1;
        if (!idstr.equals("")) {
            id = Integer.parseInt(idstr);
        }
        int iddv = getIdDv();
        String thuocsd = txtThuocsd.getText();
        if (thuocsd.equals("")) {
            JOptionPane.showMessageDialog(this, "Thuốc Sử Dụng Không Được Để Trống", "Thông Báo", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        Date ngaytiem = txtNgayTiem.getDate();
        if (ngaytiem == null || ngaytiem.equals("")) {
            JOptionPane.showMessageDialog(this, "Ngày Tiêm Không Được Để Trống", "Thông Báo", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        String tinhtrang = txtTinhTrang.getText();
        if (tinhtrang.equals("")) {
            JOptionPane.showMessageDialog(this, "Tình Trạng Sau Khi Tiêm Không Được Để Trống", "Thông Báo", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        lichsutiemphong lst = new lichsutiemphong(id, iddv, thuocsd, ngaytiem, tinhtrang);
        return lst;
    }

    private void fillTable() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblLstiem.getModel();
        defaultTableModel.setRowCount(0);
        if (idDv == -1) {
            listls = lstdao.getAllData(tendm);
        }else{
            listls = lstdao.getAllDataById(idDv);
        }
        if (listls.isEmpty()) {
            uliti.Dialog.fail("Tìm");
            System.out.println("Danh sách Trống");
            return;
        }
        for (lichsutiemphong x : listls) {
            Object[] row = {
                x.getId(),
                x.getTendv(),
                x.getThuocdasudung(),
                x.getNgaytiem(),
                x.getTinhtrangsaukhitiem(),
                x.getAnh()
            };
            defaultTableModel.addRow(row);
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
        tblLstiem = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbbTenDv = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtThuocsd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNgayTiem = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtTinhTrang = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblanh = new javax.swing.JLabel();

        tblLstiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblLstiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên Động Vật", "Thuốc Đã Sử Dụng", "Ngày Tiêm", "Tình Trạng Sức Khoẻ", "Ảnh"
            }
        ));
        tblLstiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLstiemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLstiem);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Tên Động Vật:");

        cbbTenDv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Thuốc Đã Sử Dụng:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Ngày Tiêm:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tình Trạng Sau Khi Tiêm:");

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("ID:");

        txtID.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ảnh"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblanh, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtThuocsd)
                                        .addComponent(txtNgayTiem, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                        .addComponent(txtTinhTrang)
                                        .addComponent(cbbTenDv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnMoi)))
                        .addGap(212, 212, 212)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbbTenDv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtThuocsd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtNgayTiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)
                            .addComponent(btnMoi)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblLstiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLstiemMouseClicked
        try {
            // TODO add your handling code here:
            setForm();
        } catch (ParseException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_tblLstiemMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        lichsutiemphong lst = getForm();
        if (lst == null) {
            return;
        }
        lstdao.create(lst);
        fillTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        lichsutiemphong lst = getForm();
        if (lst == null) {
            return;
        }
        lstdao.update(lst);
        fillTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        lichsutiemphong lst = getForm();
        if (lst == null) {
            return;
        }
        lstdao.delete(lst);
        fillTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        lblanh.setIcon(null);
        txtID.setText("");
        txtNgayTiem.setDate(null);
        txtThuocsd.setText(null);
        txtTinhTrang.setText(null);
    }//GEN-LAST:event_btnMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbTenDv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblanh;
    private javax.swing.JTable tblLstiem;
    private javax.swing.JTextField txtID;
    private com.toedter.calendar.JDateChooser txtNgayTiem;
    private javax.swing.JTextField txtThuocsd;
    private javax.swing.JTextField txtTinhTrang;
    // End of variables declaration//GEN-END:variables
}
