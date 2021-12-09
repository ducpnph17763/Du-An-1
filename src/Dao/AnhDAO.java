/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Helper.JDBCHelper;
import Model.Anh;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author nhatd
 */
public class AnhDAO extends BarberDAO<Anh, String>{

    String INSERT_SQL="insert into AnhChup(Id_HD,Anh) values(?,?)";
    String UPDATE_SQL ="update AnhChup set Anh=? where Id_HD=?";
    String SELECT_BY_ID_SQL="select*from AnhChup where Id_HD=?";
    
    @Override
    public void insert(Anh entity) {
        try {
            JDBCHelper.update(INSERT_SQL, entity.getId_HD(),entity.getAnh());
        } catch (SQLException ex) {
            Logger.getLogger(AnhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Anh entity) {
        try {
            JDBCHelper.update(UPDATE_SQL, entity.getAnh(),entity.getId_HD());
        } catch (SQLException ex) {
            Logger.getLogger(AnhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Anh selectById(String id) {
       List<Anh> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public List<Anh> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Anh> selectBySql(String sql, Object... args) {
         List<Anh> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
               Anh entity = new Anh();
               entity.setId_HD(rs.getInt("Id_HD"));
               entity.setAnh(rs.getString("Anh"));
               list.add(entity);

            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
