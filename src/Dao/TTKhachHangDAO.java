/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Helper.JDBCHelper;
import Model.KhachHang;
import Model.TTKhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84868
 */
public class TTKhachHangDAO extends BarberDAO<TTKhachHang, String>{

    String INSERT_SQL = " insert into ThongTinKhachHang(Id_KH,SoDienThoai,Email) values(?,?,?) ";
    String UPDATE_SQL = " UPDATE ThongTinKhachHang set SoDienThoai = ?, Email = ?  where Id_KH = ? ";
    String DELETE_SQL = " DELETE From ThongTinKhachHang";
    String SELECT_ALL_SQL = " select * from ThongTinKhachHang";
    String SELECT_BY_ID_SQL = " select * from ThongTinKhachHang where Id_KH = ?";

    @Override
    public void insert(TTKhachHang entity) {
         try {
            JDBCHelper.update(INSERT_SQL,entity.getId_KH() ,entity.getSdt(), entity.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(TTKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(TTKhachHang entity) {
       try {
            JDBCHelper.update(UPDATE_SQL, entity.getSdt(), entity.getEmail(),entity.getId_KH());
        } catch (SQLException ex) {
            Logger.getLogger(TTKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
         try {
            JDBCHelper.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(TTKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public TTKhachHang selectById(String id) {
        List<TTKhachHang> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
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
//                entity.setId(rs.getInt("Id"));
                entity.setId_KH(rs.getInt("Id_KH"));
                entity.setSdt(rs.getString("Sdt"));
                entity.setEmail(rs.getString("Email"));
                list.add(entity);

            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

   
}
