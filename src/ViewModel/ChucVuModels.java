/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author Admin
 */
public class ChucVuModels {
        private String iD;
    private String ten;

    public ChucVuModels() {
    }

    public ChucVuModels(String iD, String ten) {
        this.iD = iD;
        this.ten = ten;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
     public Object[] rowData() {
        return new Object[]{iD,ten};
    } 
    
}
