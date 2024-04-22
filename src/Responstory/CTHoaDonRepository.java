/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory;

import Utilities.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import DomainModel.CTHoaDon;
import DomainModel.D_SanPhamBig;
import Utilities.JDBCHeper;
import ViewModel.CTHD_Table;
import ViewModel.CTHoaDonNT;
import ViewModel.CTSanPhamHD;
import ViewModel.HD_LoadTable;
import java.util.List;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Dell
 */
public class CTHoaDonRepository {

    public boolean insert(CTHoaDon cthd) {
        try {
            Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO HoaDonChiTiet(idctsp,idhd,slmua,trangthai) VALUES(?,?,?,?)");
            ps.setString(1, cthd.getIdCtsp());
            ps.setString(2, cthd.getIdHoaDon());
            ps.setInt(4, cthd.getSLMua());
            ps.setInt(4, cthd.getTrangThai());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi tại Add()");
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(CTHoaDon cthd) {
        try ( Connection conn = DBconnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM HoaDonChiTiet WHERE idhd = ? AND idctsp = ?");
            ps.setString(1, cthd.getIdHoaDon());
            ps.setString(2, cthd.getIdCtsp());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Loi khong the ket noi vao CSDL tai Delete");
            return false;
        }
    }

    public boolean update(CTHoaDon cthd) {
        try {
            Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE HoaDonChiTiet SET idctsp = ?, idhd = ?, slmua = ?, trangthai = ? WHERE ID = ?");
            ps.setString(1, cthd.getIdCtsp());
            ps.setString(2, cthd.getIdHoaDon());
            ps.setInt(4, cthd.getSLMua());
            ps.setInt(5, cthd.getTrangThai());
            ps.setString(6, cthd.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi kết nối tại Update()");
            e.printStackTrace();
            return false;
        }
    }

    public List<Double> sumDate(Date date, int trangThai) throws SQLException {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = dateFormat.format(date);

            List<Double> list = new ArrayList<>();
            Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT SUM(hoadon.sotienphaitra) FROM hoadon JOIN hoadonchitiet ON hoadonchitiet.idhd = hoadon.idhd WHERE hoadon.ngaytao = ? and  hoadon.trangthai = ?");
            ps.setString(1, dateString);
            ps.setInt(2, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double sum = rs.getDouble(1);
                list.add(sum);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Double> sumMonth(String date, int trangThai) throws SQLException {
        try {
            List<Double> list = new ArrayList<>();
            Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT SUM(hoadon.sotienphaitra) FROM hoadon JOIN hoadonchitiet ON hoadonchitiet.idhd = hoadon.idhd WHERE month(hoadon.ngaytao) = ? and  hoadon.trangthai = ?");
            ps.setString(1, date);
            ps.setInt(2, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double sum = rs.getDouble(1);
                list.add(sum);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Double> sumYear(String date, int trangThai) throws SQLException {
        try {
            List<Double> list = new ArrayList<>();
            Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT SUM(hoadon.sotienphaitra) FROM hoadon JOIN hoadonchitiet ON hoadonchitiet.idhd = hoadon.idhd WHERE year(hoadon.ngaytao) = ? and  hoadon.trangthai = ?");
            ps.setString(1, date);
            ps.setInt(2, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double sum = rs.getDouble(1);
                list.add(sum);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CTSanPhamHD> getListThongKe(String ngayBatDau, String ngayKetThuc, int trangThai) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d 'thg' M, yyyy");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = new Date(dateFormat.parse(ngayBatDau).getTime());
            endDate = new Date(dateFormat.parse(ngayKetThuc).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<CTSanPhamHD> list = new ArrayList<>();
        String sql = "SELECT sanpham.masp, COUNT(hoadonchitiet.idsp) AS tong FROM hoadonchitiet \n"
                + "INNER JOIN sanpham ON hoadonchitiet.idsp = sanpham.id\n"
                + "INNER JOIN hoadon ON hoadonchitiet.idhd = hoadon.idhd \n"
                + "WHERE hoadon.ngaytao BETWEEN ? AND ?  and  hoadon.trangthai = ?\n"
                + "GROUP BY sanpham.masp \n"
                + "ORDER BY tong DESC";
        try {
            Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, startDate);
            ps.setDate(2, endDate);
            ps.setInt(3, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CTSanPhamHD ctsp = new CTSanPhamHD();
                ctsp.setMaSP(rs.getString("masp"));
                ctsp.setSoLuong(rs.getInt("tong"));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Long getSoLuongDoanhThu(int month, int trangThai) {
        Long totalAmount = null;
        try {
            Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(hoadonchitiet.idsp)\n"
                    + "FROM hoadonchitiet\n"
                    + "JOIN hoadon ON hoadonchitiet.idhd = hoadon.idhd\n"
                    + "WHERE MONTH(hoadon.ngaytao) = ? AND hoadon.trangthai = ?");
            ps.setInt(1, month);
            ps.setInt(2, trangThai);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                totalAmount = rs.getLong(1);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalAmount;
    }

    public Double getTongTienHang(int month, int trangThai) {
        Double totalValue = null;
        try {
            Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select sum(hoadon.tongtienhang) from hoadon JOIN hoadonchitiet ON hoadonchitiet.idhd = hoadon.idhd\n"
                    + "where month(hoadon.ngaytao) = ? and  hoadon.trangthai = ?");
            ps.setInt(1, month);
            ps.setInt(2, trangThai);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                totalValue = rs.getDouble(1);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalValue;
    }

    public Double getSoTienPhaiTra(int month, int trangThai) {
        Double totalDiscount = null;
        try {
            Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select sum(hoadon.sotienphaitra) from hoadon JOIN hoadonchitiet ON hoadonchitiet.idhd = hoadon.idhd\n"
                    + "where month(hoadon.ngaytao) = ? and hoadon.trangthai = ?");
            ps.setInt(1, month);
            ps.setInt(2, trangThai);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                totalDiscount = rs.getDouble(1);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalDiscount;
    }

    public List<Integer> getListDoanhThu(String year, int trangThai) {
        List<Integer> list = new ArrayList<>();
        try {
            Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT MONTH(hoadon.ngaytao) FROM hoadon JOIN hoadonchitiet ON hoadonchitiet.idhd = hoadon.idhd\n"
                    + "                    WHERE YEAR(hoadon.ngaytao) = ? and hoadon.trangthai = ?");
            ps.setString(1, year);
            ps.setInt(2, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //Biểu đồ
    public List<CTHoaDonNT> getListByHoaDon(String year, int trangThai) {
        Connection cons = DBconnection.getConnection();
        String sql = "select DISTINCT month(ngaytao) as ngaytao ,sum(sotienphaitra) as doanhthu from hoadon JOIN hoadonchitiet ON hoadonchitiet.idhd = hoadon.idhd\n"
                + "where year(ngaytao) = ? and hoadon.trangthai = ?\n"
                + "group by ngaytao ";
        List<CTHoaDonNT> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setString(1, year);
            ps.setInt(2, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CTHoaDonNT sanpham = new CTHoaDonNT();
                sanpham.setNgayTao(rs.getString("ngaytao"));
                sanpham.setDoanhThu(rs.getInt("doanhthu"));
                list.add(sanpham);
            }
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
        public List<CTHD_Table> getOneCTHD(String masp) {
        ArrayList<CTHD_Table> dsp = new ArrayList<>();
        String sql = "select hdct.id,sp.maSP,sp.tenSP,sp.namSX,Mau.mauSac,sp.giaban,sk.sokhung,hd.trangThai,hd.maHoaDon from HoaDONChiTiet hdct\n"
                + "inner join SanPham sp on hdct.idsp = sp.id inner join Mau on sp.idMau = Mau.id \n"
                + "inner join SoKhung sk on hdct.idsk = sk.id \n"
                + "inner join HoaDon hd on hdct.idhd = hd.idhd inner join KhuyenMai km on hd.idkhuyenmai = km.idkm\n"
                + " where hd.idhd ='" + masp + "'";

        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {

                CTHD_Table sp = new CTHD_Table();
                sp.setIdcthd(rs.getString(1));
                sp.setMaSP(rs.getString(2));
                sp.setTenSP(rs.getString(3));
                sp.setNamSX(rs.getString(4));
                sp.setMauSac(rs.getString(5));
                sp.setGiaBan(rs.getFloat(6));
                sp.setSoKhung(rs.getString(7));
                sp.setTrangThai(rs.getInt(8));

                dsp.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsp;
    }
}
