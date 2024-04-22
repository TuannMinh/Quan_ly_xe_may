
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Responstory.HoaDonRepositories;
import Service.HoaDonServies;
import ViewModel.HD_LoadTable;
import ViewModel.HoaDon;
import ViewModel.HoaDonMODEL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoadonServicesImpl implements HoaDonServies {

    HoaDonRepositories rs = new HoaDonRepositories();

    @Override
    public void them(HoaDonMODEL HD, String KH, String nv, String Km) {
        rs.add(HD, KH, nv, Km);
    }

    @Override
    public String dinhDangTien(float k) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        String formattedNumber = decimalFormat.format(k);
        return formattedNumber;
    }

    @Override
    public String dateTime() {
        Date now = new Date();

// Chuyển đổi sang chuỗi thời gian theo định dạng
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = formatter.format(now);
        return formattedDate;
    }

    @Override
    public ArrayList<HD_LoadTable> getAllSanPham() {
        return rs.getAllSanPham();
    }

    @Override
    public ArrayList<HD_LoadTable> getAllHoaDonCho() {
        return rs.getAllHoaDonCho();
    }


    @Override
    public List<Integer> getYear() {
        return rs.getYear();
    }

    @Override
    public List<HoaDon> getList(int trangThai) {
        return rs.getList(trangThai);
    }

    @Override
    public void addhuyhoadon(HoaDonMODEL HD, String KH, String nv, String Km) {
                rs.add(HD, KH, nv, Km);
    }

    @Override
    public void sua(HoaDonMODEL HD, String ma, String nv) {
    rs.Sua(HD, ma, nv);  }
}
