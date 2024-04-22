/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;
import DomainModel.D_KhachHang;
import java.util.List;
/**
 *
 * @author Dell
 */
public interface KhachHangService {

    public List<D_KhachHang> getAll();

    public boolean insert(D_KhachHang kh);

    public boolean update(String maKH, D_KhachHang kh);

    public boolean delete(String maKh);
    
    public List<D_KhachHang> search(String hoTen);
    
    public D_KhachHang one(String hoTen);
}
