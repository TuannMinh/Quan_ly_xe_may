/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhuyenMai {

    private String idkm;
    private String maKH;
    private String tenKH;
    private int loaiKhuyenMai;
    private Date thoiGianKM;
    private Date thoiGianKT;
    private int giaTri;
    private int trangThai;
    private int soLuong;

    public KhuyenMai() {
    }

    public KhuyenMai(String idkm, String maKH, String tenKH, int loaiKhuyenMai, Date thoiGianKM, Date thoiGianKT, int giaTri, int trangThai, int soLuong) {
        this.idkm = idkm;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.loaiKhuyenMai = loaiKhuyenMai;
        this.thoiGianKM = thoiGianKM;
        this.thoiGianKT = thoiGianKT;
        this.giaTri = giaTri;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
    }

    public String getIdkm() {
        return idkm;
    }

    public void setIdkm(String idkm) {
        this.idkm = idkm;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getLoaiKhuyenMai() {
        return loaiKhuyenMai;
    }

    public void setLoaiKhuyenMai(int loaiKhuyenMai) {
        this.loaiKhuyenMai = loaiKhuyenMai;
    }

    public Date getThoiGianKM() {
        return thoiGianKM;
    }

    public void setThoiGianKM(Date thoiGianKM) {
        this.thoiGianKM = thoiGianKM;
    }

    public Date getThoiGianKT() {
        return thoiGianKT;
    }

    public void setThoiGianKT(Date thoiGianKT) {
        this.thoiGianKT = thoiGianKT;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

  

}
