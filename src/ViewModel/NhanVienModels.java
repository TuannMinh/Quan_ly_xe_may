/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NhanVienModels {
    
     private String maNV;
    private String tenNV;
    private String diaChi;
    private int gioiTinh;
    private Date ngaySinh;
    private String sdt ;
    private String email;
    private String hinhAnh;
    private int trangThai;
   private String idtk;

    public NhanVienModels() {
    }

    public NhanVienModels(String maNV, String tenNV, String diaChi, int gioiTinh, Date ngaySinh, String sdt, String email, String hinhAnh, int trangThai, String idtk) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
        this.idtk = idtk;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
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
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdtk() {
        return idtk;
    }

    public void setIdtk(String idtk) {
        this.idtk = idtk;
    }
    public String gt(int gioiTinh){
        if(gioiTinh ==1){
            return "Nam";
        }else return "Nữ";
    }
    public String tt(int tt){
        if(tt==1){
            return "ĐangHD";
        }else return "ĐãNghỉ";
    }
   
   public Object[] rowData() {
        return new Object[]{maNV,tenNV,diaChi,gt(gioiTinh),tt(trangThai)};
    } 
    
}
