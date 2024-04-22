/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl.little;

import DomainModel.D_DTXiLanh;
import Responstory.Little.R_DTXiLanh;
import Service.Little.DTXiLanhService;
import ViewModel.VM_DTXiLanh;
import java.util.ArrayList;
import java.util.List;


public class DTXiLanhImpl implements DTXiLanhService {

     private final R_DTXiLanh RXL;

    public DTXiLanhImpl() {
        this.RXL = new R_DTXiLanh();
    }
    
    @Override
    public List<D_DTXiLanh> getAll() {
    return RXL.getAllDTXL();
    }

    @Override
    public List<VM_DTXiLanh> getAllDongSP() {
       List<VM_DTXiLanh> list = new ArrayList<>();
        for (D_DTXiLanh x : RXL.getAllDTXL()) {
            VM_DTXiLanh v = new VM_DTXiLanh(x.getId(),x.getDTXiLanh());
            list.add(v);
        }
        return list;
    }

    @Override
    public boolean add(VM_DTXiLanh vds) {
     D_DTXiLanh d = new D_DTXiLanh(vds.getId(),vds.getDTXiLanh());
       return RXL.add(d);
    }

    @Override
    public Integer update(VM_DTXiLanh vds) {
     D_DTXiLanh d = new D_DTXiLanh(vds.getId(),vds.getDTXiLanh());
       return RXL.update(d);
    }

    @Override
    public Integer delete(VM_DTXiLanh vds) {
     D_DTXiLanh d = new D_DTXiLanh(vds.getId(),vds.getDTXiLanh());
       return RXL.delete(d);
    }

    @Override
    public D_DTXiLanh getOne(String ma) {
     return RXL.getOne(ma);
    }
    
}
