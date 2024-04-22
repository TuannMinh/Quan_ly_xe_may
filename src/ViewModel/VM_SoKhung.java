/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import DomainModel.*;

/**
 *
 * @author VietTien
 */
public class VM_SoKhung {
    private String id;
    private D_SanPhamBig idctsp;
    private String SoKhung;
    private int trangThai;

    public VM_SoKhung() {
    }

    public VM_SoKhung(String id, D_SanPhamBig idctsp, String SoKhung, int trangThai) {
        this.id = id;
        this.idctsp = idctsp;
        this.SoKhung = SoKhung;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public D_SanPhamBig getIdctsp() {
        return idctsp;
    }

    public void setIdctsp(D_SanPhamBig idctsp) {
        this.idctsp = idctsp;
    }

    public String getSoKhung() {
        return SoKhung;
    }

    public void setSoKhung(String SoKhung) {
        this.SoKhung = SoKhung;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
}
