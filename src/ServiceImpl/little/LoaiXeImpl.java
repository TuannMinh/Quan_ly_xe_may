/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl.little;

import DomainModel.D_LoaiXe;
import Responstory.Little.R_LoaiXe;
import Service.Little.LoaiXeService;
import Service.Little.MauService;
import ViewModel.VM_LoaiXe;
import java.util.ArrayList;
import java.util.List;


public class LoaiXeImpl implements LoaiXeService {

     private final R_LoaiXe RXL;

    public LoaiXeImpl() {
        this.RXL = new R_LoaiXe();
    }
    
    @Override
    public List<D_LoaiXe> getAll() {
    return RXL.getAllLX();
    }

    @Override
    public List<VM_LoaiXe> getAllLX() {
         List<VM_LoaiXe> list = new ArrayList<>();
        for (D_LoaiXe x : RXL.getAllLX()) {
            VM_LoaiXe v = new VM_LoaiXe(x.getId(),x.getLaoiXe());
            list.add(v);
        }
        return list;
    }

    @Override
    public boolean add(VM_LoaiXe vds) {
        D_LoaiXe d = new D_LoaiXe(vds.getId(),vds.getLaoiXe());
       return RXL.add(d);
    }

    @Override
    public Integer update(VM_LoaiXe vds) {
        D_LoaiXe d = new D_LoaiXe(vds.getId(),vds.getLaoiXe());
       return RXL.update(d);
    }

    @Override
    public Integer delete(VM_LoaiXe vds) {
        D_LoaiXe d = new D_LoaiXe(vds.getId(),vds.getLaoiXe());
       return RXL.delete(d);
    }

    @Override
    public D_LoaiXe getOne(String ma) {
    return RXL.getOne(ma);
    }

  
}
