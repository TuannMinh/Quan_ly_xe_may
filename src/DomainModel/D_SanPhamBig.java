/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author VietTien
 */
public class D_SanPhamBig {
     private String idSP;
    private String MaSP;
    private String TenSP;
    private D_DTBinhXang dtBinhXang;
    private D_DTXiLanh dTXiLanh;
    private D_Mau mau;
    private D_XuatXu xuatXu;
    private D_LoaiXe loaiXe;
    private int namSX;
    private double giaBan;
    private int trangThai;
    private int soLuong;

    public D_SanPhamBig() {
    }

    public D_SanPhamBig(String idSP, String MaSP, String TenSP, D_DTBinhXang dtBinhXang, D_DTXiLanh dTXiLanh, D_Mau mau, D_XuatXu xuatXu, D_LoaiXe loaiXe, int namSX, double giaBan, int trangThai, int soLuong) {
        this.idSP = idSP;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.dtBinhXang = dtBinhXang;
        this.dTXiLanh = dTXiLanh;
        this.mau = mau;
        this.xuatXu = xuatXu;
        this.loaiXe = loaiXe;
        this.namSX = namSX;
        this.giaBan = giaBan;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public D_DTBinhXang getDtBinhXang() {
        return dtBinhXang;
    }

    public void setDtBinhXang(D_DTBinhXang dtBinhXang) {
        this.dtBinhXang = dtBinhXang;
    }

    public D_DTXiLanh getdTXiLanh() {
        return dTXiLanh;
    }

    public void setdTXiLanh(D_DTXiLanh dTXiLanh) {
        this.dTXiLanh = dTXiLanh;
    }

    public D_Mau getMau() {
        return mau;
    }

    public void setMau(D_Mau mau) {
        this.mau = mau;
    }

    public D_XuatXu getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(D_XuatXu xuatXu) {
        this.xuatXu = xuatXu;
    }

    public D_LoaiXe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(D_LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
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
