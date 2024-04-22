/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import DomainModel.D_ChucVu;
import Responstory.ChucVuResponstory;
import Service.ChucVuService;
import ViewModel.ChucVuModels;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Admin
 */
public class ChucVuImpl implements ChucVuService{
         ChucVuResponstory rs = new ChucVuResponstory();
    @Override
    public List<ChucVuModels> getAll() {
        List<ChucVuModels> list = new ArrayList<>();
        List<D_ChucVu> ds = rs.getAll();
         for (D_ChucVu d : ds) {
             ChucVuModels qltb = new ChucVuModels(d.getiD(), d.getTen());
            list.add(qltb);
        }
         return list;
       }

    @Override
    public void them(ChucVuModels cv) {
        D_ChucVu them = new D_ChucVu("",cv.getTen());
        rs.them(them);
        }

    @Override
    public void sua(ChucVuModels cv, String id) {
        D_ChucVu them = new D_ChucVu("",cv.getTen());
        rs.sua(them, id);
         }
    
}
