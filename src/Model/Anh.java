/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author dell
 */
public class Anh {
    int id_HD;
    String anh ;

    public Anh() {
    }

    public Anh(int id_HD, String anh) {
        this.id_HD = id_HD;
        this.anh = anh;
    }

    public int getId_HD() {
        return id_HD;
    }

    public void setId_HD(int id_HD) {
        this.id_HD = id_HD;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
    
}
