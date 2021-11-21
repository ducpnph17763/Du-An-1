/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.JDBCHelper;
import Model.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class HoaDonDAO extends BarberDAO<HoaDon, String> {

    String UPDATE_SQL = "UPDATE HoaDon set TrangThaiTT=?,TrangThai=? where Id=?";
    String SELECT_ALL_SQL = "select*from HoaDon";
    String SELECT_BY_ID_SQL = "select*from HoaDon where Id=?";

    @Override
    public void insert(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(HoaDon entity) {

        try {
            JDBCHelper.update(UPDATE_SQL, entity.getTrangThaiTT(), entity.getTrangThai(), entity.getId());
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HoaDon selectById(String id) {
        List<HoaDon> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                HoaDon entity = new HoaDon();
                entity.setId(rs.getInt("Id"));
                entity.setId_KH(rs.getInt("Id_KH"));
                entity.setId_TC(rs.getInt("Id_TC"));
                entity.setId_NV(rs.getInt("Id_NV"));
                entity.setNgayHen(rs.getDate("NgayHen"));
                entity.setNgayTao(rs.getString("NgayTao"));
                entity.setDatCoc(rs.getInt("DatCoc"));
                entity.setThanhToan(rs.getInt("ThanhToan"));
                entity.setDanhGia(rs.getString("DanhGia"));
                entity.setPhanHoi(rs.getString("PhanHoi"));
                entity.setTrangThaiTT(rs.getString("TrangThaiTT"));
                entity.setTrangThai(rs.getString("TrangThai"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    public List<Integer> selectYear() {
        String sql = "select distinct year(NgayTao) from HOADON ORDER BY Year(NgayTao) desc";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    
    }
}
    



