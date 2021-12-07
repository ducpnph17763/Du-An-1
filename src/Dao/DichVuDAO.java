/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.JDBCHelper;
import Model.DichVu;
import Model.*;
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
public class DichVuDAO extends BarberDAO<DichVu, String> {

    String INSERT_SQL = "INSERT INTO DichVu(TenDV,GiaTien,Hinh,MoTa) Values(?,?,?,?)";
    String UPDATE_SQL = "UPDATE DichVu set TenDV=?,GiaTien=?,Hinh=?,MoTa=? WHERE Id=?";
    String DELETE_SQL = "DELETE FROM DichVu where Id=?";
    String SELECT_ALL_SQL = "Select*from DichVu";
    String SELECT_BY_ID_SQL = "select*from DichVu where Id=?";

    public void insert1(DichVu entity) {
        String sql = "insert into DichVu(TenDV,GiaTien) values(?,?)";
        try {
            JDBCHelper.update(sql, entity.getTenDV(), entity.getGiaTien());
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(DichVu entity) {
        try {
            JDBCHelper.update(INSERT_SQL, entity.getTenDV(), entity.getGiaTien(),
                    entity.getHinh(), entity.getMoTa());
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DichVu entity) {
        try {
            JDBCHelper.update(UPDATE_SQL, entity.getTenDV(), entity.getGiaTien(),
                    entity.getHinh(), entity.getMoTa(), entity.getId());
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JDBCHelper.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DichVu selectById(String id) {
        List<DichVu> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DichVu> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<DichVu> selectBySql(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                DichVu entity = new DichVu();
                entity.setId(rs.getString("Id"));
                entity.setTenDV(rs.getString("TenDV"));
                entity.setGiaTien(rs.getInt("GiaTien"));
                entity.setHinh(rs.getString("Hinh"));
                entity.setMoTa(rs.getString("MoTa"));
                entity.setTrangThai(rs.getString("TrangThai"));
                entity.setThoiGian(rs.getInt("ThoiGian"));
                list.add(entity);

            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<DichVu> selectByDichVu(String id) {
        String sql = "SELECT*FROM DichVu WHERE Id=?";
        return this.selectBySql(sql, id);
    }

    public DichVu selectByDVHD(HoaDonCT hd) {
        String sql = "select DichVu.* from DichVu join HoaDonChiTiet on DichVu.Id=HoaDonChiTiet.Id_DV\n"
                + "join HoaDon on HoaDon.Id=HoaDonChiTiet.Id_HD\n"
                + "where HoaDonChiTiet.Id_DV=?";
        return this.selectBySql(sql, hd.getId_DV()).get(0);
    }

    public List<DichVu> SelectHoaDon(String id) {
        String sql = "select DichVu.* from DichVu \n"
                + "join HoaDonChiTiet on HoaDonChiTiet.Id_DV = DichVu.Id \n"
                + "join HoaDon on HoaDon.id = HoaDonChiTiet.Id_HD where HoaDon.Id = ?";
        return this.selectBySql(sql, id);
    }

}
