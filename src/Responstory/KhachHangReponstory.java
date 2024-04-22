/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Responstory;

import DomainModel.D_KhachHang;
import Utilities.DBconnection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class KhachHangReponstory {

    public List<D_KhachHang> getAll() {
        String query = "SELECT [idKH]\n"
                + "      ,[maKH]\n"
                + "      ,[hoTen]\n"
                + "      ,[diaChi]\n"
                + "      ,[gioiTinh]\n"
                + "      ,[SDT]\n"
               
                + "  FROM [dbo].[KhachHang]";
        try ( Connection cn = DBconnection.getConnection();  PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<D_KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new D_KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean insert(D_KhachHang kh) {
        String query = "insert into KhachHang( maKH, hoTen,"
                + " diaChi, gioiTinh, sdt) values\n"
                + "( ?, ?, ?, ?, ?)";
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getMaKH());
            ps.setObject(2, kh.getHoTen());
            ps.setObject(3, kh.getDiaChi());
            ps.setObject(4, kh.getGioiTinh());
            ps.setObject(5, kh.getSdt());
       
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean update(String maKH, D_KhachHang kh) {
        String query = "update KhachHang set hoTen = ?, diaChi = ?, "
                + "gioiTinh = ?, sdt = ? "
                + "where maKH = ?";
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, kh.getHoTen());
            ps.setObject(2, kh.getDiaChi());
            ps.setObject(3, kh.getGioiTinh());
            ps.setObject(4, kh.getSdt());
       
            ps.setObject(5, maKH);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean delete(String maKH) {
        String query = "delete from KhachHang where maKH = ?";
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, maKH);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<D_KhachHang> search(String hoTen) {
        List<D_KhachHang> list = new ArrayList<>();
        String sql = "select idKH,maKH, hoTen, diaChi,"
                + " gioiTinh, sdt from KhachHang\n"
                + " where hoTen like '%" + hoTen + "%'";
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                D_KhachHang kh = new D_KhachHang();
                kh.setIdKH(rs.getString(1));
                kh.setMaKH(rs.getString(2));
                kh.setHoTen(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                kh.setGioiTinh(rs.getInt(5));
                kh.setSdt(rs.getString(6));
           
                list.add(kh);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public D_KhachHang one(String hoTen) {
        List<D_KhachHang> list = new ArrayList<>();
        String sql = """
                     SELECT [sdt]
                       FROM [dbo].[KhachHang]
                       Where hoTen = ?
                     """;
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,hoTen);
            ResultSet rs = ps.executeQuery();
            D_KhachHang kh = new D_KhachHang();
            while (rs.next()) {
                kh.setSdt(rs.getString(1));
                
            }
            return kh;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null  ;
    }
    
    

    public static void main(String[] args) {
        List<D_KhachHang> list = new KhachHangReponstory().getAll();
        for (D_KhachHang x : list) {
            System.out.println(x.toString());
        }

    }
}
