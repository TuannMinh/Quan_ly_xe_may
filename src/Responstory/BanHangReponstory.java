/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory;
import DomainModel.D_KhachHang;
import java.sql.ResultSet;
import java.sql.Connection;
import Utilities.DBconnection;
import ViewModel.SanPhamModels;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BanHangReponstory {
//     public List<SanPhamModels> getAll() {
//        String query = """
//                     SELECT [id]
//                           ,[maSP]
//                           ,[tenSP]
//                           ,[soLuong]
//                           ,[namSX]
//                       FROM [dbo].[SanPham]
//                       """;
//        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
//            ResultSet rs = ps.executeQuery();
//            List<SanPhamModels> listnv = new ArrayList<>();
//            while (rs.next()) {
//                SanPhamModels nv = new SanPhamModels(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
//                listnv.add(nv);
//            }
//            return listnv;
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//
//    }
       public List<String> layDsKhachHang() {
        String query = """
                      SELECT [hoTen]
                                              FROM [dbo].[KhachHang]
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
      
}
