/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author VietTien
 */
public class D_DTXiLanh {

    private String id;
    private String DTXiLanh;

    public D_DTXiLanh() {
    }

    public D_DTXiLanh(String DTXiLanh) {
        this.DTXiLanh = DTXiLanh;
    }

    public D_DTXiLanh(String id, String DTXiLanh) {
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
