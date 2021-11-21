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
public class NhanVien {
    private int Id;
    private int Id_TK;
    private String hoTen;
    private boolean gioiTinh;
    private String diaChi;
    private String email;
    private String sdt;
    private String vaiTro;
    private String trangThai;

    public NhanVien() {
    }

    public NhanVien(int Id, String hoTen, boolean gioiTinh, String diaChi, String email, String sdt, String vaiTro, String trangThai) {
        this.Id = Id;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getId_TK() {
        return Id_TK;
    }

    public void setId_TK(int Id_TK) {
        this.Id_TK = Id_TK;
    }

    @Override
    public String toString() {
        return this.hoTen;
    }

  

    @Override
    public boolean equals(Object obj) {
      
        
         NhanVien other = (NhanVien) obj;
       return  other.getId()==(this.getId());
    }
    
    

   
    
    
}
