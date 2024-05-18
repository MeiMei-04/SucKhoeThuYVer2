/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.danhmucdongvat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hieu
 */
public class danhmucdongvatDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public danhmucdongvatDao() throws Exception {
        connection = uliti.DBContext.getConnection();
    }

    public List<danhmucdongvat> getAllData() {
        List<danhmucdongvat> list = new ArrayList<>();
        String sql = "SELECT * FROM danhmucdongvat";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                danhmucdongvat dmdv = new danhmucdongvat(resultSet.getInt("id"), resultSet.getString("tendm"));
                list.add(dmdv);
            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
        return list;
    }

    public void create(danhmucdongvat dmdv) {
        String sql = "INSERT INTO danhmucdongvat (tendm) VALUES\n"
                + "(?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dmdv.getTendm());
            int row = preparedStatement.executeUpdate();
            if(row > 0){
                System.out.println("Thêm Thành Công");
            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
    }
    public void update(danhmucdongvat dmdv) {
        String sql = "UPDATE danhmucdongvat SET tendm = ? where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dmdv.getTendm());
            preparedStatement.setInt(2, dmdv.getId());
            int row = preparedStatement.executeUpdate();
            if(row > 0){
                System.out.println("Sửa Thành Công");
            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
    }
    public void delete(danhmucdongvat dmdv) {
        String sql = "Delete FROM danhmucdongvat where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dmdv.getId());
            int row = preparedStatement.executeUpdate();
            if(row > 0){
                System.out.println("Xoá Thành Công");
            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
    }
}
