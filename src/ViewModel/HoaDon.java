/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import DomainModel.D_KhachHang;
import DomainModel.D_NhanVien;
import DomainModel.KhuyenMai;
import java.sql.Date;

/**
 *
 * @author Dell
 */
public class HoaDon {

    private String IdHoaDon;
    private String MaHd;
    private D_KhachHang idKhachHang;
    private D_NhanVien idNhanVien;
    private KhuyenMai idkhuyenmai;
    private Float tongTienHang;
    private Float tienPhaiTra;
    private Float tienKhachDua;
    private Float tienThua;
    private int trangThai;
    private Date NgayTao;

    public HoaDon() {
    }
    
    

    public HoaDon(String IdHoaDon, String MaHd, D_KhachHang idKhachHang, D_NhanVien idNhanVien, KhuyenMai idkhuyenmai, Float tongTienHang, Float tienPhaiTra, Float tienKhachDua, Float tienThua, int trangThai, Date NgayTao) {
        this.IdHoaDon = IdHoaDon;
        this.MaHd = MaHd;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.idkhuyenmai = idkhuyenmai;
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

    public D_KhachHang getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(D_KhachHang idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public D_NhanVien getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(D_NhanVien idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public KhuyenMai getIdkhuyenmai() {
        return idkhuyenmai;
    }

    public void setIdkhuyenmai(KhuyenMai idkhuyenmai) {
        this.idkhuyenmai = idkhuyenmai;
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
