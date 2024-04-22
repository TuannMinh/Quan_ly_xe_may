/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class TaoHoaDonModel {
     private String id;
    private String maHd;
    private String maNV;
    private String tenkh;
    private Date ngayTao;
    private int trangThai;

    public TaoHoaDonModel() {
    }

    public TaoHoaDonModel(String id, String maHd, String maNV, String tenkh, Date ngayTao, int trangThai) {
        this.id = id;
        this.maHd = maHd;
        this.maNV = maNV;
        this.tenkh = tenkh;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaHd() {
        return maHd;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

 
     public String loadTinhTrang() {
        if (trangThai== 1) {
            return "Đã thanh toán";
        } else {
            return "Chưa thanh toán";
        }
    }
    
}
