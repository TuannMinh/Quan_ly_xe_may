/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory;

import DomainModel.D_NhanVien;
import Utilities.DBconnection;
import ViewModel.NhanVienModels;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienReponstory {

    public List<D_NhanVien> getAll() {
        String query = """
                      SELECT [idNV]
                             ,[maNV]
                             ,[tenNV]
                             ,[diaChi]
                             ,[gioiTinh]
                             ,[ngaySinh]
                             ,[sdt]
                             ,[email]
                             ,[trangThai]
                             ,[hinhanh]
                             ,[idTaiKhoan]
                         FROM [dbo].[NhanVien]
                       """;
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<D_NhanVien> listnv = new ArrayList<>();
            while (rs.next()) {
                D_NhanVien nv = new D_NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11));
                listnv.add(nv);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public List<D_NhanVien> getlistloc(int tt) {
        String query = """
                      SELECT [idNV]
                             ,[maNV]
                             ,[tenNV]
                             ,[diaChi]
                             ,[gioiTinh]
                             ,[ngaySinh]
                             ,[sdt]
                             ,[email]
                             ,[trangThai]
                             ,[hinhanh]
                             ,[idTaiKhoan]
                         FROM [dbo].[NhanVien]
                        Where trangThai = ?
                       """;
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tt);
            ResultSet rs = ps.executeQuery();

            List<D_NhanVien> listnv = new ArrayList<>();
            while (rs.next()) {
                D_NhanVien nv = new D_NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11));
                listnv.add(nv);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public List<D_NhanVien> TimKiem(String ma) {
        String query = """
                      SELECT [idNV]
                             ,[maNV]
                             ,[tenNV]
                             ,[diaChi]
                             ,[gioiTinh]
                             ,[ngaySinh]
                             ,[sdt]
                             ,[email]
                             ,[trangThai]
                             ,[hinhanh]
                             ,[idTaiKhoan]
                         FROM [dbo].[NhanVien]
                        Where maNV = ? or sdt like '%'+?
                       """;
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, ma);
            ps.setString(2, ma);
            ResultSet rs = ps.executeQuery();
            List<D_NhanVien> listnv = new ArrayList<>();
            while (rs.next()) {
                D_NhanVien nv = new D_NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11));
                listnv.add(nv);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public void them(D_NhanVien nv, String user) {
        String querry = """
                        INSERT INTO [dbo].[NhanVien]
([maNV]
                                              ,[tenNV]
                                              ,[diaChi]
                                              ,[gioiTinh]
                                              ,[ngaySinh]
                                              ,[sdt]
                                              ,[email]
                                              ,[hinhanh]
                                              ,[trangThai]
                                              ,[idTaiKhoan])
                             VALUES
                                   (?,?,?,?,?,?,?,?,?,(SELECT [idtk]
                                     FROM [dbo].[TaiKhoan] where userName = ?))
                        """;
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getTenNV());
            ps.setObject(3, nv.getDiaChi());
            ps.setObject(4, nv.getGioiTinh());
            ps.setObject(5, nv.getNgaySinh());
            ps.setObject(6, nv.getSdt());
            ps.setObject(7, nv.getEmail());
            ps.setObject(8, nv.getHinhAnh());
            ps.setObject(9, nv.getTrangThai());
            ps.setObject(10, user);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void Sua(D_NhanVien nv, String id) {
        String querry = """
                        UPDATE [dbo].[NhanVien]
                           SET[maNV] = ?
                              ,[tenNV] = ? 
                              ,[diaChi] = ?
                              ,[gioiTinh] = ? 
                              ,[ngaySinh] = ?
                              ,[sdt] = ?
                              ,[email] = ? 
                              ,[hinhanh] = ?
                              ,[trangThai] =? 
                         WHERE [maNV] = ?
                        """;
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getTenNV());
            ps.setObject(3, nv.getDiaChi());
            ps.setObject(4, nv.getGioiTinh());
            ps.setObject(5, nv.getNgaySinh());
            ps.setObject(6, nv.getSdt());
            ps.setObject(7, nv.getEmail());
            ps.setObject(8, nv.getHinhAnh());
            ps.setObject(9, nv.getTrangThai());
            ps.setObject(10, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List<String> layIdtk() {
        String query = """
                      SELECT 
                            [userName]
                        FROM [dbo].[TaiKhoan]
                       """;
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public NhanVienModels layMaNv(String id) {
        String query = """
                      SELECT [maNV]
                        FROM [dbo].[NhanVien]
                        where idTaiKhoan = ?
                       """;
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            NhanVienModels nv = new NhanVienModels();
            while (rs.next()) {
                nv.setMaNV(rs.getString(1));
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

}
