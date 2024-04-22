/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.D_SanPhamBig;
import ViewModel.CTSanPhamHD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VietTien
 */
public interface CTSanPhamService {

    public ArrayList<D_SanPhamBig> getAllSanPham();

    public ArrayList<String> getDTBX();

    public ArrayList<String> getDTXL();

    public ArrayList<String> getMau();

    public ArrayList<String> getXuatXu();

    public ArrayList<String> getLoaiXe();

    public ArrayList<String> getSoKhung();

    public boolean add(D_SanPhamBig ds);

    public Boolean update(D_SanPhamBig ds);

    public Integer updateTrangthai(D_SanPhamBig ds);

    public D_SanPhamBig getOne(String ma);

    public ArrayList<String> getAllMaSP();

    public ArrayList<String> getAllKH();

    public ArrayList<String> getAllKM();

    public ArrayList<D_SanPhamBig> getAllSanPham2();

    public ArrayList<D_SanPhamBig> getAllSanPham3();
//    
//    public boolean add(SanPhamViewModel sp);
//    
//    public boolean update(int id);
//    
//    public boolean delete(int id, SanPhamViewModel sp);

    public String getByNameLoaiXe(String ma);

    public String getByNameDTXiLanh(String ma);

    public String getByNameDTBinhXang(String ma);

    public String getByNameMau(String ma);

    public String getByNameXuatXu(String ma);

    public String getByNameSanPham(String ma);

    public String getByNameSoKhung(String ma);
}
