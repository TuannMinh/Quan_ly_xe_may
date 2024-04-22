/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author Dell
 */
public class CTHoaDon {

    private String id;
    private VM_ChiTietSanPham idCtsp;
    private HoaDonMODEL idHoaDon;
    private KhuyenMai_View idKhuyenMai;
    private int soLuong;
    private int trangThai;

    public CTHoaDon() {
    }

    public CTHoaDon(String id, VM_ChiTietSanPham idCtsp, HoaDonMODEL idHoaDon, KhuyenMai_View idKhuyenMai, int soLuong, int trangThai) {
        this.id = id;
        this.idCtsp = idCtsp;
        this.idHoaDon = idHoaDon;
        this.idKhuyenMai = idKhuyenMai;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VM_ChiTietSanPham getIdCtsp() {
        return idCtsp;
    }

    public void setIdCtsp(VM_ChiTietSanPham idCtsp) {
        this.idCtsp = idCtsp;
    }

    public HoaDonMODEL getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(HoaDonMODEL idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public KhuyenMai_View getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(KhuyenMai_View idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }
    
    
}
