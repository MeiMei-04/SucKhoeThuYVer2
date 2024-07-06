/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.lichsukhambenh;
import entity.lichsutiemphong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hieu
 */
public class lichsukhambenhDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public lichsukhambenhDao() throws Exception {
        connection = uliti.DBContext.getConnection();
    }

    public List<lichsukhambenh> getAllData(String tendm) {
        List<lichsukhambenh> list = new ArrayList<>();
        String sql = "Select lichsukhambenh.id,lichsukhambenh.id_dv,danhsachdongvat.tendv,lichsukhambenh.loaibenh,lichsukhambenh.ngaykhambenh,lichsukhambenh.tinhtrangbenh, danhsachdongvat.anh from lichsukhambenh\n"
                + "join danhsachdongvat\n"
                + "on lichsukhambenh.id_dv = danhsachdongvat.id\n"
                + "join danhmucdongvat\n"
                + "on danhsachdongvat.id_danhmuc = danhmucdongvat.id where danhmucdongvat.tendm = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tendm);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                lichsukhambenh lsb = new lichsukhambenh(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_dv"),
                        resultSet.getString("tendv"),
                        resultSet.getString("loaibenh"),
                        resultSet.getDate("ngaykhambenh"),
                        resultSet.getString("tinhtrangbenh"),
                        resultSet.getString("anh"));
                list.add(lsb);

            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
        return list;
    }
    public List<lichsukhambenh> getAllDataById(int iddv) {
        List<lichsukhambenh> list = new ArrayList<>();
        String sql = "Select lichsukhambenh.id,lichsukhambenh.id_dv,danhsachdongvat.tendv,lichsukhambenh.loaibenh,lichsukhambenh.ngaykhambenh,lichsukhambenh.tinhtrangbenh, danhsachdongvat.anh from lichsukhambenh\n"
                + "join danhsachdongvat\n"
                + "on lichsukhambenh.id_dv = danhsachdongvat.id where lichsukhambenh.id_dv = ? ";
        System.out.println(sql);
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, iddv);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                lichsukhambenh lsb = new lichsukhambenh(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_dv"),
                        resultSet.getString("tendv"),
                        resultSet.getString("loaibenh"),
                        resultSet.getDate("ngaykhambenh"),
                        resultSet.getString("tinhtrangbenh"),
                        resultSet.getString("anh"));
                list.add(lsb);

            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
        return list;
    }
    public void create(lichsukhambenh lsb) {
        String sql = "INSERT INTO lichsukhambenh (id_dv, loaibenh, ngaykhambenh, tinhtrangbenh) VALUES\n"
                + "(?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, lsb.getId_dv());
            preparedStatement.setString(2, lsb.getLoaibenh());
            java.util.Date utilDate = lsb.getNgaykhambenh();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, lsb.getTinhtrangbenh());
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Thêm Thành Công");
            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
    }

    public void update(lichsukhambenh lsb) {
        String sql = "UPDATE lichsukhambenh set id_dv = ?, loaibenh = ?, ngaykhambenh = ?, tinhtrangbenh = ? where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, lsb.getId_dv());
            preparedStatement.setString(2, lsb.getLoaibenh());
            java.util.Date utilDate = lsb.getNgaykhambenh();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, lsb.getTinhtrangbenh());
            preparedStatement.setInt(5, lsb.getId());
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Sửa Thành Công");
            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
    }
    public void delete(lichsukhambenh lsb) {
        String sql = "DELETE FROM lichsukhambenh where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, lsb.getId());
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Xoá Thành Công");
            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
    }
}
