/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.JDBCHelper;
import Helper.XAuth;
import Model.KhachHang;
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
 * @author Administrator
 */
public class TaiKhoanDAO extends BarberDAO<TaiKhoan, Object> {

    String INSERT_SQL = "INSERT INTO TaiKhoan(TenTK,MatKhau,VaiTro,TrangThai)"
            + "values(?,?,?,?)";
    String UPDATE_SQL = "UPDATE TaiKhoan set TenTK=?,MatKhau=?,VaiTro=?,TrangThai=?"
            + "where Id=? ";
    String DELETE_SQL = "DELETE FROM TaiKhoan";
    String SELECT_ALL_SQL = "SELECT*FROM TaiKhoan";
    String SELECT_BY_ID_SQL = "SELECT*FROM TaiKhoan where Id=?";
    String SELECT_BY_tenTK = "Select * form TaiKhoan where tenTK = ?";
    String SELECT_BY_MATKHAU = " Select * from TaiKhoan where MATKHAU=?";
    String SelectTTKH = "Select x.email, x.SoDienThoai from ThongTinKhachHang x join KhachHang y on x.Id_KH=y.Id join TaiKhoan z on z.Id=y.Id_TK where TenTK=?";
    String SelectTTNV = "Select x.email, x.SoDienThoai, y.TenTK from NhanVien x join TaiKhoan y on x.Id_TK=y.id where TenTK=? ";

    public TaiKhoan select(String tentk) {
        String sql = "Select * from TaiKhoan where TenTK = ?";
        List<TaiKhoan> list = this.selectBySql(sql, tentk);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public void insert(TaiKhoan entity) {
        try {
            JDBCHelper.update(INSERT_SQL, entity.getTenTK(), entity.getMatKhau(), entity.getVaiTro(), entity.getTrangThai()
            );
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(TaiKhoan entity) {
        try {
            JDBCHelper.update("update TaiKhoan set MatKhau = ? where TenTK = ?", entity.getMatKhau(),
                    entity.getTenTK()
            );
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object id) {
        try {
            JDBCHelper.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public TaiKhoan selectById(Object id) {
        List<TaiKhoan> list = this.selectBySql(SELECT_BY_ID_SQL);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TaiKhoan> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                TaiKhoan entity = new TaiKhoan();
                entity.setId(rs.getInt("Id"));
                entity.setTenTK(rs.getString("TenTK"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setVaiTro(rs.getInt("VaiTro"));
                entity.setTrangThai(rs.getString("TrangThai"));
                entity.setHinh(rs.getString("Hinh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TaiKhoan selectByTaiKhoan(NhanVien nv) {
        String sql = "select TaiKhoan.* from TaiKhoan join NhanVien  on TaiKhoan.Id=NhanVien.Id_TK\n"
                + "where NhanVien.Id_TK=?";
        return this.selectBySql(sql, nv.getId_TK()).get(0);
    }

    public TaiKhoan selectById_TK(TaiKhoan nv) {
        String sql = "select top 1 * from TaiKhoan order by Id desc";
        return this.selectBySql(sql, nv.getId()).get(0);
    }
    
    
}
