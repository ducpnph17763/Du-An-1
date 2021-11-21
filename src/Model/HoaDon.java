/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;



/**
 *
 * @author Administrator
 */
public class HoaDon {
    private int id;
    private int id_KH;
    private int id_TC;
    private int id_NV;
    private Date ngayHen;
    private String ngayTao;
    private int datCoc;
    private int thanhToan;
    private String danhGia;
    private String phanHoi;
    private String trangThaiTT;
    private String trangThai;

    public HoaDon() {
    }

    public HoaDon(int id, int id_KH, int id_TC, int id_NV, Date ngayHen, String ngayTao, int datCoc, int thanhToan, String danhGia, String phanHoi, String trangThaiTT, String trangThai) {
        this.id = id;
        this.id_KH = id_KH;
        this.id_TC = id_TC;
        this.id_NV = id_NV;
        this.ngayHen = ngayHen;
        this.ngayTao = ngayTao;
        this.datCoc = datCoc;
        this.thanhToan = thanhToan;
        this.danhGia = danhGia;
        this.phanHoi = phanHoi;
        this.trangThaiTT = trangThaiTT;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_KH() {
        return id_KH;
    }

    public void setId_KH(int id_KH) {
        this.id_KH = id_KH;
    }

    public int getId_TC() {
        return id_TC;
    }

    public void setId_TC(int id_TC) {
        this.id_TC = id_TC;
    }

    public int getId_NV() {
        return id_NV;
    }

    public void setId_NV(int id_NV) {
        this.id_NV = id_NV;
    }

    public Date getNgayHen() {
        return ngayHen;
    }

    public void setNgayHen(Date ngayHen) {
        this.ngayHen = ngayHen;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getDatCoc() {
        return datCoc;
    }

    public void setDatCoc(int datCoc) {
        this.datCoc = datCoc;
    }

    public int getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(int thanhToan) {
        this.thanhToan = thanhToan;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public String getPhanHoi() {
        return phanHoi;
    }

    public void setPhanHoi(String phanHoi) {
        this.phanHoi = phanHoi;
    }

    public String getTrangThaiTT() {
        return trangThaiTT;
    }

    public void setTrangThaiTT(String trangThaiTT) {
        this.trangThaiTT = trangThaiTT;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
   
    
    
}
