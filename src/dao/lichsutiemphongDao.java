/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.danhsachdongvat;
import entity.lichsutiemphong;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hieu
 */
public class lichsutiemphongDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public lichsutiemphongDao() throws Exception {
        connection = uliti.DBContext.getConnection();
    }

    public List<lichsutiemphong> getAllData(String tendm) {
        List<lichsutiemphong> list = new ArrayList<>();
        String sql = "Select lichsutiemphong.id,lichsutiemphong.id_dv,danhsachdongvat.tendv,lichsutiemphong.thuocdasudung,lichsutiemphong.ngaytiem,lichsutiemphong.tinhtrangsaukhitiem,danhsachdongvat.anh from lichsutiemphong\n"
                + "join danhsachdongvat\n"
                + "on lichsutiemphong.id_dv = danhsachdongvat.id\n"
                + "join danhmucdongvat\n"
                + "on danhsachdongvat.id_danhmuc = danhmucdongvat.id where danhmucdongvat.tendm = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tendm);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                lichsutiemphong ls = new lichsutiemphong(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_dv"),
                        resultSet.getString("tendv"),
                        resultSet.getString("thuocdasudung"),
                        resultSet.getDate("ngaytiem"),
                        resultSet.getString("tinhtrangsaukhitiem"),
                        resultSet.getString("anh"));
                list.add(ls);

            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
        return list;
    }

    public void create(lichsutiemphong lst) {
        String sql = "INSERT INTO lichsutiemphong (id_dv, thuocdasudung, ngaytiem, tinhtrangsaukhitiem) VALUES\n"
                + "(?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, lst.getId_dv());
            preparedStatement.setString(2, lst.getThuocdasudung());
            java.util.Date utilDate = lst.getNgaytiem();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, lst.getTinhtrangsaukhitiem());
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Thêm Thành Công");
            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
    }

    public void update(lichsutiemphong lst) {
        String sql = "UPDATE lichsutiemphong set id_dv = ?, thuocdasudung = ?, ngaytiem = ?, tinhtrangsaukhitiem = ? where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, lst.getId_dv());
            preparedStatement.setString(2, lst.getThuocdasudung());
            java.util.Date utilDate = lst.getNgaytiem();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, lst.getTinhtrangsaukhitiem());
            preparedStatement.setInt(5, lst.getId());
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Sửa Thành Công");
            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
    }

    public void delete(lichsutiemphong lst) {
        String sql = "DELETE FROM lichsutiemphong where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, lst.getId());
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Xoá Thành Công");
            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
    }
}
