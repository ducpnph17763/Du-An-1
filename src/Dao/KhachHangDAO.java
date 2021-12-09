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
import Model.NhanVien;
import Model.TaiKhoan;
import java.sql.PreparedStatement;
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
public class KhachHangDAO extends BarberDAO<KhachHang, String>{

    String INSERT_SQL = "  Insert into KhachHang(Id_TK,HoTen) values(?,?)";
    String UPDATE_SQL = "  UPDATE KhachHang set HoTen = ? where Id_TK = ?";
    String DELETE_SQL = " DELETE From KhachHang";
    String SELECT_ALL_SQL = " select * from KhachHang";
    String SELECT_BY_ID_SQL = " select * from KhachHang where Id_TK = ?";
    String SELECT_Join = "Select Email, SoDienThoai from KhachHang join ThongTinKhachHang\n"
            + "  on KhachHang.Id = ThongTinKhachHang.Id_KH where ThongTinKhachHang.Id_KH = ?";
    
    @Override
    public void insert(KhachHang entity) {
        try {
            JDBCHelper.update(INSERT_SQL, entity.getId_tk(), entity.getHoTen());
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(KhachHang entity) {
        try {
            JDBCHelper.update(UPDATE_SQL,  entity.getHoTen(), entity.getId_tk());
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JDBCHelper.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public KhachHang selectById(String id) {
        List<KhachHang> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }
    
    
    
     public KhachHang selectByIdob(Object id) {
        List<KhachHang> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public List<KhachHang> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }
    
     public List<KhachHang> selectKH() {
         String sql="select KhachHang.Id,Hoten,Email,SoDienThoai from KhachHang join ThongTinKhachHang\n"
                + "on ThongTinKhachHang.Id_KH=KhachHang.Id\n"
                + "join TaiKhoan on TaiKhoan.Id=KhachHang.Id_TK";
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setId(rs.getInt("Id"));
                entity.setId_tk(rs.getInt("Id_TK"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setTrangThai(rs.getString("TrangThai"));
                list.add(entity);

            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object LayEmail(int kh) {
        Object[] oj = new Object[2];
        try {
            PreparedStatement pstm = JDBCHelper.getStmt("Select * from ThongTinKhachHang where Id_KH = ?", kh);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                
                oj[0] = rs.getString("SoDienThoai");
                oj[1] = rs.getString("Email");
                
            }
        } catch (Exception e) {
        }
        return oj;
    }
    
    public Object LayTK(KhachHang tk) {
        Object[] oj = new Object[2];
        try {
            PreparedStatement pstm = JDBCHelper.getStmt("Select * from TaiKhoan  join KhachHang on TaiKhoan.Id = KhachHang.Id_TK where Id_TK = ?", tk.getId_tk());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                
                oj[0] = rs.getString("TenTK");
                
                
            }
        } catch (Exception e) {
        }
        return oj;
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
