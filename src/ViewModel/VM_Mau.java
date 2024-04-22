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
public class VM_Mau {

    private String id;
    private String Mau;

    public VM_Mau() {
    }

    public VM_Mau(String id, String Mau) {
        this.id = id;
        this.Mau = Mau;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMau() {
        return Mau;
    }

    public void setMau(String Mau) {
        this.Mau = Mau;
    }

}
