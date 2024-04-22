/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author VietTien
 */
public class VM_ChiTietSanPham {


    
     private String idctsp;
    private VM_DTXiLanh dTXiLanh;
    private VM_DTBinhXang dTBinhXang;
    private VM_Mau Mau;
    private VM_XuatXu xuatXu;
    private VM_LoaiXe loaiXe;
    private VM_SoKhung soKhung;
    private VM_SanPham sanPham;
    private double giaNhap;
    private double giaBan;
    private String hinhAnh;
    private int trangThai;
    private int soLuong;

    public VM_ChiTietSanPham() {
    }

    public VM_ChiTietSanPham(String idctsp, VM_DTXiLanh dTXiLanh, VM_DTBinhXang dTBinhXang, VM_Mau Mau, VM_XuatXu xuatXu, VM_LoaiXe loaiXe, VM_SoKhung soKhung, VM_SanPham sanPham, double giaNhap, double giaBan, String hinhAnh, int trangThai, int soLuong) {
        this.idctsp = idctsp;
        this.dTXiLanh = dTXiLanh;
        this.dTBinhXang = dTBinhXang;
        this.Mau = Mau;
        this.xuatXu = xuatXu;
        this.loaiXe = loaiXe;
        this.soKhung = soKhung;
        this.sanPham = sanPham;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
    }

    public String getIdctsp() {
        return idctsp;
    }

    public void setIdctsp(String idctsp) {
        this.idctsp = idctsp;
    }

    public VM_DTXiLanh getdTXiLanh() {
        return dTXiLanh;
    }

    public void setdTXiLanh(VM_DTXiLanh dTXiLanh) {
        this.dTXiLanh = dTXiLanh;
    }

    public VM_DTBinhXang getdTBinhXang() {
        return dTBinhXang;
    }

    public void setdTBinhXang(VM_DTBinhXang dTBinhXang) {
        this.dTBinhXang = dTBinhXang;
    }

    public VM_Mau getMau() {
        return Mau;
    }

    public void setMau(VM_Mau Mau) {
        this.Mau = Mau;
    }

    public VM_XuatXu getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(VM_XuatXu xuatXu) {
        this.xuatXu = xuatXu;
    }

    public VM_LoaiXe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(VM_LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }

    public VM_SoKhung getSoKhung() {
        return soKhung;
    }

    public void setSoKhung(VM_SoKhung soKhung) {
        this.soKhung = soKhung;
    }

    public VM_SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(VM_SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

   
}
