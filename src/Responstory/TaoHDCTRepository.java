/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory;

import ViewModel.TaoHDCTMODEL;
import Utilities.DBconnection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author ADMIN
 */
public class TaoHDCTRepository {
     public void them(TaoHDCTMODEL nv, String idsp,String idhd,String idsk,String idkm) {
        String querry = """
                        INSERT INTO [dbo].[HoaDONChiTiet]
                                   ([idsp]
                                   ,[idhd]
                                   ,[idsk]
                                   ,[idkm])
                             VALUES
                                   ((SELECT [id]
                          FROM [dbo].[SanPham]
                          where maSP = ?)
                                   ,(SELECT [idhd]
                          FROM [dbo].[HoaDon]
                          where maHoaDon = ?)
                                   ,(SELECT [id]
                          FROM [dbo].[SoKhung]
                          where SoKhung = ?)
                                   ,(SELECT [idkm] FROM [dbo].[KhuyenMai]  Where maKhuyenMai = ?))
                        """;
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);

            ps.setObject(1,idsp);
            ps.setObject(2, idhd);
            ps.setObject(3, idsk);
            ps.setObject(4, idkm);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
}
