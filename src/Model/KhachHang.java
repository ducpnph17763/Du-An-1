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
public class KhachHang {

    private Integer id;
    private int id_TK;
    private String hoTen;
    private String hinh;
    private String trangThai;

    public KhachHang() {
    }

    public KhachHang(Integer id, int id_TK, String hoTen, String hinh, String trangThai) {
        this.id = id;
        this.id_TK = id_TK;
        this.hoTen = hoTen;
        this.hinh = hinh;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId_TK() {
        return id_TK;
    }

    public void setId_TK(int id_TK) {
        this.id_TK = id_TK;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
