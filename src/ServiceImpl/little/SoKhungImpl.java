/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl.little;

import DomainModel.D_SoKhung;
import Responstory.Little.R_SoKhung;
import Service.Little.SoKhungService;
import ViewModel.VM_SoKhung;
import java.util.ArrayList;
import java.util.List;


public class SoKhungImpl implements SoKhungService {

     private final R_SoKhung RXL;

    public SoKhungImpl() {
        this.RXL = new R_SoKhung();
    }
    
    @Override
    public List<D_SoKhung> getAll() {
    return RXL.getAllSK();   
    }

    @Override
    public List<D_SoKhung> getAllSoKhung() {
       return RXL.getAllSK();   
    }

    @Override
    public Integer add(D_SoKhung vds) {
        return RXL.add(vds);
    }

    @Override
    public Integer update(D_SoKhung vds) {
        return RXL.update(vds);
    }

    @Override
    public Integer delete(D_SoKhung vds) {
        return RXL.delete(vds);
        
    }

    @Override
    public D_SoKhung getOne(String ma) {
        return RXL.getOne(ma);
     }

    @Override
    public ArrayList<String> getMSP() {
    return RXL.getMSP();
    }

    @Override
    public List<D_SoKhung> getAllByNameMaSP(String masp) {
     return RXL.getAllByNameMaSP(masp);
    }

    @Override
    public Integer updateTrangThaiSoKhung(D_SoKhung ds) {
     return RXL.updateTrangThaiSoKhung(ds);
    }
    @Override
    public Integer updateTraLaiTrangThaiSK(D_SoKhung ds) {
    return RXL.updateTraLaiTrangThaiSK(ds);
    }

    @Override
    public void suask(String d) {
        RXL.Suask(d); }

    @Override
    public List<D_SoKhung> getAllByNameMaSP2(String masp) {
        return RXL.getAllByNameMaSP2(masp);
    }

    @Override
    public void suask1(String d) {
        RXL.Suask1(d);
     }
    
    
}
