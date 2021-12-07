/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author dell
 */
public class DichVu {
    private String Id;
    private String tenDV;
    private int giaTien;
    private String hinh;
    private String moTa;
    private String trangThai;
    private int thoiGian;

    public DichVu() {
    }

    public DichVu(String Id, String tenDV, int giaTien, String hinh, String moTa, String trangThai, int thoiGian) {
        this.Id = Id;
        this.tenDV = tenDV;
        this.giaTien = giaTien;
        this.hinh = hinh;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.thoiGian = thoiGian;
    }
    

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }
    

    @Override
    public String toString() {
        return this.tenDV;
    }
    
    
    
}
