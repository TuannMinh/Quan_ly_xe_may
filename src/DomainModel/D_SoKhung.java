/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author VietTien
 */
public class D_SoKhung {

    private String id;
    private D_SanPhamBig ctsp;
    private String SoKhung;
    private int trangThai;

    public D_SoKhung() {
    }

    public D_SoKhung(String id, D_SanPhamBig ctsp, String SoKhung, int trangThai) {
        this.id = id;
        this.ctsp = ctsp;
        this.SoKhung = SoKhung;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public D_SanPhamBig getCtsp() {
        return ctsp;
    }

    public void setCtsp(D_SanPhamBig ctsp) {
        this.ctsp = ctsp;
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
