/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Hieu
 */
public class danhsachdongvat {
    private int id;
    private int iddm;
    private String tendm;
    private String tendv;
    private float cannang;
    private String anh;

    public danhsachdongvat(int id, int iddm, String tendv, float cannang, String anh) {
        this.id = id;
        this.iddm = iddm;
        this.tendv = tendv;
        this.cannang = cannang;
        this.anh = anh;
    }

    public danhsachdongvat(int id, int iddm, String tendm, String tendv, float cannang, String anh) {
        this.id = id;
        this.iddm = iddm;
        this.tendm = tendm;
        this.tendv = tendv;
        this.cannang = cannang;
        this.anh = anh;
    }

    public danhsachdongvat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIddm() {
        return iddm;
    }

    public void setIddm(int iddm) {
        this.iddm = iddm;
    }

    public String getTendm() {
        return tendm;
    }

    public void setTendm(String tendm) {
        this.tendm = tendm;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public float getCannang() {
        return cannang;
    }

    public void setCannang(float cannang) {
        this.cannang = cannang;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
}
