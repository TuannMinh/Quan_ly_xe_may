/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceImpl;
import Responstory.KhachHangReponstory;
import DomainModel.D_KhachHang;
import Service.KhachHangService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class KhachHangImpl implements KhachHangService{
    
    private KhachHangReponstory khachhangRepo = new  KhachHangReponstory();

    @Override
    public List<D_KhachHang> getAll() {
        return khachhangRepo.getAll();
    }

    @Override
    public boolean insert(D_KhachHang kh) {
       return khachhangRepo.insert(kh);
    }

    @Override
    public boolean update(String maKH, D_KhachHang kh) {
         return khachhangRepo.update(maKH, kh);
    }

    @Override
    public boolean delete(String maKh) {
        return khachhangRepo.delete(maKh);
    }

    @Override
    public List<D_KhachHang> search(String hoTen) {
        return khachhangRepo.search(hoTen);
    }

    @Override
    public D_KhachHang one(String hoTen) {
      return khachhangRepo.one(hoTen);
    }

    
}
