/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Helper.JDBCHelper;
import Model.KhachHang;
import Model.NhanVien;
import Model.TaiKhoan;
import Model.ThongTinKhachHang;
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

    String INSERT_SQL = "INSERT INTO TaiKhoan(TenTK,MatKhau,VaiTro,TrangThai,Hinh) values(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE TaiKhoan set MatKhau=?,TrangThai=? where TenTK=?";
    String DELETE_SQL = "DELETE FROM TaiKhoan Where TenTK=?";
    String SELECT_ALL_SQL = "SELECT * FROM TaiKhoan";
    String SELECT_BY_ID_SQL = "SELECT * FROM TaiKhoan where Id=?";
    String SELECT_BY_tenTK = "Select * form TaiKhoan where tenTK = ?";
    String SELECT_BY_MATKHAU = " Select * from TaiKhoan where MATKHAU=?";
    String INSERT_KH_SQL = "INSERT INTO KhachHang (HoTen)" + "values(?)";
    String INSERT_TT_KH_SQL = "INSERT INTO ThongTinKhachHang (Id_KH,SoDienThoai,Email)" + "values(?,?,?)";
    String UPDATE_ANH = "update TaiKhoan set hinh = ? where TenTK = ?";

    public void setHinh(TaiKhoan entity) {
        try {
            JDBCHelper.update(UPDATE_ANH, entity.getHinh(), entity.getTenTK()
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public TaiKhoan getTenTKKH(String email) {
        String sql1 = "Select x.* from TaiKhoan x join KhachHang y on x.Id=y.Id_TK join ThongTinKhachHang z on y.Id=z.Id_KH where z.Email=?";
        List<TaiKhoan> list = this.selectBySql(sql1, email);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public TaiKhoan getTenTKNV(String email) {
        String sql1 = "Select x.* from TaiKhoan x join NhanVien y on x.Id=y.Id_TK where y.Email=?";
        List<TaiKhoan> list = this.selectBySql(sql1, email);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

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
            JDBCHelper.update(INSERT_SQL, entity.getTenTK(), entity.getMatKhau(), entity.getVaiTro(), entity.getTrangThai(), entity.getHinh()
            );
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(TaiKhoan entity) {
        try {
            JDBCHelper.update(
                    "update TaiKhoan set MatKhau = ? where TenTK = ?", entity.getMatKhau(),
                    entity.getTenTK()
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public TaiKhoan selectById(Object id) {
        List<TaiKhoan> list = this.selectBySql(SELECT_BY_ID_SQL, id);
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

    public void insertKH(KhachHang entity) {
        try {
            JDBCHelper.update(INSERT_KH_SQL, entity.getId_tk(), entity.getHoTen());
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertTTKH(ThongTinKhachHang entity) {
        try {
            JDBCHelper.update(INSERT_TT_KH_SQL, entity.getIdKH(), entity.getSdt(), entity.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TaiKhoan selectByTenTK(Object id) {
        List<TaiKhoan> list = this.selectBySql(SELECT_BY_tenTK);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<TaiKhoan> selectByVaiTro(int vaiTro, String tenTK) {
        String sql = "SELECT*FROM TaiKhoan where VaiTro=? and TenTK=?";
        return this.selectBySql(sql, vaiTro, tenTK);
    }

//    public List<TaiKhoan> selectByIdNv(int idNV){
//        String sql = "SELECT TAIKHOAN.ID,TENTK,MATKHAU,TAIKHOAN.TRANGTHAI FROM TAIKHOAN JOIN NHANVIEN ON TAIKHOAN.ID = NHANVIEN.ID_TK WHERE NHANVIEN.ID=?";
//        return  this.selectBySql(sql, idNV);
//    }
    String sql = "SELECT * FROM TAIKHOAN where ID=?";

    public TaiKhoan selectByIdNv(int idNV) {
        List<TaiKhoan> list = this.selectBySql(sql, idNV);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteTK(String tenTK) {
        try {
            JDBCHelper.update(DELETE_SQL, tenTK);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTK(String tenTK) throws SQLException {
        String sql = "UPDATE TaiKhoan SET TrangThai = 'Không hoạt động' WHERE TenTK = ?";
        JDBCHelper.update(sql, tenTK);
    }

    public void updateByTenTK(TaiKhoan entity) {
        try {
            JDBCHelper.update(UPDATE_SQL, entity.getMatKhau(), entity.getTrangThai(), entity.getTenTK()
            );
        } catch (SQLException ex) {
//            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public void updateByTK(String tenTK, String matKhau, String Trangthai) throws SQLException {
        String sql = "UPDATE TaiKhoan set MatKhau=?,TrangThai=? where TenTK=?";
        JDBCHelper.update(sql, matKhau, Trangthai, tenTK);
    }
}
