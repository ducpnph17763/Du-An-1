/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Helper.JDBCHelper;
import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class QLTaiKhoanDAO extends BarberDAO<TTKhachHang, Object> {

    String DELETE_SQL = "delete from ThongTinKhachHang where SoDienThoai=?";
    String INSERT_SQL = "insert into ThongTinKhachHang (Id_KH,SoDienThoai,Email,TrangThai) values (?,?,?,?)";
    String UPDATE_SQL = "update ThongTinKhachHang set Email=?, SoDienThoai=? where SoDienThoai=? ";
    String SELECT_ALL_SQL = "select * from ThongTinKhachHang";
    String getId = "Select * from ThongTinKhachHang where SoDienThoai=?";

    public List<TTKhachHang> selectTT(String id) {
        String sql = "select x.* from ThongTinKhachHang x join KhachHang y on x.Id_KH=y.id join TaiKhoan z on z.Id=y.Id_TK where z.TenTK = ?";
        List<TTKhachHang> list = this.selectBySql(sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    public TTKhachHang selectId(String sdt) {
        List<TTKhachHang> list = this.selectBySql(getId, sdt);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public void insert(TTKhachHang entity) {
        try {
            JDBCHelper.update(INSERT_SQL, entity.getId_KH(), entity.getSdt(),
                    entity.getEmail(), entity.getTrangThai());
        } catch (SQLException ex) {
            Logger.getLogger(QLTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(TTKhachHang entity) {
        try {
            JDBCHelper.update(UPDATE_SQL, entity.getId_KH(), entity.getSdt(),
                    entity.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(QLTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object id) {
        try {
            JDBCHelper.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(QLTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public TTKhachHang selectById(Object id) {
        String sql = "Select * from ThongTinKhachHang where Id_KH = ?";
        List<TTKhachHang> list = this.selectBySql(sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TTKhachHang> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<TTKhachHang> selectBySql(String sql, Object... args) {
        List<TTKhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                TTKhachHang entity = new TTKhachHang();
                entity.setId_KH(rs.getInt("Id_KH"));
                entity.setEmail(rs.getString("Email"));
                entity.setSdt(rs.getString("SoDienThoai"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
