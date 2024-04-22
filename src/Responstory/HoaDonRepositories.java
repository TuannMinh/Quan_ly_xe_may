/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory;

import DomainModel.D_KhachHang;
import DomainModel.D_NhanVien;
import DomainModel.KhuyenMai;
import ViewModel.HoaDonMODEL;
import Utilities.DBconnection;
import Utilities.JDBCHeper;
import ViewModel.HD_LoadTable;
import ViewModel.HoaDon;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonRepositories {

    public void add(HoaDonMODEL hd, String kh, String nhanVien, String KM) {
        String querry = """
                        INSERT INTO [dbo].[HoaDon]
                                   ([maHoaDon]
                                   ,[idKhachHang]
                                   ,[idNhanVien]
                                   ,[idkhuyenmai]
                                   ,[tongTienHang]
                                   ,[soTienPhaiTra]
                                   ,[tienKhachDua]
                                   ,[tienThua]
                                   ,[trangThai]
                                   ,[ngaytao])
                             VALUES
                                   (?,(SELECT [idKH] FROM [dbo].[KhachHang] Where hoTen =?),(SELECT [idNV] FROM [dbo].[NhanVien] where maNV = ?),(SELECT [idkm] FROM [dbo].[KhuyenMai]  Where maKhuyenMai = ?)
                                    ,?,?,?,?,?,?)
                        """;
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setObject(1, hd.getMaHd());
            ps.setObject(2, kh);
            ps.setObject(3, nhanVien);
            ps.setObject(4, KM);
            ps.setObject(5, hd.getTongTienHang());
            ps.setObject(6, hd.getTienPhaiTra());
            ps.setObject(7, hd.getTienKhachDua());
            ps.setObject(8, hd.getTienThua());
            ps.setObject(9, hd.getTrangThai());
            ps.setObject(10, hd.getNgayTao());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void addhuyhoadon(HoaDonMODEL hd, String kh, String nhanVien, String KM) {
        String querry = """
                        INSERT INTO [dbo].[HoaDon]
                                   ([maHoaDon]
                                   ,[idKhachHang]
                                   ,[idNhanVien]
                                   ,[idkhuyenmai]
                                   ,[tongTienHang]
                                   ,[soTienPhaiTra]                                 
                                   ,[tienThua]
                                   ,[trangThai]
                                   ,[ngaytao])
                             VALUES
                                   (?,(SELECT [idKH] FROM [dbo].[KhachHang] Where hoTen =?),(SELECT [idNV] FROM [dbo].[NhanVien] where maNV = ?),(SELECT [idkm] FROM [dbo].[KhuyenMai]  Where maKhuyenMai = ?)
                                    ,?,?,?,?,?)
                        """;
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setObject(1, hd.getMaHd());
            ps.setObject(2, kh);
            ps.setObject(3, nhanVien);
            ps.setObject(4, KM);
            ps.setObject(5, hd.getTongTienHang());
            ps.setObject(6, hd.getTienPhaiTra());
            ps.setObject(8, hd.getTienThua());
            ps.setObject(9, hd.getTrangThai());
            ps.setObject(10, hd.getNgayTao());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public ArrayList<HD_LoadTable> getAllSanPham() {
        ArrayList<HD_LoadTable> list = new ArrayList<>();
        String sql = "select hd.idhd, hd.maHoaDon,kh.hoTen ,kh.sdt,nv.tenNV,nv.ngaySinh,km.maKhuyenMai,km.GiaTri,hd.tongTienHang,hd.soTienPhaiTra,hd.tienKhachDua,hd.tienThua,hd.ngaytao,hd.trangthai from hoadon hd \n"
                + "inner join KhachHang kh on hd.idKhachHang = kh.idKH \n"
                + "inner join NhanVien nv on hd.idNhanVien = nv.idNV\n"
                + "inner join KhuyenMai km on hd.idkhuyenmai = km.idkm ORDER BY hd.idhd DESC";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                HD_LoadTable ctsp = new HD_LoadTable();

                ctsp.setIdHoaDon(rs.getString(1));
                ctsp.setMaHd(rs.getString(2));
                ctsp.setTenKH(rs.getString(3));
                ctsp.setSdt(rs.getString(4));
                ctsp.setTenNV(rs.getString(5));
                ctsp.setNgaySinh(rs.getString(6));
                ctsp.setMaKhuyenMai(rs.getString(7));
                ctsp.setGiTri(rs.getString(8));
                ctsp.setTongTienHang(rs.getFloat(9));
                ctsp.setTienPhaiTra(rs.getFloat(10));
                ctsp.setTienKhachDua(rs.getFloat(11));
                ctsp.setTienThua(rs.getFloat(12));
                ctsp.setNgayTao(rs.getDate(13));
                ctsp.setTrangThai(rs.getInt(14));

                list.add(ctsp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HD_LoadTable> getAllHoaDonCho() {
        ArrayList<HD_LoadTable> list = new ArrayList<>();
        String sql = " select hd.idhd, hd.maHoaDon,kh.hoTen,km.maKhuyenMai,hd.tongTienHang,hd.soTienPhaiTra,hd.tienKhachDua,hd.tienThua from hoadon hd \n"
                + "         	inner join KhachHang kh on hd.idKhachHang = kh.idKH \n"
                + "           		inner join NhanVien nv on hd.idNhanVien = nv.idNV\n"
                + "            		inner join KhuyenMai km on hd.idkhuyenmai = km.idkm\n"
                + "              		where hd.trangThai=1";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                HD_LoadTable ctsp = new HD_LoadTable();

                ctsp.setIdHoaDon(rs.getString(1));
                ctsp.setMaHd(rs.getString(2));
                ctsp.setTenKH(rs.getString(3));
                ctsp.setMaKhuyenMai(rs.getString(4));
                ctsp.setTongTienHang(rs.getFloat(5));
                ctsp.setTienPhaiTra(rs.getFloat(6));
                ctsp.setTienKhachDua(rs.getFloat(7));
                ctsp.setTienThua(rs.getFloat(8));

                list.add(ctsp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void Sua(HoaDonMODEL hd, String ma, String nv) {
        String querry = """
                        UPDATE [dbo].[HoaDon]
                           SET  
                        	  [idNhanVien] = (SELECT [idNV] FROM [dbo].[NhanVien] where maNV = ?)
                              ,[tienKhachDua] = ?
                              ,[tienThua] = ?
                              ,[trangThai] = ?
                              ,[ngaytao] = ?
                         WHERE maHoaDon =?
                        """;
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setObject(1, nv);
            ps.setObject(2, hd.getTienKhachDua());
            ps.setObject(3, hd.getTienThua());
            ps.setObject(4, hd.getTrangThai());
            ps.setObject(5, hd.getNgayTao());
            ps.setObject(6, ma);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List<Integer> getYear() {
        List<Integer> list = new ArrayList<>();
        try {
            Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT YEAR(ngaytao) as [YEAR] FROM HOADON WHERE ngaytao IS NOT NULL ORDER BY [YEAR] DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();

            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<HoaDon> getList(int trangThai) {
        List<HoaDon> list = new ArrayList<>();
        try {
            Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM HoaDon where trangthai = ?");
            ps.setInt(1, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon ctsp = new HoaDon();
                ctsp.setIdHoaDon(rs.getString(1));
                ctsp.setMaHd(rs.getString(2));

                D_KhachHang kh = new D_KhachHang();
                kh.setIdKH(rs.getString(3));
                ctsp.setIdKhachHang(kh);

                D_NhanVien nv = new D_NhanVien();
                nv.setId(rs.getString(4));
                ctsp.setIdNhanVien(nv);

                KhuyenMai km = new KhuyenMai();
                kh.setIdKH(rs.getString(5));
                ctsp.setIdkhuyenmai(km);

                ctsp.setTongTienHang(rs.getFloat(6));
                ctsp.setTienPhaiTra(rs.getFloat(7));
                ctsp.setTienKhachDua(rs.getFloat(8));
                ctsp.setTienThua(rs.getFloat(9));
//                ctsp.setNgayTao(rs.getDate(10));
                list.add(ctsp);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
