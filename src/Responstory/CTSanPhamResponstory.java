package Responstory;

import DomainModel.D_DTBinhXang;
import DomainModel.D_DTXiLanh;
import DomainModel.D_LoaiXe;
import DomainModel.D_Mau;
import DomainModel.D_SanPhamBig;
import DomainModel.D_XuatXu;
import Utilities.DBconnection;
import Utilities.JDBCHeper;
import ViewModel.CTSanPhamHD;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CTSanPhamResponstory {

    private DBconnection context;

    public ArrayList<D_SanPhamBig> getAllSanPham() {
        ArrayList<D_SanPhamBig> list = new ArrayList<>();
        String sql = "SELECT \n"
                + "    sp.id, \n"
                + "    sp.maSp, \n"
                + "    sp.tenSp, \n"
                + "    bx.dTBinhXang, \n"
                + "    xl.dTXiLanh, \n"
                + "    m.mauSac, \n"
                + "    xx.xuatXu, \n"
                + "	lx.loaiXe,\n"
                + "	sp.namSX,\n"
                + "    sp.giaBan, \n"
                + "    sp.trangThai,   \n"
                + "    \n"
                + "	    COUNT(sk.id) AS soLuongSoKhung\n"
                + "FROM SanPham sp\n"
                + "INNER JOIN DTBinhXang bx ON sp.idDTBinhXang = bx.id\n"
                + "INNER JOIN DTXiLanh xl ON sp.idDTXiLanh = xl.id\n"
                + "INNER JOIN Mau m ON sp.idMau = m.id\n"
                + "INNER JOIN XuatXu xx ON sp.idXuatXu = xx.id\n"
                + "INNER JOIN LoaiXe lx ON sp.idLoaiXe = lx.id\n"
                + "INNER JOIN SoKhung sk ON sp.id = sk.idsp\n"
                + "WHERE sk.trangThai = 1\n"
                + "GROUP BY sp.id,sp.maSp, sp.tenSp, bx.dTBinhXang, xl.dTXiLanh, m.mauSac, xx.xuatXu,lx.loaiXe, sp.namSX,sp.giaBan, sp.trangThai ";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                D_SanPhamBig ctsp = new D_SanPhamBig();
                ctsp.setIdSP(rs.getString(1));
                ctsp.setMaSP(rs.getString(2));
                ctsp.setTenSP(rs.getString(3));

                D_DTBinhXang bx = new D_DTBinhXang();
                bx.setDTBinhXang(rs.getString(4));
                ctsp.setDtBinhXang(bx);

                D_DTXiLanh xlanh = new D_DTXiLanh();
                xlanh.setDTXiLanh(rs.getString(5));
                ctsp.setdTXiLanh(xlanh);

                D_Mau m = new D_Mau();
                m.setMau(rs.getString(6));
                ctsp.setMau(m);

                D_XuatXu xx = new D_XuatXu();
                xx.setXuatXu(rs.getString(7));
                ctsp.setXuatXu(xx);

                D_LoaiXe lx = new D_LoaiXe();
                lx.setLaoiXe(rs.getString(8));
                ctsp.setLoaiXe(lx);

                ctsp.setNamSX(rs.getInt(9));
                ctsp.setGiaBan(rs.getDouble(10));
                ctsp.setTrangThai(rs.getInt(11));
                ctsp.setSoLuong(rs.getInt(12));

                list.add(ctsp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<D_SanPhamBig> getAllSanPham2() {
        ArrayList<D_SanPhamBig> list = new ArrayList<>();
        String sql = "	SELECT sp.id, sp.maSp, sp.tenSp,bx.dTBinhXang, xl.dTXiLanh, m.mauSac,  xx.xuatXu, lx.loaiXe,sp.namSX,sp.giaBan, sp.trangThai               \n"
                + "               	    \n"
                + "               FROM SanPham sp\n"
                + "                INNER JOIN DTBinhXang bx ON sp.idDTBinhXang = bx.id\n"
                + "                INNER JOIN DTXiLanh xl ON sp.idDTXiLanh = xl.id\n"
                + "               INNER JOIN Mau m ON sp.idMau = m.id\n"
                + "               INNER JOIN XuatXu xx ON sp.idXuatXu = xx.id\n"
                + "                INNER JOIN LoaiXe lx ON sp.idLoaiXe = lx.id";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                D_SanPhamBig ctsp = new D_SanPhamBig();
                ctsp.setIdSP(rs.getString(1));
                ctsp.setMaSP(rs.getString(2));
                ctsp.setTenSP(rs.getString(3));

                D_DTBinhXang bx = new D_DTBinhXang();
                bx.setDTBinhXang(rs.getString(4));
                ctsp.setDtBinhXang(bx);

                D_DTXiLanh xlanh = new D_DTXiLanh();
                xlanh.setDTXiLanh(rs.getString(5));
                ctsp.setdTXiLanh(xlanh);

                D_Mau m = new D_Mau();
                m.setMau(rs.getString(6));
                ctsp.setMau(m);

                D_XuatXu xx = new D_XuatXu();
                xx.setXuatXu(rs.getString(7));
                ctsp.setXuatXu(xx);

                D_LoaiXe lx = new D_LoaiXe();
                lx.setLaoiXe(rs.getString(8));
                ctsp.setLoaiXe(lx);

                ctsp.setNamSX(rs.getInt(9));
                ctsp.setGiaBan(rs.getDouble(10));
                ctsp.setTrangThai(rs.getInt(11));

                list.add(ctsp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<D_SanPhamBig> getAllSanPham3() {
        ArrayList<D_SanPhamBig> list = new ArrayList<>();
        String sql = "SELECT  sp.id, sp.maSp, sp.tenSp,  bx.dTBinhXang,  xl.dTXiLanh, m.mauSac, xx.xuatXu, 	lx.loaiXe, sp.namSX,sp.giaBan, sp.trangThai,                      \n"
                + "COUNT(sk.id) AS soLuongSoKhung\n"
                + "FROM SanPham sp\n"
                + "INNER JOIN DTBinhXang bx ON sp.idDTBinhXang = bx.id\n"
                + "INNER JOIN DTXiLanh xl ON sp.idDTXiLanh = xl.id\n"
                + "INNER JOIN Mau m ON sp.idMau = m.id\n"
                + "INNER JOIN XuatXu xx ON sp.idXuatXu = xx.id\n"
                + "INNER JOIN LoaiXe lx ON sp.idLoaiXe = lx.id\n"
                + "INNER JOIN SoKhung sk ON sp.id = sk.idsp\n"
                + "WHERE sk.trangThai = 1 and sp.trangThai = 1 \n"
                + "GROUP BY sp.id,sp.maSp, sp.tenSp, bx.dTBinhXang, xl.dTXiLanh, m.mauSac, xx.xuatXu,lx.loaiXe, sp.namSX,sp.giaBan, sp.trangThai ";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                D_SanPhamBig ctsp = new D_SanPhamBig();
                ctsp.setIdSP(rs.getString(1));
                ctsp.setMaSP(rs.getString(2));
                ctsp.setTenSP(rs.getString(3));

                D_DTBinhXang bx = new D_DTBinhXang();
                bx.setDTBinhXang(rs.getString(4));
                ctsp.setDtBinhXang(bx);

                D_DTXiLanh xlanh = new D_DTXiLanh();
                xlanh.setDTXiLanh(rs.getString(5));
                ctsp.setdTXiLanh(xlanh);

                D_Mau m = new D_Mau();
                m.setMau(rs.getString(6));
                ctsp.setMau(m);

                D_XuatXu xx = new D_XuatXu();
                xx.setXuatXu(rs.getString(7));
                ctsp.setXuatXu(xx);

                D_LoaiXe lx = new D_LoaiXe();
                lx.setLaoiXe(rs.getString(8));
                ctsp.setLoaiXe(lx);

                ctsp.setNamSX(rs.getInt(9));
                ctsp.setGiaBan(rs.getDouble(10));
                ctsp.setTrangThai(rs.getInt(11));
                ctsp.setSoLuong(rs.getInt(12));

                list.add(ctsp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String> getAllMaSP() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select maSP from sanpham";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String st = rs.getString(1);
                list.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<String> getAllKH() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select hoTen from KhachHang";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String st = rs.getString(1);
                list.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<String> getAllKM() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select maKhuyenMai  from KhuyenMai where (GETDATE()   BETWEEN thoiGianBd and thoiGianKT)";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String st = rs.getString(1);
                list.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<String> getDTBX() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select DTbinhxang from DTBinhXang";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String st = rs.getString(1);
                list.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<String> getDTXL() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select DTxilanh from DTXiLanh";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String st = rs.getString(1);
                list.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<String> getMau() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select mausac from Mau";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String st = rs.getString(1);
                list.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<String> getXuatXu() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select xuatxu from XuatXu";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String st = rs.getString(1);
                list.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<String> getLoaiXe() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select loaiXe from LoaiXe";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String st = rs.getString(1);
                list.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<String> getSoKhung() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select soKhung from soKhung";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String st = rs.getString(1);
                list.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

//    public Integer add(D_SanPhamBig ds) {
//        Integer row = 0;
//        String sql = "insert into SanPham(maSP ,tenSP ,idDTBinhXang,idDTXiLanh,idMau ,idXuatXu ,idLoaiXe ,namSX ,giaBan ,trangThai ) values \n"
//                + "(?,?,?,?,?,?,?,?,?,?)";
//        try {
//            row = JDBCHeper.excuteUpdate(sql,
//                    ds.getMaSP(),
//                    ds.getTenSP(),
//                    ds.getDtBinhXang().getId(),
//                    ds.getdTXiLanh().getId(),
//                    ds.getMau().getId(),
//                    ds.getXuatXu().getId(),
//                    ds.getLoaiXe().getId(),
//                    ds.getNamSX(),
//                    ds.getGiaBan(),
//                    ds.getTrangThai()
//            );
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return row;
//    }
    public boolean add(D_SanPhamBig ds) {

        String query = "insert into SanPham(maSP ,tenSP ,idDTBinhXang,idDTXiLanh,idMau ,idXuatXu ,idLoaiXe ,namSX ,giaBan ,trangThai ) values\n"
                + "                (?,?,?,?,?,?,?,?,?,?)";
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ds.getMaSP());
            ps.setObject(2, ds.getTenSP());
            ps.setObject(3, ds.getDtBinhXang().getId());
            ps.setObject(4, ds.getdTXiLanh().getId());
            ps.setObject(5, ds.getMau().getId());
            ps.setObject(6, ds.getXuatXu().getId());
            ps.setObject(7, ds.getLoaiXe().getId());
            ps.setObject(8, ds.getNamSX());
            ps.setObject(9, ds.getGiaBan());
            ps.setObject(10, ds.getTrangThai());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public Integer update(D_SanPhamBig ds) {
//        Integer row = 0;
//        String sql = "update sanpham set maSP=? ,tenSP=? ,idDTBinhXang=?,idDTXiLanh=?,idMau=? ,idXuatXu=? ,idLoaiXe=? ,namSX=? ,giaBan=? ,trangThai=? where id =? ";
//        try {
//            row = JDBCHeper.excuteUpdate(sql,
//                    ds.getMaSP(),
//                    ds.getTenSP(),
//                    ds.getDtBinhXang().getId(),
//                    ds.getdTXiLanh().getId(),
//                    ds.getMau().getId(),
//                    ds.getXuatXu().getId(),
//                    ds.getLoaiXe().getId(),
//                    ds.getNamSX(),
//                    ds.getGiaBan(),
//                    ds.getTrangThai(),
//                    ds.getIdSP()
//            );
//
//        } catch (Exception e) {
//            System.out.println(e);
//            e.printStackTrace();
//        }
//
//        return row;
//    }
    public Boolean update(D_SanPhamBig ds) {
        String query = "update sanpham set maSP=? ,tenSP=? ,idDTBinhXang=?,idDTXiLanh=?,idMau=? ,idXuatXu=? ,idLoaiXe=? ,namSX=? ,giaBan=? ,trangThai=? where id =? ";
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, ds.getMaSP());
            ps.setObject(2, ds.getTenSP());
            ps.setObject(3, ds.getDtBinhXang().getId());
            ps.setObject(4, ds.getdTXiLanh().getId());
            ps.setObject(5, ds.getMau().getId());
            ps.setObject(6, ds.getXuatXu().getId());
            ps.setObject(7, ds.getLoaiXe().getId());
            ps.setObject(8, ds.getNamSX());
            ps.setObject(9, ds.getGiaBan());
            ps.setObject(10, ds.getTrangThai());
            ps.setObject(11, ds.getIdSP());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Integer updateTrangthai(D_SanPhamBig ds) {
        Integer row = 0;
        String sql = "update SanPham set trangThai=1\n"
                + "where id=?";
        try {
            row = JDBCHeper.excuteUpdate(sql,
                    ds.getIdSP()
            //                    ds.getHinhAnh()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    public D_SanPhamBig getOne(String ma) {

        String sql = "select id,maSP from sanpham  \n"
                + "where maSP = ?";
        try ( Connection cn = context.getConnection();  PreparedStatement pr = cn.prepareStatement(sql)) {
            pr.setObject(1, ma);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                D_SanPhamBig sp = new D_SanPhamBig();
                sp.setIdSP(rs.getString(1));
                sp.setMaSP(rs.getString(2));

                return sp;

            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public String getByNameSanPham(String ma) {
        String id = null;
        String sql = "select tenSp from SanPham where SanPham.masp = ?";
        Connection cons = DBconnection.getConnection();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String sp = rs.getString(1);
                return sp;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
    }

    public String getByNameSoKhung(String ma) {
        String id = null;
        String sql = "select HoaDONChiTiet.id,SoKhung from SoKhung \n"
                + "INNER JOIN hoadonchitiet ON HoaDONChiTiet.idsk = SoKhung.id\n"
                + "where Sokhung.idsp = ? and HoaDONChiTiet.id = ?";
        Connection cons = DBconnection.getConnection();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String sokhung = rs.getString(1);
                return sokhung;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
    }

    public String getByNameLoaiXe(String ma) {
        String id = null;
        String sql = "SELECT loaixe FROM SanPham "
                + "JOIN LoaiXe ON LoaiXe.id = SanPham.idLoaiXe "
                + "WHERE SanPham.maSp = ?";
        Connection cons = DBconnection.getConnection();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String loaixe = rs.getString(1);
                return loaixe;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
    }

    public String getByNameDTXiLanh(String ma) {
        String id = null;
        String sql = "SELECT dTXiLanh FROM SanPham "
                + "JOIN DTXiLanh ON DTXiLanh.id = SanPham.idDTXiLanh "
                + "WHERE SanPham.maSp = ?";
        Connection cons = DBconnection.getConnection();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String dtxilanh = rs.getString(1);
                return dtxilanh;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
    }

    public String getByNameDTBinhXang(String ma) {
        String id = null;
        String sql = "SELECT dTBinhXang FROM SanPham "
                + "JOIN DTBinhXang ON DTBinhXang.id = SanPham.idDTBinhxang "
                + "WHERE SanPham.maSp = ?";
        Connection cons = DBconnection.getConnection();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String dtbinhxang = rs.getString(1);
                return dtbinhxang;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
    }

    public String getByNameMau(String ma) {
        String id = null;
        String sql = "SELECT mauSac FROM SanPham "
                + "JOIN Mau ON Mau.id = SanPham.idMau "
                + "WHERE SanPham.maSp = ?";
        Connection cons = DBconnection.getConnection();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String mausac = rs.getString(1);
                return mausac;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
    }

    public String getByNameXuatXu(String ma) {
        String id = null;
        String sql = "SELECT xuatXu FROM SanPham "
                + "JOIN XuatXu ON XuatXu.id = SanPham.idXuatXu "
                + "WHERE SanPham.maSp = ?";
        Connection cons = DBconnection.getConnection();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String xuatxu = rs.getString(1);
                return xuatxu;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
    }

}
