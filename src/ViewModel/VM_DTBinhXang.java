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
public class VM_DTBinhXang {
    private String id;
    private String DTBinhXang;

    public VM_DTBinhXang() {
    }

    public VM_DTBinhXang(String id, String DTBinhXang) {
        this.id = id;
        this.DTBinhXang = DTBinhXang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDTBinhXang() {
        return DTBinhXang;
    }

    public void setDTBinhXang(String DTBinhXang) {
        this.DTBinhXang = DTBinhXang;
    }

   
}
