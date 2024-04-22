/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import DomainModel.CTHoaDon;
import DomainModel.D_SanPhamBig;
import Responstory.CTHoaDonRepository;
import Service.CTHoaDonService;
import ViewModel.CTHD_Table;
import ViewModel.CTHoaDonNT;
import ViewModel.CTSanPhamHD;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class CTHoaDonImpl implements CTHoaDonService {

    private CTHoaDonRepository cthdrepo = new CTHoaDonRepository();

    @Override
    public boolean insert(CTHoaDon cthd) {
        return cthdrepo.insert(cthd);
    }

    @Override
    public boolean delete(CTHoaDon cthd) {
        return cthdrepo.delete(cthd);
    }

    @Override
    public boolean update(CTHoaDon cthd) {
        return cthdrepo.update(cthd);
    }

    @Override
    public List<Double> sumDate(Date date,int trangThai) {
        try {
            return cthdrepo.sumDate(date,trangThai);
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Double> sumMonth(String date,int trangThai) {
        try {
            return cthdrepo.sumMonth(date,trangThai);
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Double> sumYear(String date,int trangThai) {
        try {
            return cthdrepo.sumYear(date,trangThai);
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<CTSanPhamHD> getListThongKe(String ngayBatDau, String ngayKetThuc,int trangThai) {
        return cthdrepo.getListThongKe(ngayBatDau, ngayKetThuc,trangThai);
    }

    @Override
    public Long getSoLuongDoanhThu(int month,int trangThai) {
        return cthdrepo.getSoLuongDoanhThu(month,trangThai);
    }

    @Override
    public Double getTongTienHang(int month,int trangThai) {
        return cthdrepo.getTongTienHang(month,trangThai);
    }

    @Override
    public Double getSoTienPhaiTra(int month,int trangThai) {
        return cthdrepo.getSoTienPhaiTra(month,trangThai);
    }

    @Override
    public List<Integer> getListDoanhThu(String year,int trangThai) {
        return cthdrepo.getListDoanhThu(year,trangThai);
    }

    @Override
    public List<CTHD_Table> getOneCTHD(String ma) {
        return cthdrepo.getOneCTHD(ma);
    }

    @Override
    public List<CTHoaDonNT> getListByHoaDon(String year, int trangThai) {
        return cthdrepo.getListByHoaDon(year, trangThai);
    }

}
