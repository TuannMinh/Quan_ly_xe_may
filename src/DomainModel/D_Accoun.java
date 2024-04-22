/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author Admin
 */
public class D_Accoun {
    private String idtk;
    private String manv;
    private String username;
    private String passwword;
    private String idchucVu;

    public D_Accoun() {
    }

    public D_Accoun(String idtk, String manv, String username, String passwword, String idchucVu) {
        this.idtk = idtk;
        this.manv = manv;
        this.username = username;
        this.passwword = passwword;
        this.idchucVu = idchucVu;
    }

    public String getIdtk() {
        return idtk;
    }

    public void setIdtk(String idtk) {
        this.idtk = idtk;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswword() {
        return passwword;
    }

    public void setPasswword(String passwword) {
        this.passwword = passwword;
    }

    public String getIdchucVu() {
        return idchucVu;
    }

    public void setIdchucVu(String idchucVu) {
        this.idchucVu = idchucVu;
    }
    
}
