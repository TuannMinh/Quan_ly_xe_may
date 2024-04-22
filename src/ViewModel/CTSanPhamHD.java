/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author Dell
 */
public class CTSanPhamHD {
    private String maSP;
    private int soLuong;

    public CTSanPhamHD() {
    }

    public CTSanPhamHD(String maSP, int soLuong) {
        this.maSP = maSP;
        this.soLuong = soLuong;
    }
    
    

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
