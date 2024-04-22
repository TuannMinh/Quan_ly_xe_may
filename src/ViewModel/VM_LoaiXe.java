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
public class VM_LoaiXe {

    private String id;
    private String loaiXe;

    public VM_LoaiXe() {
    }

    public VM_LoaiXe(String id, String laoiXe) {
        this.id = id;
        this.loaiXe = laoiXe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLaoiXe() {
        return loaiXe;
    }

    public void setLaoiXe(String laoiXe) {
        this.loaiXe = laoiXe;
    }

}
