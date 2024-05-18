/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.danhmucdongvat;
import entity.danhsachdongvat;
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
public class danhsachdongvatDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public danhsachdongvatDao() throws Exception {
        connection = uliti.DBContext.getConnection();
    }

    public List<danhsachdongvat> getAllData() {
        List<danhsachdongvat> list = new ArrayList<>();
        String sql = "Select danhsachdongvat.id,danhsachdongvat.id_danhmuc,danhmucdongvat.tendm,danhsachdongvat.tendv,danhsachdongvat.cannang,danhsachdongvat.anh from danhsachdongvat\n"
                + "join danhmucdongvat\n"
                + "on danhsachdongvat.id_danhmuc = danhmucdongvat.id";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                danhsachdongvat dsdv = new danhsachdongvat(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_danhmuc"),
                        resultSet.getString("tendm"),
                        resultSet.getString("tendv"),
                        resultSet.getFloat("cannang"),
                        resultSet.getString("anh"));
                list.add(dsdv);

            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
        return list;
    }
    public List<danhsachdongvat> getAllDataByTenDm(String tendm) {
        List<danhsachdongvat> list = new ArrayList<>();
        String sql = "Select danhsachdongvat.id,danhsachdongvat.id_danhmuc,danhmucdongvat.tendm,danhsachdongvat.tendv,danhsachdongvat.cannang,danhsachdongvat.anh from danhsachdongvat\n"
                + "join danhmucdongvat\n"
                + "on danhsachdongvat.id_danhmuc = danhmucdongvat.id where danhmucdongvat.tendm = ? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tendm);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                danhsachdongvat dsdv = new danhsachdongvat(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_danhmuc"),
                        resultSet.getString("tendm"),
                        resultSet.getString("tendv"),
                        resultSet.getFloat("cannang"),
                        resultSet.getString("anh"));
                list.add(dsdv);

            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
        return list;
    }
    public void create(danhsachdongvat dsdv) {
        String sql = "INSERT INTO danhsachdongvat (id_danhmuc, tendv, cannang, anh) VALUES\n"
                + "(?, ?,?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dsdv.getIddm());
            preparedStatement.setString(2, dsdv.getTendv());
            preparedStatement.setFloat(3, dsdv.getCannang());
            preparedStatement.setString(4,dsdv.getAnh());
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Thêm Thành Công");
            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
    }
    public void update(danhsachdongvat dsdv) {
        String sql = "UPDATE danhsachdongvat set id_danhmuc = ?,tendv = ?,cannang = ?, anh = ? where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dsdv.getIddm());
            preparedStatement.setString(2, dsdv.getTendv());
            preparedStatement.setFloat(3, dsdv.getCannang());
            preparedStatement.setString(4,dsdv.getAnh());
            preparedStatement.setInt(5,dsdv.getId());
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Sửa Thành Công");
            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
    }
    public void delete(danhsachdongvat dsdv) {
        String sql = "Delete FROM danhsachdongvat where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dsdv.getId());
            int row = preparedStatement.executeUpdate();
            if(row > 0){
                System.out.println("Xoá Thành Công");
            }
        } catch (SQLException e) {
            System.out.println("Mã Lỗi:" + e);
        }
    }
}
