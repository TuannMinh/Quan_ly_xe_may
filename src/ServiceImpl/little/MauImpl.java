/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl.little;

import DomainModel.D_Mau;
import Responstory.Little.R_Mau;
import Service.Little.MauService;
import ViewModel.VM_Mau;
import ViewModel.VM_Mau;
import java.util.ArrayList;
import java.util.List;


public class MauImpl implements MauService {

     private final R_Mau RXL;

    public MauImpl() {
        this.RXL = new R_Mau();
    }
    
    @Override
    public List<D_Mau> getAll() {
    return RXL.getAllMau();  
    }

    @Override
    public List<VM_Mau> getAllMau() {
            List<VM_Mau> list = new ArrayList<>();
        for (D_Mau x : RXL.getAllMau()) {
            VM_Mau v = new VM_Mau(x.getId(),x.getMau());
            list.add(v);
        }
        return list;
    }

    @Override
    public boolean add(VM_Mau vds) {
       D_Mau d = new D_Mau(vds.getId(),vds.getMau());
       return RXL.add(d);
    }

    @Override
    public Integer update(VM_Mau vds) {
       D_Mau d = new D_Mau(vds.getId(),vds.getMau());
       return RXL.update(d);
    }

    @Override
    public Integer delete(VM_Mau vds) {
        D_Mau d = new D_Mau(vds.getId(),vds.getMau());
       return RXL.delete(d);
    }

    @Override
    public D_Mau getOne(String ma) {
       return RXL.getOne(ma);
    }

 
}
