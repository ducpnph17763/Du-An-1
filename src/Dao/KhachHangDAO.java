/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dao.BarberDAO;
import Helper.JDBCHelper;
import Model.HoaDon;
import Model.KhachHang;
import Model.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huong
 */
public class KhachHangDAO extends BarberDAO<KhachHang, Object>{

    String INSERT_SQL = "INSERT INTO KHACHHANG (ID_TK,HOTEN,HINH,TRANGTHAI)"
            + "values(?,?,?,?)";
    String UPDATE_SQL = "UPDATE TaiKhoan set TenTK=?,MatKhau=?,VaiTro=?,TrangThai=?"
            + "where Id=? "; 
String SELECT_ALL_SQL = "SELECT * FROM KHACHHANG WHERE TrangThai = N'Hoạt động'";
    @Override
    public void insert(KhachHang entity) {
        try {
            JDBCHelper.update(INSERT_SQL, entity.getId_tk(), entity.getHoTen(), entity.getHinh(),entity.getTrangThai());
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(KhachHang entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KhachHang selectById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<KhachHang> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang>list=new ArrayList<>();
        try {
            ResultSet rs=JDBCHelper.query(sql, args);
            while (rs.next()) {                
                KhachHang entity=new KhachHang();
                entity.setId(rs.getInt(1));
                entity.setId_tk(rs.getInt(2));
                entity.setHoTen(rs.getString(3));
                entity.setHinh(rs.getString(4));
                entity.setTrangThai(rs.getString(5));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public KhachHang SelectByTenTK(String tentk) {
        List<KhachHang>list=this.selectBySql("select KhachHang.* from KhachHang join TaiKhoan on KhachHang.Id_TK = TaiKhoan.Id where TaiKhoan.TenTK = ?", tentk);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
    public KhachHang SelectBySoDienThoai(String sdt) {
        List<KhachHang>list=this.selectBySql("select KhachHang.* from KhachHang join ThongTinKhachHang on KhachHang.Id = ThongTinKhachHang.Id_KH where SoDienThoai = ? ", sdt);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
}
