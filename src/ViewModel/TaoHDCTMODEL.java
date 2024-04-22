/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author ADMIN
 */
public class TaoHDCTMODEL {
    private  String id;
    private String idsp;
    private String idhd;
    private String idsk;
    private String idkm;
    private int slmua;
    private int trangthai;

    public TaoHDCTMODEL() {
    }

    public TaoHDCTMODEL(String id, String idsp, String idhd, String idsk, String idkm, int slmua, int trangthai) {
        this.id = id;
        this.idsp = idsp;
        this.idhd = idhd;
        this.idsk = idsk;
        this.idkm = idkm;
        this.slmua = slmua;
        this.trangthai = trangthai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdsp() {
        return idsp;
    }

    public void setIdsp(String idsp) {
        this.idsp = idsp;
    }

    public String getIdhd() {
        return idhd;
    }

    public void setIdhd(String idhd) {
        this.idhd = idhd;
    }

    public String getIdsk() {
        return idsk;
    }

    public void setIdsk(String idsk) {
        this.idsk = idsk;
    }

    public String getIdkm() {
        return idkm;
    }

    public void setIdkm(String idkm) {
        this.idkm = idkm;
    }

    public int getSlmua() {
        return slmua;
    }

    public void setSlmua(int slmua) {
        this.slmua = slmua;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
    
}
