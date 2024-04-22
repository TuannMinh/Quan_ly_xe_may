/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModel.TaoHoaDonModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface TaoHoaDonServices {
    public List<TaoHoaDonModel> getListhd(int index);
     void them(TaoHoaDonModel nv);
     public List<TaoHoaDonModel> getListhdall();
}
