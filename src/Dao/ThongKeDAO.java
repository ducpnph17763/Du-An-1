/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Helper.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class ThongKeDAO {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getDoanhThu(Integer nam) {

        String sql = "{CALL sp_ThongKeDoanhThu(?)}";
        String[] cols = {"Tháng", "Số hóa đơn", "Doanh thu"};
        return getListOfArray(sql, cols, nam);
    }

    public List<Object[]> getDoanhSo(Integer nam) {

        String sql = "{CALL sp_ThongKeDoanhSoDichVu(?)}";
        String[] cols = {"Mã dịch vụ", "Số lần sử dụng", "Doanh thu"};
        return getListOfArray(sql, cols, nam);
    }
}
