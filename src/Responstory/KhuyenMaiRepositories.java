/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory;

import Utilities.DBconnection;
import ViewModel.KhuyenMai_View;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class KhuyenMaiRepositories {

    public KhuyenMai_View one(String makm) {
        String sql = """
                     SELECT [GiaTri]    
                       FROM [dbo].[KhuyenMai]
                       Where maKhuyenMai = ?
                     """;
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, makm);
            ResultSet rs = ps.executeQuery();
            KhuyenMai_View km = new KhuyenMai_View();
            while (rs.next()) {
                km.setGiaTri(rs.getInt(1));

            }
            return km;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
