/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Hieu
 */
public class lichsukhambenh {
    private int id;
    private int id_dv;
    private String tendv;
    private String loaibenh;
    private Date ngaykhambenh;
    private String tinhtrangbenh;
    private String anh;

    public lichsukhambenh(int id, int id_dv, String loaibenh, Date ngaykhambenh, String tinhtrangbenh) {
        this.id = id;
        this.id_dv = id_dv;
        this.loaibenh = loaibenh;
        this.ngaykhambenh = ngaykhambenh;
        this.tinhtrangbenh = tinhtrangbenh;
    }

    public lichsukhambenh(int id, int id_dv, String tendv, String loaibenh, Date ngaykhambenh, String tinhtrangbenh, String anh) {
        this.id = id;
        this.id_dv = id_dv;
        this.tendv = tendv;
        this.loaibenh = loaibenh;
        this.ngaykhambenh = ngaykhambenh;
        this.tinhtrangbenh = tinhtrangbenh;
        this.anh = anh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_dv() {
        return id_dv;
    }

    public void setId_dv(int id_dv) {
        this.id_dv = id_dv;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public String getLoaibenh() {
        return loaibenh;
    }

    public void setLoaibenh(String loaibenh) {
        this.loaibenh = loaibenh;
    }

    public Date getNgaykhambenh() {
        return ngaykhambenh;
    }

    public void setNgaykhambenh(Date ngaykhambenh) {
        this.ngaykhambenh = ngaykhambenh;
    }

    public String getTinhtrangbenh() {
        return tinhtrangbenh;
    }

    public void setTinhtrangbenh(String tinhtrangbenh) {
        this.tinhtrangbenh = tinhtrangbenh;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
   

    
    
}
