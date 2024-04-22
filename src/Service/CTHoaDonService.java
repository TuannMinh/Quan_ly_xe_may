/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.CTHoaDon;
import DomainModel.D_SanPhamBig;
import ViewModel.CTHD_Table;
import ViewModel.CTHoaDonNT;
import ViewModel.CTSanPhamHD;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface CTHoaDonService {

    public boolean insert(CTHoaDon cthd);

    public boolean delete(CTHoaDon cthd);

    public boolean update(CTHoaDon cthd);

    public List<Double> sumDate(Date date, int trangThai);

    public List<Double> sumMonth(String date, int trangThai);

    public List<Double> sumYear(String date, int trangThai);

    public List<CTSanPhamHD> getListThongKe(String ngayBatDau, String ngayKetThuc, int trangThai);

    public Long getSoLuongDoanhThu(int month, int trangThai);

    public Double getTongTienHang(int month, int trangThai);

    public Double getSoTienPhaiTra(int month, int trangThai);

    public List<Integer> getListDoanhThu(String year, int trangThai);

    public List<CTHD_Table> getOneCTHD(String ma);

    public List<CTHoaDonNT> getListByHoaDon(String year, int trangThai);

}
