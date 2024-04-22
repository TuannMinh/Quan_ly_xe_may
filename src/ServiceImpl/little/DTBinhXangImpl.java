/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl.little;

import DomainModel.D_DTBinhXang;
import Responstory.Little.R_DTBinhXang;
import Service.Little.DTBinhXangService;
import ViewModel.VM_DTBinhXang;
import java.util.ArrayList;
import java.util.List;


public class DTBinhXangImpl implements DTBinhXangService {

     private  R_DTBinhXang RXL = new R_DTBinhXang();

    public DTBinhXangImpl() {
        this.RXL = new R_DTBinhXang();
    }
    
    @Override
    public List<D_DTBinhXang> getAll() {
    return RXL.getAllDTBX();
    }



    @Override
    public List<D_DTBinhXang> getAllBX() {
    
        return RXL.getAllDTBX();
    }

    @Override
    public boolean add(D_DTBinhXang vds) {
    
       return RXL.add(vds);
    }

    @Override
    public Integer update(D_DTBinhXang vds) {
     return RXL.update(vds);
    }

    @Override
    public Integer delete(D_DTBinhXang vds) {
      return RXL.delete(vds);
    }

    @Override
    public D_DTBinhXang getOne(String ma) {
        return RXL.getOne(ma);
    }
    
}
