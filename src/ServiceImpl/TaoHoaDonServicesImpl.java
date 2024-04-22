/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Responstory.ThemHDReopositories;
import Service.TaoHoaDonServices;
import ViewModel.TaoHoaDonModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TaoHoaDonServicesImpl implements TaoHoaDonServices{
    ThemHDReopositories rs = new ThemHDReopositories();
    @Override
    public List<TaoHoaDonModel> getListhd(int index) {
        return rs.getAll(index);
        }

    @Override
    public void them(TaoHoaDonModel nv) {
        rs.themHD(nv); }

    @Override
    public List<TaoHoaDonModel> getListhdall() {
      return rs.getALLIN();
    }
    
}
