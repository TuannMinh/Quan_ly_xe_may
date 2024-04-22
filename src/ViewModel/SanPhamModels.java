/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author Admin
 */
public class SanPhamModels {
   private String id;
   private String maSp;
   private String tenSp;
   private String Sl;
   private int sx;

    public SanPhamModels() {
    }

    public SanPhamModels(String id, String maSp, String tenSp, String Sl, int sx) {
        this.id = id;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.Sl = Sl;
        this.sx = sx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getSl() {
        return Sl;
    }

    public void setSl(String Sl) {
        this.Sl = Sl;
    }

    public int getSx() {
        return sx;
    }

    public void setSx(int sx) {
        this.sx = sx;
    }
    
   public Object[] rowData() {
        return new Object[]{maSp,tenSp,Sl,sx};
    } 
      
}
