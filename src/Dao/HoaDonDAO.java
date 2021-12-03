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
    String SELECT_ALL_SQL = "select * from HoaDon";
    String SELECT_BY_ID_SQL = "select * from HoaDon where Id=?";
    String Insert = "Insert into HoaDon(Id_KH,Id_NV,Id_TC,NgayHen,GioHen,NgayTao,DatCoc,ThanhToan,TrangThaiTT,TrangThai,DanhGia,PhanHoi)"
            + "values(?,?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public void insert(HoaDon entity) {
       try {
            JDBCHelper.update(Insert, entity.getId_KH(),
                    entity.getId_NV(), entity.getId_TC(), entity.getNgayHen(), entity.getGioHen(),
                    entity.getNgayTao(), entity.getDatCoc(), entity.getThanhToan(),
                    entity.getTrangThaiTT(), entity.getTrangThai(), entity.getDanhGia(), entity.getPhanHoi());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                entity.setNgayTao(rs.getDate("NgayTao"));
                entity.setDatCoc(rs.getInt("DatCoc"));
                entity.setThanhToan(rs.getInt("ThanhToan"));
                entity.setDanhGia(rs.getString("DanhGia"));
                entity.setPhanHoi(rs.getString("PhanHoi"));
                entity.setTrangThaiTT(rs.getString("TrangThaiTT"));
                entity.setTrangThai(rs.getString("TrangThai"));
                entity.setGioHen(rs.getString("GioHen"));
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

    public HoaDon SelectHoaDonByGioHen(HoaDon hd) {
        List<HoaDon> list = this.selectBySql("Select * from HoaDon where Id_TC = ? and NgayHen = ? and GioHen = ?", hd.getId_TC(), hd.getNgayHen(), hd.getGioHen());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<Model.HoaDon> SelectHoaDonNguoiDung(String tentk) {
            List<Model.HoaDon> list = this.selectBySql("select * from HoaDon join KhachHang on KhachHang.Id = HoaDon.Id_KH \n" +
"join TaiKhoan on TaiKhoan.Id = KhachHang.Id_TK where HoaDon.TrangThaiTT=N'Đã thanh toán' and TenTK = ?", tentk);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    
    public Model.HoaDon TimKiemHoaDonNguoiDung(String tk, String id) {
        List<Model.HoaDon> ls = this.selectBySql("Select HoaDon.* from HoaDon join KhachHang on KhachHang.Id = HoaDon.Id_KH join TaiKhoan on KhachHang.Id_TK = TaiKhoan.Id where TaiKhoan.TenTK = ? and HoaDon.Id = ? and HoaDon.TrangThaiTT = N'Đã thanh toán'", tk , id);
        if(ls.size() == 0) {
            return null;
        }else {
            return ls.get(0);
        }
    }
    
    
    
    public void InsertHDCT(HoaDon hd, DichVu dv) {
        try {
            JDBCHelper.update("insert into HoaDonChiTiet(Id_DV, Id_HD, GiaTien, TrangThai) values (?,?,?,?)", dv.getId(), hd.getId(), dv.getGiaTien(), hd.getTrangThai());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public HoaDon selectHD_CuoiCung() {
        List<HoaDon> list = this.selectBySql("SELECT TOP 1 * FROM HoaDon ORDER BY Id DESC ");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public List<HoaDon> SelectByThoCat(int id) {
        return this.selectBySql("Select * from HoaDon where Id_TC = ? and TrangThaiTT = ?", id, "Chưa thanh toán");
    }

}
