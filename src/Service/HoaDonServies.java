/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModel.HD_LoadTable;
import ViewModel.HoaDon;
import ViewModel.HoaDonMODEL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface HoaDonServies {

    void them(HoaDonMODEL HD, String KH, String nv, String Km);
    void addhuyhoadon(HoaDonMODEL HD, String KH, String nv, String Km);

    void sua(HoaDonMODEL HD, String ma ,String nv);

    String dinhDangTien(float k);

    String dateTime();

    public ArrayList<HD_LoadTable> getAllSanPham();

    public ArrayList<HD_LoadTable> getAllHoaDonCho();

    public List<Integer> getYear();

    public List<HoaDon> getList(int trangThai);
}
