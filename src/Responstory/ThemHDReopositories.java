/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory;
import Utilities.DBconnection;
import ViewModel.TaoHoaDonModel;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ADMIN
 */
public class ThemHDReopositories {
    public List<TaoHoaDonModel> getAll( int index) {
        String query = """
                     SELECT [idhd]
                            ,[maHoaDon]
                            ,[idNhanVien]
                            ,[idKhachHang]
                            ,[ngayTao]
                            ,[trangThai]  
                        FROM [dbo].[HoaDon]
                       Where trangThai = ?
                       """;
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, index);
            ResultSet rs = ps.executeQuery();
            List<TaoHoaDonModel> listnv = new ArrayList<>();
            while (rs.next()) {
               TaoHoaDonModel nv = new  TaoHoaDonModel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6));
        listnv.add(nv);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }
     public List<TaoHoaDonModel> getALLIN() {
        String query = """
                     SELECT [idhd]
                            ,[maHoaDon]
                            ,[idNhanVien]
                            ,[idKhachHang]
                            ,[ngayTao]
                            ,[trangThai]  
                        FROM [dbo].[HoaDon]
                       """;
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<TaoHoaDonModel> listnv = new ArrayList<>();
            while (rs.next()) {
               TaoHoaDonModel nv = new  TaoHoaDonModel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6));
        listnv.add(nv);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }
    public void themHD(TaoHoaDonModel Hd) {
        String querry = """
                        INSERT INTO [dbo].[HoaDon]
                                   ([maHoaDon]
                                   ,[trangThai]
                                   ,[ngayTao])
                             VALUES(?,?,?)
                        """;
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setObject(1, Hd.getMaHd());
            ps.setObject(2, Hd.getTrangThai());
            ps.setObject(3, Hd.getNgayTao());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
