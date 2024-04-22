/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl.little;

import DomainModel.D_XuatXu;
import Responstory.Little.R_XuatXu;
import Service.Little.XuatXuService;
import ViewModel.VM_XuatXu;
import java.util.ArrayList;
import java.util.List;


public class XuatXuImpl implements XuatXuService {

     private final R_XuatXu RXL;

    public XuatXuImpl() {
        this.RXL = new R_XuatXu();
    }
    
    @Override
    public List<D_XuatXu> getAll() {
    return RXL.getAllXX();
    
    }

    @Override
    public List<VM_XuatXu> getAllXuatXu() {
    List<VM_XuatXu> list = new ArrayList<>();
        for (D_XuatXu x : RXL.getAllXX()) {
            VM_XuatXu v = new VM_XuatXu(x.getId(),x.getXuatXu());
            list.add(v);
        }
        return list;
    }

    @Override
    public boolean add(VM_XuatXu vds) {
    D_XuatXu d = new D_XuatXu(vds.getId(),vds.getXuatXu());
       return RXL.add(d);
    }

    @Override
    public Integer update(VM_XuatXu vds) {
       D_XuatXu d = new D_XuatXu(vds.getId(),vds.getXuatXu());
       return RXL.update(d);
    }

    @Override
    public Integer delete(VM_XuatXu vds) {
      D_XuatXu d = new D_XuatXu(vds.getId(),vds.getXuatXu());
       return RXL.delete(d);
    }

    @Override
    public D_XuatXu getOne(String ma) {
       return RXL.getOne(ma);
    }

   
}
