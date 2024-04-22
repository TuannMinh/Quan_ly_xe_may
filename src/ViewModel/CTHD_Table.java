/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

public class CTHD_Table {

    private String idcthd;
    private String maSP;
    private String tenSP;
    private String namSX;
    private String mauSac;
    private Float giaBan;
    private String soKhung;
    private int trangThai;

    public CTHD_Table() {
    }

    public CTHD_Table(String idcthd, String maSP, String tenSP, String namSX, String mauSac, Float giaBan, String soKhung, int trangThai) {
        this.idcthd = idcthd;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.namSX = namSX;
        this.mauSac = mauSac;
        this.giaBan = giaBan;
        this.soKhung = soKhung;
        this.trangThai = trangThai;
    }

    public String getIdcthd() {
        return idcthd;
    }

    public void setIdcthd(String idcthd) {
        this.idcthd = idcthd;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getNamSX() {
        return namSX;
    }

    public void setNamSX(String namSX) {
        this.namSX = namSX;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public Float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Float giaBan) {
        this.giaBan = giaBan;
    }

    public String getSoKhung() {
        return soKhung;
    }

    public void setSoKhung(String soKhung) {
        this.soKhung = soKhung;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

   

}
