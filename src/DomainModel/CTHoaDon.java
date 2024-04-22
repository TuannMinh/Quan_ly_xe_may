/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import ViewModel.*;

/**
 *
 * @author Dell
 */
public class CTHoaDon {

    private String id;
    private String idCtsp;
    private String idHoaDon;
    private int SLMua;
    private int trangThai;

    public CTHoaDon() {
    }

    public CTHoaDon(String id, String idCtsp, String idHoaDon, int SLMua, int trangThai) {
        this.id = id;
        this.idCtsp = idCtsp;
        this.idHoaDon = idHoaDon;
        this.SLMua = SLMua;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCtsp() {
        return idCtsp;
    }

    public void setIdCtsp(String idCtsp) {
        this.idCtsp = idCtsp;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getSLMua() {
        return SLMua;
    }

    public void setSLMua(int SLMua) {
        this.SLMua = SLMua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
    
    
}
