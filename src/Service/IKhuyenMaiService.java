/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.D_KhuyenMai;
import ViewModel.KhuyenMai_View;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IKhuyenMaiService {

    List<KhuyenMai_View> getall();
    
    KhuyenMai_View getGt(String ma);

    boolean insert(KhuyenMai_View km);

    boolean update(KhuyenMai_View km);

    boolean delete(KhuyenMai_View km);

}
