/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author Dell
 */
public class CTHoaDonNT {

    private String ngayTao;
    private double doanhThu;

    public CTHoaDonNT(String ngayTao, double doanhThu) {
        this.ngayTao = ngayTao;
        this.doanhThu = doanhThu;
    }

    public CTHoaDonNT() {
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }
    

    
    
}
