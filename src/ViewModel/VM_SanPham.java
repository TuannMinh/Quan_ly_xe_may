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
public class VM_SanPham {

    private String id;
    private String maSP;
    private String tenSP;
    private int namSX;

    public VM_SanPham() {
    }

    public VM_SanPham(String id, String maSP, String tenSP, int namSX) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.namSX = namSX;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

  

}
