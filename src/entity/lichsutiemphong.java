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
public class lichsutiemphong {
    private int id;
    private int id_dv;
    private String tendv;
    private String thuocdasudung;
    private Date ngaytiem;
    private String tinhtrangsaukhitiem;
    private String anh;

    public lichsutiemphong(int id, int id_dv, String tendv, String thuocdasudung, Date ngaytiem, String tinhtrangsaukhitiem, String anh) {
        this.id = id;
        this.id_dv = id_dv;
        this.tendv = tendv;
        this.thuocdasudung = thuocdasudung;
        this.ngaytiem = ngaytiem;
        this.tinhtrangsaukhitiem = tinhtrangsaukhitiem;
        this.anh = anh;
    }

    

    public lichsutiemphong(int id, int id_dv, String thuocdasudung, Date ngaytiem, String tinhtrangsaukhitiem) {
        this.id = id;
        this.id_dv = id_dv;
        this.thuocdasudung = thuocdasudung;
        this.ngaytiem = ngaytiem;
        this.tinhtrangsaukhitiem = tinhtrangsaukhitiem;
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

    public String getThuocdasudung() {
        return thuocdasudung;
    }

    public void setThuocdasudung(String thuocdasudung) {
        this.thuocdasudung = thuocdasudung;
    }

    public Date getNgaytiem() {
        return ngaytiem;
    }

    public void setNgaytiem(Date ngaytiem) {
        this.ngaytiem = ngaytiem;
    }

    public String getTinhtrangsaukhitiem() {
        return tinhtrangsaukhitiem;
    }

    public void setTinhtrangsaukhitiem(String tinhtrangsaukhitiem) {
        this.tinhtrangsaukhitiem = tinhtrangsaukhitiem;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    
    
}
