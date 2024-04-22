/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class D_KhachHang {
    private String idKH;
    private String maKH;
    private String hoTen;
    private String diaChi;
    private int gioiTinh;
    private String sdt;
    private float soTienDaChi;

    public D_KhachHang() {
    }

    public D_KhachHang(String idKH, String maKH, String hoTen, String diaChi, int gioiTinh, String sdt, float soTienDaChi) {
        this.idKH = idKH;
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.soTienDaChi = soTienDaChi;
    }

    public D_KhachHang(String idKH, String maKH, String hoTen, String diaChi, int gioiTinh, String sdt) {
        this.idKH = idKH;
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
    }
    
    

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public float getSoTienDaChi() {
        return soTienDaChi;
    }

    public void setSoTienDaChi(float soTienDaChi) {
        this.soTienDaChi = soTienDaChi;
    }
    
    
    public D_KhachHang(String maKH, String hoTen, String diaChi, int gioiTinh, String sdt) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
    }

    public D_KhachHang(String idKH) {
        this.idKH = idKH;
    }

}
