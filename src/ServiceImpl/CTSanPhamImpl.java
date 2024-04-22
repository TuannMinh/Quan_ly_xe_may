/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import DomainModel.D_SanPhamBig;
import Responstory.CTSanPhamResponstory;
import ViewModel.VM_ChiTietSanPham;
import java.util.ArrayList;
import java.util.List;
import Service.CTSanPhamService;
import ViewModel.CTSanPhamHD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VietTien
 */
public class CTSanPhamImpl implements CTSanPhamService {

    CTSanPhamResponstory rs = new CTSanPhamResponstory();

    @Override
    public ArrayList<D_SanPhamBig> getAllSanPham() {
        return rs.getAllSanPham();
    }

    @Override
    public ArrayList<String> getDTBX() {
        return rs.getDTBX();
    }

    @Override
    public ArrayList<String> getDTXL() {
        return rs.getDTXL();
    }

    @Override
    public ArrayList<String> getMau() {
        return rs.getMau();
    }

    @Override
    public ArrayList<String> getXuatXu() {
        return rs.getXuatXu();
    }

    @Override
    public ArrayList<String> getSoKhung() {
        return rs.getSoKhung();
    }

    @Override
    public boolean add(D_SanPhamBig ds) {
        return rs.add(ds);

    }

    @Override
    public Boolean update(D_SanPhamBig ds) {
        return rs.update(ds);
    }

    @Override
    public Integer updateTrangthai(D_SanPhamBig ds) {
        return rs.updateTrangthai(ds);
    }

    @Override
    public D_SanPhamBig getOne(String ma) {
        return rs.getOne(ma);
    }

    @Override
    public ArrayList<String> getLoaiXe() {
        return rs.getLoaiXe();
    }

    @Override
    public ArrayList<String> getAllMaSP() {
        return rs.getAllMaSP();
    }

    @Override
    public ArrayList<String> getAllKH() {
        return rs.getAllKH();
    }

    @Override
    public ArrayList<String> getAllKM() {
        return rs.getAllKM();
    }

    @Override
    public ArrayList<D_SanPhamBig> getAllSanPham2() {
        return rs.getAllSanPham2();
    }

    @Override
    public ArrayList<D_SanPhamBig> getAllSanPham3() {
        return rs.getAllSanPham3();
    }

    @Override
    public String getByNameLoaiXe(String ma) {
        return rs.getByNameLoaiXe(ma);
    }

    @Override
    public String getByNameDTXiLanh(String ma) {
        return rs.getByNameDTXiLanh(ma);
    }

    @Override
    public String getByNameDTBinhXang(String ma) {
        return rs.getByNameDTBinhXang(ma);
    }

    @Override
    public String getByNameMau(String ma) {
        return rs.getByNameMau(ma);
    }

    @Override
    public String getByNameXuatXu(String ma) {
        return rs.getByNameXuatXu(ma);
    }

    @Override
    public String getByNameSanPham(String ma) {
        return rs.getByNameSanPham(ma);
    }

    @Override
    public String getByNameSoKhung(String ma) {
        return rs.getByNameSoKhung(ma);
    }
}
