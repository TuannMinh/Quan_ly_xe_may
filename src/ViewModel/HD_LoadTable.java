/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author VietTien
 */
public class HD_LoadTable {

    private String IdHoaDon;
    private String MaHd;
    private String tenKH;
    private String Sdt;
    private String TenNV;
    private String NgaySinh;
    private String maKhuyenMai;
    private String giTri;
    private Float tongTienHang;
    private Float tienPhaiTra;
    private Float tienKhachDua;
    private Float tienThua;
    private int trangThai;
    private Date NgayTao;

    public HD_LoadTable() {
    }

    public HD_LoadTable(String IdHoaDon, String MaHd, String tenKH, String Sdt, String TenNV, String NgaySinh, String maKhuyenMai, String giTri, Float tongTienHang, Float tienPhaiTra, Float tienKhachDua, Float tienThua, int trangThai, Date NgayTao) {
        this.IdHoaDon = IdHoaDon;
        this.MaHd = MaHd;
        this.tenKH = tenKH;
        this.Sdt = Sdt;
        this.TenNV = TenNV;
        this.NgaySinh = NgaySinh;
        this.maKhuyenMai = maKhuyenMai;
        this.giTri = giTri;
        this.tongTienHang = tongTienHang;
        this.tienPhaiTra = tienPhaiTra;
        this.tienKhachDua = tienKhachDua;
        this.tienThua = tienThua;
        this.trangThai = trangThai;
        this.NgayTao = NgayTao;
    }

    public String getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(String IdHoaDon) {
        this.IdHoaDon = IdHoaDon;
    }

    public String getMaHd() {
        return MaHd;
    }

    public void setMaHd(String MaHd) {
        this.MaHd = MaHd;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getGiTri() {
        return giTri;
    }

    public void setGiTri(String giTri) {
        this.giTri = giTri;
    }

    public Float getTongTienHang() {
        return tongTienHang;
    }

    public void setTongTienHang(Float tongTienHang) {
        this.tongTienHang = tongTienHang;
    }

    public Float getTienPhaiTra() {
        return tienPhaiTra;
    }

    public void setTienPhaiTra(Float tienPhaiTra) {
        this.tienPhaiTra = tienPhaiTra;
    }

    public Float getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(Float tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public Float getTienThua() {
        return tienThua;
    }

    public void setTienThua(Float tienThua) {
        this.tienThua = tienThua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    
    
}
