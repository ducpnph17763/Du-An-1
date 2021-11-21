/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class JDBCHelper {
     static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String dburl="jdbc:sqlserver://localhost:1433;databaseName=DATLICHCATTOC";
    static String user="sa";
    static String pass="12345";
    Connection conn;
    static{
        try {
            Class.forName(driver);
        } catch (Exception e){
        }
    }
    
    public static PreparedStatement getStmt(String sql,Object...args) throws SQLException{
        Connection conn=DriverManager.getConnection(dburl,user,pass);
        PreparedStatement pstm;
        if(sql.trim().startsWith("{")){
            pstm=conn.prepareCall(sql);
        }else{
            pstm=conn.prepareStatement(sql);
        }
        
        for (int i = 0; i < args.length; i++) {
            pstm.setObject(i+1, args[i]);
        }
        return pstm;
    }
    
    public static int update(String sql,Object...args) throws SQLException {
        try{ 
              PreparedStatement pstm=JDBCHelper.getStmt(sql, args);
            try {
                return pstm.executeUpdate();
            } finally {
                pstm.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
      
        
    }
    
    public static ResultSet query(String sql,Object...args){
        try {
            PreparedStatement pstm=JDBCHelper.getStmt(sql, args);
            try {
                return pstm.executeQuery();
            } finally{
                
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
      public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL){
        try {
            
            Statement stmt = conn.createStatement();           
            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
            
        return null;
    }
    
    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void ExcuteQueryUpdateDB(String cauTruyVanSQL) throws SQLException{
       Connection conn=DriverManager.getConnection(dburl,user,pass);
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(cauTruyVanSQL);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
