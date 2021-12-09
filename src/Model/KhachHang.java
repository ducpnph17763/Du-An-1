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
    private Integer id,id_tk;
    private String hoTen;
    private String trangThai;

    public KhachHang() {
    }

    public KhachHang(Integer id, Integer id_tk, String hoTen, String trangThai) {
        this.id = id;
        this.id_tk = id_tk;
        this.hoTen = hoTen;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_tk() {
        return id_tk;
    }

    public void setId_tk(Integer id_tk) {
        this.id_tk = id_tk;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
