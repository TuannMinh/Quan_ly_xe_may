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
public class VM_DTXiLanh {

    private String id;

    private String DTXiLanh;

    public VM_DTXiLanh() {
    }

    public VM_DTXiLanh(String id, String DTXiLanh) {
        this.id = id;
        this.DTXiLanh = DTXiLanh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDTXiLanh() {
        return DTXiLanh;
    }

    public void setDTXiLanh(String DTXiLanh) {
        this.DTXiLanh = DTXiLanh;
    }


}
