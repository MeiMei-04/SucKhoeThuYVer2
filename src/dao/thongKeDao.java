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
public class thongKeDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public thongKeDao() throws Exception {
        connection = uliti.DBContext.getConnection();
    }
    public List<lichsukhambenh> ThongKeLichSuKhamBenh(int thang,int nam) {
        List<lichsukhambenh> list = new ArrayList<>();
        String sql = "EXEC ThongKeLichSuKhamBenhTheoThang @Month = ?, @Year = ?;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, thang);
            preparedStatement.setInt(2, nam);
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
    public List<lichsutiemphong> ThongKeLichSuTiemPhong(int thang,int nam) {
        List<lichsutiemphong> list = new ArrayList<>();
        String sql = "EXEC ThongKeLichSuTiemPhongTheoThang @Month = ?, @Year = ?;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, thang);
            preparedStatement.setInt(2, nam);
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
}
