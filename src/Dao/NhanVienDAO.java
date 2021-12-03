/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.JDBCHelper;
import Model.HoaDon;
import Model.NhanVien;
import Model.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class NhanVienDAO extends BarberDAO<NhanVien, Object>{
    String INSERT_SQL = "INSERT INTO NhanVien(Id_TK,HoTen,GioiTinh,DiaChi,Email,SoDienThoai,VaiTro)"
            + "values(?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NhanVien set HoTen=?,GioiTinh=?,DiaChi=?"
            + ",Email=?,SoDienThoai=?,VaiTro=?,TrangThai=? where Id=?";
    String DELETE_SQL = "DELETE FROM NhanVien";
    String SELECT_ALL_SQL = "SELECT*FROM NhanVien where TrangThai =N'Hoạt động'";
    String SELECT_BY_ID_SQL = "SELECT*FROM NhanVien where Id=?";
    String SELECT_BY_EMAIL = "SELECT*FROM NhanVien where Email=?";
String SELECT_VTRO = "SELECT VaiTro FROM NhanVien";

    @Override
    public void insert(NhanVien entity) {
        try {
            JDBCHelper.update(INSERT_SQL, entity.getId_TK(), entity.getHoTen(), entity.getGioiTinh(),
                    entity.getDiaChi(), entity.getEmail(), entity.getSdt(),
                    entity.getVaiTro() );
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhanVien entity) {
        try {
            JDBCHelper.update(UPDATE_SQL, entity.getHoTen(), entity.getGioiTinh(),
                    entity.getDiaChi(), entity.getEmail(), entity.getSdt(),
                    entity.getVaiTro(),entity.getTrangThai(), entity.getId());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object id) {
        try {
            JDBCHelper.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public NhanVien selectById(Object id) {
      List<NhanVien>list=this.selectBySql(SELECT_BY_ID_SQL, id);
      if(list.isEmpty()){
          return null;
      }else{
          return list.get(0);
      }
    }

    @Override
    public List<NhanVien> selectAll() {
      return this.selectBySql(SELECT_ALL_SQL);
    }
    
    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
       List<NhanVien>list=new ArrayList<NhanVien>();
        try {
            ResultSet rs=JDBCHelper.query(sql, args);
            while (rs.next()) {                
                NhanVien entity=new NhanVien();
                entity.setId(rs.getInt("Id"));
                entity.setId_TK(rs.getInt("Id_TK"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setDiaChi(rs.getString("DiaChi"));
                entity.setEmail(rs.getString("Email"));
                entity.setSdt(rs.getString("SoDienThoai"));
                entity.setVaiTro(rs.getString("VaiTro"));
                entity.setTrangThai(rs.getString("TrangThai"));
                list.add(entity);
                
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<NhanVien>selectByThoCat(){
        String sql="select*from NhanVien where VaiTro=N'Thợ cắt'";
        return this.selectBySql(sql);
    }
    
     public List<NhanVien> selectByThoCat1() {
        String sql = "select NhanVien.* ,HoaDon.Id,HoaDon.Id_KH,HoaDon.Id_NV,HoaDon.Id_TC, \n"
                + "CONVERT(VARCHAR(9),RIGHT(NgayHen,8),108) as N'NgayHen',NgayTao,\n"
                + "DatCoc,ThanhToan,DanhGia,PhanHoi,TrangThaiTT,HoaDon.TrangThai \n"
                + "from NhanVien join HoaDon on NhanVien.Id=HoaDon.Id_TC where  NhanVien.VaiTro=N'Thợ cắt'";
        return this.selectBySql(sql);
    }
    
     public NhanVien selectByNgayHen(HoaDon hd){
        String sql = "select NhanVien.*, HoaDon.Id,HoaDon.Id_KH,HoaDon.Id_NV,HoaDon.Id_TC, \n"
                + "CONVERT(VARCHAR(9),RIGHT(NgayHen,8),108) as N'NgayHen',NgayTao,\n"
                + "DatCoc,ThanhToan,DanhGia,PhanHoi,TrangThaiTT,HoaDon.TrangThai  \n"
                + "from NhanVien join HoaDon on NhanVien.Id=HoaDon.Id_TC where NhanVien.VaiTro=N'Thợ cắt' and HoaDon.Id_NV=";
        return this.selectBySql(sql,hd.getId()).get(0);
    }

    public NhanVien selectByNgayHen(UI.ChucNang.HoaDon hd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public List<NhanVien> selectHD() {
        String sql = "SELECT * FROM NhanVien WHERE TrangThai = N'Hoạt động'";
        return this.selectBySql(sql);
    }

    public List<NhanVien> selectKHD() {
        String sql = "SELECT * FROM NhanVien WHERE TrangThai = N'Không hoạt động'";
        return this.selectBySql(sql);
    }

    public void updateHD(NhanVien entity) throws SQLException {
        String sql = "UPDATE NhanVien SET TrangThai = 'Hoạt động' WHERE Id = ?";
        JDBCHelper.update(sql, entity.getId());
    }
    public void updateKHD(NhanVien entity) throws SQLException {
        String sql = "UPDATE NhanVien SET TrangThai = 'Không hoạt động' WHERE Id = ?";
        JDBCHelper.update(sql, entity.getId());
    }
    
    
    public NhanVien selectByEmail(Object id) {
      List<NhanVien>list=this.selectBySql(SELECT_BY_EMAIL, id);
      if(list.isEmpty()){
          return null;
      }else{
          return list.get(0);
      }
    }
    
    public NhanVien selectBySDT(Object id) {
      List<NhanVien>list=this.selectBySql("SELECT*FROM NhanVien where SoDienThoai=?", id);
      if(list.isEmpty()){
          return null;
      }else{
          return list.get(0);
      }
    }
    
    public NhanVien selectBVTro(Object id) {
      List<NhanVien>list=this.selectBySql(SELECT_VTRO, id);
      if(list.isEmpty()){
          return null;
      }else{
          return list.get(0);
      }
    }
    
    public List<NhanVien> selectByVaiTro(String vaiTro) {
        String sql = "SELECT*FROM NhanVien where VaiTro=?";
        return this.selectBySql(sql, vaiTro);
    }
    
    public List<NhanVien> selectByIdNv(int idNV){
        String sql = "SELECT TAIKHOAN.* FROM TAIKHOAN JOIN NHANVIEN ON TAIKHOAN.ID = NHANVIEN.ID_TK WHERE NHANVIEN.ID=?";
        return  this.selectBySql(sql, idNV);
    }
    
    
    public List<NhanVien> selectByIdNV(String id, String hoTen, String SoDienThoai, String Email, String VaiTro) {
        String sql = "SELECT * FROM NHANVIEN WHERE Id LIKE ? OR HoTen LIKE ? OR SoDienThoai LIKE ? OR Email LIKE ? OR VaiTro LIKE ?";
        return this.selectBySql(sql, "%" + id + "%", "%" + hoTen + "%", "%" + SoDienThoai + "%", "%" + Email + "%", "%" + VaiTro + "%");
    }
    
    public void updateTK(int idNV) throws SQLException {
        String sql = "UPDATE NhanVien SET TrangThai = 'Không hoạt động' WHERE id = ?";
        JDBCHelper.update(sql, idNV);
    }
    
    
    public NhanVien selectByIdTK(int id) {
        String sql = "Select * from KhachHang where Id_TK = ?";
        List<NhanVien> list = this.selectBySql(sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<NhanVien> selectTT(String tenTk) {
        String sql = "select x.* from NhanVien x join TaiKhoan y on x.Id_TK = y.Id where y.TenTK = ? ";
        List<NhanVien> list = this.selectBySql(sql, tenTk);
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }
    
    public NhanVien SelectByTenTK(String tentk) {
        List<NhanVien>list=this.selectBySql("select NhanVien.* from NhanVien join TaiKhoan on NhanVien.Id_TK = TaiKhoan.Id where TaiKhoan.TenTK = ?", tentk);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
}
