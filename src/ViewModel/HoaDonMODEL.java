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
public class HoaDonMODEL {
    private String IdHoaDon;
    private String MaHd;
    private String idKH;
    private String idNv;
    private String idKhuyenMai;
 private Float tongTienHang;
    private Float tienPhaiTra;
    private Float tienKhachDua;
    private Float tienThua;
    private int trangThai;
    private Date NgayTao;

    public HoaDonMODEL() {
    }

    public HoaDonMODEL(String IdHoaDon, String MaHd, String idKH, String idNv, String idKhuyenMai, Float tongTienHang, Float tienPhaiTra, Float tienKhachDua, Float tienThua, int trangThai, Date NgayTao) {
        this.IdHoaDon = IdHoaDon;
        this.MaHd = MaHd;
        this.idKH = idKH;
        this.idNv = idNv;
        this.idKhuyenMai = idKhuyenMai;
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

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdNv() {
        return idNv;
    }

    public void setIdNv(String idNv) {
        this.idNv = idNv;
    }

    public String getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(String idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
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
