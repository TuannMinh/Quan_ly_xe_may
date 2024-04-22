/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Responstory.BanHangReponstory;
import Service.SanPhamService;
import ViewModel.SanPhamModels;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamImpl implements SanPhamService{
    BanHangReponstory rs = new BanHangReponstory();

    @Override
    public List<String> dskh() {
     return rs.layDsKhachHang();
    }

    
    
}
