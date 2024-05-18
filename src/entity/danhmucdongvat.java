/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Hieu
 */
public class danhmucdongvat {
    private int id;
    private String tendm;

    public danhmucdongvat(int id, String tendm) {
        this.id = id;
        this.tendm = tendm;
    }

    public danhmucdongvat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTendm() {
        return tendm;
    }

    public void setTendm(String tendm) {
        this.tendm = tendm;
    }
    
}
