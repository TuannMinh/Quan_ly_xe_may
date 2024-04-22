/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NhanVienTTCT {
    private String manv;
    private String tenNV;
    private String diaChi;
    private int GioiTinh;
    private Date ngaySinh;
    private String Sdt;
    private String email;
    private  int trangThai;
    private String username;
   private String passwword;
   private String chucVu;

    public NhanVienTTCT() {
    }

    public NhanVienTTCT(String manv, String tenNV, String diaChi, int GioiTinh, Date ngaySinh, String Sdt, String email, int trangThai, String username, String passwword, String chucVu) {
        this.manv = manv;
        this.tenNV = tenNV;
        this.diaChi = diaChi;
        this.GioiTinh = GioiTinh;
        this.ngaySinh = ngaySinh;
        this.Sdt = Sdt;
        this.email = email;
        this.trangThai = trangThai;
        this.username = username;
        this.passwword = passwword;
        this.chucVu = chucVu;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswword() {
        return passwword;
    }

    public void setPasswword(String passwword) {
        this.passwword = passwword;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
   
    
}
