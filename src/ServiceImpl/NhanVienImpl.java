/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import DomainModel.D_NhanVien;
import Responstory.NhanVienReponstory;
import Responstory.NhanVienTTCTRepositories;
import Service.NhanVienService;
import ViewModel.NhanVienModels;
import ViewModel.NhanVienTTCT;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Admin
 */
public class NhanVienImpl implements NhanVienService{
    private NhanVienReponstory rs = new NhanVienReponstory();
    private NhanVienTTCTRepositories nvrs = new NhanVienTTCTRepositories();
    
    @Override
    public List<NhanVienModels> getList() {
        List<NhanVienModels> list = new ArrayList<>();
        List<D_NhanVien> ds = rs.getAll();
         for (D_NhanVien d : ds) {
            NhanVienModels qlnv = new NhanVienModels(d.getMaNV(),d.getTenNV(), d.getDiaChi(),d.getGioiTinh(),d.getNgaySinh(), d.getSdt(), d.getEmail(),d.getHinhAnh(),d.getTrangThai(),d.getIdtk());
            list.add(qlnv);
        }
        return list;
    }

    @Override
    public void them(NhanVienModels nv ,String user) {
        D_NhanVien nvv = new D_NhanVien();
       nvv.setMaNV(nv.getMaNV());
        nvv.setTenNV(nv.getTenNV());
        nvv.setDiaChi(nv.getDiaChi());
        nvv.setSdt(nv.getSdt());
        nvv.setGioiTinh(nv.getGioiTinh());
        nvv.setNgaySinh(nv.getNgaySinh());
        nvv.setTrangThai(nv.getTrangThai());
        nvv.setEmail(nv.getEmail());
        nvv.setHinhAnh(nv.getHinhAnh());
        
        rs.them(nvv,user);
      }

    @Override
    public List<String> getListusename() {
     return rs.layIdtk();
             }

    @Override
    public void sua(NhanVienModels nv, String d) {
     D_NhanVien nvv = new D_NhanVien();
       nvv.setMaNV(nv.getMaNV());
        nvv.setTenNV(nv.getTenNV());
        nvv.setDiaChi(nv.getDiaChi());
        nvv.setSdt(nv.getSdt());
        nvv.setGioiTinh(nv.getGioiTinh());
        nvv.setNgaySinh(nv.getNgaySinh());
        nvv.setTrangThai(nv.getTrangThai());
        nvv.setEmail(nv.getEmail());
        nvv.setHinhAnh(nv.getHinhAnh());
        rs.Sua(nvv, d);
    }

    @Override
    public List<NhanVienModels> gettk(String ma) {
     List<NhanVienModels> list = new ArrayList<>();
        List<D_NhanVien> ds = rs.TimKiem(ma);
         for (D_NhanVien d : ds) {
            NhanVienModels qlnv = new NhanVienModels(d.getMaNV(),d.getTenNV(), d.getDiaChi(),d.getGioiTinh(),d.getNgaySinh(), d.getSdt(), d.getEmail(),d.getHinhAnh(),d.getTrangThai(),d.getIdtk());
            list.add(qlnv);
        }
        return list;}

    @Override
    public List<NhanVienModels> getListloc(int id) {
      List<NhanVienModels> list = new ArrayList<>();
        List<D_NhanVien> ds = rs.getlistloc(id);
         for (D_NhanVien d : ds) {
            NhanVienModels qlnv = new NhanVienModels(d.getMaNV(),d.getTenNV(), d.getDiaChi(),d.getGioiTinh(),d.getNgaySinh(), d.getSdt(), d.getEmail(),d.getHinhAnh(),d.getTrangThai(),d.getIdtk());
            list.add(qlnv);
        }
        return list; }

    @Override
    public NhanVienModels getLisstma(String id) {
     return rs.layMaNv(id); }  

    @Override
    public NhanVienTTCT getCt(String ma) {
      NhanVienTTCT nv = nvrs.getone(ma);
      return nv;
    }


    
}
