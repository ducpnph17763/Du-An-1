/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Administrator
 */
public class HoaDonCT {
    private String id;
    private String id_DV;
    private String id_HD;
    private int giaTien;
    private String trangThai;

    public HoaDonCT() {
    }

    public HoaDonCT(String id, String id_DV, String id_HD, int giaTien, String trangThai) {
        this.id = id;
        this.id_DV = id_DV;
        this.id_HD = id_HD;
        this.giaTien = giaTien;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_DV() {
        return id_DV;
    }

    public void setId_DV(String id_DV) {
        this.id_DV = id_DV;
    }

    public String getId_HD() {
        return id_HD;
    }

    public void setId_HD(String id_HD) {
        this.id_HD = id_HD;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
